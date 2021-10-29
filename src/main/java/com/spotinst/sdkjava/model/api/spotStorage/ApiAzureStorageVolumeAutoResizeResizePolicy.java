package com.spotinst.sdkjava.model.api.spotStorage;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.spotinst.sdkjava.client.rest.IPartialUpdateEntity;

import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonFilter("PartialUpdateEntityFilter")
public class ApiAzureStorageVolumeAutoResizeResizePolicy implements IPartialUpdateEntity {
    //region Members
    @JsonIgnore
    private Set<String>                                       isSet;
    private String                                            policyName;
    private Integer                                           usagePercentage;
    private String                                            operator;
    private ApiAzureStorageVolumeAutoResizeResizePolicyAction action;
    private Integer                                           period;
    private Integer                                           consecutivePeriods;
    private Integer                                           cooldown;
    //endregion

    //region Constructor
    public ApiAzureStorageVolumeAutoResizeResizePolicy() {
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

    //region PolicyName
    public String getPolicyName() {
        return policyName;
    }

    public void setPolicyName(String policyName) {
        isSet.add("policyName");
        this.policyName = policyName;
    }
    //endregion

    //region UsagePercentage
    public Integer getUsagePercentage() {
        return usagePercentage;
    }

    public void setUsagePercentage(Integer usagePercentage) {
        isSet.add("usagePercentage");
        this.usagePercentage = usagePercentage;
    }
    //endregion

    //region Operator
    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        isSet.add("operator");
        this.operator = operator;
    }
    //endregion

    //region Action
    public ApiAzureStorageVolumeAutoResizeResizePolicyAction getAction() {
        return action;
    }

    public void setAction(ApiAzureStorageVolumeAutoResizeResizePolicyAction action) {
        isSet.add("action");
        this.action = action;
    }
    //endregion

    //region Period
    public Integer getPeriod() {
        return period;
    }

    public void setPeriod(Integer period) {
        isSet.add("period");
        this.period = period;
    }
    //endregion

    //region ConsecutivePeriods
    public Integer getConsecutivePeriods() {
        return consecutivePeriods;
    }

    public void setConsecutivePeriods(Integer consecutivePeriods) {
        isSet.add("consecutivePeriods");
        this.consecutivePeriods = consecutivePeriods;
    }
    //endregion

    //region Cooldown
    public Integer getCooldown() {
        return cooldown;
    }

    public void setCooldown(Integer cooldown) {
        isSet.add("cooldown");
        this.cooldown = cooldown;
    }
    //endregion


    //region isSet methods
    // Is policyName Set boolean method
    @JsonIgnore
    public boolean isPolicyNameSet() {
        return isSet.contains("policyName");
    }

    // Is usagePercentage Set boolean method
    @JsonIgnore
    public boolean isUsagePercentageSet() {
        return isSet.contains("usagePercentage");
    }

    // Is operator Set boolean method
    @JsonIgnore
    public boolean isOperatorSet() {
        return isSet.contains("operator");
    }

    // Is action Set boolean method
    @JsonIgnore
    public boolean isActionSet() {
        return isSet.contains("action");
    }

    // Is period Set boolean method
    @JsonIgnore
    public boolean isPeriodSet() {
        return isSet.contains("period");
    }

    // Is consecutivePeriods Set boolean method
    @JsonIgnore
    public boolean isConsecutivePeriodsSet() {
        return isSet.contains("consecutivePeriods");
    }

    // Is cooldown Set boolean method
    @JsonIgnore
    public boolean isCooldownSet() {
        return isSet.contains("cooldown");
    }
    //endregion
}
