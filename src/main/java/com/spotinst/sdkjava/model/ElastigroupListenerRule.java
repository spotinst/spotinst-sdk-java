package com.spotinst.sdkjava.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ElastigroupListenerRule {
    //region Members
    @JsonIgnore
    private Set<String> isSet;
    private String ruleArn;
    private List<StaticTargetGroups> staticTargetGroups;
    //endregion

    //region Constructors

    private ElastigroupListenerRule() {
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

    public List<StaticTargetGroups> getStaticTargetGroups() {
        return staticTargetGroups;
    }

    public void setStaticTargetGroups(List<StaticTargetGroups> staticTargetGroups) {
        isSet.add("staticTargetGroups");
        this.staticTargetGroups = staticTargetGroups;
    }

    //endregion

    //region Builder class
    public static class Builder {
        private ElastigroupListenerRule listenerRules;

        private Builder() {
            this.listenerRules = new ElastigroupListenerRule();
        }

        public static Builder get() {
            return new Builder();
        }

        public Builder setRuleArn(final String ruleArn) {
            listenerRules.setRuleArn(ruleArn);
            return this;
        }

        public Builder setStaticTargetGroups(final List<StaticTargetGroups> staticTargetGroups) {
            listenerRules.setStaticTargetGroups(staticTargetGroups);
            return this;
        }

        public ElastigroupListenerRule build() {
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

    // Is staticTargetGroups Set boolean method
    @JsonIgnore
    public boolean isStaticTargetGroupsSet() {
        return isSet.contains("staticTargetGroups");
    }

    //endregion
}
