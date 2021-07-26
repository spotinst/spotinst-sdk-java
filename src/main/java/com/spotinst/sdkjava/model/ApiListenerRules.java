package com.spotinst.sdkjava.model;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.spotinst.sdkjava.client.rest.IPartialUpdateEntity;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by ohadmuchnik on 12/07/2016.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonFilter("PartialUpdateEntityFilter")
class ApiListenerRules implements IPartialUpdateEntity {
    //region Members

    @JsonIgnore
    private Set<String>  isSet;
    private String       ruleArn;

    //endregion

    //region Constructor

    public ApiListenerRules() {
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
    
    //region isSet methods
    // Is ruleArn Set boolean method
    @JsonIgnore
    public boolean isRuleArnSet() {
        return isSet.contains("ruleArn");
    }

    //endregion
}
