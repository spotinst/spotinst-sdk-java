package com.spotinst.sdkjava.model.converters.oceanCD;

import com.spotinst.sdkjava.model.api.oceanCD.*;
import com.spotinst.sdkjava.model.api.oceanCD.response.ApiCluster;
import com.spotinst.sdkjava.model.api.oceanCD.response.ApiClusterClusterInfo;
import com.spotinst.sdkjava.model.api.oceanCD.response.ApiClusterControllerInfo;
import com.spotinst.sdkjava.model.api.oceanCD.response.ApiClusterNotification;
import com.spotinst.sdkjava.model.bl.oceanCD.*;
import com.spotinst.sdkjava.model.bl.oceanCD.response.Cluster;
import com.spotinst.sdkjava.model.bl.oceanCD.response.ClusterClusterInfo;
import com.spotinst.sdkjava.model.bl.oceanCD.response.ClusterControllerInfo;
import com.spotinst.sdkjava.model.bl.oceanCD.response.ClusterNotification;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Janetlin Kiruba on 22/10/2022.
 */

public class OceanCDClusterConverter {

    public static ApiClusterNotification toDal(ClusterNotification src) {
        ApiClusterNotification apiClusterNotification = null;

        if (src != null) {
            apiClusterNotification = new ApiClusterNotification();

            if (src.isMinutesWithoutHeartbeatSet()) {
                apiClusterNotification.setMinutesWithoutHeartbeat(src.getMinutesWithoutHeartbeat());
            }
            if (src.isProvidersSet()) {
                apiClusterNotification.setProviders(src.getProviders());
            }
        }

        return apiClusterNotification;
    }

    public static Cluster toBl(ApiCluster src) {
        Cluster cluster = null;

        if (src != null) {
            Cluster.Builder clusterBuilder = Cluster.Builder.get();

            if (src.isLastHeartbeatTimeSet()) {
                clusterBuilder.setLastHeartbeatTime(src.getLastHeartbeatTime());
            }
            if (src.isControllerInfoSet()) {
                clusterBuilder.setControllerInfo(toBl(src.getControllerInfo()));
            }
            if (src.isClusterInfoSet()) {
                clusterBuilder.setClusterInfo(toBl(src.getClusterInfo()));
            }
            if (src.isNotificationSet()) {
                clusterBuilder.setNotification(toBl(src.getNotification()));
            }
            if (src.isIdSet()) {
                clusterBuilder.setId(src.getId());
            }
            if (src.isCreatedAtSet()) {
                clusterBuilder.setCreatedAt(src.getCreatedAt());
            }
            if (src.isUpdatedAtSet()) {
                clusterBuilder.setUpdatedAt(src.getUpdatedAt());
            }

            cluster = clusterBuilder.build();
        }

        return cluster;
    }

    public static ClusterControllerInfo toBl(ApiClusterControllerInfo src) {
        ClusterControllerInfo clusterControllerInfo = null;

        if (src != null) {
            ClusterControllerInfo.Builder clusterControllerInfoBuilder = ClusterControllerInfo.Builder.get();

            if (src.isNodeNameSet()) {
                clusterControllerInfoBuilder.setNodeName(src.getNodeName());
            }
            if (src.isControllerVersionSet()) {
                clusterControllerInfoBuilder.setControllerVersion(src.getControllerVersion());
            }
            if (src.isPodNameSet()) {
                clusterControllerInfoBuilder.setPodName(src.getPodName());
            }
            clusterControllerInfo = clusterControllerInfoBuilder.build();
        }

        return clusterControllerInfo;
    }

    public static ClusterClusterInfo toBl(ApiClusterClusterInfo src) {
        ClusterClusterInfo clusterClusterInfo = null;

        if (src != null) {
            ClusterClusterInfo.Builder clusterClusterInfoBuilder = ClusterClusterInfo.Builder.get();

            if (src.isKubernetesVersionSet()) {
                clusterClusterInfoBuilder.setKubernetesVersion(src.getKubernetesVersion());
            }
            if (src.isCloudProviderSet()) {
                clusterClusterInfoBuilder.setCloudProvider(src.getCloudProvider());
            }
            if (src.isKubernetesOrchestratorSet()) {
                clusterClusterInfoBuilder.setKubernetesOrchestrator(src.getKubernetesOrchestrator());
            }
            clusterClusterInfo = clusterClusterInfoBuilder.build();
        }

        return clusterClusterInfo;
    }

    public static ClusterNotification toBl(ApiClusterNotification src) {
        ClusterNotification clusterNotification = null;

        if (src != null) {
            ClusterNotification.Builder clusterNotificationBuilder = ClusterNotification.Builder.get();

            if (src.isMinutesWithoutHeartbeatSet()) {
                clusterNotificationBuilder.setMinutesWithoutHeartbeat(src.getMinutesWithoutHeartbeat());
            }
            if (src.isProvidersSet()) {
                clusterNotificationBuilder.setProviders(src.getProviders());
            }
            clusterNotification = clusterNotificationBuilder.build();
        }

        return clusterNotification;
    }

}
