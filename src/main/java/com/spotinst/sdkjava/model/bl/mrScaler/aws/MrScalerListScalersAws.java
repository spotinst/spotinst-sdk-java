package com.spotinst.sdkjava.model.bl.mrScaler.aws;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MrScalerListScalersAws {
    @JsonIgnore
    private Set<String> isSet;
    private String      id;
    private String      availabilityZone;
    private String      state;
    private Date		createdAt;
    private Date		updatedAt;

    private MrScalerListScalersAws()  {
        isSet = new HashSet<>();
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        isSet.add("id");
        this.id = id;
    }

    public Date getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        isSet.add("createdAt");
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return this.updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        isSet.add("updatedAt");
        this.updatedAt = updatedAt;
    }

    public String getAvailabilityZone() {
        return this.availabilityZone;
    }

    public void setAvailabilityZone(String availabilityZone) {
        isSet.add("availabilityZone");
        this.availabilityZone = availabilityZone;
    }

    public String getState() {
        return this.state;
    }

    public void setState(String state) {
        isSet.add("state");
        this.state = state;
    }

    public static class Builder {
        private MrScalerListScalersAws mrScalerListScalersAws;

        private Builder() {
            this.mrScalerListScalersAws = new MrScalerListScalersAws();
        }

        public static Builder get() {
            Builder builder = new Builder();
            return builder;
        }

        public Builder setId(final String id) {
            mrScalerListScalersAws.setId(id);
            return this;
        }

        public Builder setCreatedAt(final Date createdAt) {
            mrScalerListScalersAws.setCreatedAt(createdAt);
            return this;
        }

        public Builder setUpdatedAt(final Date updatedAt) {
            mrScalerListScalersAws.setUpdatedAt(updatedAt);
            return this;
        }

        public Builder setAvailabilityZone(final String availabilityZone) {
            mrScalerListScalersAws.setAvailabilityZone(availabilityZone);
            return this;
        }

        public Builder setState(final String state) {
            mrScalerListScalersAws.setState(state);
            return this;
        }

        public MrScalerListScalersAws build() {
            return mrScalerListScalersAws;
        }
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