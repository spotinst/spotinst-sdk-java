package com.spotinst.sdkjava.model.api.aws.managed.instance;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.Set;

public class ApiLoadBalancers {

    @JsonIgnore
    private Set<String> isSet;
    private String      arn;
    private Boolean     autoWeight;
    private Boolean     azAwareness;
    private String      balancerId;
    private String      name;
    private String      targetSetId;
    private String      type;

    private ApiLoadBalancers() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public String getArn() {
        return arn;
    }

    public void setArn(String arn) {
        isSet.add("arn");
        this.arn = arn;
    }

    public Boolean getAutoWeight() {
        return autoWeight;
    }

    public void setAutoWeight(Boolean autoWeight) {
        isSet.add("autoWeight");
        this.autoWeight = autoWeight;
    }

    public Boolean getAzAwareness() {
        return azAwareness;
    }

    public void setAzAwareness(Boolean azAwareness) {
        isSet.add("azAwareness");
        this.azAwareness = azAwareness;
    }

    public String getBalancerId() {
        return balancerId;
    }

    public void setBalancerId(String balancerId) {
        isSet.add("balancerId");
        this.balancerId = balancerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        isSet.add("name");
        this.name = name;
    }

    public String getTargetSetId() {
        return targetSetId;
    }

    public void setTargetSetId(String targetSetId) {
        isSet.add("targetSetId");
        this.targetSetId = targetSetId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        isSet.add("type");
        this.type = type;
    }

    @JsonIgnore
    public boolean isArnSet() {
        return isSet.contains("arn");
    }

    @JsonIgnore
    public boolean isAutoWeightSet() {
        return isSet.contains("autoWeight");
    }

    @JsonIgnore
    public boolean isAzAwarenessSet() {
        return isSet.contains("azAwareness");
    }

    @JsonIgnore
    public boolean isBalancerIdSet() {
        return isSet.contains("balancerId");
    }

    @JsonIgnore
    public boolean isNameSet() {
        return isSet.contains("name");
    }

    @JsonIgnore
    public boolean isTargetSetIdSet() {
        return isSet.contains("targetSetId");
    }

    @JsonIgnore
    public boolean isTypeSet() {
        return isSet.contains("type");
    }

}
