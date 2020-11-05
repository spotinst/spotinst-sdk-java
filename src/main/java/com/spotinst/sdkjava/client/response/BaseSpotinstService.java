package com.spotinst.sdkjava.client.response;

import com.spotinst.sdkjava.client.http.UserAgentConfig;
import com.spotinst.sdkjava.client.rest.JsonMapper;
import com.spotinst.sdkjava.client.rest.RestResponse;
import com.spotinst.sdkjava.exception.SpotinstHttpErrorsException;
import com.spotinst.sdkjava.exception.SpotinstHttpException;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * Created by aharontwizer on 8/24/15.
 */
public class BaseSpotinstService {

    private static final Logger LOGGER = LoggerFactory.getLogger(BaseSpotinstService.class);

    private static final String VERSION_FILE_PATH     = "project.properties";
    private static final String VERSION_PROPERTY_NAME = "version";
    private static       String spotSdkJava           = "spotinst-sdk-java";

    static {
        String userAgentFormat = "%s/%s";

        try {
            InputStream is = BaseSpotinstService.class.getClassLoader().getResourceAsStream(VERSION_FILE_PATH);
            Properties prop = new Properties();
            prop.load(is);
            String version = prop.getProperty(VERSION_PROPERTY_NAME);
            spotSdkJava = String.format(userAgentFormat, spotSdkJava, version);
            LOGGER.info(String.format("Spot Java SDK version is: %s", version));
        }
        catch (Exception e) {
            LOGGER.error(String.format("failed to get Spot Java SDK version from project.properties, message: %s", e));
        }

    }

    public static void addCustomUserAgents(List<UserAgentConfig> userAgentConfigurations) {
        for (UserAgentConfig userAgentConfig : userAgentConfigurations) {
            String agentType = null;

            if (userAgentConfig.getAgentType() != null) {
                agentType = userAgentConfig.getAgentType().getName();
            }

            String userAgentToAdd = String.format("%s/%s", agentType, userAgentConfig.getVersion());
            spotSdkJava = String.format("%s %s", spotSdkJava, userAgentToAdd);
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

        }
        else {
            // Read the errors.
            String message =
                    "Got status code different the SC_OK : " + response.getStatusCode() + " Body " + response.getBody();
            LOGGER.warn(message);

            // Try to cast the error to ErrorResponse.
            ServiceErrorsResponse serviceErrorsResponse =
                    JsonMapper.fromJson(response.getBody(), ServiceErrorsResponse.class);
            if (serviceErrorsResponse != null) {
                throw new SpotinstHttpErrorsException(message, serviceErrorsResponse.getResponse().getErrors());
            }
            else {
                throw new SpotinstHttpException(message);
            }
        }

        return retVal;
    }

    protected static Map<String, String> buildHeaders(String authToken) {
        Map<String, String> retVal = new HashMap<>();
        retVal.put("Authorization", "Bearer " + authToken);
        retVal.put("Content-Type", "application/json");
        retVal.put(HttpHeaders.USER_AGENT, getUserAgent());

        return retVal;
    }

    private static String getUserAgent() {
        return spotSdkJava;
    }
}
