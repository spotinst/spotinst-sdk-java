package com.spotinst.sdkjava.model.bl.ocean.gke;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class LaunchSpecTaintsSpecification {

    @JsonIgnore
    private Set<String> isSet;
    private String      key;
    private String      value;
    private String      effect;

    public LaunchSpecTaintsSpecification(){ isSet = new HashSet<>();}

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }
    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        isSet.add("key");
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        isSet.add("value");
        this.value = value;
    }

    public String getEffect() {
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

        public static Builder get() {
            Builder builder = new Builder();
            return builder;
        }

        public Builder setKey(final String key) {
            taints.setKey(key);
            return this;
        }

        public Builder setValue(final String value) {
            taints.setValue(value);
            return this;
        }
        public Builder setEffect(final String effect) {
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