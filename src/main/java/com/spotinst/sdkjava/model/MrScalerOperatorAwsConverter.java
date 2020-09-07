package com.spotinst.sdkjava.model;

import com.spotinst.sdkjava.model.api.mrScaler.aws.ApiMrScalerAws;
import com.spotinst.sdkjava.model.api.mrScaler.aws.ApiMrScalerOperatorAws;
import com.spotinst.sdkjava.model.api.mrScaler.aws.ApiMrScalerOperatorAwsResponse;
import com.spotinst.sdkjava.model.bl.mrScaler.aws.BlMrScalerAws;
import com.spotinst.sdkjava.model.bl.mrScaler.aws.BlMrScalerOperatorAws;
import com.spotinst.sdkjava.model.bl.mrScaler.aws.BlMrScalerOperatorResponse;

public class MrScalerOperatorAwsConverter {
    // region toBl
    public static BlMrScalerOperatorAws toBl(ApiMrScalerOperatorAws apiMrScalerOperatorAws) {
        BlMrScalerOperatorAws blMrScalerOperatorAws = null;

        if (apiMrScalerOperatorAws != null) {
            blMrScalerOperatorAws = new BlMrScalerOperatorAws();

            if(apiMrScalerOperatorAws.isMrScalerSet()) {
                ApiMrScalerAws apiMrScalerAws = apiMrScalerOperatorAws.getMrScaler();
                BlMrScalerAws  blMrScalerAws  = MrScalerAwsConverter.toBl(apiMrScalerAws);
                blMrScalerOperatorAws.setMrScaler(blMrScalerAws);
            }

            if (apiMrScalerOperatorAws.isNameSet()) {
                blMrScalerOperatorAws.setName(apiMrScalerOperatorAws.getName());
            }
        }

        return blMrScalerOperatorAws;
    }
    // endregion

    // region toApi
    public static ApiMrScalerOperatorAwsResponse toApi(BlMrScalerOperatorResponse blMrScalerOperatorAwsResponse) {
        ApiMrScalerOperatorAwsResponse apiMrScalerOperatorAwsResponse = null;

        if (blMrScalerOperatorAwsResponse != null) {
            apiMrScalerOperatorAwsResponse = new ApiMrScalerOperatorAwsResponse();

            if (blMrScalerOperatorAwsResponse.getName() != null) {
                apiMrScalerOperatorAwsResponse.setName(blMrScalerOperatorAwsResponse.getName());
            }

            if (blMrScalerOperatorAwsResponse.getMrScalerId() != null) {
                apiMrScalerOperatorAwsResponse.setMrScalerId(blMrScalerOperatorAwsResponse.getMrScalerId());
            }
            if (blMrScalerOperatorAwsResponse.getState() != null) {
                apiMrScalerOperatorAwsResponse.setState(blMrScalerOperatorAwsResponse.getState());
            }
        }

        return apiMrScalerOperatorAwsResponse;
    }
    // endregion
}
