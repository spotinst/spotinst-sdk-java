package com.spotinst.sdkjava.model.requests.elastigroup.aws;

import com.spotinst.sdkjava.client.rest.JsonMapper;
import com.spotinst.sdkjava.model.ElastigroupConverter;
import com.spotinst.sdkjava.model.api.elastigroup.aws.ApiGetSuggestedInstanceType;
import com.spotinst.sdkjava.model.bl.elastigroup.aws.GetSuggestedInstanceType;

public class GetSuggestedInstanceTypeRequest {

    private GetSuggestedInstanceType suggestedInstanceType;

    private GetSuggestedInstanceTypeRequest() {
    }

    public GetSuggestedInstanceType getSuggestedInstanceType() {
        return suggestedInstanceType;
    }

    public void setSuggestedInstanceType(GetSuggestedInstanceType suggestedInstanceType) {
        this.suggestedInstanceType = suggestedInstanceType;
    }

    public static class Builder {
        private GetSuggestedInstanceTypeRequest getSuggestedInstanceTypeRequest;

        private Builder() {
            this.getSuggestedInstanceTypeRequest = new GetSuggestedInstanceTypeRequest();
        }

        public static Builder get() {
            return new Builder();
        }

        public Builder setSuggestedInstanceType(GetSuggestedInstanceType suggestedInstanceType) {
            getSuggestedInstanceTypeRequest.setSuggestedInstanceType(suggestedInstanceType);
            return this;
        }

        public GetSuggestedInstanceTypeRequest build() {
            return getSuggestedInstanceTypeRequest;
        }
    }

    //region Json methods
    public String toJson() {
        ApiGetSuggestedInstanceType suggestedInstanceTypeRequest = ElastigroupConverter.toDal(suggestedInstanceType);
        return JsonMapper.toJson(suggestedInstanceTypeRequest);
    }

    //endregion

}
