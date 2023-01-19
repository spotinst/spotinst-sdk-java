package com.spotinst.sdkjava.model.api.aws.managedInstance;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.spotinst.sdkjava.client.rest.IPartialUpdateEntity;
import com.spotinst.sdkjava.model.bl.aws.managedInstance.Costs;
import com.spotinst.sdkjava.model.bl.aws.managedInstance.Running;
import com.spotinst.sdkjava.model.bl.aws.managedInstance.Savings;

import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonFilter("PartialUpdateEntityFilter")
public class ApiGetInstanceCost implements IPartialUpdateEntity {

    @JsonIgnore
    private Set<String> isSet;
    private Costs      costs;
    private Running    running;
    private Savings    savings;

    private ApiGetInstanceCost() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }


    public Costs getCosts() {
        return costs;
    }

    public void setCosts(Costs costs) {
        isSet.add("costs");
        this.costs = costs;
    }

    public Running getRunning() {
        return running;
    }

    public void setRunning(Running running) {
        isSet.add("running");
        this.running = running;
    }

    public Savings getSavings() {
        return savings;
    }

    public void setSavings(Savings savings) {
        isSet.add("savings");
        this.savings = savings;
    }

    @JsonIgnore
    public boolean isCostsSet() {
        return isSet.contains("costs");
    }

    @JsonIgnore
    public boolean isRunningSet() {
        return isSet.contains("running");
    }

    @JsonIgnore
    public boolean isSavingsSet() {
        return isSet.contains("savings");
    }

}

