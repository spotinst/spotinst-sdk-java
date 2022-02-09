package com.spotinst.sdkjava.model.repo.mrScaler.aws;

import com.spotinst.sdkjava.exception.ExceptionHelper;
import com.spotinst.sdkjava.exception.SpotinstHttpException;
import com.spotinst.sdkjava.model.ISpotinstMrScalerListInstancesRepo;
import com.spotinst.sdkjava.model.RepoGenericResponse;
import com.spotinst.sdkjava.model.service.mrScaler.aws.SpotinstMrScalerListInstancesService;
import com.spotinst.sdkjava.model.api.mrScaler.aws.ApiMrScalerListInstancesAws;
import com.spotinst.sdkjava.model.bl.mrScaler.aws.BlMrScalerListInstancesAws;
import com.spotinst.sdkjava.model.converters.mrScaler.aws.MrScalerListInstancesConverter;

import java.util.List;
import java.util.stream.Collectors;

public class SpotinstMrScalerListInstancesRepo implements ISpotinstMrScalerListInstancesRepo {

    @Override
    public RepoGenericResponse<List<ApiMrScalerListInstancesAws>> listMrScalerInstances(String mrScalerId, String authToken, String account) {
        RepoGenericResponse<List<ApiMrScalerListInstancesAws>> retVal;

        try {
            List<ApiMrScalerListInstancesAws> apiMrScalerListInstances = null;
            List<BlMrScalerListInstancesAws> blMrScalerListInstances  = SpotinstMrScalerListInstancesService.listMrScalerInstances(mrScalerId, authToken, account);
            if(blMrScalerListInstances != null){
                apiMrScalerListInstances = blMrScalerListInstances.stream().map(MrScalerListInstancesConverter::toApi).collect(Collectors.toList());
            }


            retVal = new RepoGenericResponse<>(apiMrScalerListInstances);
        } catch (SpotinstHttpException e) {
            retVal = ExceptionHelper.handleHttpException(e);
        }

        return retVal;
    }
}
