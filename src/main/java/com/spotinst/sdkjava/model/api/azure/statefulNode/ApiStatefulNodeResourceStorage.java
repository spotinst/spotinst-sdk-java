package com.spotinst.sdkjava.model.api.azure.statefulNode;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiStatefulNodeResourceStorage {

    @JsonIgnore
    private Set<String>                                 isSet;
    private ApiStatefulNodeResourceOsDisk               osDisk;
    private List<ApiStatefulNodeResourceDataDisks>      dataDisk;

    public ApiStatefulNodeResourceStorage() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public List<ApiStatefulNodeResourceDataDisks> getDataDisk() {
        return dataDisk;
    }

    public void setDataDisk(List<ApiStatefulNodeResourceDataDisks> dataDisk) {
        isSet.add("dataDisk");
        this.dataDisk = dataDisk;
    }

    public ApiStatefulNodeResourceOsDisk getOsDisk() {
        return osDisk;
    }

    public void setOsDisk(ApiStatefulNodeResourceOsDisk osDisk) {
        isSet.add("osDisk");
        this.osDisk = osDisk;
    }

    @JsonIgnore
    public boolean isDataDiskSet() {
        return isSet.contains("dataDisk");
    }

    @JsonIgnore
    public boolean isOsDiskSet() { return isSet.contains("osDisk"); }
}
