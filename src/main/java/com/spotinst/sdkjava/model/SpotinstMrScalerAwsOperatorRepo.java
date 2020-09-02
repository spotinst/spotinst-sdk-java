package com.spotinst.sdkjava.model;

import com.spotinst.sdkjava.exception.ExceptionHelper;
import com.spotinst.sdkjava.exception.SpotinstHttpException;
import com.spotinst.sdkjava.model.api.mrScaler.aws.ApiMrScalerOperatorAws;
import com.spotinst.sdkjava.model.bl.mrScaler.aws.BlMrScalerOperatorAws;

public class SpotinstMrScalerAwsOperatorRepo implements ISpotinstMrScalerOperatorAwsRepo{
    @Override
    public RepoGenericResponse<ApiMrScalerOperatorAws> mrScalerOperator(ApiMrScalerOperatorAws mrScalerOperator, String authToken, String account) {
        RepoGenericResponse<ApiMrScalerOperatorAws> retVal;

        try {
            BlMrScalerOperatorAws  blMrScalerOperator         = MrScalerOperatorAwsConverter.toBl(mrScalerOperator);
            BlMrScalerOperatorAws  returnedBlMrScalerOperator = SpotinstMrScalerOperatorAwsService.mrScalerOperator(blMrScalerOperator, authToken, account);

            //Set returned id to MrScaler object
            returnedBlMrScalerOperator.setMrScaler(blMrScalerOperator.getMrScaler());
            returnedBlMrScalerOperator.getMrScaler().setId(returnedBlMrScalerOperator.getMrScalerId());

            ApiMrScalerOperatorAws returnedMrScalerOperator   = MrScalerOperatorAwsConverter.toApi(returnedBlMrScalerOperator);
            retVal = new RepoGenericResponse<>(returnedMrScalerOperator);

        } catch (SpotinstHttpException ex) {
            retVal = ExceptionHelper.handleHttpException(ex);
        }

        return retVal;
    }
}

