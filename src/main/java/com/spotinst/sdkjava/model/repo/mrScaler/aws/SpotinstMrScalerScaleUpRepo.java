package com.spotinst.sdkjava.model.repo.mrScaler.aws;

import com.spotinst.sdkjava.exception.ExceptionHelper;
import com.spotinst.sdkjava.exception.SpotinstHttpException;
import com.spotinst.sdkjava.model.ISpotinstMrScalerScaleUpRepo;
import com.spotinst.sdkjava.model.RepoGenericResponse;
import com.spotinst.sdkjava.model.converters.mrScaler.aws.MrScalerAwsConverter;
import com.spotinst.sdkjava.model.service.mrScaler.aws.SpotinstMrScalerScaleUpService;
import com.spotinst.sdkjava.model.api.mrScaler.aws.ApiMrScalerScaleUpAws;
import com.spotinst.sdkjava.model.bl.mrScaler.aws.MrScalerScaleUpAws;

import java.util.List;
import java.util.stream.Collectors;

public class SpotinstMrScalerScaleUpRepo implements ISpotinstMrScalerScaleUpRepo {

    @Override
    public RepoGenericResponse<List<MrScalerScaleUpAws>> scaleUpMrScaler(String mrScalerId, Integer adjustment, String authToken, String account) {
        RepoGenericResponse<List<MrScalerScaleUpAws>> retVal;

        try {
            List<ApiMrScalerScaleUpAws> apiMrScalerScaleUp = SpotinstMrScalerScaleUpService.scaleUpMrScaler(mrScalerId, adjustment, authToken, account);
            List<MrScalerScaleUpAws> blMrScalerScaleUp  = apiMrScalerScaleUp.stream().map(MrScalerAwsConverter::toBl).collect(Collectors.toList());

            retVal = new RepoGenericResponse<>(blMrScalerScaleUp);
        } catch (SpotinstHttpException e) {
            retVal = ExceptionHelper.handleHttpException(e);
        }
        return retVal;
    }
}