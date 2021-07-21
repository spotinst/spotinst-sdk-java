package com.spotinst.sdkjava.model.bl.gcp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.Set;

public class OceanGKETaints {

    private Set<String> isSet;
    private String      key;
    private String      value;
    private String      effect;

    private OceanGKETaints(){isSet = new HashSet<>();}

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }
    public String getKey(){
        return key;
    }

    public void setKey(String key){
        isSet.add("key");
        this.key = key;
    }

    public String getValue(){
        return key;
    }

    public void setValue(String value) {
        isSet.add("value");
        this.value = value;
    }

    public String getEffect(){
        return key;
    }

    public void setEffect(String effect) {
        isSet.add("effect");
        this.effect = effect;
    }

    public static class Builder {
        private OceanGKETaints gkeTaints;

        private Builder() {
            this.gkeTaints = new OceanGKETaints();
        }

        public static OceanGKETaints.Builder get() {
            OceanGKETaints.Builder builder = new OceanGKETaints.Builder();
            return builder;
        }

        public OceanGKETaints.Builder setKey(final String key) {
            gkeTaints.setKey(key);
            return this;
        }

        public OceanGKETaints.Builder setValue(final String value) {
            gkeTaints.setValue(value);
            return this;
        }
        public OceanGKETaints.Builder setEffect(final String effect) {
            gkeTaints.setEffect(effect);
            return this;
        }
        public OceanGKETaints build() {
            return gkeTaints;
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
