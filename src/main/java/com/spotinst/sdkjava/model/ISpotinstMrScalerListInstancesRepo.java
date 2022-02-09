package com.spotinst.sdkjava.model;

import com.spotinst.sdkjava.exception.SpotinstNotSupportedException;
import com.spotinst.sdkjava.model.api.mrScaler.aws.ApiMrScalerListInstancesAws;

import java.util.List;

public interface ISpotinstMrScalerListInstancesRepo extends IRepository<ApiMrScalerListInstancesAws, Void, String> {
    default RepoGenericResponse<List<ApiMrScalerListInstancesAws>> listMrScalerInstances(String mrScalerId, String authToken, String account){
        throw new SpotinstNotSupportedException();
    }
}
