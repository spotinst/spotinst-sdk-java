package com.spotinst.sdkjava.model;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.spotinst.sdkjava.client.rest.IPartialUpdateEntity;
import com.spotinst.sdkjava.model.api.elastigroup.aws.ApiElasticBeanstalk;

import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonFilter("PartialUpdateEntityFilter")
class ApiThirdPartiesIntegration implements IPartialUpdateEntity {
    //region Members
    @JsonIgnore
    private Set<String>   isSet;
    private ApiEcs        ecs;
    private ApiCodeDeploy codeDeploy;
    private ApiElasticBeanstalk elasticBeanstalk;
    //endregion

    //region Constructor

    public ApiThirdPartiesIntegration() {
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

    public ApiEcs getEcs() {
        return ecs;
    }

    public void setEcs(ApiEcs ecs) {
        isSet.add("ecs");
        this.ecs = ecs;
    }

    public ApiCodeDeploy getCodeDeploy() {
        return codeDeploy;
    }

    public void setCodeDeploy(ApiCodeDeploy codeDeploy) {
        isSet.add("codeDeploy");
        this.codeDeploy = codeDeploy;
    }


    public ApiElasticBeanstalk getElasticBeanstalk() {
        return elasticBeanstalk;
    }

    public void setElasticBeanstalk(ApiElasticBeanstalk elasticBeanstalk) {
        isSet.add("elasticBeanstalk");
        this.elasticBeanstalk = elasticBeanstalk;
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
    public boolean isElasticBeanstalk() {
        return isSet.contains("elasticBeanstalk");
    }
    //endregion

}
