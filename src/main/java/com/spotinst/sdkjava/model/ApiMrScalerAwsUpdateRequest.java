package com.spotinst.sdkjava.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.spotinst.sdkjava.client.rest.JsonMapper;
import com.spotinst.sdkjava.model.api.mrScaler.aws.ApiMrScalerAws;
import com.spotinst.sdkjava.model.bl.mrScaler.aws.BlMrScalerAws;

import java.util.HashMap;
import java.util.Map;

public class ApiMrScalerAwsUpdateRequest {
    //region Members
    @JsonProperty("mrscaler")
    private ApiMrScalerAws mrScaler;
    //endregion

    //region Private constructor
    private ApiMrScalerAwsUpdateRequest() {
    }
    //endregion

    //region Getters & Setters

    public ApiMrScalerAws getMrScaler() {
        return mrScaler;
    }

    public void setMrScaler(ApiMrScalerAws mrScaler) {
        this.mrScaler = mrScaler;
    }

    //endregion

    //region Builder class
    public static class Builder {
        private ApiMrScalerAwsUpdateRequest mrScalerCreationRequest;

        private Builder() {
            this.mrScalerCreationRequest = new ApiMrScalerAwsUpdateRequest();
        }

        public static ApiMrScalerAwsUpdateRequest.Builder get() {
            return new Builder();
        }

        public Builder setMrScaler(final ApiMrScalerAws mrScaler) {
            mrScalerCreationRequest.setMrScaler(mrScaler);
            return this;
        }

        public ApiMrScalerAwsUpdateRequest build() {
            return mrScalerCreationRequest;
        }

    }
    //endregion

    //region Json methods
    public String toJson() {
        BlMrScalerAws blMrScalerToCreate = MrScalerAwsConverter.toBl(mrScaler);

        Map<String, BlMrScalerAws> mrScalerRequest = new HashMap<>();
        mrScalerRequest.put("mrScaler", blMrScalerToCreate);

        return JsonMapper.toJson(mrScalerRequest);
    }
    //endregion
}
