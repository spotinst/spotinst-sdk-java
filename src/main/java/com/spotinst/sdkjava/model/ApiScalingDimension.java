package com.spotinst.sdkjava.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by aharontwizer on 8/27/15.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiScalingDimension {

    // Partial Update support
    private Set<String> isSet = new HashSet<>();

    private String name;
    private String value;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        isSet.add("name");
        this.name = name;
    }

    @JsonIgnore
    public boolean isNameSet() {
        return isSet.contains("name");
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        isSet.add("value");
        this.value = value;
    }

    @JsonIgnore
    public boolean isValueSet() {
        return isSet.contains("value");
    }
}
