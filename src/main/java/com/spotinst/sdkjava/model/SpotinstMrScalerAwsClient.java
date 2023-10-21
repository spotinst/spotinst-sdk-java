package com.spotinst.sdkjava.model;

import com.spotinst.sdkjava.exception.HttpError;
import com.spotinst.sdkjava.exception.SpotinstHttpException;
import com.spotinst.sdkjava.model.bl.mrScaler.aws.*;
import com.spotinst.sdkjava.model.requests.mrScaler.aws.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;


public class SpotinstMrScalerAwsClient {
    private static final Logger LOGGER = LoggerFactory.getLogger(SpotinstSpectrumClient.class);

    //region Members
    private String                              authToken;
    private String                              account;
    private Integer                             adjustment;
    private ISpotinstMrScalerAwsRepo            spotinstMrScalerRepo;
    private ISpotinstMrScalerOperatorAwsRepo    spotinstMrScalerOperatorAwsRepo;
    private ISpotinstMrScalerListInstancesRepo  sportMrScalerListInstancesRepo;
    private ISpotinstMrScalerListScalersRepo    spotinstMrScalerListScalersRepo;
    private ISpotinstMrScalerScaleUpRepo        spotinstMrScalerScaleUpRepo;
    private ISpotinstMrScalerScaleDownRepo      spotinstMrScalerScaleDownRepo;

    public ISpotinstMrScalerAwsRepo getSpotinstMrScalerRepo() {
        return this.spotinstMrScalerRepo;
    }

    public void setSpotinstMrScalerRepo() {
        this.spotinstMrScalerRepo = SpotinstRepoManager.getInstance().getSpotinstMrScalerAwsRepo();
    }

    public ISpotinstMrScalerOperatorAwsRepo getSpotinstMrScalerOperatorAwsRepo() {
        return spotinstMrScalerOperatorAwsRepo;
    }

    public void setSpotinstMrScalerOperatorAwsRepo() {
        this.spotinstMrScalerOperatorAwsRepo = SpotinstRepoManager.getInstance().getSpotinstMrScalerOperatorAwsRepo();
    }

    public ISpotinstMrScalerListInstancesRepo getSpotinstMrScalerListInstancesRepo(){
        return this.sportMrScalerListInstancesRepo;
    }

    public void setSportMrScalerListInstancesRepo(){
        this.sportMrScalerListInstancesRepo = SpotinstRepoManager.getInstance().getSpotinstMrScalerListInstancesRepo();
    }

    public ISpotinstMrScalerListScalersRepo getSpotinstMrScalerListScalersRepo(){
        return this.spotinstMrScalerListScalersRepo;
    }

    public void setSpotinstMrScalerListScalersRepo(){
        this.spotinstMrScalerListScalersRepo = SpotinstRepoManager.getInstance().getSpotinstMrScalerListScalersRepo();
    }

    public ISpotinstMrScalerScaleUpRepo getSpotinstMrScalerScaleUpRepo(){
        return this.spotinstMrScalerScaleUpRepo;
    }

    public void setSpotinstMrScalerScaleUpRepo(){
        this.spotinstMrScalerScaleUpRepo = SpotinstRepoManager.getInstance().getSpotinstMrScalerScaleUpRepo();
    }

    public ISpotinstMrScalerScaleDownRepo getSpotinstMrScalerScaleDownRepo(){
        return this.spotinstMrScalerScaleDownRepo;
    }

    public void setSpotinstMrScalerScaleDownRepo(){
        this.spotinstMrScalerScaleDownRepo = SpotinstRepoManager.getInstance().getSpotinstMrScalerScaleDownRepo();
    }

    /**
     * This Object is used to store the users account and token information and then make requests to the
     * AWS MrScaler endpoints.
     *
     * @param authToken User Spotinst API token
     * @param account   User Spotinst account ID
     */
    public SpotinstMrScalerAwsClient(String authToken, String account) {
        this.authToken = authToken;
        this.account = account;

        setSpotinstMrScalerRepo();
        setSpotinstMrScalerOperatorAwsRepo();
        setSportMrScalerListInstancesRepo();
        setSpotinstMrScalerListScalersRepo();
        setSpotinstMrScalerScaleUpRepo();
        setSpotinstMrScalerScaleDownRepo();
    }


    // endregion

    // region Methods

    /**
     * This method is used to create an AWS MrScaler Cluster
     *
     * @param mrScalerCreationRequest MrScalerAwsCreationRequest Object that contains the requested create params
     * @return ApiMrScalerAws
     */
    public MrScalerAws createMrScaler(MrScalerAwsCreationRequest mrScalerCreationRequest) {
        MrScalerAws isCreated;

        MrScalerAws mrScalerToCreate = mrScalerCreationRequest.getMrScaler();

        RepoGenericResponse<MrScalerAws> creationResponse =
                getSpotinstMrScalerRepo().create(mrScalerToCreate, authToken, account);
        if (creationResponse.isRequestSucceed()) {
            isCreated = creationResponse.getValue();
        }
        else {
            List<HttpError> httpExceptions = creationResponse.getHttpExceptions();
            HttpError       httpException  = httpExceptions.get(0);
            LOGGER.error(String.format("Error encountered while attempting to create MrScaler. Code: %s. Message: %s.",
                                       httpException.getCode(), httpException.getMessage()));
            throw new SpotinstHttpException(httpException.getMessage());
        }
        return isCreated;
    }

    /**
     * This method is used to update an exiting AWS MrScaler Cluster
     *
     * @param mrScalerUpdateRequest MrScalerAwsUpdateRequest Object that contains the requested update params
     * @param clusterId             String for the cluster Id to update
     * @return Boolean
     */
    public Boolean updateMrScaler(MrScalerAwsUpdateRequest mrScalerUpdateRequest, String clusterId) {
        Boolean isUpdated;

        MrScalerAws mrScalerToUpdate = mrScalerUpdateRequest.getMrScaler();

        RepoGenericResponse<Boolean> updateResponse =
                getSpotinstMrScalerRepo().update(clusterId, mrScalerToUpdate, authToken, account);
        if (updateResponse.isRequestSucceed()) {
            isUpdated = updateResponse.getValue();
        }
        else {
            List<HttpError> httpExceptions = updateResponse.getHttpExceptions();
            HttpError       httpException  = httpExceptions.get(0);
            LOGGER.error(String.format("Error encountered while attempting to create mrScaler. Code: %s. Message: %s.",
                                       httpException.getCode(), httpException.getMessage()));
            throw new SpotinstHttpException(httpException.getMessage());
        }
        return isUpdated;
    }

    /**
     * This method is used to delete an exiting AWS MrScaler Cluster
     *
     * @param mrScalerDeletionRequest ApiMrScalerAwsDeleteRequest Object that contains the requested delete mrScaler ID
     * @return Boolean
     */
    public Boolean deleteMrScaler(MrScalerAwsDeleteRequest mrScalerDeletionRequest) {
        Boolean isDeleted;
        String  mrScalerToDeleteId = mrScalerDeletionRequest.getMrScalerId();
        RepoGenericResponse<Boolean> mrScalerDeletionResponse =
                getSpotinstMrScalerRepo().delete(mrScalerToDeleteId, authToken, account);
        if (mrScalerDeletionResponse.isRequestSucceed()) {
            isDeleted = mrScalerDeletionResponse.getValue();
        }
        else {
            List<HttpError> httpExceptions = mrScalerDeletionResponse.getHttpExceptions();
            HttpError       httpException  = httpExceptions.get(0);
            LOGGER.error(String.format("Error encountered while attempting to delete mrScaler. Code: %s. Message: %s.",
                                       httpException.getCode(), httpException.getMessage()));
            throw new SpotinstHttpException(httpException.getMessage());
        }

        return isDeleted;
    }

    /**
     * This method is used to get an exiting AWS MrScaler Cluster
     *
     * @param mrScalerAwsGetRequest MrScalerAwsGetRequest Object that contains the requested get mrScaler ID
     * @return ApiMrScalerAws
     */
    public MrScalerAws getMrScaler(MrScalerAwsGetRequest mrScalerAwsGetRequest) {
        MrScalerAws retVal;
        String         clusterToGet = mrScalerAwsGetRequest.getMrScalerId();
        RepoGenericResponse<MrScalerAws> mrScalerGetRes =
                getSpotinstMrScalerRepo().get(clusterToGet, authToken, account);
        if (mrScalerGetRes.isRequestSucceed()) {
            retVal = mrScalerGetRes.getValue();
        }
        else {
            List<HttpError> httpExceptions = mrScalerGetRes.getHttpExceptions();
            HttpError       httpException  = httpExceptions.get(0);
            LOGGER.error(String.format("Error encountered while attempting to get mrScaler. Code: %s. Message: %s.",
                                       httpException.getCode(), httpException.getMessage()));
            throw new SpotinstHttpException(httpException.getMessage());
        }

        return retVal;
    }

    /**
     * This method is used to Get a list of all instances and instances groups in the cluster
     *
     *
     * @return a list of instances
     */
    public List<MrScalerListInstancesAws> listMrScalerInstances(
            MrScalerListInstancesRequest mrScalerListInstancesRequest) {
        List<MrScalerListInstancesAws> retVal;
        String         clusterToGet = mrScalerListInstancesRequest.getMrScalerId();
        RepoGenericResponse<List<MrScalerListInstancesAws>> mrScalerListInstances = getSpotinstMrScalerListInstancesRepo().listMrScalerInstances(clusterToGet, authToken, account);

        if(mrScalerListInstances.isRequestSucceed()){
            retVal = mrScalerListInstances.getValue();
        }
        else {
            List<HttpError> httpExceptions = mrScalerListInstances.getHttpExceptions();
            HttpError       httpException  = httpExceptions.get(0);
            LOGGER.error(String.format("Error encountered while attempting to get a list of all instances and instances groups in the cluster. Code: %s. Message: %s.",
                                       httpException.getCode(), httpException.getMessage()));
            throw new SpotinstHttpException(httpException.getMessage());
        }

        return retVal;
    }

    /**
     * This method is used to Scaler cluster
     *
     *
     * @return a list of Scaler cluster
     */
    public List<MrScalerListScalersAws> listMrScalers(MrScalerListMrScalersRequest mrScalerListScalersRequest) {
        List<MrScalerListScalersAws> retVal;
        String         clusterToGet = mrScalerListScalersRequest.getMrScalerId();
        RepoGenericResponse<List<MrScalerListScalersAws>> mrScalerListScalers =
                getSpotinstMrScalerListScalersRepo().listMrScalers(clusterToGet, authToken, account);

        if(mrScalerListScalers.isRequestSucceed()){
            retVal = mrScalerListScalers.getValue();
        }
        else {
            List<HttpError> httpExceptions = mrScalerListScalers.getHttpExceptions();
            HttpError       httpException  = httpExceptions.get(0);
            LOGGER.error(String.format("Error encountered while attempting to get a list of Scaler cluster. Code: %s. Message: %s.",
                                       httpException.getCode(), httpException.getMessage()));
            throw new SpotinstHttpException(httpException.getMessage());
        }

        return retVal;
    }

    /**
     * This method is used to Scale Up the cluster
     *
     *
     * @return a list of instances
     */
    public List<MrScalerScaleUpAws> scaleUpMrScaler(MrScalerScaleUpRequest mrScalerScaleUpRequest) {
        List<MrScalerScaleUpAws> retVal;
        String         clusterToGet = mrScalerScaleUpRequest.getMrScalerId();
        Integer        adjustment   = mrScalerScaleUpRequest.getAdjustment();
        RepoGenericResponse<List<MrScalerScaleUpAws>> mrScalerScaleUp = getSpotinstMrScalerScaleUpRepo()
                .scaleUpMrScaler(clusterToGet, adjustment, authToken, account);

        if(mrScalerScaleUp.isRequestSucceed()){
            retVal = mrScalerScaleUp.getValue();
        }
        else {
            List<HttpError> httpExceptions = mrScalerScaleUp.getHttpExceptions();
            HttpError       httpException  = httpExceptions.get(0);
            LOGGER.error(String.format("Error encountered while attempting to Scale Up the cluster. Code: %s. Message: %s.",
                                       httpException.getCode(), httpException.getMessage()));
            throw new SpotinstHttpException(httpException.getMessage());
        }

        return retVal;
    }

    /**
     * This method is used to Scale Down the cluster
     *
     *
     * @return a list of instances
     */
    public List<MrScalerScaleDownAws> scaleDownMrScaler(MrScalerScaleDownRequest mrScalerScaleDownRequest) {
        List<MrScalerScaleDownAws> retVal;
        String clusterToGet = mrScalerScaleDownRequest.getMrScalerId();
        Integer adjustment  = mrScalerScaleDownRequest.getAdjustment();
        RepoGenericResponse<List<MrScalerScaleDownAws>> mrScalerScaleDown = getSpotinstMrScalerScaleDownRepo()
                .scaleDownMrScaler(clusterToGet, adjustment, authToken, account);

        if(mrScalerScaleDown.isRequestSucceed()){
            retVal = mrScalerScaleDown.getValue();
        }
        else {
            List<HttpError> httpExceptions = mrScalerScaleDown.getHttpExceptions();
            HttpError       httpException  = httpExceptions.get(0);
            LOGGER.error(String.format("Error encountered while attempting to Scale Down the cluster. Code: %s. Message: %s.",
                                       httpException.getCode(), httpException.getMessage()));
            throw new SpotinstHttpException(httpException.getMessage());
        }

        return retVal;
    }

    /**
     * This method is used to get all AWS MrScaler Clusters
     *
     * @return List
     */
    public List<MrScalerAws> getAllMrScalers() {
        List<MrScalerAws> retVal;
        RepoGenericResponse<List<MrScalerAws>> getAllRes =
                getSpotinstMrScalerRepo().getAll(null, authToken, account);

        if (getAllRes.isRequestSucceed()) {
            retVal = getAllRes.getValue();
        }
        else {
            List<HttpError> httpExceptions = getAllRes.getHttpExceptions();
            HttpError       httpException  = httpExceptions.get(0);
            LOGGER.error(
                    String.format("Error encountered while attempting to get all mrScalers. Code: %s. Message: %s.",
                                  httpException.getCode(), httpException.getMessage()));
            throw new SpotinstHttpException(httpException.getMessage());
        }

        return retVal;
    }

    /**
     * This method is used to create an AWS MrScaler Operator.
     * if MrScaler does not exist - it will create a new one
     * otherwise - it will return the MrScaler ID which is connected to this operator name and its cluster status.
     *
     * @param mrScalerOperatorRequest ApiMrScalerOpeartorAwsRequest Object that contains the requested operator params
     * @return ApiMrScalerOperatorAwsResponse
     */
    public MrScalerOperatorResponse createMrScalerOperator(
            MrScalerOperatorAws mrScalerOperatorRequest) {
        MrScalerOperatorResponse retVal;

        RepoGenericResponse<MrScalerOperatorResponse> operatorResponse =
                getSpotinstMrScalerOperatorAwsRepo().createOperator(mrScalerOperatorRequest, authToken, account);
        if (operatorResponse.isRequestSucceed()) {
            retVal = operatorResponse.getValue();
        }
        else {
            List<HttpError> httpExceptions = operatorResponse.getHttpExceptions();
            HttpError       httpException  = httpExceptions.get(0);
            LOGGER.error(String.format(
                    "Error encountered while attempting to create MrScaler operator. Code: %s. Message: %s.",
                    httpException.getCode(), httpException.getMessage()));
            throw new SpotinstHttpException(httpException.getMessage());
        }
        return retVal;
    }

    // endregion

}
