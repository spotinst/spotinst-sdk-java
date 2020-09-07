package com.spotinst.sdkjava.model.api.mrScaler.aws;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.Set;

public class ApiMrScalerOperatorAwsResponse {
    //region Members
    @JsonIgnore
    private Set<String> isSet;
    private String      name;
    private String      mrScalerId;
    //todo liron - change to enum
    private String      state;
    //endregion

    //region Constructor
    public ApiMrScalerOperatorAwsResponse() { isSet = new HashSet<>(); }
    // endregion

    //region getters and setters
    //region Name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        isSet.add("name");
        this.name = name;
    }

    public Boolean isNameSet(){
        return isSet.contains("name");
    }
    //endregion

    //region MrScalerId
    public String getMrScalerId() {
        return mrScalerId;
    }

    public void setMrScalerId(String mrScalerId) {
        isSet.add("mrScalerId");
        this.mrScalerId = mrScalerId;
    }

    public Boolean isMrScalerIdSet(){
        return isSet.contains("mrScalerId");
    }
    //endregion

    //region State
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
    //endregion
    //endregion

    //todo liron - remove if not used
        public static class Builder {
        private ApiMrScalerOperatorAwsResponse apiMrScalerAwsResponse;

        private Builder() { this.apiMrScalerAwsResponse = new ApiMrScalerOperatorAwsResponse();}

        public static Builder get() {
            Builder builder = new Builder();
            return builder;

        }

        //region Build methods
        public Builder setName(final String name) {
            apiMrScalerAwsResponse.setName(name);
            return this;
        }

        public Builder setMscalerId(final String mrScalerId) {
            apiMrScalerAwsResponse.setMrScalerId(mrScalerId);
            return this;
        }

        public Builder setState(final String state) {
            apiMrScalerAwsResponse.setState(state);
            return this;
        }

        public ApiMrScalerOperatorAwsResponse build(){
            return apiMrScalerAwsResponse;
        }
        // endregion
    }
}
