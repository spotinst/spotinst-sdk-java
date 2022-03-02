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
 * @author: Saikumar Jalda
 * @since: 14/02/2022
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonFilter("PartialUpdateEntityFilter")
public class ApiImportASG implements IPartialUpdateEntity {
    //region Members
    @JsonIgnore
    private Set<String>               isSet;
    private String                    product;
    private List<String>              spotInstanceTypes;
    private String                    name;
    private String                    availabilityVsCost;
    //endregion

    //region Constructor

    public ApiImportASG() {
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

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        isSet.add("product");
        this.product = product;
    }

    public List<String> getSpotInstanceTypes() {
        return spotInstanceTypes;
    }

    public void setSpotInstanceTypes(List<String> spotInstanceTypes) {
        isSet.add("spotInstanceTypes");
        this.spotInstanceTypes = spotInstanceTypes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        isSet.add("name");
        this.name = name;
    }

    public String getAvailabilityVsCost() {
        return availabilityVsCost;
    }

    public void setAvailabilityVsCost(String availabilityVsCost) {
        isSet.add("availabilityVsCost");
        this.availabilityVsCost = availabilityVsCost;
    }

    //endregion

    //region isSet methods
    // Is name Set boolean method
    @JsonIgnore
    public boolean isProductSet() {
        return isSet.contains("product");
    }

    // Is spotInstanceTypes Set boolean method
    @JsonIgnore
    public boolean isSpotInstanceTypesSet() {
        return isSet.contains("spotInstanceTypes");
    }

    @JsonIgnore
    public boolean isNameSet() {
        return isSet.contains("name");
    }

    @JsonIgnore
    public boolean isAvailabilityVsCostSet() {
        return isSet.contains("availabilityVsCost");
    }
    //endregion
}
