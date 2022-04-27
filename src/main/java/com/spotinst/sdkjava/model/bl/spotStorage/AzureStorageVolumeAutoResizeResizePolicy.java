package com.spotinst.sdkjava.model.bl.spotStorage;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.Set;

public class AzureStorageVolumeAutoResizeResizePolicy {
    //region Members
    @JsonIgnore
    private Set<String>                                    isSet;
    private String                                         policyName;
    private Integer                                        usagePercentage;
    private String                                         operator;
    private AzureStorageVolumeAutoResizeResizePolicyAction action;
    private Integer                                        period;
    private Integer                                        consecutivePeriods;
    private Integer                                        cooldown;
    //endregion

    //region Constructor
    private AzureStorageVolumeAutoResizeResizePolicy() {
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
    public AzureStorageVolumeAutoResizeResizePolicyAction getAction() {
        return action;
    }

    public void setAction(AzureStorageVolumeAutoResizeResizePolicyAction action) {
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

    //region Builder class
    public static class Builder {
        //region Members
        private AzureStorageVolumeAutoResizeResizePolicy volumeAutoResizeResizePolicy;
        //endregion


        private Builder() {
            this.volumeAutoResizeResizePolicy = new AzureStorageVolumeAutoResizeResizePolicy();
        }

        public static Builder get() {
            return new Builder();
        }

        //region Build methods
        public Builder setPolicyName(final String policyName) {
            volumeAutoResizeResizePolicy.setPolicyName(policyName);
            return this;
        }

        public Builder setUsagePercentage(final Integer usagePercentage) {
            volumeAutoResizeResizePolicy.setUsagePercentage(usagePercentage);
            return this;
        }

        public Builder setOperator(final String operator) {
            volumeAutoResizeResizePolicy.setOperator(operator);
            return this;
        }

        public Builder setAction(final AzureStorageVolumeAutoResizeResizePolicyAction action) {
            volumeAutoResizeResizePolicy.setAction(action);
            return this;
        }

        public Builder setPeriod(final Integer period) {
            volumeAutoResizeResizePolicy.setPeriod(period);
            return this;
        }

        public Builder setConsecutivePeriods(final Integer consecutivePeriods) {
            volumeAutoResizeResizePolicy.setConsecutivePeriods(consecutivePeriods);
            return this;
        }

        public Builder setCooldown(final Integer cooldown) {
            volumeAutoResizeResizePolicy.setCooldown(cooldown);
            return this;
        }

        public AzureStorageVolumeAutoResizeResizePolicy build() {
            // Validations
            return volumeAutoResizeResizePolicy;
        }
        //endregion
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
