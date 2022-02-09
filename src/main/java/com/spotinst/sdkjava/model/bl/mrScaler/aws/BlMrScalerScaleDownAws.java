package com.spotinst.sdkjava.model.bl.mrScaler.aws;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BlMrScalerScaleDownAws {

    private List<String> modifiedInstanceGroups;
    private List<String> victimInstances;

    public List<String> getModifiedInstanceGroups() {
        return this.modifiedInstanceGroups;
    }

    public void setModifiedInstanceGroups(List<String> modifiedInstanceGroups) {
        this.modifiedInstanceGroups = modifiedInstanceGroups;
    }

    public List<String> getVictimInstances() {
        return this.victimInstances;
    }

    public void setVictimInstances(List<String> victimInstances) {
        this.victimInstances = victimInstances;
    }
}