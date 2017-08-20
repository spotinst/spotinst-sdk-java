package com.spotinst.sdkjava.client.rest;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.BeanPropertyWriter;
import com.fasterxml.jackson.databind.ser.PropertyWriter;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;

public class PartialUpdateEntityPropertyFilter extends SimpleBeanPropertyFilter
    {
        @Override
        public void serializeAsField
                (Object pojo, JsonGenerator jgen, SerializerProvider provider, PropertyWriter writer)
                throws Exception {
            if (include(writer)) {

                // Check if the property was set.
                IPartialUpdateEntity parialUpdateEntity = (IPartialUpdateEntity) pojo;
                boolean contains = parialUpdateEntity.getIsSet().contains(writer.getName());

                if (contains) {
                    writer.serializeAsField(pojo, jgen, provider);
                    return;
                }
            } else if (!jgen.canOmitFields()) { // since 2.3
                writer.serializeAsOmittedField(pojo, jgen, provider);
            }
        }
        @Override
        protected boolean include(BeanPropertyWriter writer) {
            return true;
        }
        @Override
        protected boolean include(PropertyWriter writer) {
            return true;
        }
    }