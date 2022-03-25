package com.spotinst.sdkjava;


import com.spotinst.sdkjava.client.http.UserAgentConfig;
import com.spotinst.sdkjava.client.rest.SpotinstHttpContext;
import com.spotinst.sdkjava.model.*;

import java.util.List;

/**
 * Created by talzur on 12/01/2017.
 */
public class SpotinstClient {

    //region Methods
    public static SpotOceanGkeClusterClient getSpotOceanGkeLaunchSpecClient(String authToken, String account) {
        return new SpotOceanGkeClusterClient(authToken, account);
    }
    @Deprecated
    public static SpotinstElastigroupClient getElastigroupClient(String authToken) {
        return new SpotinstElastigroupClient(authToken, null);
    }

    public static SpotinstElastigroupClient getElastigroupClient(String authToken, String account) {
        return new SpotinstElastigroupClient(authToken, account);
    }

    public static SpotinstElastigroupClient getElastigroupClient(String authToken, String account,
                                                                 List<UserAgentConfig> userAgentConfigurations) {
        return new SpotinstElastigroupClient(authToken, account, userAgentConfigurations);
    }

    public static void setNonDefaultEndpoint(String newEndpoint) {
        SpotinstHttpContext.getInstance().getConfiguration().setEndpoint(newEndpoint);
    }

    @Deprecated
    public static SpotinstSubscriptionClient getSubscriptionClient(String authToken) {
        return new SpotinstSubscriptionClient(authToken, null);
    }

    public static SpotinstSubscriptionClient getSubscriptionClient(String authToken, String account) {
        return new SpotinstSubscriptionClient(authToken, account);
    }

    @Deprecated
    public static SpotinstSpectrumClient getSpectrumClient(String authToken) {
        return new SpotinstSpectrumClient(authToken, null);
    }

    public static SpotinstSpectrumClient getSpectrumClient(String authToken, String account) {
        return new SpotinstSpectrumClient(authToken, account);
    }

    public static SpotinstMrScalerAwsClient getMrScalerAwsClient(String authToken, String account) {
        return new SpotinstMrScalerAwsClient(authToken, account);
    }

    public static SpotOceanK8sClusterClient getOceanClusterClient(String authToken, String account) {
        return new SpotOceanK8sClusterClient(authToken, account);
    }

    public static SpotinstElastigroupClientAzure getElastigroupClientAzure(String authToken) {
        return new SpotinstElastigroupClientAzure(authToken, null);
    }

    public static SpotinstElastigroupClientAzure getElastigroupClientAzure(String authToken, String account) {
        return new SpotinstElastigroupClientAzure(authToken, account);
    }

    public static SpotinstElastigroupClientAzure getElastigroupClientAzure(String authToken, String account,
                                                                 List<UserAgentConfig> userAgentConfigurations) {
        return new SpotinstElastigroupClientAzure(authToken, account, userAgentConfigurations);
    }

    public static SpotinstElastigroupClientGcp getElastigroupClientGcp(String authToken) {
        return new SpotinstElastigroupClientGcp(authToken, null);
    }

    public static SpotinstElastigroupClientGcp getElastigroupClientGcp(String authToken, String account) {
        return new SpotinstElastigroupClientGcp(authToken, account);
    }

    public static SpotinstElastigroupClientGcp getElastigroupClientGcp(String authToken, String account,
                                                                           List<UserAgentConfig> userAgentConfigurations) {
        return new SpotinstElastigroupClientGcp(authToken, account, userAgentConfigurations);
    }

    public static SpotOceanAzureAksClusterClient getOceanAzureAksClusterClient(String authToken, String account) {
        return new SpotOceanAzureAksClusterClient(authToken, account);
    }

    public static SpotinstAccountAdminClient getAdminAccountClient(String authToken) {
        return new SpotinstAccountAdminClient(authToken);
    }

    public static SpotStorageAzureVolumeClient getVolumeClient(String authToken, String account) {
        return new SpotStorageAzureVolumeClient(authToken, account);
    }
    public static SpotOceanEcsClusterClient getOceanEcsClusterClient(String authToken, String account) {
        return new SpotOceanEcsClusterClient(authToken, account);
    }

    public static SpotOceanGkeClusterClient getOceanGkeClusterClient(String authToken, String account) {
        return new SpotOceanGkeClusterClient(authToken, account);
    }

    public static SpotAwsManagedInstanceClient getManagedInstanceClient(String authToken, String account) {
        return new SpotAwsManagedInstanceClient(authToken, account);

    }

    public static K8sVngClient getK8sVngClient(String authToken, String account) {
        return new K8sVngClient(authToken, account);
    }

    public static AzureAksVngClient getAksVngClient(String authToken, String account) {
        return new AzureAksVngClient(authToken, account);
    }

    //endregion
}
