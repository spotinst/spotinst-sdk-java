package com.spotinst.sdkjava.model.converters.oceanCD;

import com.spotinst.sdkjava.model.api.oceanCD.response.*;
import com.spotinst.sdkjava.model.bl.oceanCD.response.*;


/**
 * Created by Janetlin Kiruba on 2/09/2022.
 */

public class OceanCDRolloutConverter {

    public static RolloutStatus toBl(ApiRolloutStatus src) {
        RolloutStatus rolloutStatus = null;

        if (src != null) {
            RolloutStatus.Builder builder = RolloutStatus.Builder.get();

            if (src.isIdSet()) {
                builder.setId(src.getId());
            }
            if (src.isStatusSet()) {
                builder.setStatus(src.getStatus());
            }
            if (src.isSpotDeploymentSet()) {
                builder.setSpotDeployment(src.getSpotDeployment());
            }
            if (src.isOriginalRolloutIdSet()) {
                builder.setOriginalRolloutId(src.getOriginalRolloutId());
            }
            if (src.isStartTimeSet()) {
                builder.setStartTime(src.getStartTime());
            }
            if (src.isEndTimeSet()) {
                builder.setEndTime(src.getEndTime());
            }
            if (src.isClusterIdSet()) {
                builder.setClusterId(src.getClusterId());
            }
            if (src.isNamespaceSet()) {
                builder.setNamespace(src.getNamespace());
            }
            if (src.isStrategySet()) {
                builder.setStrategy(src.getStrategy());
            }
            if (src.isHasBackgroundVerificationSet()) {
                builder.setHasBackgroundVerification(src.getHasBackgroundVerification());
            }
            if (src.isNewVersionStatusSet()) {
                builder.setNewVersionStatus(toBl(src.getNewVersionStatus()));
            }
            if (src.isStableVersionStatusSet()) {
                builder.setStableVersionStatus(toBl(src.getStableVersionStatus()));
            }
            rolloutStatus = builder.build();

        }

        return rolloutStatus;
    }

    public static VersionStatus toBl(ApiVersionStatus src) {
        VersionStatus versionStatus = null;

        if (src != null) {
            VersionStatus.Builder builder = VersionStatus.Builder.get();

            if (src.isVersionSet()) {
                builder.setVersion(src.getVersion());
            }
            if (src.isK8sServiceSet()) {
                builder.setK8sService(src.getK8sService());
            }
            if (src.isTrafficPercentageSet()) {
                builder.setTrafficPercentage(src.getTrafficPercentage());
            }
            if (src.isReplicasSet()) {
                builder.setReplicas(toBl(src.getReplicas()));
            }
            versionStatus = builder.build();

        }

        return versionStatus;
    }

    public static VersionStatusReplicas toBl(ApiVersionStatusReplicas src) {
        VersionStatusReplicas versionStatusReplicas = null;

        if (src != null) {
            VersionStatusReplicas.Builder builder = VersionStatusReplicas.Builder.get();

            if (src.isDesiredSet()) {
                builder.setDesired(src.getDesired());
            }
            if (src.isReadySet()) {
                builder.setReady(src.getReady());
            }
            if (src.isInProgressSet()) {
                builder.setInProgress(src.getInProgress());
            }
            if (src.isFailedSet()) {
                builder.setFailed(src.getdFailed());
            }
            versionStatusReplicas = builder.build();

        }

        return versionStatusReplicas;
    }

    public static RolloutsDetails toBl(ApiRolloutsDetails src) {
        RolloutsDetails rolloutStatus = null;

        if (src != null) {
            RolloutsDetails.Builder builder = RolloutsDetails.Builder.get();

            if (src.isIdSet()) {
                builder.setId(src.getId());
            }
            if (src.isStatusSet()) {
                builder.setStatus(src.getStatus());
            }
            if (src.isSpotDeploymentSet()) {
                builder.setSpotDeployment(toBl(src.getSpotDeployment()));
            }
            if (src.isStrategyNameSet()) {
                builder.setStrategyName(src.getStrategyName());
            }
            if (src.isStartTimeSet()) {
                builder.setStartTime(src.getStartTime());
            }
            if (src.isEndTimeSet()) {
                builder.setEndTime(src.getEndTime());
            }
            if (src.isClusterIdSet()) {
                builder.setClusterId(src.getClusterId());
            }
            if (src.isNamespaceSet()) {
                builder.setNamespace(src.getNamespace());
            }
            if (src.isStrategySet()) {
                builder.setStrategy(src.getStrategy());
            }
            if (src.isStrategyTypeSet()) {
                builder.setStrategyType(src.getStrategyType());
            }
            if (src.isRolloutSpecSet()) {
                builder.setRolloutSpec(src.getRolloutSpec());
            }
            if (src.isCloudProviderSet()) {
                builder.setCloudProvider(src.getCloudProvider());
            }
            rolloutStatus = builder.build();

        }

        return rolloutStatus;
    }

    public static SpotDeployment toBl(ApiSpotDeployment src) {
        SpotDeployment spotDeployment = null;

        if (src != null) {
            SpotDeployment.Builder builder = SpotDeployment.Builder.get();

            if (src.isNameSet()) {
                builder.setName(src.getName());
            }
            if (src.isOldVersionSet()) {
                builder.setOldVersion(src.getOldVersion());
            }
            if (src.isNewVersionSet()) {
                builder.setNewVersion(src.getNewVersion());
            }
            if (src.isOldManifestSet()) {
                builder.setOldManifest(src.getOldManifest());
            }
            if (src.isNewManifestSet()) {
                builder.setNewManifest(src.getNewManifest());
            }
            spotDeployment = builder.build();

        }

        return spotDeployment;
    }

}
