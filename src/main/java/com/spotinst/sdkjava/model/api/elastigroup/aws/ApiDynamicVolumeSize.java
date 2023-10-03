package com.spotinst.sdkjava.model.api.elastigroup.aws;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.spotinst.sdkjava.client.rest.IPartialUpdateEntity;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by sobhana p on 9/12/2023.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonFilter("PartialUpdateEntityFilter")
public class ApiDynamicVolumeSize implements IPartialUpdateEntity {

    //region Members
    @JsonIgnore
    private Set<String>     isSet;
    private Integer         baseSize;
    private Integer         sizePerResourceUnit;
    private String          resource;
    //endregion

    //region Constructor
    public ApiDynamicVolumeSize() {
        isSet = new HashSet<>();
    }
    //endregion

    //region Getters & Setters
    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public Integer getBaseSize() {
        return baseSize;
    }

    public void setBaseSize(Integer baseSize) {
        isSet.add("baseSize");
        this.baseSize = baseSize;
    }

    public Integer getSizePerResourceUnit() {
        return sizePerResourceUnit;
    }

    public void setSizePerResourceUnit(Integer sizePerResourceUnit) {
        isSet.add("sizePerResourceUnit");
        this.sizePerResourceUnit = sizePerResourceUnit;
    }

    public String getResource() {
        return resource;
    }

    public void setResource(String resource) {
        isSet.add("resource");
        this.resource = resource;
    }

    //endregion
    //region isSet methods

    // Is baseSize Set boolean method
    @JsonIgnore
    public boolean isBaseSizeSet() {
            return isSet.contains("baseSize");
        }

    @JsonIgnore
    public boolean isSizePerResourceUnitSet() {
        return isSet.contains("sizePerResourceUnit");
    }

    // Is encrypted Set boolean method
    @JsonIgnore
    public boolean isResourceSet() {
        return isSet.contains("resource");
    }
    //endregion
}
