package com.spotinst.sdkjava.model;

import com.spotinst.sdkjava.exception.SpotinstNotSupportedException;
import com.spotinst.sdkjava.model.bl.mrScaler.aws.MrScalerScaleUpAws;

import java.util.List;

public interface ISpotinstMrScalerScaleUpRepo extends IRepository<MrScalerScaleUpAws, Void, String> {
    default RepoGenericResponse<List<MrScalerScaleUpAws>> scaleUpMrScaler(String mrScalerId, Integer adjustment, String authToken, String account){
        throw new SpotinstNotSupportedException();
    }
}