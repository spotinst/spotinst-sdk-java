package com.spotinst.sdkjava.model;

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
public class ApiDefaultStaticTargetGroups implements IPartialUpdateEntity {

    //region Members
    @JsonIgnore
    private Set<String>              isSet;
    private String                   arn;
    private Float                    percentage;
    //endregion

    //region Constructor
    public ApiDefaultStaticTargetGroups() {
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

    public String getArn() {
        return arn;
    }

    public void setArn(String arn) {
        isSet.add("arn");
        this.arn = arn;
    }

    public Float getPercentage() {
        return percentage;
    }

    public void setPercentage(Float percentage) {
        isSet.add("percentage");
        this.percentage = percentage;
    }

    //endregion

    //region isSet methods
    // Is arn Set boolean method
    @JsonIgnore
    public boolean isArnSet() {
        return isSet.contains("arn");
    }

    // Is percentage Set boolean method
    @JsonIgnore
    public boolean isPercentageSet() {
        return isSet.contains("percentage");
    }

    //endregion
}
