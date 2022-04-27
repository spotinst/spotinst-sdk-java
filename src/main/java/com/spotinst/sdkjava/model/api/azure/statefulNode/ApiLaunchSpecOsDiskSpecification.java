package com.spotinst.sdkjava.model.api.azure.statefulNode;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.spotinst.sdkjava.client.rest.IPartialUpdateEntity;
import com.spotinst.sdkjava.enums.azure.statefulNode.AzureStatefulNodeDiskTypeEnum;

import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonFilter("PartialUpdateEntityFilter")
public class ApiLaunchSpecOsDiskSpecification implements IPartialUpdateEntity {
    @JsonIgnore
    private Set<String>                     isSet;
    private Integer                         sizeGB;
    private AzureStatefulNodeDiskTypeEnum type;

    public ApiLaunchSpecOsDiskSpecification() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public Integer getSizeGB() {
        return sizeGB;
    }

    public void setSizeGB(Integer sizeGB) {
        isSet.add("sizeGB");
        this.sizeGB = sizeGB;
    }

    public AzureStatefulNodeDiskTypeEnum getType() {
        return type;
    }

    public void setType(AzureStatefulNodeDiskTypeEnum type) {
        isSet.add("type");
        this.type = type;
    }

    @JsonIgnore
    public boolean isSizeGBSet() {
        return isSet.contains("setSizeGB");
    }

    @JsonIgnore
    public boolean isTypeSet() {
        return isSet.contains("type");
    }

}
