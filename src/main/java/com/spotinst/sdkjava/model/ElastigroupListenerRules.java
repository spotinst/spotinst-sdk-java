package com.spotinst.sdkjava.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.Set;

public class ElastigroupListenerRules {
    //region Members
    @JsonIgnore
    private Set<String> isSet;
    private String ruleArn;
    //endregion

    //region Constructors

    private ElastigroupListenerRules() {
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

    public String getRuleArn() {
        return ruleArn;
    }

    public void setRuleArn(String ruleArn) {
        isSet.add("ruleArn");
        this.ruleArn = ruleArn;
    }

    //endregion

    //region Builder class
    public static class Builder {
        private ElastigroupListenerRules listenerRules;

        private Builder() {
            this.listenerRules = new ElastigroupListenerRules();
        }

        public static Builder get() {
            Builder builder = new Builder();
            return builder;
        }

        public Builder setRuleArnType(final String ruleArnType) {
            listenerRules.setRuleArn(ruleArnType);
            return this;
        }


        public ElastigroupListenerRules build() {
            return listenerRules;
        }
    }
    //endregion
    //region isSet methods
    // Is ruleArn Set boolean method
    @JsonIgnore
    public boolean isRuleArnSet() {
        return isSet.contains("ruleArn");
    }

    //endregion
}
