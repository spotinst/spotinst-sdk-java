package com.spotinst.sdkjava.model.repo.mrScaler.aws;

import com.spotinst.sdkjava.exception.ExceptionHelper;
import com.spotinst.sdkjava.exception.SpotinstHttpException;
import com.spotinst.sdkjava.model.ISpotinstMrScalerAwsRepo;
import com.spotinst.sdkjava.model.converters.mrScaler.aws.MrScalerAwsConverter;
import com.spotinst.sdkjava.model.RepoGenericResponse;
import com.spotinst.sdkjava.model.service.mrScaler.aws.SpotinstMrScalerAwsService;
import com.spotinst.sdkjava.model.api.mrScaler.aws.ApiMrScalerAws;
import com.spotinst.sdkjava.model.bl.mrScaler.aws.MrScalerAws;

import java.util.List;
import java.util.stream.Collectors;

public class SpotinstMrScalerAwsRepo implements ISpotinstMrScalerAwsRepo {
    @Override
    public RepoGenericResponse<MrScalerAws> create(MrScalerAws mrScalerToCreate, String authToken, String account) {
        RepoGenericResponse<MrScalerAws> retVal;

        try {
            ApiMrScalerAws     apiMrScalertoCreate    = MrScalerAwsConverter.toDal(mrScalerToCreate);

            ApiMrScalerAws      apiMrScaleCreate = SpotinstMrScalerAwsService.createMrScaler(apiMrScalertoCreate, authToken, account);
            MrScalerAws blCreatedMrScaler  = MrScalerAwsConverter.toBl(apiMrScaleCreate);

            retVal = new RepoGenericResponse<>(blCreatedMrScaler);
        } catch (SpotinstHttpException ex) {
            retVal = ExceptionHelper.handleHttpException(ex);
        }

        return retVal;
    }

    @Override
    public RepoGenericResponse<Boolean> update(String clusterId, MrScalerAws mrScalerToUpdate, String authToken, String account) {
        RepoGenericResponse<Boolean> retVal;

        try{
            ApiMrScalerAws apiMrScalerToUpdate = MrScalerAwsConverter.toDal(mrScalerToUpdate);
            Boolean success = SpotinstMrScalerAwsService.updateMrScaler(clusterId, apiMrScalerToUpdate, authToken, account);
            retVal = new RepoGenericResponse<>(success);
        } catch (SpotinstHttpException ex) {
            retVal = ExceptionHelper.handleHttpException(ex);
        }
        return retVal;
    }


    @Override
    public RepoGenericResponse<Boolean> delete(String identifier, String authToken, String account) {
        RepoGenericResponse<Boolean> retVal;

        try {
            Boolean updated = SpotinstMrScalerAwsService.deleteMrScaler(identifier, authToken, account);
            retVal = new RepoGenericResponse<>(updated);

        } catch (SpotinstHttpException e) {
            retVal = ExceptionHelper.handleHttpException(e);
        }

        return retVal;
    }

    @Override
    public RepoGenericResponse<MrScalerAws> get(String mrScalerId, String authToken, String account) {
        RepoGenericResponse<MrScalerAws> retVal;

        try {
            ApiMrScalerAws blMrScaler = SpotinstMrScalerAwsService.getMrScaler(mrScalerId, authToken, account);
            MrScalerAws apiMrScalerAws = MrScalerAwsConverter.toBl(blMrScaler);
            retVal = new RepoGenericResponse<>(apiMrScalerAws);
        } catch (SpotinstHttpException e) {
            retVal = ExceptionHelper.handleHttpException(e);
        }

        return retVal;
    }

    @Override
    public RepoGenericResponse<List<MrScalerAws>> getAll(Void filter, String authToken, String account){
        RepoGenericResponse<List<MrScalerAws>> retVal;

        try{
            List<ApiMrScalerAws> blMrScalerList = SpotinstMrScalerAwsService.getAllMrScaler(authToken, account);
            List<MrScalerAws> mrScalers =
                    blMrScalerList.stream().map(MrScalerAwsConverter::toBl).collect(Collectors.toList());
            retVal = new RepoGenericResponse<>(mrScalers);
        } catch (SpotinstHttpException e) {
            retVal = ExceptionHelper.handleHttpException(e);
        }

        return retVal;
    }


}
