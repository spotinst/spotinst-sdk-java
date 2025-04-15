package com.spotinst.sdkjava.model.repo.mrScaler.aws;

import com.spotinst.sdkjava.exception.ExceptionHelper;
import com.spotinst.sdkjava.exception.SpotinstHttpException;
import com.spotinst.sdkjava.model.ISpotinstMrScalerOperatorAwsRepo;
import com.spotinst.sdkjava.model.converters.mrScaler.aws.MrScalerAwsConverter;
import com.spotinst.sdkjava.model.RepoGenericResponse;
import com.spotinst.sdkjava.model.bl.mrScaler.aws.MrScalerOperatorAws;
import com.spotinst.sdkjava.model.service.mrScaler.aws.SpotinstMrScalerOperatorAwsService;
import com.spotinst.sdkjava.model.api.mrScaler.aws.ApiMrScalerOperatorAwsResponse;
import com.spotinst.sdkjava.model.bl.mrScaler.aws.MrScalerOperatorResponse;

public class SpotinstMrScalerAwsOperatorRepo implements ISpotinstMrScalerOperatorAwsRepo {
    @Override
    public RepoGenericResponse<MrScalerOperatorResponse> createOperator(
            MrScalerOperatorAws blScalerOperatorAws, String authToken, String account) {

        RepoGenericResponse<MrScalerOperatorResponse> create;

        try {

            ApiMrScalerOperatorAwsResponse apiScalerOperatorResponse = SpotinstMrScalerOperatorAwsService
                    .createMrScalerOperator(blScalerOperatorAws, authToken, account);
            MrScalerOperatorResponse blCreatedMrScalerOperator = MrScalerAwsConverter.toBl(apiScalerOperatorResponse);
            create = new RepoGenericResponse<>(blCreatedMrScalerOperator);
        }
        catch (SpotinstHttpException ex) {
            create = ExceptionHelper.handleHttpException(ex);
        }

        return create;
    }
}