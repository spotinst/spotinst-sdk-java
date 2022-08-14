package com.spotinst.sdkjava.model;

import com.spotinst.sdkjava.model.bl.oceanCD.RolloutSpec;
import com.spotinst.sdkjava.model.bl.oceanCD.Strategy;

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

    RepoGenericResponse<Boolean> updateRolloutSpec(RolloutSpec rolloutSpecReq, String rolloutSpecName, String authToken);

    RepoGenericResponse<Boolean> patchRolloutSpec(RolloutSpec rolloutSpecReq, String rolloutSpecName, String authToken);

    RepoGenericResponse<Boolean> deleteRolloutSpec(String rolloutSpecName, String authToken);
}
