package com.spotinst.sdkjava.model.bl.mrScaler.aws;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MrScalerScaleUpAws {
    @JsonIgnore
    private Set<String> isSet;
    private List<String> modifiedInstanceGroups;
    private List<String> newInstanceGroups;

    private MrScalerScaleUpAws() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public List<String> getModifiedInstanceGroups() {
        return this.modifiedInstanceGroups;
    }

    public void setModifiedInstanceGroups(List<String> modifiedInstanceGroups) {
        isSet.add("modifiedInstanceGroups");
        this.modifiedInstanceGroups = modifiedInstanceGroups;
    }

    public List<String> getNewInstanceGroups() {
        return this.newInstanceGroups;
    }

    public void setNewInstanceGroups(List<String> newInstanceGroups) {
        isSet.add("newInstanceGroups");
        this.newInstanceGroups = newInstanceGroups;
    }

    public static class Builder {
        private MrScalerScaleUpAws mrScalerScaleUpAws;

        private Builder() {
            this.mrScalerScaleUpAws = new MrScalerScaleUpAws();
        }

        public static Builder get() {
            Builder builder = new Builder();
            return builder;
        }

        public Builder setModifiedInstanceGroups(final List<String> modifiedInstanceGroups) {
            mrScalerScaleUpAws.setModifiedInstanceGroups(modifiedInstanceGroups);
            return this;
        }

        public Builder setNewInstanceGroups(final List<String> newInstanceGroups) {
            mrScalerScaleUpAws.setNewInstanceGroups(newInstanceGroups);
            return this;
        }

        public MrScalerScaleUpAws build(){
            return mrScalerScaleUpAws;
        }

    }

    @JsonIgnore
    public Boolean isModifiedInstanceGroupsSet(){
        return isSet.contains("modifiedInstanceGroups");
    }

    @JsonIgnore
    public Boolean isNewInstanceGroupsSet(){
        return isSet.contains("newInstanceGroups");
    }
}