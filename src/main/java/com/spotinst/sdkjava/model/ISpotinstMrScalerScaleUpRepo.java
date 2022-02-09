package com.spotinst.sdkjava.model;

import com.spotinst.sdkjava.exception.SpotinstNotSupportedException;
import com.spotinst.sdkjava.model.api.mrScaler.aws.ApiMrScalerScaleUpAws;

import java.util.List;

public interface ISpotinstMrScalerScaleUpRepo extends IRepository<ApiMrScalerScaleUpAws, Void, String> {
    default RepoGenericResponse<List<ApiMrScalerScaleUpAws>> scaleUpMrScaler(String mrScalerId, Integer adjustment, String authToken, String account){
        throw new SpotinstNotSupportedException();
    }
}