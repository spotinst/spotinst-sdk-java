package com.spotinst.sdkjava.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.spotinst.sdkjava.model.bl.elastigroup.aws.ElasticBeanstalk;

import java.util.HashSet;
import java.util.Set;

public class ElastigroupThirdPartiesIntegrationConfiguration {
    //region Members
    // Partial Update support
    @JsonIgnore
    private Set<String>                 isSet;
    private ElastigroupEcsSpecification ecs;
    private ElastigroupCodeDeploy       codeDeploy;
    private ElasticBeanstalk            elasticBeanstalk;
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

    public ElastigroupCodeDeploy getCodeDeploy() {
        return codeDeploy;
    }

    public void setCodeDeploy(ElastigroupCodeDeploy codeDeploy) {
        isSet.add("codeDeploy");
        this.codeDeploy = codeDeploy;
    }

    public ElasticBeanstalk getElasticBeanstalk() {
        return elasticBeanstalk;
    }

    public void setElasticBeanstalk(ElasticBeanstalk elasticBeanstalk) {
        isSet.add("elasticBeanstalk");
        this.elasticBeanstalk = elasticBeanstalk;
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
            return new Builder();
        }

        public Builder setEcs(final ElastigroupEcsSpecification ecs) {
            ThirdPartiesIntegration.setEcs(ecs);
            return this;
        }

        public Builder setCodeDeploy(final ElastigroupCodeDeploy codeDeploy) {
            ThirdPartiesIntegration.setCodeDeploy(codeDeploy);
            return this;
        }

        public Builder setElasticBeanstalk(final ElasticBeanstalk elasticBeanstalk) {
            ThirdPartiesIntegration.setElasticBeanstalk(elasticBeanstalk);
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

    // Is codeDeploy Set boolean method
    @JsonIgnore
    public boolean isCodeDeploySet() {
        return isSet.contains("codeDeploy");
    }

    // Is elasticBeanstalk Set boolean method
    @JsonIgnore
    public boolean isElasticBeanstalkSet() {
        return isSet.contains("elasticBeanstalk");
    }

    //endregion

}
