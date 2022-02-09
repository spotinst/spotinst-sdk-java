package com.spotinst.sdkjava.model.repo.mrScaler.aws;

import com.spotinst.sdkjava.exception.ExceptionHelper;
import com.spotinst.sdkjava.exception.SpotinstHttpException;
import com.spotinst.sdkjava.model.ISpotinstMrScalerScaleUpRepo;
import com.spotinst.sdkjava.model.RepoGenericResponse;
import com.spotinst.sdkjava.model.service.mrScaler.aws.SpotinstMrScalerScaleUpService;
import com.spotinst.sdkjava.model.api.mrScaler.aws.ApiMrScalerScaleUpAws;
import com.spotinst.sdkjava.model.bl.mrScaler.aws.BlMrScalerScaleUpAws;
import com.spotinst.sdkjava.model.converters.mrScaler.aws.MrScalerScaleUpConverter;

import java.util.List;
import java.util.stream.Collectors;

public class SpotinstMrScalerScaleUpRepo implements ISpotinstMrScalerScaleUpRepo {

    @Override
    public RepoGenericResponse<List<ApiMrScalerScaleUpAws>> scaleUpMrScaler(String mrScalerId, Integer adjustment, String authToken, String account) {
        RepoGenericResponse<List<ApiMrScalerScaleUpAws>> retVal;

        try {
            List<ApiMrScalerScaleUpAws> apiMrScalerScaleUp = null;
            List<BlMrScalerScaleUpAws> blMrScalerScaleUp  = SpotinstMrScalerScaleUpService.scaleUpMrScaler(mrScalerId, adjustment, authToken, account);
            if(blMrScalerScaleUp != null){
                apiMrScalerScaleUp = blMrScalerScaleUp.stream().map(MrScalerScaleUpConverter::toApi).collect(Collectors.toList());
            }


            retVal = new RepoGenericResponse<>(apiMrScalerScaleUp);
        } catch (SpotinstHttpException e) {
            retVal = ExceptionHelper.handleHttpException(e);
        }

        return retVal;
    }
}