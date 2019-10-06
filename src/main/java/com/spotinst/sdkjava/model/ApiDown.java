package com.spotinst.sdkjava.model;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonFilter("PartialUpdateEntityFilter")
public class ApiDown {
    //region Members
    @JsonIgnore
    private Set<String> isSet;
    private Integer     evaluationPeriods;
    //endregion

    //region Constructor
    public ApiDown() {isSet = new HashSet<>();}
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
    //endregion
    //region isSet methods
    // Is evaluationPeriods Set boolean method
    @JsonIgnore
    public boolean isEvaluationPeriodsSet() { return isSet.contains("evaluationPeriods");}

    //endregion
}
