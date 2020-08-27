package com.spotinst.sdkjava.model;

import com.spotinst.sdkjava.exception.ExceptionHelper;
import com.spotinst.sdkjava.exception.SpotinstHttpException;
import com.spotinst.sdkjava.model.api.mrScaler.aws.ApiMrScalerAws;
import com.spotinst.sdkjava.model.api.mrScaler.aws.ApiMrScalerOperatorAws;
import com.spotinst.sdkjava.model.bl.mrScaler.aws.BlMrScalerAws;
import com.spotinst.sdkjava.model.bl.mrScaler.aws.BlMrScalerOperatorAws;

import java.util.ArrayList;
import java.util.List;

public class SpotinstMrScalerAwsRepo implements ISpotinstMrScalerAwsRepo {
    @Override
    public RepoGenericResponse<ApiMrScalerAws> create(ApiMrScalerAws mrScalerToCreate, String authToken, String account) {
        RepoGenericResponse<ApiMrScalerAws> retVal;

        try {
            BlMrScalerAws      blMrScalerToCreate = MrScalerAwsConverter.toBl(mrScalerToCreate);
            BlMrScalerAws      blCreatedMrScaler  = SpotinstMrScalerAwsService.createMrScaler(blMrScalerToCreate, authToken, account);
            ApiMrScalerAws     createdMrScaler    = MrScalerAwsConverter.toApi(blCreatedMrScaler);
            retVal = new RepoGenericResponse<>(createdMrScaler);
        } catch (SpotinstHttpException ex) {
            retVal = ExceptionHelper.handleHttpException(ex);
        }

        return retVal;
    }

    @Override
    public RepoGenericResponse<Boolean> update(String clusterId, ApiMrScalerAws mrScalerToUpdate, String authToken, String account) {
        RepoGenericResponse<Boolean> retVal;

        try{
            BlMrScalerAws blMrScalerToUpdate = MrScalerAwsConverter.toBl(mrScalerToUpdate);
            Boolean success = SpotinstMrScalerAwsService.updateMrScaler(clusterId, blMrScalerToUpdate, authToken, account);
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
    public RepoGenericResponse<ApiMrScalerAws> get(String mrScalerId, String authToken,String account) {
        RepoGenericResponse<ApiMrScalerAws> retVal;

        try {
            BlMrScalerAws blMrScaler = SpotinstMrScalerAwsService.getMrScaler(mrScalerId, authToken, account);
            ApiMrScalerAws apiMrScalerAws = MrScalerAwsConverter.toApi(blMrScaler);
            retVal = new RepoGenericResponse<>(apiMrScalerAws);
        } catch (SpotinstHttpException e) {
            retVal = ExceptionHelper.handleHttpException(e);
        }

        return retVal;
    }

    @Override
    public RepoGenericResponse<List<ApiMrScalerAws>> getAll(Void filter, String authToken,String account){
        RepoGenericResponse<List<ApiMrScalerAws>> retVal;

        try{
            List<BlMrScalerAws> blMrScalerList = SpotinstMrScalerAwsService.getAllMrScaler(authToken, account);
            List<ApiMrScalerAws> convertedList = new ArrayList<>();
            for(BlMrScalerAws singleMrScaler: blMrScalerList){
                ApiMrScalerAws temp = MrScalerAwsConverter.toApi(singleMrScaler);
                convertedList.add(temp);
            }
            retVal = new RepoGenericResponse<>(convertedList);
        } catch (SpotinstHttpException e) {
            retVal = ExceptionHelper.handleHttpException(e);
        }

        return retVal;
    }

    //TODO - Override???
    public RepoGenericResponse<ApiMrScalerOperatorAws> operator(ApiMrScalerOperatorAws mrScalerOperator, String authToken, String account) {
        RepoGenericResponse<ApiMrScalerOperatorAws> retVal;

        try {
            BlMrScalerOperatorAws blMrScalerOperator = MrScalerOperatorAwsConverter.toBl(mrScalerOperator);
            BlMrScalerOperatorAws         returnedBlMrScalerOperator  = SpotinstMrScalerAwsService.mrScalerOperator(blMrScalerOperator, authToken, account);
            ApiMrScalerOperatorAws        returnedMrScalerOperator    = MrScalerOperatorAwsConverter.toApi(returnedBlMrScalerOperator);
            retVal = new RepoGenericResponse<>(returnedMrScalerOperator);
        } catch (SpotinstHttpException ex) {
            retVal = ExceptionHelper.handleHttpException(ex);
        }

        return retVal;
    }

}
