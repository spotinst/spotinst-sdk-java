package com.spotinst.sdkjava.model.bl.ocean.aks;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.spotinst.sdkjava.client.rest.IPartialUpdateEntity;

import java.util.HashSet;
import java.util.Set;

public class ClusterLoginAks  {
    @JsonIgnore
    private Set<String>               isSet;
    private String                    sshPublicKey;
    private String                    userName;


    private ClusterLoginAks() {
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

    public static class Builder {

        private ClusterLoginAks clusterLoginAks;

        private Builder() {
            this.clusterLoginAks = new ClusterLoginAks();
        }

        public static Builder get() {
            Builder builder = new Builder();
            return builder;
        }
        public Builder setSshPublicKey(final String sshPublicKey) {
            clusterLoginAks.setSshPublicKey(sshPublicKey);
            return this;
        }

        public Builder setUserName(final String userName) {
            clusterLoginAks.setUserName(userName);
            return this;
        }

        public ClusterLoginAks build() {
            return clusterLoginAks;
        }
    }
}
