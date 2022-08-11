package com.spotinst.sdkjava.model.api.oceanCD;

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
public class ApiStepsSetCanaryScale implements IPartialUpdateEntity {
    @JsonIgnore
    private Set<String>                               isSet;
    private Integer                                   weight;
    private Integer                                   replicas;
    private Boolean                                   matchTrafficWeight;


    public ApiStepsSetCanaryScale() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        isSet.add("weight");
        this.weight = weight;
    }

    public Integer getReplicas() {
        return replicas;
    }

    public void setReplicas(Integer replicas) {
        isSet.add("replicas");
        this.replicas = replicas;
    }

    public Boolean getMatchTrafficWeight() {
        return matchTrafficWeight;
    }

    public void setMatchTrafficWeight(Boolean matchTrafficWeight) {
        isSet.add("matchTrafficWeight");
        this.matchTrafficWeight = matchTrafficWeight;
    }

    public static class Builder {
        private ApiStepsSetCanaryScale stepsSetCanaryScale;

        private Builder() {
            this.stepsSetCanaryScale = new ApiStepsSetCanaryScale();
        }

        public static Builder get() {
            return new Builder();
        }

        public Builder setWeight(final Integer weight) {
            stepsSetCanaryScale.setWeight(weight);
            return this;
        }

        public Builder setReplicas(final Integer replicas) {
            stepsSetCanaryScale.setReplicas(replicas);
            return this;
        }

        public Builder setMatchTrafficWeight(final Boolean matchTrafficWeight) {
            stepsSetCanaryScale.setMatchTrafficWeight(matchTrafficWeight);
            return this;
        }

        public ApiStepsSetCanaryScale build() {
            return stepsSetCanaryScale;
        }
    }

    @JsonIgnore
    public boolean isWeightSet() {
        return isSet.contains("weight");
    }

    @JsonIgnore
    public boolean isReplicasSet() {
        return isSet.contains("replicas");
    }

    @JsonIgnore
    public boolean isMatchTrafficWeightSet() {
        return isSet.contains("matchTrafficWeight");
    }
}