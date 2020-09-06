package com.spotinst.sdkjava.model;

import com.spotinst.sdkjava.exception.ExceptionHelper;
import com.spotinst.sdkjava.exception.SpotinstHttpException;
import com.spotinst.sdkjava.model.api.mrScaler.aws.ApiMrScalerOperatorAws;
import com.spotinst.sdkjava.model.api.mrScaler.aws.ApiMrScalerOperatorAwsResponse;
import com.spotinst.sdkjava.model.bl.mrScaler.aws.BlMrScalerOperatorAws;
import com.spotinst.sdkjava.model.bl.mrScaler.aws.BlMrScalerOperatorResponse;

public class SpotinstMrScalerAwsOperatorRepo implements ISpotinstMrScalerOperatorAwsRepo {
    @Override
    public RepoGenericResponse<ApiMrScalerOperatorAwsResponse> createMrScalerOperator(
            ApiMrScalerOperatorAws apiMrScalerOperatorAws, String authToken, String account) {
        RepoGenericResponse<ApiMrScalerOperatorAwsResponse> retVal;

        try {
            BlMrScalerOperatorAws blMrScalerOperatorAws = MrScalerOperatorAwsConverter.toBl(apiMrScalerOperatorAws);

            BlMrScalerOperatorResponse blCreatedMrScalerOperator = SpotinstMrScalerOperatorAwsService
                    .createMrScalerOperator(blMrScalerOperatorAws, authToken, account);

            ApiMrScalerOperatorAwsResponse createdMrScalerOperator =
                    MrScalerOperatorAwsConverter.toApi(blCreatedMrScalerOperator);

            retVal = new RepoGenericResponse<>(createdMrScalerOperator);

        }
        catch (SpotinstHttpException ex) {
            retVal = ExceptionHelper.handleHttpException(ex);
        }

        return retVal;
    }
}

