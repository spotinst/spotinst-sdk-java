package com.spotinst.sdkjava.model;

import com.spotinst.sdkjava.exception.SpotinstNotSupportedException;
import com.spotinst.sdkjava.model.bl.mrScaler.aws.MrScalerScaleDownAws;

import java.util.List;

public interface ISpotinstMrScalerScaleDownRepo extends IRepository<MrScalerScaleDownAws, Void, String> {
    default RepoGenericResponse<List<MrScalerScaleDownAws>> scaleDownMrScaler(String mrScalerId, Integer adjustment, String authToken, String account){
        throw new SpotinstNotSupportedException();
    }
}