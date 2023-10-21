package com.spotinst.sdkjava.model.api.elastigroup.aws;

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
public class ApiRecordSets implements IPartialUpdateEntity {
    //region Members
    // Partial Update support
    @JsonIgnore
    private Set<String>                 isSet;
    private String               name;
    private boolean              usePublicDns;
    private boolean              usePublicIp;
    //endregion

    //region Constructor

    public ApiRecordSets() {
        isSet = new HashSet<>();
    }
    //endregion

    //region Getters & Setters


    public String getName() {
        return name;
    }

    public void setName(String name) {
        isSet.add("name");
        this.name = name;
    }

    public boolean isUsePublicDns() {
        return usePublicDns;
    }

    public void setUsePublicDns(boolean usePublicDns) {
        isSet.add("usePublicDns");
        this.usePublicDns = usePublicDns;
    }

    public boolean isUsePublicIp() {
        return usePublicIp;
    }

    public void setUsePublicIp(boolean usePublicIp) {
        isSet.add("usePublicIp");
        this.usePublicIp = usePublicIp;
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    //endregion
    //region isSet methods
    // Is name Set boolean method
    @JsonIgnore
    public boolean isNameSet() {
        return isSet.contains("name");
    }

    // Is usePublicDns Set boolean method
    @JsonIgnore
    public boolean isUsePublicDnsSet() {
        return isSet.contains("usePublicDns");
    }

    // Is usePublicIp Set boolean method
    @JsonIgnore
    public boolean isUsePublicIpSet() {
        return isSet.contains("usePublicIp");
    }
    //endregion
}
