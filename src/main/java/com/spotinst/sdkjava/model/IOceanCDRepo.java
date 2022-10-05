package com.spotinst.sdkjava.model;

import com.spotinst.sdkjava.model.bl.oceanCD.RolloutSpec;
import com.spotinst.sdkjava.model.bl.oceanCD.Strategy;
import com.spotinst.sdkjava.model.bl.oceanCD.VerificationProvider;
import com.spotinst.sdkjava.model.bl.oceanCD.VerificationTemplate;
import com.spotinst.sdkjava.model.bl.oceanCD.response.RolloutStatus;
import com.spotinst.sdkjava.model.bl.oceanCD.response.RolloutsDetails;
import com.spotinst.sdkjava.model.requests.oceanCD.RolloutActions;

import java.util.List;

/**
 * Created by Janetlin Kiruba on 11/08/2022.
 */

public interface IOceanCDRepo extends IRepository<Strategy, GroupFilter, String> {

    RepoGenericResponse<Strategy> createStrategy(Strategy createStrategyReq, String authToken);

    RepoGenericResponse<Strategy> getStrategy(String strategyName, String authToken);

    RepoGenericResponse<List<Strategy>> getAllStrategies(String authToken);

    RepoGenericResponse<Boolean> updateStrategy(Strategy strategyUpdateReq, String strategyName, String authToken);

    RepoGenericResponse<Boolean> patchStrategy(Strategy strategyUpdateReq, String strategyName, String authToken);

    RepoGenericResponse<Boolean> deleteStrategy(String strategyName, String authToken);

    RepoGenericResponse<RolloutSpec> createRolloutSpec(RolloutSpec rolloutSpecReq, String authToken);

    RepoGenericResponse<RolloutSpec> getRolloutSpec(String rolloutSpecName, String authToken);

    RepoGenericResponse<List<RolloutSpec>> getAllRolloutSpecs(String authToken);

    RepoGenericResponse<RolloutStatus> getRolloutStatus(String rolloutId, String authToken);

    RepoGenericResponse<List<RolloutsDetails>> getAllRollouts(String fromDate, String authToken);

    RepoGenericResponse<Boolean> updateRolloutSpec(RolloutSpec rolloutSpecReq, String rolloutSpecName, String authToken);

    RepoGenericResponse<Boolean> patchRolloutSpec(RolloutSpec rolloutSpecReq, String rolloutSpecName, String authToken);

    RepoGenericResponse<Boolean> deleteRolloutSpec(String rolloutSpecName, String authToken);

    RepoGenericResponse<Boolean> rolloutAction(RolloutActions rolloutActionsReq, String rolloutId, String authToken);

    RepoGenericResponse<VerificationProvider> createVerificationProvider(VerificationProvider verificationProviderReq, String authToken);

    RepoGenericResponse<VerificationProvider> getVerificationProvider(String verificationProviderName, String authToken);

    RepoGenericResponse<List<VerificationProvider>> getAllVerificationProviders(String authToken);

    RepoGenericResponse<Boolean> updateVerificationProvider(VerificationProvider verificationProviderReq, String verificationProviderName, String authToken);

    RepoGenericResponse<Boolean> patchVerificationProvider(VerificationProvider verificationProviderReq, String verificationProviderName, String authToken);

    RepoGenericResponse<Boolean> deleteVerificationProvider(String verificationProviderName, String authToken);

    RepoGenericResponse<VerificationTemplate> createVerificationTemplate(VerificationTemplate verificationTemplateReq, String authToken);

    RepoGenericResponse<VerificationTemplate> getVerificationTemplate(String verificationTemplateName, String authToken);

    RepoGenericResponse<List<VerificationTemplate>> getAllVerificationTemplates(String authToken);

    RepoGenericResponse<Boolean> updateVerificationTemplate(VerificationTemplate verificationTemplateReq, String verificationTemplateName, String authToken);

    RepoGenericResponse<Boolean> patchVerificationTemplate(VerificationTemplate verificationTemplateReq, String verificationTemplateName, String authToken);

    RepoGenericResponse<Boolean> deleteVerificationTemplate(String verificationTemplateName, String authToken);
}
