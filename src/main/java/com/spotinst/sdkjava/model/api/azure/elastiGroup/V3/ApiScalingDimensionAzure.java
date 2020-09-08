package com.spotinst.sdkjava.model.api.azure.elastiGroup.V3;

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
public class ApiScalingDimensionAzure {

    // Partial Update support
    private Set<String> isSet = new HashSet<>();

    private String name;
    private String value;
    private String resourceGrodownName;
    private String resourceName;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        isSet.add("name");
        this.name = name;
    }

    public String getResourceGrodownName() {
        return resourceGrodownName;
    }

    public void setResourceGrodownName(String resourceGrodownName) {
        isSet.add("resourceGrodownName");
        this.resourceGrodownName = resourceGrodownName;
    }

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        isSet.add("resourceName");
        this.resourceName = resourceName;
    }

    @JsonIgnore
    public boolean isNameSet() {
        return isSet.contains("name");
    }

    @JsonIgnore
    public boolean isResourceNameSet() {
        return isSet.contains("resourceName");
    }

    @JsonIgnore
    public boolean isResourceGrodownNameSet() {
        return isSet.contains("resourceGrodownName");
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
