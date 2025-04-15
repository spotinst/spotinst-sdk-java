package com.spotinst.sdkjava.model.repo.mrScaler.aws;

import com.spotinst.sdkjava.exception.ExceptionHelper;
import com.spotinst.sdkjava.exception.SpotinstHttpException;
import com.spotinst.sdkjava.model.ISpotinstMrScalerListInstancesRepo;
import com.spotinst.sdkjava.model.RepoGenericResponse;
import com.spotinst.sdkjava.model.converters.mrScaler.aws.MrScalerAwsConverter;
import com.spotinst.sdkjava.model.service.mrScaler.aws.SpotinstMrScalerListInstancesService;
import com.spotinst.sdkjava.model.api.mrScaler.aws.ApiMrScalerListInstancesAws;
import com.spotinst.sdkjava.model.bl.mrScaler.aws.MrScalerListInstancesAws;

import java.util.List;
import java.util.stream.Collectors;

public class SpotinstMrScalerListInstancesRepo implements ISpotinstMrScalerListInstancesRepo {

    @Override
    public RepoGenericResponse<List<MrScalerListInstancesAws>> listMrScalerInstances(String mrScalerId, String authToken, String account) {
        RepoGenericResponse<List<MrScalerListInstancesAws>> retVal;

        try {
            List<ApiMrScalerListInstancesAws> apiMrScalerListInstances =
                    SpotinstMrScalerListInstancesService.listMrScalerInstances(mrScalerId, authToken, account);
            List<MrScalerListInstancesAws> blMrScalerListInstances =
                    apiMrScalerListInstances.stream().map(MrScalerAwsConverter::toBl).collect(Collectors.toList());
            retVal = new RepoGenericResponse<>(blMrScalerListInstances);
        } catch (SpotinstHttpException e) {
            retVal = ExceptionHelper.handleHttpException(e);
        }

        return retVal;
    }
}
