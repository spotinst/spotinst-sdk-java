package com.spotinst.sdkjava.model;

import com.spotinst.sdkjava.exception.SpotinstNotSupportedException;
import com.spotinst.sdkjava.model.bl.mrScaler.aws.MrScalerListScalersAws;

import java.util.List;

public interface ISpotinstMrScalerListScalersRepo extends IRepository<MrScalerListScalersAws, Void, String> {
    default RepoGenericResponse<List<MrScalerListScalersAws>> listMrScalers(String mrScalerId, String authToken, String account){
        throw new SpotinstNotSupportedException();
    }
}