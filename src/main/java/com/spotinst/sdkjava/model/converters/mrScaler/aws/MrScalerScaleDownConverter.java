package com.spotinst.sdkjava.model.converters.mrScaler.aws;

import com.spotinst.sdkjava.model.api.mrScaler.aws.ApiMrScalerScaleDownAws;
import com.spotinst.sdkjava.model.bl.mrScaler.aws.BlMrScalerScaleDownAws;

public class MrScalerScaleDownConverter {

    public static BlMrScalerScaleDownAws toBl(ApiMrScalerScaleDownAws apiMrScalerScaleDownAws) {
        BlMrScalerScaleDownAws blMrScalerScaleDownAws = null;

        if (apiMrScalerScaleDownAws != null) {
            blMrScalerScaleDownAws = new BlMrScalerScaleDownAws();

            if (apiMrScalerScaleDownAws.isModifiedInstanceGroupsSet()) {
                blMrScalerScaleDownAws.setModifiedInstanceGroups(apiMrScalerScaleDownAws.getModifiedInstanceGroups());
            }

            if (apiMrScalerScaleDownAws.isVictimInstancesSet()) {
                blMrScalerScaleDownAws.setVictimInstances(apiMrScalerScaleDownAws.getVictimInstances());
            }
        }

        return blMrScalerScaleDownAws;
    }

    // region toApi
    public static ApiMrScalerScaleDownAws toApi(BlMrScalerScaleDownAws blMrScalerScaleDownAws) {
        ApiMrScalerScaleDownAws apiMrScalerScaleDownAws = null;

        if (blMrScalerScaleDownAws != null) {
            apiMrScalerScaleDownAws = new ApiMrScalerScaleDownAws();

            if (blMrScalerScaleDownAws.getModifiedInstanceGroups() != null) {
                apiMrScalerScaleDownAws.setModifiedInstanceGroups(blMrScalerScaleDownAws.getModifiedInstanceGroups());
            }

            if (blMrScalerScaleDownAws.getVictimInstances() != null) {
                apiMrScalerScaleDownAws.setVictimInstances(blMrScalerScaleDownAws.getVictimInstances());
            }
        }

        return apiMrScalerScaleDownAws;
    }
}