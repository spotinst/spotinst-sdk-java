package com.spotinst.sdkjava.model.bl.ocean.aks;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ImportClusterLoginAks {
    @JsonIgnore
    private Set<String>               isSet;
    private String                    userName;


    private ImportClusterLoginAks() {
        isSet = new HashSet<>();
    }

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

    public static class Builder {

        private ImportClusterLoginAks clusterLoginAks;

        private Builder() {
            this.clusterLoginAks = new ImportClusterLoginAks();
        }

        public static Builder get() {
            return new Builder();
        }

        public Builder setUserName(final String userName) {
            clusterLoginAks.setUserName(userName);
            return this;
        }

        public ImportClusterLoginAks build() {
            return clusterLoginAks;
        }
    }

    @JsonIgnore
    public boolean isUserNameSet() {
        return isSet.contains("userName");
    }
}
