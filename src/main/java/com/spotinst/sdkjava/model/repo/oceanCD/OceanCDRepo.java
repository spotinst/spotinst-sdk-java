package com.spotinst.sdkjava.model.repo.oceanCD;

import com.spotinst.sdkjava.exception.ExceptionHelper;
import com.spotinst.sdkjava.exception.SpotinstHttpException;
import com.spotinst.sdkjava.model.*;
import com.spotinst.sdkjava.model.api.oceanCD.ApiRolloutSpec;
import com.spotinst.sdkjava.model.api.oceanCD.ApiStrategy;
import com.spotinst.sdkjava.model.api.oceanCD.ApiVerificationProvider;
import com.spotinst.sdkjava.model.api.oceanCD.ApiVerificationTemplate;
import com.spotinst.sdkjava.model.api.oceanCD.response.ApiRolloutStatus;
import com.spotinst.sdkjava.model.api.oceanCD.response.ApiRolloutsDetails;
import com.spotinst.sdkjava.model.bl.oceanCD.RolloutSpec;
import com.spotinst.sdkjava.model.bl.oceanCD.Strategy;
import com.spotinst.sdkjava.model.bl.oceanCD.VerificationProvider;
import com.spotinst.sdkjava.model.bl.oceanCD.VerificationTemplate;
import com.spotinst.sdkjava.model.bl.oceanCD.response.RolloutStatus;
import com.spotinst.sdkjava.model.bl.oceanCD.response.RolloutsDetails;
import com.spotinst.sdkjava.model.converters.oceanCD.*;
import com.spotinst.sdkjava.model.requests.oceanCD.RolloutActions;
import com.spotinst.sdkjava.model.service.oceanCD.OceanCDService;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Janetlin Kiruba on 11/08/2022.
 */

public class OceanCDRepo implements IOceanCDRepo {

    @Override
    public RepoGenericResponse<Strategy> createStrategy(Strategy createStrategyReq, String authToken) {
        RepoGenericResponse<Strategy> retVal;

        try {
            ApiStrategy apiCreateStrategyReq = OceanCDStrategyConverter.toDal(createStrategyReq);
            ApiStrategy apiCreateStrategyRes = OceanCDService.createStrategy(apiCreateStrategyReq, authToken);
            Strategy createStrategyRes = OceanCDStrategyConverter.toBl(apiCreateStrategyRes);
            retVal = new RepoGenericResponse<>(createStrategyRes);
        }
        catch (SpotinstHttpException ex) {
            retVal = ExceptionHelper.handleHttpException(ex);
        }

        return retVal;
    }

    @Override
    public RepoGenericResponse<Strategy> getStrategy(String strategyName, String authToken) {
        RepoGenericResponse<Strategy> retVal;

        try {
            ApiStrategy apiCreateStrategy = OceanCDService.getStrategy(strategyName, authToken);
            Strategy strategy    = OceanCDStrategyConverter.toBl(apiCreateStrategy);
            retVal = new RepoGenericResponse<>(strategy);
        }
        catch (SpotinstHttpException e) {
            retVal = ExceptionHelper.handleHttpException(e);
        }

        return retVal;
    }

    @Override
    public RepoGenericResponse<List<Strategy>> getAllStrategies(String authToken) {
        RepoGenericResponse<List<Strategy>> retVal;

        try {
            List<ApiStrategy> apiCreateStrategy = OceanCDService.getAllStrategies(authToken);
            List<Strategy> strategies = apiCreateStrategy.stream().map(OceanCDStrategyConverter::toBl).collect(Collectors.toList());
            retVal = new RepoGenericResponse<>(strategies);
        }
        catch (SpotinstHttpException e) {
            retVal = ExceptionHelper.handleHttpException(e);
        }

        return retVal;
    }

    @Override
    public RepoGenericResponse<Boolean> updateStrategy(Strategy strategyUpdateReq, String strategyName, String authToken) {
        RepoGenericResponse<Boolean> retVal;

        ApiStrategy apiStrategy = OceanCDStrategyConverter.toDal(strategyUpdateReq);

        try {
            Boolean success = OceanCDService.updateStrategy(apiStrategy, strategyName, authToken);
            retVal = new RepoGenericResponse<>(success);
        }
        catch (SpotinstHttpException e) {
            retVal = ExceptionHelper.handleHttpException(e);
        }

        return retVal;
    }

    @Override
    public RepoGenericResponse<Boolean> patchStrategy(Strategy strategyUpdateReq, String strategyName, String authToken) {
        RepoGenericResponse<Boolean> retVal;

        ApiStrategy apiStrategy = OceanCDStrategyConverter.toDal(strategyUpdateReq);

        try {
            Boolean success = OceanCDService.patchStrategy(apiStrategy, strategyName, authToken);
            retVal = new RepoGenericResponse<>(success);
        }
        catch (SpotinstHttpException e) {
            retVal = ExceptionHelper.handleHttpException(e);
        }

        return retVal;
    }

    @Override
    public RepoGenericResponse<Boolean> deleteStrategy(String strategyName, String authToken) {
        RepoGenericResponse<Boolean> retVal;

        try {
            Boolean success = OceanCDService.deleteStrategy(strategyName, authToken);
            retVal = new RepoGenericResponse<>(success);
        }
        catch (SpotinstHttpException e) {
            retVal = ExceptionHelper.handleHttpException(e);
        }

        return retVal;
    }

    @Override
    public RepoGenericResponse<RolloutSpec> createRolloutSpec(RolloutSpec rolloutSpecReq, String authToken) {
        RepoGenericResponse<RolloutSpec> retVal;

        try {
            ApiRolloutSpec apiRolloutSpecReq = OceanCDRolloutSpecConverter.toDal(rolloutSpecReq);
            ApiRolloutSpec apiRolloutSpecRes = OceanCDService.createRolloutSpec(apiRolloutSpecReq, authToken);
            RolloutSpec createStrategyRes = OceanCDRolloutSpecConverter.toBl(apiRolloutSpecRes);
            retVal = new RepoGenericResponse<>(createStrategyRes);
        }
        catch (SpotinstHttpException ex) {
            retVal = ExceptionHelper.handleHttpException(ex);
        }

        return retVal;
    }

    @Override
    public RepoGenericResponse<RolloutSpec> getRolloutSpec(String rolloutSpecName, String authToken) {
        RepoGenericResponse<RolloutSpec> retVal;

        try {
            ApiRolloutSpec apiCreateStrategy = OceanCDService.getRolloutSpec(rolloutSpecName, authToken);
            RolloutSpec strategy    = OceanCDRolloutSpecConverter.toBl(apiCreateStrategy);
            retVal = new RepoGenericResponse<>(strategy);
        }
        catch (SpotinstHttpException e) {
            retVal = ExceptionHelper.handleHttpException(e);
        }

        return retVal;
    }

    @Override
    public RepoGenericResponse<List<RolloutSpec>> getAllRolloutSpecs(String authToken) {
        RepoGenericResponse<List<RolloutSpec>> retVal;

        try {
            List<ApiRolloutSpec> apiCreateStrategy = OceanCDService.getAllRolloutSpecs(authToken);
            List<RolloutSpec> strategies = apiCreateStrategy.stream().map(OceanCDRolloutSpecConverter::toBl).collect(Collectors.toList());
            retVal = new RepoGenericResponse<>(strategies);
        }
        catch (SpotinstHttpException e) {
            retVal = ExceptionHelper.handleHttpException(e);
        }

        return retVal;
    }

    @Override
    public RepoGenericResponse<Boolean> updateRolloutSpec(RolloutSpec rolloutSpecReq, String rolloutSpecName, String authToken) {
        RepoGenericResponse<Boolean> retVal;

        ApiRolloutSpec apiRolloutSpec = OceanCDRolloutSpecConverter.toDal(rolloutSpecReq);

        try {
            Boolean success = OceanCDService.updateRolloutSpec(apiRolloutSpec, rolloutSpecName, authToken);
            retVal = new RepoGenericResponse<>(success);
        }
        catch (SpotinstHttpException e) {
            retVal = ExceptionHelper.handleHttpException(e);
        }

        return retVal;
    }

    @Override
    public RepoGenericResponse<Boolean> patchRolloutSpec(RolloutSpec rolloutSpecReq, String rolloutSpecName, String authToken) {
        RepoGenericResponse<Boolean> retVal;

        ApiRolloutSpec apiRolloutSpec = OceanCDRolloutSpecConverter.toDal(rolloutSpecReq);

        try {
            Boolean success = OceanCDService.patchRolloutSpec(apiRolloutSpec, rolloutSpecName, authToken);
            retVal = new RepoGenericResponse<>(success);
        }
        catch (SpotinstHttpException e) {
            retVal = ExceptionHelper.handleHttpException(e);
        }

        return retVal;
    }

    @Override
    public RepoGenericResponse<Boolean> deleteRolloutSpec(String rolloutSpecName, String authToken) {
        RepoGenericResponse<Boolean> retVal;

        try {
            Boolean success = OceanCDService.deleteRolloutSpec(rolloutSpecName, authToken);
            retVal = new RepoGenericResponse<>(success);
        }
        catch (SpotinstHttpException e) {
            retVal = ExceptionHelper.handleHttpException(e);
        }

        return retVal;
    }

    @Override
    public RepoGenericResponse<RolloutStatus> getRolloutStatus(String rolloutId, String authToken) {
        RepoGenericResponse<RolloutStatus> retVal;

        try {
            ApiRolloutStatus apiRolloutStatus = OceanCDService.getRolloutStatus(rolloutId, authToken);
            RolloutStatus rolloutStatus    = OceanCDRolloutConverter.toBl(apiRolloutStatus);
            retVal = new RepoGenericResponse<>(rolloutStatus);
        }
        catch (SpotinstHttpException e) {
            retVal = ExceptionHelper.handleHttpException(e);
        }

        return retVal;
    }

    @Override
    public RepoGenericResponse<List<RolloutsDetails>> getAllRollouts(String fromDate, String authToken) {
        RepoGenericResponse<List<RolloutsDetails>> retVal;

        try {
            List<ApiRolloutsDetails> apiRolloutStatus = OceanCDService.getAllRollouts(fromDate, authToken);
            List<RolloutsDetails> rolloutStatus = apiRolloutStatus.stream().map(OceanCDRolloutConverter::toBl).collect(Collectors.toList());
            retVal = new RepoGenericResponse<>(rolloutStatus);
        }
        catch (SpotinstHttpException e) {
            retVal = ExceptionHelper.handleHttpException(e);
        }

        return retVal;
    }

    @Override
    public RepoGenericResponse<Boolean> rolloutAction(RolloutActions rolloutActionsReq, String rolloutId, String authToken) {
        RepoGenericResponse<Boolean> retVal;

        try {

            Boolean success = OceanCDService.rolloutAction(rolloutActionsReq, rolloutId, authToken);
            retVal = new RepoGenericResponse<>(success);
        }
        catch (SpotinstHttpException e) {
            retVal = ExceptionHelper.handleHttpException(e);
        }

        return retVal;
    }

    @Override
    public RepoGenericResponse<VerificationProvider> createVerificationProvider(VerificationProvider verificationProviderReq, String authToken) {
        RepoGenericResponse<VerificationProvider> retVal;

        try {
            ApiVerificationProvider apiverificationProviderReq = OceanCDVerificationProviderConverter.toDal(verificationProviderReq);
            ApiVerificationProvider apiverificationProviderRes = OceanCDService.createVerificationProvider(apiverificationProviderReq, authToken);
            VerificationProvider verificationProviderRes = OceanCDVerificationProviderConverter.toBl(apiverificationProviderRes);
            retVal = new RepoGenericResponse<>(verificationProviderRes);
        }
        catch (SpotinstHttpException ex) {
            retVal = ExceptionHelper.handleHttpException(ex);
        }

        return retVal;
    }

    @Override
    public RepoGenericResponse<VerificationProvider> getVerificationProvider(String verificationProviderName, String authToken) {
        RepoGenericResponse<VerificationProvider> retVal;

        try {
            ApiVerificationProvider apiVerificationProvider = OceanCDService.getVerificationProvider(verificationProviderName, authToken);
            VerificationProvider verificationProvider    = OceanCDVerificationProviderConverter.toBl(apiVerificationProvider);
            retVal = new RepoGenericResponse<>(verificationProvider);
        }
        catch (SpotinstHttpException e) {
            retVal = ExceptionHelper.handleHttpException(e);
        }

        return retVal;
    }

    @Override
    public RepoGenericResponse<List<VerificationProvider>> getAllVerificationProviders(String authToken) {
        RepoGenericResponse<List<VerificationProvider>> retVal;

        try {
            List<ApiVerificationProvider> apiVerificationProvider = OceanCDService.getAllVerificationProviders(authToken);
            List<VerificationProvider> strategies = apiVerificationProvider.stream().map(OceanCDVerificationProviderConverter::toBl).collect(Collectors.toList());
            retVal = new RepoGenericResponse<>(strategies);
        }
        catch (SpotinstHttpException e) {
            retVal = ExceptionHelper.handleHttpException(e);
        }

        return retVal;
    }

    @Override
    public RepoGenericResponse<Boolean> updateVerificationProvider(VerificationProvider verificationProviderReq, String verificationProviderName, String authToken) {
        RepoGenericResponse<Boolean> retVal;

        ApiVerificationProvider apiVerificationProvider = OceanCDVerificationProviderConverter.toDal(verificationProviderReq);

        try {
            Boolean success = OceanCDService.updateVerificationProvider(apiVerificationProvider, verificationProviderName, authToken);
            retVal = new RepoGenericResponse<>(success);
        }
        catch (SpotinstHttpException e) {
            retVal = ExceptionHelper.handleHttpException(e);
        }

        return retVal;
    }

    @Override
    public RepoGenericResponse<Boolean> patchVerificationProvider(VerificationProvider verificationProviderReq, String verificationProviderName, String authToken) {
        RepoGenericResponse<Boolean> retVal;

        ApiVerificationProvider apiVerificationProvider = OceanCDVerificationProviderConverter.toDal(verificationProviderReq);

        try {
            Boolean success = OceanCDService.patchVerificationProvider(apiVerificationProvider, verificationProviderName, authToken);
            retVal = new RepoGenericResponse<>(success);
        }
        catch (SpotinstHttpException e) {
            retVal = ExceptionHelper.handleHttpException(e);
        }

        return retVal;
    }

    @Override
    public RepoGenericResponse<Boolean> deleteVerificationProvider(String verificationProviderName, String authToken) {
        RepoGenericResponse<Boolean> retVal;

        try {
            Boolean success = OceanCDService.deleteVerificationProvider(verificationProviderName, authToken);
            retVal = new RepoGenericResponse<>(success);
        }
        catch (SpotinstHttpException e) {
            retVal = ExceptionHelper.handleHttpException(e);
        }

        return retVal;
    }

    @Override
    public RepoGenericResponse<VerificationTemplate> createVerificationTemplate(VerificationTemplate verificationTemplateReq, String authToken) {
        RepoGenericResponse<VerificationTemplate> retVal;

        try {
            ApiVerificationTemplate apiverificationTemplateReq = OceanCDVerificationTemplateConverter.toDal(verificationTemplateReq);
            ApiVerificationTemplate apiverificationTemplateRes = OceanCDService.createVerificationTemplate(apiverificationTemplateReq, authToken);
            VerificationTemplate verificationTemplateRes = OceanCDVerificationTemplateConverter.toBl(apiverificationTemplateRes);
            retVal = new RepoGenericResponse<>(verificationTemplateRes);
        }
        catch (SpotinstHttpException ex) {
            retVal = ExceptionHelper.handleHttpException(ex);
        }

        return retVal;
    }

    @Override
    public RepoGenericResponse<VerificationTemplate> getVerificationTemplate(String verificationTemplateName, String authToken) {
        RepoGenericResponse<VerificationTemplate> retVal;

        try {
            ApiVerificationTemplate apiVerificationTemplate = OceanCDService.getVerificationTemplate(verificationTemplateName, authToken);
            VerificationTemplate verificationTemplate    = OceanCDVerificationTemplateConverter.toBl(apiVerificationTemplate);
            retVal = new RepoGenericResponse<>(verificationTemplate);
        }
        catch (SpotinstHttpException e) {
            retVal = ExceptionHelper.handleHttpException(e);
        }

        return retVal;
    }

    @Override
    public RepoGenericResponse<List<VerificationTemplate>> getAllVerificationTemplates(String authToken) {
        RepoGenericResponse<List<VerificationTemplate>> retVal;

        try {
            List<ApiVerificationTemplate> apiVerificationTemplate = OceanCDService.getAllVerificationTemplates(authToken);
            List<VerificationTemplate> strategies = apiVerificationTemplate.stream().map(OceanCDVerificationTemplateConverter::toBl).collect(Collectors.toList());
            retVal = new RepoGenericResponse<>(strategies);
        }
        catch (SpotinstHttpException e) {
            retVal = ExceptionHelper.handleHttpException(e);
        }

        return retVal;
    }

    @Override
    public RepoGenericResponse<Boolean> updateVerificationTemplate(VerificationTemplate verificationTemplateReq, String verificationTemplateName, String authToken) {
        RepoGenericResponse<Boolean> retVal;

        ApiVerificationTemplate apiVerificationTemplate = OceanCDVerificationTemplateConverter.toDal(verificationTemplateReq);

        try {
            Boolean success = OceanCDService.updateVerificationTemplate(apiVerificationTemplate, verificationTemplateName, authToken);
            retVal = new RepoGenericResponse<>(success);
        }
        catch (SpotinstHttpException e) {
            retVal = ExceptionHelper.handleHttpException(e);
        }

        return retVal;
    }

    @Override
    public RepoGenericResponse<Boolean> patchVerificationTemplate(VerificationTemplate verificationTemplateReq, String verificationTemplateName, String authToken) {
        RepoGenericResponse<Boolean> retVal;

        ApiVerificationTemplate apiVerificationTemplate = OceanCDVerificationTemplateConverter.toDal(verificationTemplateReq);

        try {
            Boolean success = OceanCDService.patchVerificationTemplate(apiVerificationTemplate, verificationTemplateName, authToken);
            retVal = new RepoGenericResponse<>(success);
        }
        catch (SpotinstHttpException e) {
            retVal = ExceptionHelper.handleHttpException(e);
        }

        return retVal;
    }

    @Override
    public RepoGenericResponse<Boolean> deleteVerificationTemplate(String verificationTemplateName, String authToken) {
        RepoGenericResponse<Boolean> retVal;

        try {
            Boolean success = OceanCDService.deleteVerificationTemplate(verificationTemplateName, authToken);
            retVal = new RepoGenericResponse<>(success);
        }
        catch (SpotinstHttpException e) {
            retVal = ExceptionHelper.handleHttpException(e);
        }

        return retVal;
    }
}