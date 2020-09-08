package com.spotinst.sdkjava.model.api.azure.elastiGroup.V3;

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
public class ApiLoginAzure implements IPartialUpdateEntity {
    //region Members
    @JsonIgnore
    private Set<String> isSet;
    private String      userName;
    private String      sshPublicKey;
    private String      password;
    //endregion

    //region Constructors
    public ApiLoginAzure() {
        isSet = new HashSet<>();
    }
    //endregion

    ApiLoginAzure(String userName, String sshPublicKey, String password) {
        isSet = new HashSet<>();
        this.setUserName(userName);
        this.setSshPublicKey(sshPublicKey);
        this.setPassword(password);
    }
    //endregion

    //region Getters & Setters
    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        isSet.add("userName");
        this.userName = userName;
    }

    public String getSshPublicKey() {
        return sshPublicKey;
    }

    public void setSshPublicKey(String sshPublicKey) {
        isSet.add("sshPublicKey");
        this.sshPublicKey = sshPublicKey;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        isSet.add("password");
        this.password = password;
    }
    //endregion

    //region isSet methods
    // Is userName Set boolean method
    @JsonIgnore
    public boolean isUserNameSet() {
        return isSet.contains("userName");
    }

    // Is sshPublicKey Set boolean method
    @JsonIgnore
    public boolean isSshPublicKeySet() {
        return isSet.contains("sshPublicKey");
    }

    // Is password Set boolean method
    @JsonIgnore
    public boolean isPasswordSet() {
        return isSet.contains("password");
        //endregion
    }
}
