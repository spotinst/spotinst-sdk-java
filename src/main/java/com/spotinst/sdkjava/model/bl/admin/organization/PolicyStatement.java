package com.spotinst.sdkjava.model.bl.admin.organization;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.spotinst.sdkjava.enums.admin.account.PolicyEffectEnum;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PolicyStatement {
    @JsonIgnore
    private Set<String>      isSet;
    private PolicyEffectEnum effect;
    private List<String>     actions;
    private List<String>     resources;

    public PolicyStatement() {
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

    public static class Builder {
        private PolicyStatement statements;

        private Builder() {
            this.statements = new PolicyStatement();
        }

        public static Builder get() {
            Builder builder = new Builder();
            return builder;
        }

        public Builder setEffect(final PolicyEffectEnum effect) {
            statements.setEffect(effect);
            return this;
        }

        public Builder setActions(final List<String> actions) {
            statements.setActions(actions);
            return this;
        }

        public Builder setResources(final List<String> resources) {
            statements.setResources(resources);
            return this;
        }

        public PolicyStatement build() {
            return statements;
        }
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
