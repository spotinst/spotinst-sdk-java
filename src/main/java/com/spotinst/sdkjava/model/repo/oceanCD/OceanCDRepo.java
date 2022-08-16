package com.spotinst.sdkjava.model.repo.oceanCD;

import com.spotinst.sdkjava.exception.ExceptionHelper;
import com.spotinst.sdkjava.exception.SpotinstHttpException;
import com.spotinst.sdkjava.model.*;
import com.spotinst.sdkjava.model.api.oceanCD.ApiRolloutSpec;
import com.spotinst.sdkjava.model.api.oceanCD.ApiStrategy;
import com.spotinst.sdkjava.model.bl.oceanCD.RolloutSpec;
import com.spotinst.sdkjava.model.bl.oceanCD.Strategy;
import com.spotinst.sdkjava.model.converters.oceanCD.OceanCDRolloutSpecConverter;
import com.spotinst.sdkjava.model.converters.oceanCD.OceanCDStrategyConverter;
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
}