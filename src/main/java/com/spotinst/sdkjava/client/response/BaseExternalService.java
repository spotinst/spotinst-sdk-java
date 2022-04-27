package com.spotinst.sdkjava.client.response;

import com.spotinst.sdkjava.client.rest.JsonMapper;
import com.spotinst.sdkjava.client.rest.RestResponse;
import com.spotinst.sdkjava.exception.SpotinstHttpException;
import org.apache.http.HttpStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by aharontwizer on 8/24/15.
 */
public class BaseExternalService {

    private static final Logger LOGGER = LoggerFactory.getLogger(BaseExternalService.class);

    protected static <T> T getCastedResponse(RestResponse response, Class<T> contentClass) throws SpotinstHttpException {
        T retVal;

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

            throw new SpotinstHttpException(message);
        }

        return retVal;
    }
}
