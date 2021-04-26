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
public class ApiClusterExtensionAks implements IPartialUpdateEntity {
    @JsonIgnore
    private Set<String>                 isSet;
    private String                      apiVersion;
    private boolean                     minorVersionAutoUpgrade;
    private String                      name;
    private String                      publisher;
    private String                      type;


    public ApiClusterExtensionAks() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public String getApiVersion() {
        return apiVersion;
    }

    public void setApiVersion(String apiVersion) {
        isSet.add("apiVersion");
        this.apiVersion = apiVersion;
    }

    public boolean getMinorVersionAutoUpgrade() {
        return minorVersionAutoUpgrade;
    }

    public void setMinorVersionAutoUpgrade(boolean minorVersionAutoUpgrade) {
        isSet.add("minorVersionAutoUpgrade");
        this.minorVersionAutoUpgrade = minorVersionAutoUpgrade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        isSet.add("name");
        this.name = name;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        isSet.add("publisher");
        this.publisher = publisher;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {

        isSet.add("type");
        this.type = type;
    }

    @JsonIgnore
    public boolean isApiVersionSet() {
        return isSet.contains("apiVersion");
    }

    @JsonIgnore
    public boolean isMinorVersionAutoUpgradeSet() {
        return isSet.contains("minorVersionAutoUpgrade");
    }

    @JsonIgnore
    public boolean isNameSet() {
        return isSet.contains("name");
    }

    @JsonIgnore
    public boolean isPublisherSet() {
        return isSet.contains("publisher");
    }

    @JsonIgnore
    public boolean isTypeSet() {
        return isSet.contains("type");
    }
}
