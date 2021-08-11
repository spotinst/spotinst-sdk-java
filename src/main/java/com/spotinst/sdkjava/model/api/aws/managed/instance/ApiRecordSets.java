package com.spotinst.sdkjava.model.api.aws.managed.instance;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.Set;

public class ApiRecordSets {

    @JsonIgnore
    private Set<String> isSet;
    private String      name;
    private Boolean     usePublicIp;

    private ApiRecordSets() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        isSet.add("name");
        this.name = name;
    }

    public Boolean getAutoWeight() {
        return usePublicIp;
    }

    public void setUsePublicIp(Boolean usePublicIp) {
        isSet.add("usePublicIp");
        this.usePublicIp = usePublicIp;
    }

    @JsonIgnore
    public boolean isNameSet() {
        return isSet.contains("name");
    }

    @JsonIgnore
    public boolean isUsePublicIpSet() {
        return isSet.contains("usePublicIp");
    }
}
