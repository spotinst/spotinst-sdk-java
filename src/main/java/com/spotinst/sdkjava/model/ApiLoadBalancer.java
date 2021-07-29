package com.spotinst.sdkjava.model;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.spotinst.sdkjava.client.rest.IPartialUpdateEntity;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by yossi.elman on 12/03/20.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonFilter("PartialUpdateEntityFilter")
public class ApiLoadBalancer implements IPartialUpdateEntity {
    //region Members
    // Partial Update support
    @JsonIgnore
    private Set<String> isSet;
    private String      name;
    private String      arn;
    private String      type;
    private String      balancerId;
    private String      targetSetId;
    private Boolean     azAwareness;
    private Boolean     autoWeight;
    //endregion

    //region Constructor

    public ApiLoadBalancer() {
        isSet = new HashSet<>();
    }
    //endregion

    //region Getters & Setters

    public Set<String> getIsSet() {
        return isSet;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        isSet.add("name");
        this.name = name;
    }

    @JsonIgnore
    public boolean isNameSet() {
        return isSet.contains("name");
    }

    public String getArn() {
        return arn;
    }

    public void setArn(String arn) {
        isSet.add("arn");
        this.arn = arn;
    }

    @JsonIgnore
    public boolean isArnSet() {
        return isSet.contains("arn");
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        isSet.add("type");
        this.type = type;
    }

    @JsonIgnore
    public boolean isTypeSet() { return isSet.contains("type"); }

    public String getBalancerId() {
        return balancerId;
    }

    public void setBalancerId(String balancerId) {
        isSet.add("balancerId");
        this.balancerId = balancerId;
    }

    @JsonIgnore
    public boolean isBalancerIdSet() { return isSet.contains("balancerId"); }

    public String getTargetSetId() {
        return targetSetId;
    }

    public void setTargetSetId(String targetSetId) {
        isSet.add("targetSetId");
        this.targetSetId = targetSetId;
    }

    @JsonIgnore
    public boolean isTargetSetIdSet() { return isSet.contains("targetSetId"); }

    public Boolean getAzAwareness() {
        return azAwareness;
    }

    public void setAzAwareness(Boolean azAwareness) {
        isSet.add("azAwareness");
        this.azAwareness = azAwareness;
    }

    @JsonIgnore
    public boolean isAzAwarenessSet() { return isSet.contains("azAwareness"); }

    public Boolean getAutoWeight() {
        return autoWeight;
    }

    public void setAutoWeight(Boolean autoWeight) {
        isSet.add("autoWeight");
        this.autoWeight = autoWeight;
    }

    @JsonIgnore
    public boolean isAutoWeightSet() { return isSet.contains("autoWeight"); }

    //endregion
}
