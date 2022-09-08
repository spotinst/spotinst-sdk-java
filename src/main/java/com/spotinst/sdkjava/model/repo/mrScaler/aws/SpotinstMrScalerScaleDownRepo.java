package com.spotinst.sdkjava.model.repo.mrScaler.aws;

import com.spotinst.sdkjava.exception.ExceptionHelper;
import com.spotinst.sdkjava.exception.SpotinstHttpException;
import com.spotinst.sdkjava.model.ISpotinstMrScalerScaleDownRepo;
import com.spotinst.sdkjava.model.RepoGenericResponse;
import com.spotinst.sdkjava.model.converters.mrScaler.aws.MrScalerAwsConverter;
import com.spotinst.sdkjava.model.service.mrScaler.aws.SpotinstMrScalerScaleDownService;
import com.spotinst.sdkjava.model.api.mrScaler.aws.ApiMrScalerScaleDownAws;
import com.spotinst.sdkjava.model.bl.mrScaler.aws.MrScalerScaleDownAws;

import java.util.List;
import java.util.stream.Collectors;

public class SpotinstMrScalerScaleDownRepo implements ISpotinstMrScalerScaleDownRepo {

    @Override
    public RepoGenericResponse<List<MrScalerScaleDownAws>> scaleDownMrScaler(String mrScalerId, Integer adjustment, String authToken, String account) {
        RepoGenericResponse<List<MrScalerScaleDownAws>> retVal;

        try {
            List<ApiMrScalerScaleDownAws> apiMrScalerScaleDown = SpotinstMrScalerScaleDownService.scaleDownMrScaler(mrScalerId, adjustment, authToken, account);
            List<MrScalerScaleDownAws> blMrScalerScaleDown  = apiMrScalerScaleDown.stream().map(MrScalerAwsConverter::toBl).collect(Collectors.toList());

            retVal = new RepoGenericResponse<>(blMrScalerScaleDown);

        }
        catch (SpotinstHttpException e) {
            retVal = ExceptionHelper.handleHttpException(e);
        }

        return retVal;
    }
}