package com.spotinst.sdkjava.model.api.elastigroup.aws;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.spotinst.sdkjava.client.rest.IPartialUpdateEntity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author: Janetlin Kiruba
 * @since: 10/01/2022
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonFilter("PartialUpdateEntityFilter")
public class ApiElastigroupImportEC2Instance implements IPartialUpdateEntity {
    //region Members
    @JsonIgnore
    private Set<String>                isSet;
    private String                     name;
    private List<String> spotInstanceTypes;
    //endregion

    //region Constructor

    public ApiElastigroupImportEC2Instance() {
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        isSet.add("name");
        this.name = name;
    }

    public List<String> getSpotInstanceTypes() {
        return spotInstanceTypes;
    }

    public void setSpotInstanceTypes(List<String> spotInstanceTypes) {
        isSet.add("spotInstanceTypes");
        this.spotInstanceTypes = spotInstanceTypes;
    }

    //endregion

    //region isSet methods
    // Is name Set boolean method
    @JsonIgnore
    public boolean isNameSet() {
        return isSet.contains("name");
    }

    // Is spotInstanceTypes Set boolean method
    @JsonIgnore
    public boolean isSpotInstanceTypesSet() {
        return isSet.contains("spotInstanceTypes");
    }

    //endregion
}
