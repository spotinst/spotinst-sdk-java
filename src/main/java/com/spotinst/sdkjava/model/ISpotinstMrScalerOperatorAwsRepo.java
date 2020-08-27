package com.spotinst.sdkjava.model;

import com.spotinst.sdkjava.exception.SpotinstNotSupportedException;
import com.spotinst.sdkjava.model.api.mrScaler.aws.ApiMrScalerOperatorAws;

public interface ISpotinstMrScalerOperatorAwsRepo extends IRepository<ApiMrScalerOperatorAws, Void, String> {
    default RepoGenericResponse<ApiMrScalerOperatorAws> mrScalerOperator(ApiMrScalerOperatorAws apiMrScalerOperatorAws, String authToken, String account) {
        throw new SpotinstNotSupportedException();
    }
}
