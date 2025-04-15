package com.spotinst.sdkjava.model;

import com.spotinst.sdkjava.model.bl.mrScaler.aws.MrScalerOperatorAws;
import com.spotinst.sdkjava.model.bl.mrScaler.aws.MrScalerOperatorResponse;

public interface ISpotinstMrScalerOperatorAwsRepo extends IRepository<MrScalerOperatorAws, Void, String> {

    RepoGenericResponse<MrScalerOperatorResponse> createOperator(MrScalerOperatorAws mrScalerOperator,
                                                                 String authToken, String account);
}
