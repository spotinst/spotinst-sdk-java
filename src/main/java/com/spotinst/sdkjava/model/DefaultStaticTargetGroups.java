package com.spotinst.sdkjava.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by aharontwizer on 8/24/15.
 */
public class DefaultStaticTargetGroups {

    //region Members
    @JsonIgnore
    private Set<String>              isSet;
    private String                   arn;
    private Float                    percentage;
    //endregion

    //region Constructor
    public DefaultStaticTargetGroups() {
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

    public String getArn() {
        return arn;
    }

    public void setArn(String arn) {
        isSet.add("arn");
        this.arn = arn;
    }

    public Float getPercentage() {
        return percentage;
    }

    public void setPercentage(Float percentage) {
        isSet.add("percentage");
        this.percentage = percentage;
    }

    //endregion

    //region Builder class
    public static class Builder {
        private DefaultStaticTargetGroups defaultStaticTargetGroups;

        private Builder() {
            this.defaultStaticTargetGroups = new DefaultStaticTargetGroups();
        }

        public static Builder get() {
            return new Builder();
        }

        public Builder setArn(final String arn) {
            defaultStaticTargetGroups.setArn(arn);
            return this;
        }

        public Builder setPercentage(final Float percentage) {
            defaultStaticTargetGroups.setPercentage(percentage);
            return this;
        }

        public DefaultStaticTargetGroups build() {
            return defaultStaticTargetGroups;
        }
    }

    //endregion

    //region isSet methods
    // Is arn Set boolean method
    @JsonIgnore
    public boolean isArnSet() {
        return isSet.contains("arn");
    }

    // Is percentage Set boolean method
    @JsonIgnore
    public boolean isPercentageSet() {
        return isSet.contains("percentage");
    }

    //endregion
}
