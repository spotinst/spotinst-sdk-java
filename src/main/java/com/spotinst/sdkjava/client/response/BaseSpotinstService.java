package com.spotinst.sdkjava.client.response;

import com.spotinst.sdkjava.client.rest.JsonMapper;
import com.spotinst.sdkjava.client.rest.RestResponse;
import com.spotinst.sdkjava.exception.SpotinstHttpErrorsException;
import com.spotinst.sdkjava.exception.SpotinstHttpException;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpStatus;
import org.apache.logging.log4j.core.util.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by aharontwizer on 8/24/15.
 */
public class BaseSpotinstService {

    private static final Logger LOGGER = LoggerFactory.getLogger(BaseSpotinstService.class);

    private static final String FILE_PATH  = "gradle.properties";
    private static       String SPOTINST_SDK_JAVA_USER_AGENT = "spotinst-sdk-java";



    static {
        String     userAgentFormat = "%s/%s";

        try {
            ClassLoader classloader = Thread.currentThread().getContextClassLoader();
            InputStream is = classloader.getResourceAsStream(FILE_PATH);

            String theString = IOUtils.toString(new InputStreamReader(is));
            String[] arrOfStr = theString.split("=");

            String version = StringUtils.chomp(arrOfStr[1]);
            SPOTINST_SDK_JAVA_USER_AGENT = String.format(userAgentFormat, SPOTINST_SDK_JAVA_USER_AGENT, version);

        } catch (IOException ex) {
            LOGGER.error("Cannot determine spotinst-sdk-java version", ex);
        }
    }

    public static <T> T getCastedResponse(RestResponse response, Class<T> contentClass) throws SpotinstHttpException {
        T retVal = null;

        if (response.getStatusCode() == HttpStatus.SC_OK) {
            // Desarialize the response.
            retVal = JsonMapper.fromJson(response.getBody(), contentClass);
            if (retVal == null) {// Couldn't read the json.
                throw new SpotinstHttpException("Can't parse response to class : " + contentClass.toString());
            }

        } else {
            // Read the errors.
            String message = "Got status code different the SC_OK : " + response.getStatusCode() + " Body " + response.getBody();
            LOGGER.warn(message);

            // Try to cast the error to ErrorResponse.
            ServiceErrorsResponse serviceErrorsResponse = JsonMapper.fromJson(response.getBody(), ServiceErrorsResponse.class);
            if (serviceErrorsResponse != null) {
                throw new SpotinstHttpErrorsException(message, serviceErrorsResponse.getResponse().getErrors());
            } else {
                throw new SpotinstHttpException(message);
            }
        }

        return retVal;
    }

    public static Map<String, String> buildHeaders(String authToken) {
        Map<String, String> retVal = new HashMap<String, String>();
        retVal.put("Authorization", "Bearer " + authToken);
        retVal.put("Content-Type", "application/json");
        retVal.put(HttpHeaders.USER_AGENT, SPOTINST_SDK_JAVA_USER_AGENT);


        return retVal;
    }
}
