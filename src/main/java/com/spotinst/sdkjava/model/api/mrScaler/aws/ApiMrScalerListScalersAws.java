package com.spotinst.sdkjava.model.api.mrScaler.aws;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class ApiMrScalerListScalersAws {
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        isSet.add("id");
        this.id = id;
    }

    public Boolean isIdSet(){
        return isSet.contains("id");
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        isSet.add("createdAt");
        this.createdAt = createdAt;
    }

    public Boolean isCreatedAtSet(){
        return isSet.contains("createdAt");
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        isSet.add("updatedAt");
        this.updatedAt = updatedAt;
    }

    public Boolean isUpdatedAtSet(){
        return isSet.contains("updatedAt");
    }

    public String getAvailabilityZone() {
        return availabilityZone;
    }

    public void setAvailabilityZone(String availabilityZone) {
        isSet.add("availabilityZone");
        this.availabilityZone = availabilityZone;
    }

    public Boolean isAvailabilityZoneSet(){
        return isSet.contains("availabilityZone");
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        isSet.add("state");
        this.state = state;
    }

    public Boolean isStateSet(){
        return isSet.contains("state");
    }

    public static class Builder {
        private ApiMrScalerListScalersAws apiMrScalerListScalersAws;

        private Builder() {
            this.apiMrScalerListScalersAws = new ApiMrScalerListScalersAws();
        }

        public static Builder get() {
            Builder builder = new Builder();
            return builder;
        }

        //region Build methods
        public Builder setId(final String id) {
            apiMrScalerListScalersAws.setId(id);
            return this;
        }

        public Builder setCreatedAt(final Date createdAt) {
            apiMrScalerListScalersAws.setCreatedAt(createdAt);
            return this;
        }

        public Builder setUpdatedAt(final Date updatedAt) {
            apiMrScalerListScalersAws.setUpdatedAt(updatedAt);
            return this;
        }

        public Builder setAvailabilityZone(final String availabilityZone) {
            apiMrScalerListScalersAws.setAvailabilityZone(availabilityZone);
            return this;
        }

        public Builder setState(final String state) {
            apiMrScalerListScalersAws.setState(state);
            return this;
        }

        public ApiMrScalerListScalersAws build() {
            return apiMrScalerListScalersAws;
        }
        // endregion
    }
}