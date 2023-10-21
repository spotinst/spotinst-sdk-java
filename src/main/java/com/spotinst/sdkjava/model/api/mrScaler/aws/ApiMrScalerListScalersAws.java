package com.spotinst.sdkjava.model.api.mrScaler.aws;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.spotinst.sdkjava.client.rest.IPartialUpdateEntity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonFilter("PartialUpdateEntityFilter")
public class ApiMrScalerListScalersAws implements IPartialUpdateEntity {
    @JsonIgnore
    private Set<String> isSet;
    private String      id;
    private String      availabilityZone;
    private String      state;
    private Date		createdAt;
    private Date		updatedAt;

    public ApiMrScalerListScalersAws() {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        isSet.add("id");
        this.id = id;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        isSet.add("createdAt");
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        isSet.add("updatedAt");
        this.updatedAt = updatedAt;
    }

    public String getAvailabilityZone() {
        return availabilityZone;
    }

    public void setAvailabilityZone(String availabilityZone) {
        isSet.add("availabilityZone");
        this.availabilityZone = availabilityZone;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        isSet.add("state");
        this.state = state;
    }

    @JsonIgnore
    public Boolean isIdSet(){
        return isSet.contains("id");
    }

    @JsonIgnore
    public Boolean isCreatedAtSet(){
        return isSet.contains("createdAt");
    }

    @JsonIgnore
    public Boolean isUpdatedAtSet(){
        return isSet.contains("updatedAt");
    }

    @JsonIgnore
    public Boolean isAvailabilityZoneSet(){
        return isSet.contains("availabilityZone");
    }

    @JsonIgnore
    public Boolean isStateSet(){
        return isSet.contains("state");
    }
}