package com.spotinst.sdkjava.model.requests.mrScaler.aws;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.spotinst.sdkjava.client.rest.JsonMapper;
import com.spotinst.sdkjava.model.converters.mrScaler.aws.MrScalerAwsConverter;
import com.spotinst.sdkjava.model.api.mrScaler.aws.ApiMrScalerAws;
import com.spotinst.sdkjava.model.bl.mrScaler.aws.MrScalerAws;

import java.util.HashMap;
import java.util.Map;

public class MrScalerAwsCreationRequest {
    @JsonProperty("mrscaler")
    private MrScalerAws mrScaler;

    private MrScalerAwsCreationRequest() {
    }

    public MrScalerAws getMrScaler() {
        return mrScaler;
    }

    public void setMrScaler(MrScalerAws mrScaler) {
        this.mrScaler = mrScaler;
    }

    public static class Builder {
        private MrScalerAwsCreationRequest mrScalerCreationRequest;

        private Builder() {
            this.mrScalerCreationRequest = new MrScalerAwsCreationRequest();
        }

        public static MrScalerAwsCreationRequest.Builder get() {
            MrScalerAwsCreationRequest.Builder builder = new MrScalerAwsCreationRequest.Builder();
            return builder;
        }

        public Builder setMrScaler(final MrScalerAws mrScaler) {
            mrScalerCreationRequest.setMrScaler(mrScaler);
            return this;
        }

        public MrScalerAwsCreationRequest build() {
            return mrScalerCreationRequest;
        }

    }

    public String toJson() {
        ApiMrScalerAws apiMrScalerToCreate = MrScalerAwsConverter.toDal(mrScaler);

        Map<String, ApiMrScalerAws> mrScalerRequest = new HashMap<>();
        mrScalerRequest.put("mrScaler", apiMrScalerToCreate);
        String mrScalerJson = JsonMapper.toJson(mrScalerRequest);

        return mrScalerJson;
    }

}
