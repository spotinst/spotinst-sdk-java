package com.spotinst.sdkjava.model;

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
class ApiListenerRule implements IPartialUpdateEntity {
    //region Members

    @JsonIgnore
    private Set<String>  isSet;
    private String       ruleArn;
    private List<ApiStaticTargetGroups> staticTargetGroups;

    //endregion

    //region Constructor

    public ApiListenerRule() {
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

    public List<ApiStaticTargetGroups> getStaticTargetGroups() {
        return staticTargetGroups;
    }

    public void setStaticTargetGroups(List<ApiStaticTargetGroups> staticTargetGroups) {
        isSet.add("staticTargetGroups");
        this.staticTargetGroups = staticTargetGroups;
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
