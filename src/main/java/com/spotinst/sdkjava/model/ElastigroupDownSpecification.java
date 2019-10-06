package com.spotinst.sdkjava.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.Set;

public class ElastigroupDownSpecification {
    //region Members
    @JsonIgnore
    private Set<String> isSet;
    private Integer evaluationPeriods;
    //endregion

    //region Constructor

    private ElastigroupDownSpecification() {
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
    //endregion
    //region Builder class
    public static class Builder {
        private ElastigroupDownSpecification Down;

        private Builder() {
            this.Down = new ElastigroupDownSpecification();
        }

        public static Builder get() {
            Builder builder = new Builder();
            return builder;
        }

        public Builder setEvaluationPeriods (final Integer evaluationPeriods){
            Down.setEvaluationPeriods(evaluationPeriods);
            return this;
        }

        public ElastigroupDownSpecification build() {
            return Down;
        }
    }
       //endregion

    //region isSet methods
    // Is evaluationPeriods Set boolean method
    @JsonIgnore
    public boolean isEvaluationPeriodsSet() { return isSet.contains("evaluationPeriods");}

    //endregion

}
