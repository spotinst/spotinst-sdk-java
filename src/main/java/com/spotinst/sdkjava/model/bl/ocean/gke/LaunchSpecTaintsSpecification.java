package com.spotinst.sdkjava.model.bl.ocean.gke;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.Set;

public class LaunchSpecTaintsSpecification {

    private Set<String> isSet;
    private String      key;
    private String      value;
    private String      effect;

    public LaunchSpecTaintsSpecification(){ isSet = new HashSet<>();}

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
        private LaunchSpecTaintsSpecification taints;

        private Builder() {
            this.taints = new LaunchSpecTaintsSpecification();
        }

        public static LaunchSpecTaintsSpecification.Builder get() {
            LaunchSpecTaintsSpecification.Builder builder = new LaunchSpecTaintsSpecification.Builder();
            return builder;
        }

        public LaunchSpecTaintsSpecification.Builder setKey(final String key) {
            taints.setKey(key);
            return this;
        }

        public LaunchSpecTaintsSpecification.Builder setValue(final String value) {
            taints.setValue(value);
            return this;
        }
        public LaunchSpecTaintsSpecification.Builder setEffect(final String effect) {
            taints.setEffect(effect);
            return this;
        }
        public LaunchSpecTaintsSpecification build() {
            return taints;
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
