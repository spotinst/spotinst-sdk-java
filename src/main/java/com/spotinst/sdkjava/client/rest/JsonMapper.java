package com.spotinst.sdkjava.client.rest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * Created by aharontwizer on 7/22/15.
 */
public class JsonMapper {

    private static final Logger LOGGER = LoggerFactory.getLogger(JsonMapper.class);

    private static ObjectMapper jsonMapper = new ObjectMapper();

    static {

        PartialUpdateEntityPropertyFilter propertyFilter = new PartialUpdateEntityPropertyFilter();
        FilterProvider filters = new SimpleFilterProvider().addFilter("PartialUpdateEntityFilter", propertyFilter);

        // Set the filters.
        jsonMapper.setFilterProvider(filters);

    }

    public static <T> T fromJson(String content, Class<T> contentClass) {
        T retVal = null;

        try {
            retVal = jsonMapper.readValue(content, contentClass);
        } catch (IOException e) {

            LOGGER.error("Error in parsing json to object", e);
        }

        return retVal;
    }

    public static <T> T fromJson(String content, TypeReference<T> referenceClass) {
        T retVal = null;

        try {
            retVal = jsonMapper.readValue(content, referenceClass);
        } catch (IOException e) {
            LOGGER.error("Error in parsing json to object", e);
        }

        return retVal;
    }

    public static <T> String toJson(T objectToWrite) {
        String retVal = null;


        try {
            retVal = jsonMapper.writeValueAsString(objectToWrite);
        } catch (JsonProcessingException e) {
            LOGGER.error("Error in writing object to json", e);
        }

        return retVal;
    }
}
