package com.spotinst.sdkjava.model.api.admin.organization;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.spotinst.sdkjava.client.rest.IPartialUpdateEntity;
import com.spotinst.sdkjava.enums.admin.account.PolicyEffectEnum;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonFilter("PartialUpdateEntityFilter")
public class ApiPolicyStatement implements IPartialUpdateEntity {
    @JsonIgnore
    private Set<String>      isSet;
    private PolicyEffectEnum effect;
    private List<String>     actions;
    private List<String>     resources;

    public ApiPolicyStatement() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public PolicyEffectEnum getEffect() {
        return effect;
    }

    public void setEffect(PolicyEffectEnum effect) {
        isSet.add("effect");
        this.effect = effect;
    }

    public List<String> getActions() {
        return actions;
    }

    public void setActions(List<String> actions) {
        isSet.add("actions");
        this.actions = actions;
    }

    public List<String> getResources() {
        return resources;
    }

    public void setResources(List<String> resources) {
        isSet.add("resources");
        this.resources = resources;
    }

    @JsonIgnore
    public boolean isEffectSet() {
        return isSet.contains("effect");
    }

    @JsonIgnore
    public boolean isActionsSet() {
        return isSet.contains("actions");
    }

    @JsonIgnore
    public boolean isResourcesSet() {
        return isSet.contains("resources");
    }
}
