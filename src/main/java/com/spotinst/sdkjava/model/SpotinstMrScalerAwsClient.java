package com.spotinst.sdkjava.model;

import com.spotinst.sdkjava.exception.HttpError;
import com.spotinst.sdkjava.exception.SpotinstHttpException;
import com.spotinst.sdkjava.model.api.mrScaler.aws.ApiMrScalerAws;
import com.spotinst.sdkjava.model.api.mrScaler.aws.ApiMrScalerAwsCreationRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;


public class SpotinstMrScalerAwsClient {
    private static final Logger LOGGER = LoggerFactory.getLogger(SpotinstSpectrumClient.class);

    //region Members
    private String authToken;
    private String account;
    private ISpotinstMrScalerAwsRepo spotinstMrScalerRepo;


    public ISpotinstMrScalerAwsRepo getSpotinstMrScalerRepo(){
        return this.spotinstMrScalerRepo;
    }

    public void setSpotinstMrScalerRepo(){
        this.spotinstMrScalerRepo = SpotinstRepoManager.getInstance().getSpotinstMrScalerAwsRepo();
    }

    /**
     * This Object is used to store the users account and token information and then make requests to the
     * AWS MrScaler endpoints.
     *
     * @param authToken User Spotinst API token
     * @param account User Spotinst account ID
     */
    public SpotinstMrScalerAwsClient(String authToken,String account) {
        this.authToken = authToken;
        this.account = account;

        setSpotinstMrScalerRepo();
    }


    // endregion

    // region Methods
    /**
     * This method is used to create an AWS MrScaler Cluster
     *
     * @param mrScalerCreationRequest ApiMrScalerAwsCreationRequest Object that contains the requested create params
     * @return ApiMrScalerAws
     */
    public ApiMrScalerAws createMrScaler(ApiMrScalerAwsCreationRequest mrScalerCreationRequest) {
        ApiMrScalerAws retVal = null;

        ApiMrScalerAws mrScalerToCreate = mrScalerCreationRequest.getMrScaler();

        RepoGenericResponse<ApiMrScalerAws> creationResponse = getSpotinstMrScalerRepo().create(mrScalerToCreate, authToken, account);
        if (creationResponse.isRequestSucceed()) {
            retVal = creationResponse.getValue();
        } else {
            List<HttpError> httpExceptions = creationResponse.getHttpExceptions();
            HttpError httpException = httpExceptions.get(0);
            LOGGER.error(String.format("Error encountered while attempting to create MrScaler. Code: %s. Message: %s.", httpException.getCode(), httpException.getMessage()));
            throw new SpotinstHttpException(httpException.getMessage());
        }
        return retVal;
    }

    /**
     * This method is used to update an exiting AWS MrScaler Cluster
     *
     * @param mrScalerUpdateRequest ApiMrScalerAwsUpdateRequest Object that contains the requested update params
     * @param clusterId String for the cluster Id to update
     * @return Boolean
     */
    public Boolean updateMrScaler(ApiMrScalerAwsUpdateRequest mrScalerUpdateRequest, String clusterId) {
        Boolean retVal;

        ApiMrScalerAws mrScalerToUpdate = mrScalerUpdateRequest.getMrScaler();

        RepoGenericResponse<Boolean> updateResponse = getSpotinstMrScalerRepo().update(clusterId, mrScalerToUpdate, authToken, account);
        if (updateResponse.isRequestSucceed()) {
            retVal = updateResponse.getValue();
        } else {
            List<HttpError> httpExceptions = updateResponse.getHttpExceptions();
            HttpError httpException = httpExceptions.get(0);
            LOGGER.error(String.format("Error encountered while attempting to create mrScaler. Code: %s. Message: %s.", httpException.getCode(), httpException.getMessage()));
            throw new SpotinstHttpException(httpException.getMessage());
        }
        return retVal;
    }

    /**
     * This method is used to delete an exiting AWS MrScaler Cluster
     *
     * @param mrScalerDeletionRequest ApiMrScalerAwsDeleteRequest Object that contains the requested delete mrScaler ID
     * @return Boolean
     */
    public Boolean deleteMrScaler(ApiMrScalerAwsDeleteRequest mrScalerDeletionRequest) {
        Boolean retVal;
        String mrScalerToDeleteId = mrScalerDeletionRequest.getMrScalerId();
        RepoGenericResponse<Boolean> mrScalerDeletionResponse = getSpotinstMrScalerRepo().delete(mrScalerToDeleteId, authToken, account);
        if (mrScalerDeletionResponse.isRequestSucceed()) {
            retVal = mrScalerDeletionResponse.getValue();
        } else {
            List<HttpError> httpExceptions = mrScalerDeletionResponse.getHttpExceptions();
            HttpError httpException = httpExceptions.get(0);
            LOGGER.error(String.format("Error encountered while attempting to delete mrScaler. Code: %s. Message: %s.", httpException.getCode(), httpException.getMessage()));
            throw new SpotinstHttpException(httpException.getMessage());
        }

        return retVal;
    }

    /**
     * This method is used to get an exiting AWS MrScaler Cluster
     *
     * @param mrScalerAwsGetRequest ApiMrScalerAwsGetRequest Object that contains the requested get mrScaler ID
     * @return ApiMrScalerAws
     */
    public ApiMrScalerAws getMrScaler(ApiMrScalerAwsGetRequest mrScalerAwsGetRequest){
        ApiMrScalerAws retVal;
        String clusterToGet = mrScalerAwsGetRequest.getMrScalerId();
        RepoGenericResponse<ApiMrScalerAws> mrScalerGetRes = getSpotinstMrScalerRepo().get(clusterToGet, authToken, account);
        if (mrScalerGetRes.isRequestSucceed()){
            retVal = mrScalerGetRes.getValue();
        }else{
            List<HttpError> httpExceptions = mrScalerGetRes.getHttpExceptions();
            HttpError httpException = httpExceptions.get(0);
            LOGGER.error(String.format("Error encountered while attempting to get mrScaler. Code: %s. Message: %s.", httpException.getCode(), httpException.getMessage()));
            throw new SpotinstHttpException(httpException.getMessage());
        }

        return retVal;
    }

    /**
     * This method is used to get all AWS MrScaler Clusters
     *
     * @return List
     */
    public List<ApiMrScalerAws> getAllMrScalers(){
        List<ApiMrScalerAws> retVal;
        RepoGenericResponse<List<ApiMrScalerAws>> getAllRes = getSpotinstMrScalerRepo().getAll(null, authToken, account);

        if(getAllRes.isRequestSucceed()){
            retVal = getAllRes.getValue();
        }else{
            List<HttpError> httpExceptions = getAllRes.getHttpExceptions();
            HttpError httpException = httpExceptions.get(0);
            LOGGER.error(String.format("Error encountered while attempting to get all mrScalers. Code: %s. Message: %s.", httpException.getCode(), httpException.getMessage()));
            throw new SpotinstHttpException(httpException.getMessage());
        }

        return retVal;
    }

    // endregion

}
