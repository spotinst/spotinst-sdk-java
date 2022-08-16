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
public class ApiRolloutSpec implements IPartialUpdateEntity {
    @JsonIgnore
    private Set<String>                               isSet;
    private String                                    name;
    private ApiRolloutSpecSpotDeployment spotDeployment;
    private ApiRolloutSpecStrategy strategy;
    private ApiRolloutSpecTraffic traffic;
    private ApiRolloutSpecFailurePolicy failurePolicy;

    public ApiRolloutSpec() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        isSet.add("name");
        this.name = name;
    }

    public ApiRolloutSpecSpotDeployment getSpotDeployment() {
        return spotDeployment;
    }

    public void setSpotDeployment(ApiRolloutSpecSpotDeployment spotDeployment) {
        isSet.add("spotDeployment");
        this.spotDeployment = spotDeployment;
    }

    public ApiRolloutSpecStrategy getStrategy() {
        return strategy;
    }

    public void setStrategy(ApiRolloutSpecStrategy strategy) {
        isSet.add("strategy");
        this.strategy = strategy;
    }

    public ApiRolloutSpecTraffic getTraffic() {
        return traffic;
    }

    public void setTraffic(ApiRolloutSpecTraffic traffic) {
        isSet.add("traffic");
        this.traffic = traffic;
    }

    public ApiRolloutSpecFailurePolicy getFailurePolicy() {
        return failurePolicy;
    }

    public void setFailurePolicy(ApiRolloutSpecFailurePolicy failurePolicy) {
        isSet.add("failurePolicy");
        this.failurePolicy = failurePolicy;
    }

    @JsonIgnore
    public boolean isNameSet() {
        return isSet.contains("name");
    }

    @JsonIgnore
    public boolean isSpotDeploymentSet() {
        return isSet.contains("spotDeployment");
    }

    @JsonIgnore
    public boolean isStrategySet() {
        return isSet.contains("strategy");
    }

    @JsonIgnore
    public boolean isTrafficSet() {
        return isSet.contains("traffic");
    }

    @JsonIgnore
    public boolean isFailurePolicySet() {
        return isSet.contains("failurePolicy");
    }
}