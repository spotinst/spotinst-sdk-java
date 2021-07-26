package com.spotinst.sdkjava.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.spotinst.sdkjava.model.bl.gcp.OceanGKETaints;

import java.util.HashSet;
import java.util.Set;

public class ApiOceanGKETaints {

        private Set<String> isSet;
        private String      key;
        private String      value;
        private String      effect;

        public ApiOceanGKETaints(){isSet = new HashSet<>();}

        public String getKey(){
            return key;
        }

        public void setKey(String key){
            isSet.add("key");
            this.key = key;
        }

        public String getValue(){
            return value;
        }

        public void setValue(String value) {
            isSet.add("value");
            this.value = value;
        }

        public String getEffect(){
            return effect;
        }

        public void setEffect(String effect) {
            isSet.add("effect");
            this.effect = effect;
        }

        public static class Builder {
            private ApiOceanGKETaints apiGkeTaints;

            private Builder() {
                this.apiGkeTaints = new ApiOceanGKETaints();
            }

            public static ApiOceanGKETaints.Builder get() {
                ApiOceanGKETaints.Builder builder = new ApiOceanGKETaints.Builder();
                return builder;
            }

            public ApiOceanGKETaints.Builder setKey(final String key) {
                apiGkeTaints.setKey(key);
                return this;
            }

            public ApiOceanGKETaints.Builder setValue(final String value) {
                apiGkeTaints.setValue(value);
                return this;
            }
            public ApiOceanGKETaints.Builder setEffect(final String effect) {
                apiGkeTaints.setEffect(effect);
                return this;
            }
            public ApiOceanGKETaints build() {
                return apiGkeTaints;
            }
        }


        @JsonIgnore
        public boolean isKeySet() {
            return isSet.contains("key");
        }
        @JsonIgnore
        public boolean isValueSet() {
            return isSet.contains("value");
        }
        @JsonIgnore
        public boolean isEffectSet() {
            return isSet.contains("effect");
        }



}
