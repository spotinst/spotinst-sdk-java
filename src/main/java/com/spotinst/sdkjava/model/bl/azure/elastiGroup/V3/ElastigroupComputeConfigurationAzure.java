package com.spotinst.sdkjava.model.bl.azure.elastiGroup.V3;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by aharontwizer on 8/24/15.
 */
public class ElastigroupComputeConfigurationAzure {
    //region Members
    // Partial Update support
    @JsonIgnore
    private Set<String>                         isSet;
    private String                              os;
    private ElastigroupLaunchSpecificationAzure launchSpecification;
    private List<ElastigroupVmSizesAzure>       vmSizes;

    //endregion

    //region Constructor

    private ElastigroupComputeConfigurationAzure() {
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


    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        isSet.add("os");
        this.os = os;
    }

    public List<ElastigroupVmSizesAzure> getVmSizes() {
        return vmSizes;
    }

    public void setVmSizes(List<ElastigroupVmSizesAzure> vmSizes) {
        isSet.add("vmSizes");
        this.vmSizes = vmSizes;
    }

    public ElastigroupLaunchSpecificationAzure getLaunchSpecification() {
        return launchSpecification;
    }

    public void setLaunchSpecification(ElastigroupLaunchSpecificationAzure launchSpecification) {
        isSet.add("launchSpecification");
        this.launchSpecification = launchSpecification;
    }


    //endregion
    //region Builder class
    public static class Builder {
        private ElastigroupComputeConfigurationAzure compute;

        private Builder() {
            this.compute = new ElastigroupComputeConfigurationAzure();
        }

        public static Builder get() {
            Builder builder = new Builder();
            return builder;
        }


        public Builder setOs(final String os) {
            compute.setOs(os);
            return this;
        }

        public Builder setLaunchSpecification(final ElastigroupLaunchSpecificationAzure launchSpecification) {
            compute.setLaunchSpecification(launchSpecification);
            return this;
        }

        public Builder setVmSizes(final List<ElastigroupVmSizesAzure> vmSizes) {
            compute.setVmSizes(vmSizes);
            return this;
        }

        public ElastigroupComputeConfigurationAzure build() {
            // TODO : Validations
            return compute;
        }
    }
    //endregion

    //region isSet methods
    // Is os Set boolean method
    @JsonIgnore
    public boolean isOsSet() { return isSet.contains("os"); }

    // Is vmSizes Set boolean method
    @JsonIgnore
    public boolean isVmSizesSet() { return isSet.contains("vmSizes"); }


    // Is launchSpecification Set boolean method
    @JsonIgnore
    public boolean isLaunchSpecificationSet() {
        return isSet.contains("launchSpecification");
    }


    // Is instanceTypes Set boolean method
    @JsonIgnore
    public boolean isInstanceTypesSet() {
        return isSet.contains("instanceTypes");
    }



    //endregion

}