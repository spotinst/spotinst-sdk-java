package com.spotinst.sdkjava.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.Set;

public class ElastigroupThirdPartiesIntegrationConfiguration {
    //region Members
    // Partial Update support
    @JsonIgnore
    private Set<String>                 isSet;
    private ElastigroupEcsSpecification ecs;
    //endregion

    //region Constructor

    private ElastigroupThirdPartiesIntegrationConfiguration() {
        isSet = new HashSet<>();
    }
    //endregion

    //region Getters & Setters

    public ElastigroupEcsSpecification getEcs() {
        return ecs;
    }

    public void setEcs(ElastigroupEcsSpecification ecs) {
        isSet.add("ecs");
        this.ecs = ecs;
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    //endregion
    //region Builder class
    public static class Builder {
        private ElastigroupThirdPartiesIntegrationConfiguration ThirdPartiesIntegration;

        private Builder() {
            this.ThirdPartiesIntegration = new ElastigroupThirdPartiesIntegrationConfiguration();
        }

        public static Builder get() {
            Builder builder = new Builder();
            return builder;
        }

        public Builder setEcs(final ElastigroupEcsSpecification ecs) {
            ThirdPartiesIntegration.setEcs(ecs);
            return this;
        }

        public ElastigroupThirdPartiesIntegrationConfiguration build() {
            return ThirdPartiesIntegration;
        }
    }
    //endregion

    //region isSet methods
    // Is ecs Set boolean method
    @JsonIgnore
    public boolean isEcsSet() {
        return isSet.contains("ecs");
    }

    //endregion

}
