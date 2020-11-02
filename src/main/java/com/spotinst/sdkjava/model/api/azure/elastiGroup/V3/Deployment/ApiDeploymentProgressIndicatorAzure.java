package com.spotinst.sdkjava.model.api.azure.elastiGroup.V3.Deployment;

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
public class ApiDeploymentProgressIndicatorAzure implements IPartialUpdateEntity {
    //region Members
    @JsonIgnore
    private Set<String> isSet;
    private String      unit;
    private Float       value;
    //endregion

    //region constructor
    public ApiDeploymentProgressIndicatorAzure() {
        isSet = new HashSet<>();
    }
    //endregion

    //region Getters and Setters
    @Override
    public Set<String> getIsSet() {
        return isSet;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
        touch("unit");
    }

    public Float getValue() {
        return value;
    }

    public void setValue(Float value) {
        this.value = value;
        touch("value");
    }
    //endregion

    //region isSet boolean methods
    @JsonIgnore
    public Boolean isUnitSet() {
        return this.isSet.contains("unit");
    }
    @JsonIgnore
    public Boolean isValueSet() {
        return this.isSet.contains("value");
    }
    //endregion

    //region private methods - helpers
    private void touch(String fieldName) {
        this.isSet.add(fieldName);
    }
    //endregion
}
