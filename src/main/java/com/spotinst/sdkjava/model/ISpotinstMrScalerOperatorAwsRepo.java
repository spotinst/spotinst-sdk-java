package com.spotinst.sdkjava.model;

import com.spotinst.sdkjava.model.api.mrScaler.aws.ApiMrScalerOperatorAws;

public interface ISpotinstMrScalerOperatorAwsRepo extends IRepository<ApiMrScalerOperatorAws, Void, String> {
    RepoGenericResponse<ApiMrScalerOperatorAws> mrScalerOperator(ApiMrScalerOperatorAws mrScalerOperator,
                                                                 String authToken, String account);
}
