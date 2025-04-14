package com.spotinst.sdkjava.model.api.gcp;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.spotinst.sdkjava.client.rest.IPartialUpdateEntity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonFilter("PartialUpdateEntityFilter")
public class ApiInstanceTypesGcp implements IPartialUpdateEntity {
    //region members
    @JsonIgnore
    private Set<String>                             isSet;
    private List<String>                            preemptible;
    private String                                  ondemand;
    private ApiElastigroupCustomInstanceTypesGcp    custom;
    private ApiElastigroupPreferredInstanceTypesGcp preferred;
    //endregion

    //region Constructor
    public ApiInstanceTypesGcp() {
        isSet = new HashSet<>();
    }
    //endregion

    //region Getters & Setters
    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public List<String> getPreemptible() {
        return preemptible;
    }

    public void setPreemptible(List<String> preemptible) {
        isSet.add("preemptible");
        this.preemptible = preemptible;
    }

    public String getOndemand() {
        return ondemand;
    }

    public void setOndemand(String ondemand) {
        isSet.add("ondemand");
        this.ondemand = ondemand;
    }

    public ApiElastigroupCustomInstanceTypesGcp getCustom() {
        return custom;
    }

    public void setCustom(ApiElastigroupCustomInstanceTypesGcp custom) {
        isSet.add("custom");
        this.custom = custom;
    }

    public ApiElastigroupPreferredInstanceTypesGcp getPreferred() {
        return preferred;
    }

    public void setPreferred(ApiElastigroupPreferredInstanceTypesGcp preferred) {
        isSet.add("preferred");
        this.preferred = preferred;
    }
    //endregion

    //region isSet methods
    // Is preemptible Set boolean method
    @JsonIgnore
    public boolean isPreemptibleSet() {
        return isSet.contains("preemptible");
    }

    // Is ondemand Set boolean method
    @JsonIgnore
    public boolean isOndemandSet() {
        return isSet.contains("ondemand");
    }

    @JsonIgnore
    public boolean isCustomSet() { return isSet.contains("custom"); }

    @JsonIgnore
    public boolean isPreferredSet() { return isSet.contains("preferred"); }
    //endregion
}
