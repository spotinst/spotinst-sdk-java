package com.spotinst.sdkjava.model;

import com.spotinst.sdkjava.exception.SpotinstNotSupportedException;
import com.spotinst.sdkjava.model.api.mrScaler.aws.ApiMrScalerListScalersAws;

import java.util.List;

public interface ISpotinstMrScalerListScalersRepo extends IRepository<ApiMrScalerListScalersAws, Void, String> {
    default RepoGenericResponse<List<ApiMrScalerListScalersAws>> listMrScalers(String mrScalerId, String authToken, String account){
        throw new SpotinstNotSupportedException();
    }
}