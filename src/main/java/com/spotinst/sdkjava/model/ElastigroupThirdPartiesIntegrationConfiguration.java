package com.spotinst.sdkjava.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.spotinst.sdkjava.model.bl.elastigroup.aws.ElasticBeanstalk;
import com.spotinst.sdkjava.model.bl.elastigroup.aws.Nomad;
import com.spotinst.sdkjava.model.bl.elastigroup.aws.Route53;

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
    private Route53                     route53;
    private Nomad                       nomad;
    //endregion

    //region Constructor

    private ElastigroupThirdPartiesIntegrationConfiguration() {
        isSet = new HashSet<>();
    }
    //endregion

    //region Getters & Setters


    public Nomad getNomad() {
        return nomad;
    }

    public void setNomad(Nomad nomad) {
        isSet.add("nomad");
        this.nomad = nomad;
    }

    public Route53 getRoute53() {
        return route53;
    }

    public void setRoute53(Route53 route53) {
        isSet.add("route53");
        this.route53 = route53;
    }

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

        public Builder setNomad(final Nomad nomad) {
            ThirdPartiesIntegration.setNomad(nomad);
            return this;
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

        public Builder setRoute53(final Route53 route53) {
            ThirdPartiesIntegration.setRoute53(route53);
            return this;
        }

        public ElastigroupThirdPartiesIntegrationConfiguration build() {
            return ThirdPartiesIntegration;
        }
    }
    //endregion

    //region isSet methods
    // Is nomad Set boolean method
    @JsonIgnore
    public boolean isNomadSet() {
        return isSet.contains("nomad");
    }
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

    // Is route53 Set boolean method
    @JsonIgnore
    public boolean isRoute53Set() {
        return isSet.contains("route53");
    }
    //endregion
}
