package com.spotinst.sdkjava.model.api.ocean.aks;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.spotinst.sdkjava.client.rest.IPartialUpdateEntity;

import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonFilter("PartialUpdateEntityFilter")

public class ApiClusterVngOsDisk implements IPartialUpdateEntity {
    @JsonIgnore
    private Set<String> isSet;
    private String      type;
    private Integer     sizeGB;
    private Boolean     utilizeEphemeralStorage;

    public ApiClusterVngOsDisk() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        isSet.add("type");
        this.type = type;
    }

    public Integer getSizeGB() {
        return sizeGB;
    }

    public void setSizeGB(Integer sizeGB) {
        isSet.add("sizeGB");
        this.sizeGB = sizeGB;
    }

    public Boolean getUtilizeEphemeralStorage() {
        return utilizeEphemeralStorage;
    }

    public void setUtilizeEphemeralStorage(Boolean utilizeEphemeralStorage) {
        isSet.add("utilizeEphemeralStorage");
        this.utilizeEphemeralStorage = utilizeEphemeralStorage;
    }

    @JsonIgnore
    public boolean isTypeSet() {return isSet.contains("type");}

    @JsonIgnore
    public boolean isSizeGBSet() {return isSet.contains("sizeGB");}

    @JsonIgnore
    public boolean isUtilizeEphemeralStorageSet() {return isSet.contains("utilizeEphemeralStorage");}

}