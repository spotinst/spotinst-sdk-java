package com.spotinst.sdkjava.model.api.azure.elastiGroup.V3;

import com.fasterxml.jackson.annotation.JsonIgnore;


import java.util.HashSet;
import java.util.Set;

public class ElastigroupThirdPartiesIntegrationConfigurationAzure {
    //region Members
    // Partial Update support
    @JsonIgnore
    private Set<String>                 isSet;
    private ElastigroupEcsSpecificationAzure ecs;
    //endregion

    //region Constructor

    private ElastigroupThirdPartiesIntegrationConfigurationAzure() {
        isSet = new HashSet<>();
    }
    //endregion

    //region Getters & Setters

    public ElastigroupEcsSpecificationAzure getEcs() {
        return ecs;
    }

    public void setEcs(ElastigroupEcsSpecificationAzure ecs) {
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
        private ElastigroupThirdPartiesIntegrationConfigurationAzure ThirdPartiesIntegration;

        private Builder() {
            this.ThirdPartiesIntegration = new ElastigroupThirdPartiesIntegrationConfigurationAzure();
        }

        public static Builder get() {
            Builder builder = new Builder();
            return builder;
        }

        public Builder setEcs(final ElastigroupEcsSpecificationAzure ecs) {
            ThirdPartiesIntegration.setEcs(ecs);
            return this;
        }

        public ElastigroupThirdPartiesIntegrationConfigurationAzure build() {
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
