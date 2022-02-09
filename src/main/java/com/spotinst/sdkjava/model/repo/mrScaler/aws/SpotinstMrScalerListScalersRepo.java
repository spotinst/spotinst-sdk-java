package com.spotinst.sdkjava.model.repo.mrScaler.aws;

import com.spotinst.sdkjava.exception.ExceptionHelper;
import com.spotinst.sdkjava.exception.SpotinstHttpException;
import com.spotinst.sdkjava.model.ISpotinstMrScalerListScalersRepo;
import com.spotinst.sdkjava.model.RepoGenericResponse;
import com.spotinst.sdkjava.model.service.mrScaler.aws.SpotinstMrScalerListScalersService;
import com.spotinst.sdkjava.model.api.mrScaler.aws.ApiMrScalerListScalersAws;
import com.spotinst.sdkjava.model.bl.mrScaler.aws.BlMrScalerListScalersAws;
import com.spotinst.sdkjava.model.converters.mrScaler.aws.MrScalerListScalersConverter;

import java.util.List;
import java.util.stream.Collectors;

public class SpotinstMrScalerListScalersRepo implements ISpotinstMrScalerListScalersRepo {

    @Override
    public RepoGenericResponse<List<ApiMrScalerListScalersAws>> listMrScalers(String mrScalerId, String authToken, String account) {
        RepoGenericResponse<List<ApiMrScalerListScalersAws>> retVal;

        try {
            List<ApiMrScalerListScalersAws> apiMrScalerListScalers = null;
            List<BlMrScalerListScalersAws> blMrScalerListScalers  = SpotinstMrScalerListScalersService.listMrScalerInstances(mrScalerId, authToken, account);
            if(blMrScalerListScalers != null){
                apiMrScalerListScalers = blMrScalerListScalers.stream().map(MrScalerListScalersConverter::toApi).collect(Collectors.toList());
            }


            retVal = new RepoGenericResponse<>(apiMrScalerListScalers);
        } catch (SpotinstHttpException e) {
            retVal = ExceptionHelper.handleHttpException(e);
        }

        return retVal;
    }
}