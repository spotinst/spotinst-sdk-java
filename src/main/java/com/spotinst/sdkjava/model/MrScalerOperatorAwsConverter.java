package com.spotinst.sdkjava.model;

import com.spotinst.sdkjava.model.api.mrScaler.aws.ApiMrScalerOperatorAws;
import com.spotinst.sdkjava.model.bl.mrScaler.aws.BlMrScalerOperatorAws;

public class MrScalerOperatorAwsConverter extends MrScalerAwsConverter {
    // region toBl
    public static BlMrScalerOperatorAws toBl(ApiMrScalerOperatorAws apiMrScalerOperatorAws) {
        BlMrScalerOperatorAws blMrScalerOperatorAws = null;

        if (apiMrScalerOperatorAws != null) {
            blMrScalerOperatorAws = toBl(apiMrScalerOperatorAws);

            if (apiMrScalerOperatorAws.isNameSet()) {
                blMrScalerOperatorAws.setName(apiMrScalerOperatorAws.getName());
            }
        }

        return blMrScalerOperatorAws;
    }
    // endregion

    // region toApi
    public static ApiMrScalerOperatorAws toApi(BlMrScalerOperatorAws blMrScalerOperatorAws) {
        ApiMrScalerOperatorAws apiMrScalerOperatorAws = null;

        if (blMrScalerOperatorAws != null) {
            apiMrScalerOperatorAws = toApi(blMrScalerOperatorAws);

            if (blMrScalerOperatorAws.getName() != null) {
                apiMrScalerOperatorAws.setName(blMrScalerOperatorAws.getName());
            }

        }

        return apiMrScalerOperatorAws;
    }
    // endregion
}
