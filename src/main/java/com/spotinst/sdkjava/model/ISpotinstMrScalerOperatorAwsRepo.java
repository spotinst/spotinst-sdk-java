package com.spotinst.sdkjava.model;

import com.spotinst.sdkjava.model.api.mrScaler.aws.ApiMrScalerOperatorAws;
import com.spotinst.sdkjava.model.api.mrScaler.aws.ApiMrScalerOperatorAwsResponse;

public interface ISpotinstMrScalerOperatorAwsRepo extends IRepository<ApiMrScalerOperatorAwsResponse, Void, String> {
    RepoGenericResponse<ApiMrScalerOperatorAwsResponse> createMrScalerOperator(ApiMrScalerOperatorAws mrScalerOperator,
                                                                               String authToken, String account);
}
