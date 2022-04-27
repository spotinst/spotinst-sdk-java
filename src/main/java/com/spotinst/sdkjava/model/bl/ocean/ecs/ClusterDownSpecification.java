package com.spotinst.sdkjava.model.bl.ocean.ecs;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.Set;
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ClusterDownSpecification {

    @JsonIgnore
    private Set<String> isSet;
    private Integer     maxScaleDownPercentage;
    private Integer     evaluationPeriods;

    private ClusterDownSpecification() {
        isSet = new HashSet<>();
    }


    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }


    public Integer getMaxScaleDownPercentage() {
        return maxScaleDownPercentage;
    }

    public void setMaxScaleDownPercentage(Integer maxScaleDownPercentage) {
        isSet.add("maxScaleDownPercentage");
        this.maxScaleDownPercentage = maxScaleDownPercentage;
    }

    public Integer getEvaluationPeriods() {
        return evaluationPeriods;
    }

    public void setEvaluationPeriods(Integer evaluationPeriods) {
        isSet.add("evaluationPeriods");
        this.evaluationPeriods = evaluationPeriods;
    }

    public static class Builder {
        private ClusterDownSpecification down;

        private Builder() {
            this.down = new ClusterDownSpecification();
        }

        public static Builder get() {
            return new Builder();
        }

        public Builder setMaxScaleDownPercentage(final Integer maxScaleDownPercentage) {
            down.setMaxScaleDownPercentage(maxScaleDownPercentage);
            return this;
        }
        public Builder setEvaluationPeriods (final Integer evaluationPeriods){
            down.setEvaluationPeriods(evaluationPeriods);
            return this;
        }

        public ClusterDownSpecification build() {
            return down;
        }
    }

    @JsonIgnore
    public boolean isMaxScaleDownPercentageSet() {
        return isSet.contains("maxScaleDownPercentage");
    }
    @JsonIgnore
    public boolean isEvaluationPeriodSet() {
        return isSet.contains("evaluationPeriods");
    }
}
