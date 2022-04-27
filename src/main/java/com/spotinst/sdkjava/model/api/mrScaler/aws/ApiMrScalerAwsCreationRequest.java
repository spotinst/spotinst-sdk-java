package com.spotinst.sdkjava.model.api.mrScaler.aws;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.spotinst.sdkjava.client.rest.JsonMapper;
import com.spotinst.sdkjava.model.MrScalerAwsConverter;
import com.spotinst.sdkjava.model.bl.mrScaler.aws.BlMrScalerAws;

import java.util.HashMap;
import java.util.Map;

public class ApiMrScalerAwsCreationRequest {
    //region Members
    @JsonProperty("mrscaler")
    private ApiMrScalerAws mrScaler;
    //endregion

    //region Private constructor
    private ApiMrScalerAwsCreationRequest() {
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
        private ApiMrScalerAwsCreationRequest mrScalerCreationRequest;

        private Builder() {
            this.mrScalerCreationRequest = new ApiMrScalerAwsCreationRequest();
        }

        public static ApiMrScalerAwsCreationRequest.Builder get() {
            return new Builder();
        }

        public Builder setMrScaler(final ApiMrScalerAws mrScaler) {
            mrScalerCreationRequest.setMrScaler(mrScaler);
            return this;
        }

        public ApiMrScalerAwsCreationRequest build() {
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
