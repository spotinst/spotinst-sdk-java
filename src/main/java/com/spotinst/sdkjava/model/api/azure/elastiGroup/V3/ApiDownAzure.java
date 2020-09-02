package com.spotinst.sdkjava.model.api.azure.elastiGroup.V3;

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
public class ApiDownAzure implements IPartialUpdateEntity {
    //region Members
    @JsonIgnore
    private Set<String> isSet;
    private Integer     evaluationPeriods;
    private Integer     maxScaleDownPercentage;
    //endregion

    //region Constructor
    public ApiDownAzure() {
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

    public Integer getEvaluationPeriods() {
        return evaluationPeriods;
    }

    public void setEvaluationPeriods(Integer evaluationPeriods) {
        isSet.add("evaluationPeriods");
        this.evaluationPeriods = evaluationPeriods;
    }

    public Integer getMaxScaleDownPercentage() {
        return maxScaleDownPercentage;
    }

    public void setMaxScaleDownPercentage(Integer maxScaleDownPercentage) {
        isSet.add("maxScaleDownPercentage");
        this.maxScaleDownPercentage = maxScaleDownPercentage;
    }

    //endregion
    //region isSet methods
    // Is evaluationPeriods Set boolean method
    @JsonIgnore
    public boolean isEvaluationPeriodsSet() {
        return isSet.contains("evaluationPeriods");
    }

    // Is maxScaleDownPercentage Set boolean method
    @JsonIgnore
    public boolean isMaxScaleDownPercentageSet() {
        return isSet.contains("maxScaleDownPercentage");
    }
    //endregion
}
