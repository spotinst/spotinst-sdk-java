package com.spotinst.sdkjava.model;

import com.spotinst.sdkjava.exception.SpotinstNotSupportedException;
import com.spotinst.sdkjava.model.api.mrScaler.aws.ApiMrScalerScaleDownAws;

import java.util.List;

public interface ISpotinstMrScalerScaleDownRepo extends IRepository<ApiMrScalerScaleDownAws, Void, String> {
    default RepoGenericResponse<List<ApiMrScalerScaleDownAws>> scaleDownMrScaler(String mrScalerId, Integer adjustment, String authToken, String account){
        throw new SpotinstNotSupportedException();
    }
}