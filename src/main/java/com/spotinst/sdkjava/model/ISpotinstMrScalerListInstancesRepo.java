package com.spotinst.sdkjava.model;

import com.spotinst.sdkjava.exception.SpotinstNotSupportedException;
import com.spotinst.sdkjava.model.bl.mrScaler.aws.MrScalerListInstancesAws;

import java.util.List;

public interface ISpotinstMrScalerListInstancesRepo extends IRepository<MrScalerListInstancesAws, Void, String> {
    default RepoGenericResponse<List<MrScalerListInstancesAws>> listMrScalerInstances(String mrScalerId, String authToken, String account){
        throw new SpotinstNotSupportedException();
    }
}
