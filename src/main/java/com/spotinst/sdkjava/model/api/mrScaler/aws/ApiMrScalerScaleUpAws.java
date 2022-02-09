package com.spotinst.sdkjava.model.api.mrScaler.aws;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ApiMrScalerScaleUpAws {
    @JsonIgnore
    private Set<String>  isSet;
    private List<String> modifiedInstanceGroups;
    private List<String> newInstanceGroups;

    public ApiMrScalerScaleUpAws() {
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

    public List<String> getNewInstanceGroups() {
        return newInstanceGroups;
    }

    public void setNewInstanceGroups(List<String> newInstanceGroups) {
        isSet.add("newInstanceGroups");
        this.newInstanceGroups = newInstanceGroups;
    }

    public Boolean isNewInstanceGroupsSet(){
        return isSet.contains("newInstanceGroups");
    }

    public static class Builder {
        private ApiMrScalerScaleUpAws apiMrScalerScaleUpAws;

        private Builder() {
            this.apiMrScalerScaleUpAws = new ApiMrScalerScaleUpAws();
        }

        public static Builder get() {
            Builder builder = new Builder();
            return builder;
        }

        //region Build methods
        public Builder setModifiedInstanceGroups(final List<String> modifiedInstanceGroups) {
            apiMrScalerScaleUpAws.setModifiedInstanceGroups(modifiedInstanceGroups);
            return this;
        }

        public Builder setNewInstanceGroups(final List<String> newInstanceGroups) {
            apiMrScalerScaleUpAws.setNewInstanceGroups(newInstanceGroups);
            return this;
        }
        // endregion
    }
}