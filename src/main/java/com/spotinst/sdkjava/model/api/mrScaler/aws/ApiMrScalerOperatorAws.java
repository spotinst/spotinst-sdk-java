package com.spotinst.sdkjava.model.api.mrScaler.aws;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.Set;

public class ApiMrScalerOperatorAws {
    //region Members
    @JsonIgnore
    private Set<String>    isSet;
    private String         name;
    private ApiMrScalerAws mrScaler;

    // endregion

    //region Constructor
    public ApiMrScalerOperatorAws() {
        isSet = new HashSet<>();
    }
    // endregion

    //region getters and setters
    // region Name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        isSet.add("name");
        this.name = name;
    }

    public Boolean isNameSet() {
        return isSet.contains("name");
    }
    // endregion

    // region MrScaler
    public ApiMrScalerAws getMrScaler() {
        return mrScaler;
    }

    public void setMrScaler(ApiMrScalerAws mrScalerAws) {

        isSet.add("mrScaler");
        this.mrScaler = mrScalerAws;
    }

    public Boolean isMrScalerSet() {
        return isSet.contains("mrScaler");
    }
    // endregion

    public static class Builder {
        private ApiMrScalerOperatorAws apiMrScalerOperatorAws;

        private Builder() {
            this.apiMrScalerOperatorAws = new ApiMrScalerOperatorAws();
        }

        public static Builder get() {
            Builder builder = new Builder();
            return builder;
        }

        //region Build methods
        public Builder setName(final String name) {
            apiMrScalerOperatorAws.setName(name);
            return this;
        }

        public Builder setMrScaler(final ApiMrScalerAws apiMrScalerAws) {
            apiMrScalerOperatorAws.setMrScaler(apiMrScalerAws);
            return this;
        }

        public ApiMrScalerOperatorAws build() {
            return apiMrScalerOperatorAws;
        }
        // endregion
    }
}
