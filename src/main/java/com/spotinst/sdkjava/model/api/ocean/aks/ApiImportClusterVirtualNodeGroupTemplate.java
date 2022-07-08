package com.spotinst.sdkjava.model.api.ocean.aks;

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
public class ApiImportClusterVirtualNodeGroupTemplate implements IPartialUpdateEntity {

    @JsonIgnore
    private Set<String>                isSet;
    private ApiImportClusterWhitelist vmSizes;
    private List<String>               zones;

    public ApiImportClusterVirtualNodeGroupTemplate() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public ApiImportClusterWhitelist getVmSizes() {
        return vmSizes;
    }

    public void setVmSizes(ApiImportClusterWhitelist vmSizes) {
        isSet.add("vmSizes");
        this.vmSizes = vmSizes;
    }

    public List<String> getZones() {
        return zones;
    }

    public void setZones(List<String> zones) {
        isSet.add("zones");
        this.zones = zones;
    }

    @JsonIgnore
    public boolean isVmSizesSet() {return isSet.contains("vmSizes");}

    @JsonIgnore
    public boolean isZonesSet() {return isSet.contains("zones");}

}
