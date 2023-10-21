package com.spotinst.sdkjava.model.requests.mrScaler.aws;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.spotinst.sdkjava.client.rest.JsonMapper;
import com.spotinst.sdkjava.model.converters.mrScaler.aws.MrScalerAwsConverter;
import com.spotinst.sdkjava.model.api.mrScaler.aws.ApiMrScalerAws;
import com.spotinst.sdkjava.model.bl.mrScaler.aws.MrScalerAws;

import java.util.HashMap;
import java.util.Map;

public class MrScalerAwsUpdateRequest {
    //region Members
    @JsonProperty("mrscaler")
    private MrScalerAws mrScaler;
    //endregion

    //region Private constructor
    private MrScalerAwsUpdateRequest() {
    }
    //endregion

    //region Getters & Setters

    public MrScalerAws getMrScaler() {
        return mrScaler;
    }

    public void setMrScaler(MrScalerAws mrScaler) {
        this.mrScaler = mrScaler;
    }

    //endregion

    //region Builder class
    public static class Builder {
        private MrScalerAwsUpdateRequest mrScalerCreationRequest;

        private Builder() {
            this.mrScalerCreationRequest = new MrScalerAwsUpdateRequest();
        }

        public static MrScalerAwsUpdateRequest.Builder get() {
            MrScalerAwsUpdateRequest.Builder builder = new MrScalerAwsUpdateRequest.Builder();
            return builder;
        }

        public Builder setMrScaler(final MrScalerAws mrScaler) {
            mrScalerCreationRequest.setMrScaler(mrScaler);
            return this;
        }

        public MrScalerAwsUpdateRequest build() {
            return mrScalerCreationRequest;
        }

    }
    //endregion

    //region Json methods
    public String toJson() {
        ApiMrScalerAws apiMrScalerToUpdate = MrScalerAwsConverter.toDal(mrScaler);

        Map<String, ApiMrScalerAws> mrScalerRequest = new HashMap<>();
        mrScalerRequest.put("mrScaler", apiMrScalerToUpdate);
        String mrScalerJson = JsonMapper.toJson(mrScalerRequest);

        return mrScalerJson;
    }
    //endregion
}
