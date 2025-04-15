package com.spotinst.sdkjava.model.bl.mrScaler.aws;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MrScalerScaleDownAws {
    @JsonIgnore
    private Set<String> isSet;
    private List<String> modifiedInstanceGroups;
    private List<String> victimInstances;

    private MrScalerScaleDownAws() {
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

    public List<String> getVictimInstances() {
        return this.victimInstances;
    }

    public void setVictimInstances(List<String> victimInstances) {
        isSet.add("victimInstances");
        this.victimInstances = victimInstances;
    }

    public static class Builder {
        private MrScalerScaleDownAws mrScalerScaleDownAws;

        private Builder() {
            this.mrScalerScaleDownAws = new MrScalerScaleDownAws();
        }

        public static Builder get() {
            Builder builder = new Builder();
            return builder;
        }

        public Builder setModifiedInstanceGroups(final List<String> modifiedInstanceGroups) {
            mrScalerScaleDownAws.setModifiedInstanceGroups(modifiedInstanceGroups);
            return this;
        }

        public Builder setVictimInstances(final List<String> victimInstances) {
            mrScalerScaleDownAws.setVictimInstances(victimInstances);
            return this;
        }

        public MrScalerScaleDownAws build(){
            return mrScalerScaleDownAws;
        }
    }

    @JsonIgnore
    public Boolean isModifiedInstanceGroupsSet(){
        return isSet.contains("modifiedInstanceGroups");
    }

    @JsonIgnore
    public Boolean isVictimInstancesSet(){
        return isSet.contains("victimInstances");
    }
}