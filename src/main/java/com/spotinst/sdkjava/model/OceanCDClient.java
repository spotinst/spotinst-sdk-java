package com.spotinst.sdkjava.model;

import com.spotinst.sdkjava.client.http.UserAgentConfig;
import com.spotinst.sdkjava.client.response.BaseSpotinstService;
import com.spotinst.sdkjava.exception.HttpError;
import com.spotinst.sdkjava.exception.SpotinstHttpException;
import com.spotinst.sdkjava.model.bl.oceanCD.RolloutSpec;
import com.spotinst.sdkjava.model.bl.oceanCD.Strategy;
import com.spotinst.sdkjava.model.bl.oceanCD.VerificationProvider;
import com.spotinst.sdkjava.model.bl.oceanCD.VerificationTemplate;
import com.spotinst.sdkjava.model.bl.oceanCD.response.Cluster;
import com.spotinst.sdkjava.model.bl.oceanCD.response.ClusterNotification;
import com.spotinst.sdkjava.model.bl.oceanCD.response.RolloutStatus;
import com.spotinst.sdkjava.model.bl.oceanCD.response.RolloutsDetails;
import com.spotinst.sdkjava.model.requests.oceanCD.RolloutActions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Created by Janetlin Kiruba on 11/08/2022.
 */

public class OceanCDClient {
    private static final Logger    LOGGER =       LoggerFactory.getLogger(OceanCDClient.class);
    //region Members
    private              String                                      authToken;
    private              String                                      account;
    private              IOceanCDRepo                                oceanCDRepo;
    //endregion

    public IOceanCDRepo getOceanCDRepo() {
        return this.oceanCDRepo;
    }

    public void setOceanCDRepo() {
        this.oceanCDRepo = SpotinstRepoManager.getInstance().getOceanCDRepo();
    }

    //region Constructor
    public OceanCDClient(String authToken) {
        this(authToken, null);
    }

    public OceanCDClient(String authToken, List<UserAgentConfig> userAgentConfigurations) {
        this.authToken = authToken;

        setOceanCDRepo();

        if (userAgentConfigurations != null) {
            LOGGER.info(String.format("Adding custom user agents: %s", userAgentConfigurations));
            BaseSpotinstService.addCustomUserAgents(userAgentConfigurations);
        }
    }

    //endregion

    //region Methods
    public Strategy createStrategy(Strategy createStrategyReq) {

        Strategy retVal;

        RepoGenericResponse<Strategy> creationResponse = getOceanCDRepo().createStrategy(createStrategyReq, authToken);

        if (creationResponse.isRequestSucceed()) {
            retVal = creationResponse.getValue();
        }
        else {
            List<HttpError> httpExceptions = creationResponse.getHttpExceptions();
            HttpError       httpException  = httpExceptions.get(0);
            LOGGER.error(
                    String.format("Error encountered while attempting to create Strategy for Ocean CD. Code: %s. Message: %s.",
                                  httpException.getCode(), httpException.getMessage()));
            throw new SpotinstHttpException(httpException.getMessage());
        }
        return retVal;
    }

    public List<Strategy> getAllStrategies() {
        List<Strategy> retVal;

        RepoGenericResponse<List<Strategy>> getAllResponse = getOceanCDRepo().getAllStrategies(authToken);

        if (getAllResponse.isRequestSucceed()) {
            retVal = getAllResponse.getValue();
        }
        else {
            List<HttpError> httpExceptions = getAllResponse.getHttpExceptions();
            HttpError       httpException  = httpExceptions.get(0);
            LOGGER.error(
                    String.format("Error encountered while attempting to get all Ocean CD strategies. Code: %s. Message: %s.",
                            httpException.getCode(), httpException.getMessage()));
            throw new SpotinstHttpException(httpException.getMessage());
        }

        return retVal;
    }

    public Strategy getStrategy(String strategyName) {

        Strategy retVal;

        RepoGenericResponse<Strategy> getResponse = getOceanCDRepo().getStrategy(strategyName, authToken);

        if (getResponse.isRequestSucceed()) {
            retVal = getResponse.getValue();
        }
        else {
            List<HttpError> httpExceptions = getResponse.getHttpExceptions();
            HttpError       httpException  = httpExceptions.get(0);
            LOGGER.error(String.format("Error encountered while attempting to get Ocean CD strategy. Code: %s. Message: %s.",
                    httpException.getCode(), httpException.getMessage()));
            throw new SpotinstHttpException(httpException.getMessage());
        }

        return retVal;
    }

    public Boolean updateStrategy(Strategy strategyReq, String strategyName) {

        Boolean retVal;

        RepoGenericResponse<Boolean> updateResponse = getOceanCDRepo().updateStrategy(strategyReq, strategyName, authToken);

        if (updateResponse.isRequestSucceed()) {
            retVal = updateResponse.getValue();
        }
        else {
            List<HttpError> httpExceptions = updateResponse.getHttpExceptions();
            HttpError       httpException  = httpExceptions.get(0);
            LOGGER.error(
                    String.format("Error encountered while attempting to update Ocean CD Strategy. Code: %s. Message: %s.",
                            httpException.getCode(), httpException.getMessage()));
            throw new SpotinstHttpException(httpException.getMessage());
        }
        return retVal;
    }

    public Boolean patchStrategy(Strategy strategyReq, String strategyName) {

        Boolean retVal;

        RepoGenericResponse<Boolean> patchResponse = getOceanCDRepo().patchStrategy(strategyReq, strategyName, authToken);

        if (patchResponse.isRequestSucceed()) {
            retVal = patchResponse.getValue();
        }
        else {
            List<HttpError> httpExceptions = patchResponse.getHttpExceptions();
            HttpError       httpException  = httpExceptions.get(0);
            LOGGER.error(
                    String.format("Error encountered while attempting to patch Ocean CD Strategy. Code: %s. Message: %s.",
                            httpException.getCode(), httpException.getMessage()));
            throw new SpotinstHttpException(httpException.getMessage());
        }
        return retVal;
    }

    public Boolean deleteStrategy(String strategyName) {

        Boolean retVal;

        RepoGenericResponse<Boolean> deleteResponse = getOceanCDRepo().deleteStrategy(strategyName, authToken);

        if (deleteResponse.isRequestSucceed()) {
            retVal = deleteResponse.getValue();
        }
        else {
            List<HttpError> httpExceptions = deleteResponse.getHttpExceptions();
            HttpError       httpException  = httpExceptions.get(0);
            LOGGER.error(
                    String.format("Error encountered while attempting to delete Ocean CD Strategy. Code: %s. Message: %s.",
                            httpException.getCode(), httpException.getMessage()));
            throw new SpotinstHttpException(httpException.getMessage());
        }
        return retVal;
    }

    public RolloutSpec createRolloutSpec(RolloutSpec rolloutSpecReq) {

        RolloutSpec retVal;

        RepoGenericResponse<RolloutSpec> creationResponse = getOceanCDRepo().createRolloutSpec(rolloutSpecReq, authToken);

        if (creationResponse.isRequestSucceed()) {
            retVal = creationResponse.getValue();
        }
        else {
            List<HttpError> httpExceptions = creationResponse.getHttpExceptions();
            HttpError       httpException  = httpExceptions.get(0);
            LOGGER.error(
                    String.format("Error encountered while attempting to create RolloutSpec for Ocean CD. Code: %s. Message: %s.",
                            httpException.getCode(), httpException.getMessage()));
            throw new SpotinstHttpException(httpException.getMessage());
        }
        return retVal;
    }

    public List<RolloutSpec> getAllRolloutSpecs() {
        List<RolloutSpec> retVal;

        RepoGenericResponse<List<RolloutSpec>> getAllResponse = getOceanCDRepo().getAllRolloutSpecs(authToken);

        if (getAllResponse.isRequestSucceed()) {
            retVal = getAllResponse.getValue();
        }
        else {
            List<HttpError> httpExceptions = getAllResponse.getHttpExceptions();
            HttpError       httpException  = httpExceptions.get(0);
            LOGGER.error(
                    String.format("Error encountered while attempting to get all Ocean CD RolloutSpecs. Code: %s. Message: %s.",
                            httpException.getCode(), httpException.getMessage()));
            throw new SpotinstHttpException(httpException.getMessage());
        }

        return retVal;
    }

    public RolloutSpec getRolloutSpec(String rolloutSpecName) {

        RolloutSpec retVal;

        RepoGenericResponse<RolloutSpec> getResponse = getOceanCDRepo().getRolloutSpec(rolloutSpecName, authToken);

        if (getResponse.isRequestSucceed()) {
            retVal = getResponse.getValue();
        }
        else {
            List<HttpError> httpExceptions = getResponse.getHttpExceptions();
            HttpError       httpException  = httpExceptions.get(0);
            LOGGER.error(String.format("Error encountered while attempting to get Ocean CD RolloutSpec. Code: %s. Message: %s.",
                    httpException.getCode(), httpException.getMessage()));
            throw new SpotinstHttpException(httpException.getMessage());
        }

        return retVal;
    }

    public Boolean updateRolloutSpec(RolloutSpec rolloutSpecReq, String rolloutSpecName) {

        Boolean retVal;

        RepoGenericResponse<Boolean> updateResponse = getOceanCDRepo().updateRolloutSpec(rolloutSpecReq, rolloutSpecName, authToken);

        if (updateResponse.isRequestSucceed()) {
            retVal = updateResponse.getValue();
        }
        else {
            List<HttpError> httpExceptions = updateResponse.getHttpExceptions();
            HttpError       httpException  = httpExceptions.get(0);
            LOGGER.error(
                    String.format("Error encountered while attempting to update Ocean CD RolloutSpec. Code: %s. Message: %s.",
                            httpException.getCode(), httpException.getMessage()));
            throw new SpotinstHttpException(httpException.getMessage());
        }
        return retVal;
    }

    public Boolean patchRolloutSpec(RolloutSpec rolloutSpecReq, String rolloutSpecName) {

        Boolean retVal;

        RepoGenericResponse<Boolean> patchResponse = getOceanCDRepo().patchRolloutSpec(rolloutSpecReq, rolloutSpecName, authToken);

        if (patchResponse.isRequestSucceed()) {
            retVal = patchResponse.getValue();
        }
        else {
            List<HttpError> httpExceptions = patchResponse.getHttpExceptions();
            HttpError       httpException  = httpExceptions.get(0);
            LOGGER.error(
                    String.format("Error encountered while attempting to patch Ocean CD RolloutSpec. Code: %s. Message: %s.",
                            httpException.getCode(), httpException.getMessage()));
            throw new SpotinstHttpException(httpException.getMessage());
        }
        return retVal;
    }

    public Boolean deleteRolloutSpec(String rolloutSpecName) {

        Boolean retVal;

        RepoGenericResponse<Boolean> deleteResponse = getOceanCDRepo().deleteRolloutSpec(rolloutSpecName, authToken);

        if (deleteResponse.isRequestSucceed()) {
            retVal = deleteResponse.getValue();
        }
        else {
            List<HttpError> httpExceptions = deleteResponse.getHttpExceptions();
            HttpError       httpException  = httpExceptions.get(0);
            LOGGER.error(
                    String.format("Error encountered while attempting to delete Ocean CD RolloutSpec. Code: %s. Message: %s.",
                            httpException.getCode(), httpException.getMessage()));
            throw new SpotinstHttpException(httpException.getMessage());
        }
        return retVal;
    }

    public List<RolloutsDetails> getAllRollouts(String fromDate) {
        List<RolloutsDetails> retVal;

        RepoGenericResponse<List<RolloutsDetails>> getAllResponse = getOceanCDRepo().getAllRollouts(fromDate, authToken);

        if (getAllResponse.isRequestSucceed()) {
            retVal = getAllResponse.getValue();
        }
        else {
            List<HttpError> httpExceptions = getAllResponse.getHttpExceptions();
            HttpError       httpException  = httpExceptions.get(0);
            LOGGER.error(
                    String.format("Error encountered while attempting to get all Ocean CD Rollouts. Code: %s. Message: %s.",
                            httpException.getCode(), httpException.getMessage()));
            throw new SpotinstHttpException(httpException.getMessage());
        }

        return retVal;
    }

    public RolloutStatus getRolloutStatus(String rolloutId) {

        RolloutStatus retVal;

        RepoGenericResponse<RolloutStatus> getResponse = getOceanCDRepo().getRolloutStatus(rolloutId, authToken);

        if (getResponse.isRequestSucceed()) {
            retVal = getResponse.getValue();
        }
        else {
            List<HttpError> httpExceptions = getResponse.getHttpExceptions();
            HttpError       httpException  = httpExceptions.get(0);
            LOGGER.error(String.format("Error encountered while attempting to get Ocean CD Rollout ID. Code: %s. Message: %s.",
                    httpException.getCode(), httpException.getMessage()));
            throw new SpotinstHttpException(httpException.getMessage());
        }

        return retVal;
    }

    public Boolean rolloutAction(RolloutActions rolloutActionsReq, String rolloutId) {

        Boolean retVal;

        RepoGenericResponse<Boolean> updateResponse = getOceanCDRepo().rolloutAction(rolloutActionsReq, rolloutId, authToken);

        if (updateResponse.isRequestSucceed()) {
            retVal = updateResponse.getValue();
        }
        else {
            List<HttpError> httpExceptions = updateResponse.getHttpExceptions();
            HttpError       httpException  = httpExceptions.get(0);
            LOGGER.error(
                    String.format("Error encountered while attempting to update Ocean CD Rollout ID. Code: %s. Message: %s.",
                            httpException.getCode(), httpException.getMessage()));
            throw new SpotinstHttpException(httpException.getMessage());
        }
        return retVal;
    }

    public VerificationProvider createVerificationProvider(VerificationProvider verificationProviderRequest) {

        VerificationProvider retVal;

        RepoGenericResponse<VerificationProvider> creationResponse = getOceanCDRepo().createVerificationProvider(verificationProviderRequest, authToken);

        if (creationResponse.isRequestSucceed()) {
            retVal = creationResponse.getValue();
        }
        else {
            List<HttpError> httpExceptions = creationResponse.getHttpExceptions();
            HttpError       httpException  = httpExceptions.get(0);
            LOGGER.error(
                    String.format("Error encountered while attempting to create VerificationProvider for Ocean CD. Code: %s. Message: %s.",
                            httpException.getCode(), httpException.getMessage()));
            throw new SpotinstHttpException(httpException.getMessage());
        }
        return retVal;
    }

    public List<VerificationProvider> getAllVerificationProviders() {
        List<VerificationProvider> retVal;

        RepoGenericResponse<List<VerificationProvider>> getAllResponse = getOceanCDRepo().getAllVerificationProviders(authToken);

        if (getAllResponse.isRequestSucceed()) {
            retVal = getAllResponse.getValue();
        }
        else {
            List<HttpError> httpExceptions = getAllResponse.getHttpExceptions();
            HttpError       httpException  = httpExceptions.get(0);
            LOGGER.error(
                    String.format("Error encountered while attempting to get all Ocean CD VerificationProviders. Code: %s. Message: %s.",
                            httpException.getCode(), httpException.getMessage()));
            throw new SpotinstHttpException(httpException.getMessage());
        }

        return retVal;
    }

    public VerificationProvider getVerificationProvider(String verificationProviderName) {

        VerificationProvider retVal;

        RepoGenericResponse<VerificationProvider> getResponse = getOceanCDRepo().getVerificationProvider(verificationProviderName, authToken);

        if (getResponse.isRequestSucceed()) {
            retVal = getResponse.getValue();
        }
        else {
            List<HttpError> httpExceptions = getResponse.getHttpExceptions();
            HttpError       httpException  = httpExceptions.get(0);
            LOGGER.error(String.format("Error encountered while attempting to get Ocean CD VerificationProvider. Code: %s. Message: %s.",
                    httpException.getCode(), httpException.getMessage()));
            throw new SpotinstHttpException(httpException.getMessage());
        }

        return retVal;
    }

    public Boolean updateVerificationProvider(VerificationProvider verificationProviderReq, String verificationProviderName) {

        Boolean retVal;

        RepoGenericResponse<Boolean> updateResponse = getOceanCDRepo().updateVerificationProvider(verificationProviderReq, verificationProviderName, authToken);

        if (updateResponse.isRequestSucceed()) {
            retVal = updateResponse.getValue();
        }
        else {
            List<HttpError> httpExceptions = updateResponse.getHttpExceptions();
            HttpError       httpException  = httpExceptions.get(0);
            LOGGER.error(
                    String.format("Error encountered while attempting to update Ocean CD VerificationProvider. Code: %s. Message: %s.",
                            httpException.getCode(), httpException.getMessage()));
            throw new SpotinstHttpException(httpException.getMessage());
        }
        return retVal;
    }

    public Boolean patchVerificationProvider(VerificationProvider verificationProviderReq, String verificationProviderName) {

        Boolean retVal;

        RepoGenericResponse<Boolean> patchResponse = getOceanCDRepo().patchVerificationProvider(verificationProviderReq, verificationProviderName, authToken);

        if (patchResponse.isRequestSucceed()) {
            retVal = patchResponse.getValue();
        }
        else {
            List<HttpError> httpExceptions = patchResponse.getHttpExceptions();
            HttpError       httpException  = httpExceptions.get(0);
            LOGGER.error(
                    String.format("Error encountered while attempting to patch Ocean CD VerificationProvider. Code: %s. Message: %s.",
                            httpException.getCode(), httpException.getMessage()));
            throw new SpotinstHttpException(httpException.getMessage());
        }
        return retVal;
    }

    public Boolean deleteVerificationProvider(String verificationProviderName) {

        Boolean retVal;

        RepoGenericResponse<Boolean> deleteResponse = getOceanCDRepo().deleteVerificationProvider(verificationProviderName, authToken);

        if (deleteResponse.isRequestSucceed()) {
            retVal = deleteResponse.getValue();
        }
        else {
            List<HttpError> httpExceptions = deleteResponse.getHttpExceptions();
            HttpError       httpException  = httpExceptions.get(0);
            LOGGER.error(
                    String.format("Error encountered while attempting to delete Ocean CD VerificationProvider. Code: %s. Message: %s.",
                            httpException.getCode(), httpException.getMessage()));
            throw new SpotinstHttpException(httpException.getMessage());
        }
        return retVal;
    }

    public VerificationTemplate createVerificationTemplate(VerificationTemplate verificationTemplateRequest) {

        VerificationTemplate retVal;

        RepoGenericResponse<VerificationTemplate> creationResponse = getOceanCDRepo().createVerificationTemplate(verificationTemplateRequest, authToken);

        if (creationResponse.isRequestSucceed()) {
            retVal = creationResponse.getValue();
        }
        else {
            List<HttpError> httpExceptions = creationResponse.getHttpExceptions();
            HttpError       httpException  = httpExceptions.get(0);
            LOGGER.error(
                    String.format("Error encountered while attempting to create VerificationTemplate for Ocean CD. Code: %s. Message: %s.",
                            httpException.getCode(), httpException.getMessage()));
            throw new SpotinstHttpException(httpException.getMessage());
        }
        return retVal;
    }

    public List<VerificationTemplate> getAllVerificationTemplates() {
        List<VerificationTemplate> retVal;

        RepoGenericResponse<List<VerificationTemplate>> getAllResponse = getOceanCDRepo().getAllVerificationTemplates(authToken);

        if (getAllResponse.isRequestSucceed()) {
            retVal = getAllResponse.getValue();
        }
        else {
            List<HttpError> httpExceptions = getAllResponse.getHttpExceptions();
            HttpError       httpException  = httpExceptions.get(0);
            LOGGER.error(
                    String.format("Error encountered while attempting to get all Ocean CD VerificationTemplates. Code: %s. Message: %s.",
                            httpException.getCode(), httpException.getMessage()));
            throw new SpotinstHttpException(httpException.getMessage());
        }

        return retVal;
    }

    public VerificationTemplate getVerificationTemplate(String verificationTemplateName) {

        VerificationTemplate retVal;

        RepoGenericResponse<VerificationTemplate> getResponse = getOceanCDRepo().getVerificationTemplate(verificationTemplateName, authToken);

        if (getResponse.isRequestSucceed()) {
            retVal = getResponse.getValue();
        }
        else {
            List<HttpError> httpExceptions = getResponse.getHttpExceptions();
            HttpError       httpException  = httpExceptions.get(0);
            LOGGER.error(String.format("Error encountered while attempting to get Ocean CD VerificationTemplate. Code: %s. Message: %s.",
                    httpException.getCode(), httpException.getMessage()));
            throw new SpotinstHttpException(httpException.getMessage());
        }

        return retVal;
    }

    public Boolean updateVerificationTemplate(VerificationTemplate verificationTemplateReq, String verificationTemplateName) {

        Boolean retVal;

        RepoGenericResponse<Boolean> updateResponse = getOceanCDRepo().updateVerificationTemplate(verificationTemplateReq, verificationTemplateName, authToken);

        if (updateResponse.isRequestSucceed()) {
            retVal = updateResponse.getValue();
        }
        else {
            List<HttpError> httpExceptions = updateResponse.getHttpExceptions();
            HttpError       httpException  = httpExceptions.get(0);
            LOGGER.error(
                    String.format("Error encountered while attempting to update Ocean CD VerificationTemplate. Code: %s. Message: %s.",
                            httpException.getCode(), httpException.getMessage()));
            throw new SpotinstHttpException(httpException.getMessage());
        }
        return retVal;
    }

    public Boolean patchVerificationTemplate(VerificationTemplate verificationTemplateReq, String verificationTemplateName) {

        Boolean retVal;

        RepoGenericResponse<Boolean> patchResponse = getOceanCDRepo().patchVerificationTemplate(verificationTemplateReq, verificationTemplateName, authToken);

        if (patchResponse.isRequestSucceed()) {
            retVal = patchResponse.getValue();
        }
        else {
            List<HttpError> httpExceptions = patchResponse.getHttpExceptions();
            HttpError       httpException  = httpExceptions.get(0);
            LOGGER.error(
                    String.format("Error encountered while attempting to patch Ocean CD VerificationTemplate. Code: %s. Message: %s.",
                            httpException.getCode(), httpException.getMessage()));
            throw new SpotinstHttpException(httpException.getMessage());
        }
        return retVal;
    }

    public Boolean deleteVerificationTemplate(String verificationTemplateName) {

        Boolean retVal;

        RepoGenericResponse<Boolean> deleteResponse = getOceanCDRepo().deleteVerificationTemplate(verificationTemplateName, authToken);

        if (deleteResponse.isRequestSucceed()) {
            retVal = deleteResponse.getValue();
        }
        else {
            List<HttpError> httpExceptions = deleteResponse.getHttpExceptions();
            HttpError       httpException  = httpExceptions.get(0);
            LOGGER.error(
                    String.format("Error encountered while attempting to delete Ocean CD VerificationTemplate. Code: %s. Message: %s.",
                            httpException.getCode(), httpException.getMessage()));
            throw new SpotinstHttpException(httpException.getMessage());
        }
        return retVal;
    }

    public List<Cluster> getAllClusters() {
        List<Cluster> retVal;

        RepoGenericResponse<List<Cluster>> getAllResponse = getOceanCDRepo().getAllClusters(authToken);

        if (getAllResponse.isRequestSucceed()) {
            retVal = getAllResponse.getValue();
        }
        else {
            List<HttpError> httpExceptions = getAllResponse.getHttpExceptions();
            HttpError       httpException  = httpExceptions.get(0);
            LOGGER.error(
                    String.format("Error encountered while attempting to get all Ocean CD clusters. Code: %s. Message: %s.",
                            httpException.getCode(), httpException.getMessage()));
            throw new SpotinstHttpException(httpException.getMessage());
        }

        return retVal;
    }

    public Cluster getCluster(String clusterId) {

        Cluster retVal;

        RepoGenericResponse<Cluster> getResponse = getOceanCDRepo().getCluster(clusterId, authToken);

        if (getResponse.isRequestSucceed()) {
            retVal = getResponse.getValue();
        }
        else {
            List<HttpError> httpExceptions = getResponse.getHttpExceptions();
            HttpError       httpException  = httpExceptions.get(0);
            LOGGER.error(String.format("Error encountered while attempting to get Ocean CD Cluster. Code: %s. Message: %s.",
                    httpException.getCode(), httpException.getMessage()));
            throw new SpotinstHttpException(httpException.getMessage());
        }

        return retVal;
    }

    public Boolean updateCluster(ClusterNotification notificationReq, String clusterId) {

        Boolean retVal;

        RepoGenericResponse<Boolean> updateResponse = getOceanCDRepo().updateCluster(notificationReq, clusterId, authToken);

        if (updateResponse.isRequestSucceed()) {
            retVal = updateResponse.getValue();
        }
        else {
            List<HttpError> httpExceptions = updateResponse.getHttpExceptions();
            HttpError       httpException  = httpExceptions.get(0);
            LOGGER.error(
                    String.format("Error encountered while attempting to update Ocean CD Cluster. Code: %s. Message: %s.",
                            httpException.getCode(), httpException.getMessage()));
            throw new SpotinstHttpException(httpException.getMessage());
        }
        return retVal;
    }

    public Boolean deleteCluster(String clusterId) {

        Boolean retVal;

        RepoGenericResponse<Boolean> deleteResponse = getOceanCDRepo().deleteCluster(clusterId, authToken);

        if (deleteResponse.isRequestSucceed()) {
            retVal = deleteResponse.getValue();
        }
        else {
            List<HttpError> httpExceptions = deleteResponse.getHttpExceptions();
            HttpError       httpException  = httpExceptions.get(0);
            LOGGER.error(
                    String.format("Error encountered while attempting to delete Ocean CD cluster. Code: %s. Message: %s.",
                            httpException.getCode(), httpException.getMessage()));
            throw new SpotinstHttpException(httpException.getMessage());
        }
        return retVal;
    }

}