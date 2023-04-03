package com.spotinst.sdkjava.model.bl.elastigroup.gcp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.Set;

public class ElastigroupDownSpecificationGcp {

    @JsonIgnore
    private Set<String> isSet;
    private Integer     evaluationPeriods;

    private ElastigroupDownSpecificationGcp() {
        isSet = new HashSet<>();
    }

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

    public static class Builder {
        private ElastigroupDownSpecificationGcp down;

        private Builder() {
            this.down = new ElastigroupDownSpecificationGcp();
        }

        public static Builder get() {
            return new Builder();
        }

        public Builder setEvaluationPeriods(final Integer evaluationPeriods) {
            down.setEvaluationPeriods(evaluationPeriods);
            return this;
        }

        public ElastigroupDownSpecificationGcp build() {
            return down;
        }
    }

    @JsonIgnore
    public boolean isEvaluationPeriodsSet() {
        return isSet.contains("evaluationPeriods");
    }
}
