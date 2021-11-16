package com.spotinst.sdkjava.model.api.ocean.kubernetes;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.spotinst.sdkjava.client.rest.IPartialUpdateEntity;

import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonFilter("PartialUpdateEntityFilter")

public class ApiK8sVngTaints implements IPartialUpdateEntity {

    @JsonIgnore
    private Set<String> isSet;
    private String		effect;
    private String      key;
    private String      value;

    public ApiK8sVngTaints() {
        isSet = new HashSet<>();
    }

    public ApiK8sVngTaints(String effect, String key, String value) {
        isSet = new HashSet<>();
        this.setEffect(effect);
        this.setKey(key);
        this.setValue(value);
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
