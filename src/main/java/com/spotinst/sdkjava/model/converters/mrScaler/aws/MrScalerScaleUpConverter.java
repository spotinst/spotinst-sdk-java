package com.spotinst.sdkjava.model.converters.mrScaler.aws;

import com.spotinst.sdkjava.model.api.mrScaler.aws.ApiMrScalerScaleUpAws;
import com.spotinst.sdkjava.model.bl.mrScaler.aws.BlMrScalerScaleUpAws;

public class MrScalerScaleUpConverter {

    public static BlMrScalerScaleUpAws toBl(ApiMrScalerScaleUpAws apiMrScalerScaleUpAws) {
        BlMrScalerScaleUpAws blMrScalerScaleUpAws = null;

        if (apiMrScalerScaleUpAws != null) {
            blMrScalerScaleUpAws = new BlMrScalerScaleUpAws();

            if (apiMrScalerScaleUpAws.isModifiedInstanceGroupsSet()) {
                blMrScalerScaleUpAws.setModifiedInstanceGroups(apiMrScalerScaleUpAws.getModifiedInstanceGroups());
            }

            if (apiMrScalerScaleUpAws.isNewInstanceGroupsSet()) {
                blMrScalerScaleUpAws.setNewInstanceGroups(apiMrScalerScaleUpAws.getNewInstanceGroups());
            }
        }

        return blMrScalerScaleUpAws;
    }

    // region toApi
    public static ApiMrScalerScaleUpAws toApi(BlMrScalerScaleUpAws blMrScalerScaleUpAws) {
        ApiMrScalerScaleUpAws apiMrScalerScaleUpAws = null;

        if (blMrScalerScaleUpAws != null) {
            apiMrScalerScaleUpAws = new ApiMrScalerScaleUpAws();

            if (blMrScalerScaleUpAws.getModifiedInstanceGroups() != null) {
                apiMrScalerScaleUpAws.setModifiedInstanceGroups(blMrScalerScaleUpAws.getModifiedInstanceGroups());
            }

            if (blMrScalerScaleUpAws.getNewInstanceGroups() != null) {
                apiMrScalerScaleUpAws.setNewInstanceGroups(blMrScalerScaleUpAws.getNewInstanceGroups());
            }
        }

        return apiMrScalerScaleUpAws;
    }
}