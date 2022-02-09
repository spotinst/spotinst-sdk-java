package com.spotinst.sdkjava.model.api.mrScaler.aws;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ApiMrScalerScaleDownAws {
    @JsonIgnore
    private Set<String>  isSet;
    private List<String> modifiedInstanceGroups;
    private List<String> victimInstances;

    public ApiMrScalerScaleDownAws() {
        isSet = new HashSet<>();
    }

    public List<String> getModifiedInstanceGroups() {
        return modifiedInstanceGroups;
    }

    public void setModifiedInstanceGroups(List<String> modifiedInstanceGroups) {
        isSet.add("modifiedInstanceGroups");
        this.modifiedInstanceGroups = modifiedInstanceGroups;
    }

    public Boolean isModifiedInstanceGroupsSet(){
        return isSet.contains("modifiedInstanceGroups");
    }

    public List<String> getVictimInstances() {
        return victimInstances;
    }

    public void setVictimInstances(List<String> victimInstances) {
        isSet.add("victimInstances");
        this.victimInstances = victimInstances;
    }

    public Boolean isVictimInstancesSet(){
        return isSet.contains("victimInstances");
    }

    public static class Builder {
        private ApiMrScalerScaleDownAws apiMrScalerScaleDownAws;

        private Builder() {
            this.apiMrScalerScaleDownAws = new ApiMrScalerScaleDownAws();
        }

        public static Builder get() {
            Builder builder = new Builder();
            return builder;
        }

        //region Build methods
        public Builder setModifiedInstanceGroups(final List<String> modifiedInstanceGroups) {
            apiMrScalerScaleDownAws.setModifiedInstanceGroups(modifiedInstanceGroups);
            return this;
        }

        public Builder setVictimInstances(final List<String> victimInstances) {
            apiMrScalerScaleDownAws.setVictimInstances(victimInstances);
            return this;
        }
        // endregion
    }
}