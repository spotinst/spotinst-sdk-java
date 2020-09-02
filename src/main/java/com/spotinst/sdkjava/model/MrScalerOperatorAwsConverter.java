package com.spotinst.sdkjava.model;

import com.spotinst.sdkjava.model.api.mrScaler.aws.ApiMrScalerAws;
import com.spotinst.sdkjava.model.api.mrScaler.aws.ApiMrScalerOperatorAws;
import com.spotinst.sdkjava.model.bl.mrScaler.aws.BlMrScalerAws;
import com.spotinst.sdkjava.model.bl.mrScaler.aws.BlMrScalerOperatorAws;

public class MrScalerOperatorAwsConverter {
    // region toBl
    public static BlMrScalerOperatorAws toBl(ApiMrScalerOperatorAws apiMrScalerOperatorAws) {
        BlMrScalerOperatorAws blMrScalerOperatorAws = null;

        if (apiMrScalerOperatorAws != null) {
            BlMrScalerAws blMrScaler = MrScalerAwsConverter.toBl(apiMrScalerOperatorAws);

            blMrScalerOperatorAws = new BlMrScalerOperatorAws();
            blMrScalerOperatorAws.setMrScaler(blMrScaler);

            if (apiMrScalerOperatorAws.isOperatorNameSet()) {
                blMrScalerOperatorAws.setName(apiMrScalerOperatorAws.getOperatorName());
            }
        }

        return blMrScalerOperatorAws;
    }
    // endregion

    // region toApi
    public static ApiMrScalerOperatorAws toApi(BlMrScalerOperatorAws blMrScalerOperatorAws) {
       ApiMrScalerOperatorAws apiMrScalerOperatorAws = null;

        if (blMrScalerOperatorAws != null) {
            BlMrScalerAws blMrScalerAws = blMrScalerOperatorAws.getMrScaler();
            ApiMrScalerAws apiMrScalerAws = MrScalerAwsConverter.toApi(blMrScalerAws);

            ApiMrScalerOperatorAws.Builder apiMrScalerOperatorAwsBuilder = ApiMrScalerOperatorAws.Builder.get();
            apiMrScalerOperatorAws = apiMrScalerOperatorAwsBuilder.setName(blMrScalerAws.getName())
                                                                  .setCluster(apiMrScalerAws.getCluster())
                                                                  .setCompute(apiMrScalerAws.getCompute())
                                                                  .setDescription(apiMrScalerAws.getDescription())
                                                                  .setRegion(apiMrScalerAws.getRegion())
                                                                  .setScaling(apiMrScalerAws.getScaling())
                                                                  .setStrategy(apiMrScalerAws.getStrategy())
                                                                  .seCoretScaling(apiMrScalerAws.getCoreScaling())
                                                                  .setScheduling(apiMrScalerAws.getScheduling())
                                                                  .build();

            if (blMrScalerOperatorAws.getName() != null) {
                apiMrScalerOperatorAws.setOperatorName(blMrScalerOperatorAws.getName());
            }

            if (blMrScalerOperatorAws.getMrScaler() != null) {
                if (blMrScalerOperatorAws.getMrScaler().getId() != null) {
                    String id = blMrScalerOperatorAws.getMrScaler().getId();
                    apiMrScalerOperatorAws.setId(id);
                }
            }

        }

        return apiMrScalerOperatorAws;
   }
    // endregion
}
