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

public class ApiClusterLoginAks implements IPartialUpdateEntity {
    @JsonIgnore
    private Set<String>               isSet;
    private String                    sshPublicKey;
    private String                    userName;


    public ApiClusterLoginAks() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public String getSshPublicKey() {
        return sshPublicKey;
    }

    public void setSshPublicKey(String sshPublicKey) {

        isSet.add("sshPublicKey");
        this.sshPublicKey = sshPublicKey;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {

        isSet.add("userName");
        this.userName = userName;
    }

    @JsonIgnore
    public boolean isSshPublicKeySet() {
        return isSet.contains("sshPublicKey");
    }

    @JsonIgnore
    public boolean isUserNameSet() {
        return isSet.contains("userName");
    }
}
