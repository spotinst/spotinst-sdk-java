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
public class ApiElastigroupPreferredInstanceTypesGcp implements IPartialUpdateEntity {

    @JsonIgnore
    private Set<String>                                 isSet;
    private List<String>                                preemptible;
    private ApiElastigroupCustomInstanceTypesGcp        custom;

    public ApiElastigroupPreferredInstanceTypesGcp() {
        isSet = new HashSet<>();
    }

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

    public ApiElastigroupCustomInstanceTypesGcp getCustom() {
        return custom;
    }

    public void setCustom(ApiElastigroupCustomInstanceTypesGcp custom) {
        isSet.add("custom");
        this.custom = custom;
    }

    @JsonIgnore
    public boolean isPreemptibleSet() {
        return isSet.contains("preemptible");
    }

    @JsonIgnore
    public boolean isCustomSet() { return isSet.contains("custom"); }
}
