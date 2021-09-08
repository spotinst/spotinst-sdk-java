package com.spotinst.sdkjava.model.bl.ocean.gke;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class LaunchSpecLabelsSpecification {

    private Set<String> isSet;
    private String      key;
    private String      value;

    public LaunchSpecLabelsSpecification(){ isSet = new HashSet<>();
    }
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

    public static class Builder {
        private LaunchSpecLabelsSpecification gkeLabels;

        private Builder() {
            this.gkeLabels = new LaunchSpecLabelsSpecification();
        }

        public static LaunchSpecLabelsSpecification.Builder get() {
            LaunchSpecLabelsSpecification.Builder builder = new LaunchSpecLabelsSpecification.Builder();
            return builder;
        }

        public LaunchSpecLabelsSpecification.Builder setKey(final String key) {
            gkeLabels.setKey(key);
            return this;
        }

        public LaunchSpecLabelsSpecification.Builder setValue(final String value) {
            gkeLabels.setValue(value);
            return this;
        }
        public LaunchSpecLabelsSpecification build() {
            return gkeLabels;
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


}
