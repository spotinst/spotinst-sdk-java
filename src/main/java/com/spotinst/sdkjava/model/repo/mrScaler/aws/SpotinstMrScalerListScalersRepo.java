package com.spotinst.sdkjava.model.repo.mrScaler.aws;

import com.spotinst.sdkjava.exception.ExceptionHelper;
import com.spotinst.sdkjava.exception.SpotinstHttpException;
import com.spotinst.sdkjava.model.ISpotinstMrScalerListScalersRepo;
import com.spotinst.sdkjava.model.RepoGenericResponse;
import com.spotinst.sdkjava.model.converters.mrScaler.aws.MrScalerAwsConverter;
import com.spotinst.sdkjava.model.service.mrScaler.aws.SpotinstMrScalerListScalersService;
import com.spotinst.sdkjava.model.api.mrScaler.aws.ApiMrScalerListScalersAws;
import com.spotinst.sdkjava.model.bl.mrScaler.aws.MrScalerListScalersAws;

import java.util.List;
import java.util.stream.Collectors;

public class SpotinstMrScalerListScalersRepo implements ISpotinstMrScalerListScalersRepo {

    @Override
    public RepoGenericResponse<List<MrScalerListScalersAws>> listMrScalers(String mrScalerId, String authToken, String account) {
        RepoGenericResponse<List<MrScalerListScalersAws>> retVal;

        try {
            List<ApiMrScalerListScalersAws> apiMrScalerListScalers =
                    SpotinstMrScalerListScalersService.listMrScalerInstances(mrScalerId, authToken, account);
            List<MrScalerListScalersAws> blMrScalerListScalers  =
                    apiMrScalerListScalers.stream().map(MrScalerAwsConverter::toBl).collect(Collectors.toList());


            retVal = new RepoGenericResponse<>(blMrScalerListScalers);
        } catch (SpotinstHttpException e) {
            retVal = ExceptionHelper.handleHttpException(e);
        }

        return retVal;
    }
}