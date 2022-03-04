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
 * @since: 01/03/2022
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonFilter("PartialUpdateEntityFilter")
public class ApiRequiredVCpuRequiredMemoryGib implements IPartialUpdateEntity {
    //region Members
    @JsonIgnore
    private Set<String>                isSet;
    private String                     minimum;
    private String                     maximum;
    //endregion

    //region Constructor

    public ApiRequiredVCpuRequiredMemoryGib() {
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

    public String getMinimum() {
        return minimum;
    }

    public void setMinimum(String minimum) {
        isSet.add("minimum");
        this.minimum = minimum;
    }

    public String getMaximum() {
        return maximum;
    }

    public void setMaximum(String maximum) {
        isSet.add("maximum");
        this.maximum = maximum;
    }

    //endregion

    //region isSet methods
    // Is minimum Set boolean method
    @JsonIgnore
    public boolean isMinimumSet() {
        return isSet.contains("minimum");
    }

    // Is maximum Set boolean method
    @JsonIgnore
    public boolean isMaximumSet() {
        return isSet.contains("maximum");
    }

    //endregion
}
