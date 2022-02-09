package com.spotinst.sdkjava.model.converters.mrScaler.aws;

import com.spotinst.sdkjava.model.api.mrScaler.aws.ApiMrScalerListScalersAws;
import com.spotinst.sdkjava.model.bl.mrScaler.aws.BlMrScalerListScalersAws;

public class MrScalerListScalersConverter {

    public static BlMrScalerListScalersAws toBl(ApiMrScalerListScalersAws apiMrScalerListScalersAws) {
        BlMrScalerListScalersAws blMrScalerListScalersAws = null;

        if (apiMrScalerListScalersAws != null) {
            blMrScalerListScalersAws = new BlMrScalerListScalersAws();

            if (apiMrScalerListScalersAws.isIdSet()) {
                blMrScalerListScalersAws.setId(apiMrScalerListScalersAws.getId());
            }

            if (apiMrScalerListScalersAws.isAvailabilityZoneSet()) {
                blMrScalerListScalersAws.setAvailabilityZone(apiMrScalerListScalersAws.getAvailabilityZone());
            }

            if (apiMrScalerListScalersAws.isStateSet()) {
                blMrScalerListScalersAws.setState(apiMrScalerListScalersAws.getState());
            }
        }

        return blMrScalerListScalersAws;
    }

    // region toApi
    public static ApiMrScalerListScalersAws toApi(BlMrScalerListScalersAws blMrScalerListScalersAws) {
        ApiMrScalerListScalersAws apiMrScalerListScalersAws = null;

        if (blMrScalerListScalersAws != null) {
            apiMrScalerListScalersAws = new ApiMrScalerListScalersAws();

            if (blMrScalerListScalersAws.getId() != null) {
                apiMrScalerListScalersAws.setId(blMrScalerListScalersAws.getId());
            }

            if (blMrScalerListScalersAws.getAvailabilityZone() != null) {
                apiMrScalerListScalersAws.setAvailabilityZone(blMrScalerListScalersAws.getAvailabilityZone());
            }

            if (blMrScalerListScalersAws.getState() != null) {
                apiMrScalerListScalersAws.setState(blMrScalerListScalersAws.getState());
            }
        }

        return apiMrScalerListScalersAws;
    }
}
