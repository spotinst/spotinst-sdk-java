package com.spotinst.sdkjava.model.api.mrScaler.aws;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.Set;

public class ApiMrScalerOperatorAws extends ApiMrScalerAws {
    //region Members
    @JsonIgnore
    private Set<String> isSet;
    private String      name;
    // endregion

    //region Constructor
    public ApiMrScalerOperatorAws() { isSet = new HashSet<>(); }
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

    public Boolean isNameSet(){
        return isSet.contains("name");
    }
    // endregion
    // endregion

    public static class Builder {
        private ApiMrScalerOperatorAws apiMrScalerOperatorAws;
        private Builder() { this.apiMrScalerOperatorAws = new ApiMrScalerOperatorAws(); }

        public static Builder get() {
            Builder builder = new Builder();
            return builder;

        }

        //region Build methods
        public Builder setName(final String name) {
            apiMrScalerOperatorAws.setName(name);
            return this;
        }

        public ApiMrScalerAws build(){
            return apiMrScalerOperatorAws;
        }
        // endregion
    }
}
