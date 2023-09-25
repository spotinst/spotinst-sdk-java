package com.spotinst.sdkjava.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.spotinst.sdkjava.model.bl.elastigroup.aws.DefaultStaticTargetGroups;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ElastigroupItfLoadBalancer {
    //region Members
    @JsonIgnore
    private Set<String>                   isSet;
    private String                        loadBalancerArn;
    private List<ElastigroupListenerRule> listenerRules;
    private List<DefaultStaticTargetGroups>     defaultStaticTargetGroups;
    //endregion

    //region Constructor

    private ElastigroupItfLoadBalancer() {
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

    public String getLoadBalancerArn() {
        return loadBalancerArn;
    }

    public void setLoadBalancerArn(String loadBalancerArn) {
        isSet.add("loadBalancerArn");
        this.loadBalancerArn = loadBalancerArn;
    }

    public List<ElastigroupListenerRule> getListenerRules() {
        return listenerRules;
    }

    public void setListenerRules(List<ElastigroupListenerRule> listenerRules) {
        isSet.add("listenerRules");
        this.listenerRules = listenerRules;
    }

    public List<DefaultStaticTargetGroups> getDefaultStaticTargetGroups() {
        return defaultStaticTargetGroups;
    }

    public void setDefaultStaticTargetGroups(List<DefaultStaticTargetGroups> defaultStaticTargetGroups) {
        isSet.add("defaultStaticTargetGroups");
        this.defaultStaticTargetGroups = defaultStaticTargetGroups;
    }

    //endregion

    //region Builder class
    public static class Builder {
        private ElastigroupItfLoadBalancer itf;

        private Builder() {
            this.itf = new ElastigroupItfLoadBalancer();
        }

        public static Builder get() {
            return new Builder();
        }

        public Builder setLoadBalancerArn(final String loadBalancerArn) {
            itf.setLoadBalancerArn(loadBalancerArn);
            return this;
        }

        public Builder setListenerRules(final List<ElastigroupListenerRule> listenerRules) {
            itf.setListenerRules(listenerRules);
            return this;
        }

        public Builder setDefaultStaticTargetGroups(final List<DefaultStaticTargetGroups> defaultStaticTargetGroups) {
            itf.setDefaultStaticTargetGroups(defaultStaticTargetGroups);
            return this;
        }

        public ElastigroupItfLoadBalancer build() {
            return itf;
        }
    }
    //endregion
    //region isSet methods

    // Is loadBalancerArn Set boolean method
    @JsonIgnore
    public boolean isLoadBalancerArnSet() { return isSet.contains("loadBalancerArn"); }

    // Is listenerRules Set boolean method
    @JsonIgnore
    public boolean isListenerRulesSet() {
        return isSet.contains("listenerRules");
    }

    // Is defaultStaticTargetGroups Set boolean method
    @JsonIgnore
    public boolean isDefaultStaticTargetGroupsSet() {
        return isSet.contains("defaultStaticTargetGroups");
    }
    //endregion
}
