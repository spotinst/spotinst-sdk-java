package com.spotinst.sdkjava.model.repo.mrScaler.aws;

import com.spotinst.sdkjava.exception.ExceptionHelper;
import com.spotinst.sdkjava.exception.SpotinstHttpException;
import com.spotinst.sdkjava.model.ISpotinstMrScalerScaleDownRepo;
import com.spotinst.sdkjava.model.RepoGenericResponse;
import com.spotinst.sdkjava.model.service.mrScaler.aws.SpotinstMrScalerScaleDownService;
import com.spotinst.sdkjava.model.api.mrScaler.aws.ApiMrScalerScaleDownAws;
import com.spotinst.sdkjava.model.bl.mrScaler.aws.BlMrScalerScaleDownAws;
import com.spotinst.sdkjava.model.converters.mrScaler.aws.MrScalerScaleDownConverter;

import java.util.List;
import java.util.stream.Collectors;

public class SpotinstMrScalerScaleDownRepo implements ISpotinstMrScalerScaleDownRepo {

    @Override
    public RepoGenericResponse<List<ApiMrScalerScaleDownAws>> scaleDownMrScaler(String mrScalerId, Integer adjustment, String authToken, String account) {
        RepoGenericResponse<List<ApiMrScalerScaleDownAws>> retVal;

        try {
            List<ApiMrScalerScaleDownAws> apiMrScalerScaleDown = null;
            List<BlMrScalerScaleDownAws> blMrScalerScaleDown  = SpotinstMrScalerScaleDownService.scaleDownMrScaler(mrScalerId, adjustment, authToken, account);
            if(blMrScalerScaleDown != null){
                apiMrScalerScaleDown = blMrScalerScaleDown.stream().map(MrScalerScaleDownConverter::toApi).collect(Collectors.toList());
            }


            retVal = new RepoGenericResponse<>(apiMrScalerScaleDown);
        } catch (SpotinstHttpException e) {
            retVal = ExceptionHelper.handleHttpException(e);
        }

        return retVal;
    }
}