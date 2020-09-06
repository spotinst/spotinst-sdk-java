package com.spotinst.sdkjava.model;

import com.spotinst.sdkjava.exception.HttpError;
import com.spotinst.sdkjava.exception.SpotinstHttpException;
import com.spotinst.sdkjava.model.api.mrScaler.aws.ApiMrScalerOperatorAwsRequest;
import com.spotinst.sdkjava.model.api.mrScaler.aws.ApiMrScalerOperatorAws;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class SpotinstMrScalerOperatorAwsClient {
    private static final Logger LOGGER = LoggerFactory.getLogger(SpotinstMrScalerOperatorAwsClient.class);

    //region Members
    private String authToken;
    private String account;
    private ISpotinstMrScalerOperatorAwsRepo spotinstMrScalerOperatorRepo;


    public ISpotinstMrScalerOperatorAwsRepo getSpotinstMrScalerOpratorRepo(){
        return this.spotinstMrScalerOperatorRepo;
    }

    public void setSpotinstMrScalerOperatorRepo(){
        this.spotinstMrScalerOperatorRepo = SpotinstRepoManager.getInstance().getSpotinstMrScalerOperatorAwsRepo();
    }

    /**
     * This Object is used to store the users account and token information and then make requests to the
     * AWS MrScalerOperator endpoints.
     *
     * @param authToken User Spotinst API token
     * @param account User Spotinst account ID
     */
    public SpotinstMrScalerOperatorAwsClient(String authToken,String account) {
        this.authToken = authToken;
        this.account = account;

        setSpotinstMrScalerOperatorRepo();
    }


    // endregion

    // region Methods
    /**
     * todo liron - describe what this operation does
     * This method is used to create an AWS MrScaler Cluster
     *
     * @param mrScalerOperatorRequest ApiMrScalerOpeartorAwsRequest Object that contains the requested operator params
     * @return ApiMrScalerOperatorAws
     */
    //todo liron - rename to create
    public ApiMrScalerOperatorAws mrScalerOperator(ApiMrScalerOperatorAwsRequest mrScalerOperatorRequest) {
        ApiMrScalerOperatorAws retVal;

        ApiMrScalerOperatorAws mrScalerOperator = mrScalerOperatorRequest.getMrScalerOperator();

        RepoGenericResponse<ApiMrScalerOperatorAws> operatorResponse = getSpotinstMrScalerOpratorRepo().mrScalerOperator(mrScalerOperator, authToken, account);
        if (operatorResponse.isRequestSucceed()) {
            retVal = operatorResponse.getValue();
        } else {
            List<HttpError> httpExceptions = operatorResponse.getHttpExceptions();
            HttpError       httpException  = httpExceptions.get(0);
            LOGGER.error(String.format("Error encountered while attempting to create MrScaler. Code: %s. Message: %s.", httpException.getCode(), httpException.getMessage()));
            throw new SpotinstHttpException(httpException.getMessage());
        }
        return retVal;
    }
    // endregion

}
