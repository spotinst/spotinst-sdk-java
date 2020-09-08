package com.spotinst.sdkjava.model.api.azure.elastiGroup.V3;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.spotinst.sdkjava.client.rest.IPartialUpdateEntity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonFilter("PartialUpdateEntityFilter")
public class ApiGroupComputeAzure implements IPartialUpdateEntity {
    //region Members
    @JsonIgnore
    private Set<String>                      isSet;
    private String                           os;
    private List<ApiElastigroupVmSizesAzure> vmSizes;
    private ApiLaunchSpecAzure               launchSpecification;
    //endregion

    //region Constructor
    public ApiGroupComputeAzure() {
        isSet = new HashSet<>();
    }
    //endregion

    //region getters &setters
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

    public List<ApiElastigroupVmSizesAzure> getVmSizes() {
        return vmSizes;
    }

    public void setVmSizes(List<ApiElastigroupVmSizesAzure> vmSizes) {
        isSet.add("vmSizes");
        this.vmSizes = vmSizes;
    }

    public ApiLaunchSpecAzure getLaunchSpecification() {
        return launchSpecification;
    }

    public void setLaunchSpecification(ApiLaunchSpecAzure launchSpecification) {
        isSet.add("launchSpecification");
        this.launchSpecification = launchSpecification;
    }
    //end region

    //region is set methods
    // Is os Set boolean method
    @JsonIgnore
    public boolean isOsSet() {
        return isSet.contains("os");
    }

    // Is vmSizes Set boolean method
    @JsonIgnore
    public boolean isVmSizesSet() {
        return isSet.contains("vmSizes");
    }

    // Is launchSpecification Set boolean method
    @JsonIgnore
    public boolean isLaunchSpecificationSet() {
        return isSet.contains("launchSpecification");
    }
    //endregion
}
