package com.spotinst.sdkjava.model.bl.ocean.aks;


import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.Set;


public class ClusterVngTaints {

    @JsonIgnore
    private Set<String> isSet;
    private String 		effect;
    private String 		key;
    private String 		value;

    private ClusterVngTaints(){
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public String getEffect() {
        return effect;
    }

    public void setEffect(String effect) {
        isSet.add("effect");
        this.effect = effect;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ClusterVngTaints k8sVngTaints = (ClusterVngTaints) o;

        if (!key.equals(k8sVngTaints.key)) return false;

        if (!key.equals(k8sVngTaints.effect)) return false;

        return value.equals(k8sVngTaints.value);

    }

    @Override
    public int hashCode() {
        int result = key.hashCode();
        result = 31 * result + effect.hashCode();
        result = 31 * result + value.hashCode();
        return result;
    }

    public static class Builder {
        private ClusterVngTaints tag;

        private Builder() {
            this.tag = new ClusterVngTaints();
        }

        public static Builder get(){
            return new Builder();
        }

        public Builder setEffect(final String effect) {
            tag.setEffect(effect);
            return this;
        }

        public Builder setKey(final String key) {
            tag.setKey(key);
            return this;
        }

        public Builder setValue(final String value) {
            tag.setValue(value);
            return this;
        }

        public ClusterVngTaints build() {
            return tag;
        }
    }

    @JsonIgnore
    public boolean isEffectSet() {
        return isSet.contains("effect");
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
