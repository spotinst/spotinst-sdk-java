package com.spotinst.sdkjava.model.bl.aws.managed.instance;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Compute {

    //region Members
    @JsonIgnore
    private Set<String>         isSet;
    private String              elasticIp;
    private LaunchSpecification launchSpecification;
    private String              privateIp;
    private String              product;
    private List<String>        subnetIds;
    private String              vpcId;

    //endregion

    //region Constructor
    private Compute() {
        isSet = new HashSet<>();
    }
    //endregion

    //region Setters&Getters

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public String getElasticIp() {
        return elasticIp;
    }

    public void setElasticIp(String elasticIp) {
        isSet.add("elasticIp");
        this.elasticIp = elasticIp;
    }

    public LaunchSpecification getLaunchSpecification() {
        return launchSpecification;
    }

    public void setLaunchSpecification(LaunchSpecification launchSpecification) {
        isSet.add("launchSpecification");
        this.launchSpecification = launchSpecification;
    }

    public String getPrivateIp() {
        return privateIp;
    }

    public void setPrivateIp(String privateIp) {
        isSet.add("privateIp");
        this.privateIp = privateIp;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        isSet.add("product");
        this.product = product;
    }

    public List<String> getSubnetIds() {
        return subnetIds;
    }

    public void setSubnetIds(List<String> subnetIds) {
        isSet.add("subnetIds");
        this.subnetIds = subnetIds;
    }

    public String getVpcId() {
        return vpcId;
    }

    public void setVpcId(String vpcId) {
        isSet.add("vpcId");
        this.vpcId = vpcId;
    }

    //endregion

    //region Builder class
    public static class Builder {
        private Compute compute;

        private Builder() {
            this.compute = new Compute();
        }

        public static Builder get() {
            Builder builder = new Builder();
            return builder;
        }

        public Builder setElasticIp(final String elasticIp) {
            compute.setElasticIp(elasticIp);
            return this;
        }

        public Builder setLaunchSpecification(final LaunchSpecification launchSpecification) {
            compute.setLaunchSpecification(launchSpecification);
            return this;
        }

        public Builder setPrivateIp(final String privateIp) {
            compute.setPrivateIp(privateIp);
            return this;
        }

        public Builder setProduct(final String product) {
            compute.setProduct(product);
            return this;
        }

        public Builder setSubnetIds(final List<String> subnetIds) {
            compute.setSubnetIds(subnetIds);
            return this;
        }

        public Builder setVpcId(final String vpcId) {
            compute.setVpcId(vpcId);
            return this;
        }

        public Compute build() {
            // TODO : Validations
            return compute;
        }
    }
    //endregion


    //region isSet methods
    // Is elasticIp Set boolean method
    @JsonIgnore
    public boolean isElasticIpSet() {
        return isSet.contains("elasticIp");
    }

    // Is launchSpecification Set boolean method
    @JsonIgnore
    public boolean isLaunchSpecificationSet() {
        return isSet.contains("launchSpecification");
    }

    // Is privateIp Set boolean method
    @JsonIgnore
    public boolean isPrivateIpSet() {
        return isSet.contains("privateIp");
    }

    // Is product Set boolean method
    @JsonIgnore
    public boolean isProductSet() {
        return isSet.contains("product");
    }

    // Is subnetIds Set boolean method
    @JsonIgnore
    public boolean isSubnetIdsSet() {
        return isSet.contains("subnetIds");
    }

    // Is vpcId Set boolean method
    @JsonIgnore
    public boolean isVpcIdSet() {
        return isSet.contains("vpcId");
    }

    //endregion
}
