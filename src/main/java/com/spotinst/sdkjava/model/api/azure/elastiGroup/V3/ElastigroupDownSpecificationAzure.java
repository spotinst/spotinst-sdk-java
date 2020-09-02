package com.spotinst.sdkjava.model.api.azure.elastiGroup.V3;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.Set;

public class ElastigroupDownSpecificationAzure {
    //region Members
    @JsonIgnore
    private Set<String> isSet;
    private Integer     evaluationPeriods;
    private Integer     maxScaleDownPercentage;
    //endregion

    //region Constructor

    private ElastigroupDownSpecificationAzure() {
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
    //region Builder class
    public static class Builder {
        private ElastigroupDownSpecificationAzure down;

        private Builder() {
            this.down = new ElastigroupDownSpecificationAzure();
        }

        public static Builder get() {
            Builder builder = new Builder();
            return builder;
        }

        public Builder setEvaluationPeriods(final Integer evaluationPeriods) {
            down.setEvaluationPeriods(evaluationPeriods);
            return this;
        }

        public Builder setMaxScaleDownPercentage(final Integer maxScaleDownPercentage) {
            down.setMaxScaleDownPercentage(maxScaleDownPercentage);
            return this;
        }

        public ElastigroupDownSpecificationAzure build() {
            return down;
        }
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
