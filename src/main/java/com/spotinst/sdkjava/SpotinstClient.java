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
    @Deprecated
    public static SpotinstElastigroupClient getElastigroupClient(String authToken) {
        SpotinstElastigroupClient spotinstElastigroupClient = new SpotinstElastigroupClient(authToken, null);
        return spotinstElastigroupClient;
    }

    public static SpotinstElastigroupClient getElastigroupClient(String authToken, String account) {
        SpotinstElastigroupClient spotinstElastigroupClient = new SpotinstElastigroupClient(authToken, account);
        return spotinstElastigroupClient;
    }

    public static SpotinstElastigroupClient getElastigroupClient(String authToken, String account,
                                                                 List<UserAgentConfig> userAgentConfigurations) {
        SpotinstElastigroupClient spotinstElastigroupClient =
                new SpotinstElastigroupClient(authToken, account, userAgentConfigurations);
        return spotinstElastigroupClient;
    }

    public static void setNonDefaultEndpoint(String newEndpoint) {
        SpotinstHttpContext.getInstance().getConfiguration().setEndpoint(newEndpoint);
    }

    @Deprecated
    public static SpotinstSubscriptionClient getSubscriptionClient(String authToken) {
        SpotinstSubscriptionClient spotinstSubscriptionClient = new SpotinstSubscriptionClient(authToken, null);
        return spotinstSubscriptionClient;
    }

    public static SpotinstSubscriptionClient getSubscriptionClient(String authToken, String account) {
        SpotinstSubscriptionClient spotinstSubscriptionClient = new SpotinstSubscriptionClient(authToken, account);
        return spotinstSubscriptionClient;
    }

    @Deprecated
    public static SpotinstSpectrumClient getSpectrumClient(String authToken) {
        SpotinstSpectrumClient spotinstSpectrumClient = new SpotinstSpectrumClient(authToken, null);
        return spotinstSpectrumClient;
    }

    public static SpotinstSpectrumClient getSpectrumClient(String authToken, String account) {
        SpotinstSpectrumClient spotinstSpectrumClient = new SpotinstSpectrumClient(authToken, account);
        return spotinstSpectrumClient;
    }

    public static SpotinstMrScalerAwsClient getMrScalerAwsClient(String authToken, String account) {
        SpotinstMrScalerAwsClient spotinstMrScalerAwsClient = new SpotinstMrScalerAwsClient(authToken, account);
        return spotinstMrScalerAwsClient;
    }

    public static SpotOceanK8sClusterClient getOceanClusterClient(String authToken, String account) {
        SpotOceanK8sClusterClient spotOceanK8sClusterClient = new SpotOceanK8sClusterClient(authToken, account);
        return spotOceanK8sClusterClient;
    }

    public static SpotinstElastigroupClientAzure getElastigroupClientAzure(String authToken) {
        SpotinstElastigroupClientAzure spotinstElastigroupClientAzure = new SpotinstElastigroupClientAzure(authToken, null);
        return spotinstElastigroupClientAzure;
    }

    public static SpotinstElastigroupClientAzure getElastigroupClientAzure(String authToken, String account) {
        SpotinstElastigroupClientAzure spotinstElastigroupClientAzure = new SpotinstElastigroupClientAzure(authToken, account);
        return spotinstElastigroupClientAzure;
    }

    public static SpotinstElastigroupClientAzure getElastigroupClientAzure(String authToken, String account,
                                                                 List<UserAgentConfig> userAgentConfigurations) {
        SpotinstElastigroupClientAzure spotinstElastigroupClientAzure =
                new SpotinstElastigroupClientAzure(authToken, account, userAgentConfigurations);
        return spotinstElastigroupClientAzure;
    }

    public static SpotinstElastigroupClientGcp getElastigroupClientGcp(String authToken) {
        SpotinstElastigroupClientGcp spotinstElastigroupClientGcp = new SpotinstElastigroupClientGcp(authToken, null);
        return spotinstElastigroupClientGcp;
    }

    public static SpotinstElastigroupClientGcp getElastigroupClientGcp(String authToken, String account) {
        SpotinstElastigroupClientGcp spotinstElastigroupClientGcp = new SpotinstElastigroupClientGcp(authToken, account);
        return spotinstElastigroupClientGcp;
    }

    public static SpotinstElastigroupClientGcp getElastigroupClientGcp(String authToken, String account,
                                                                           List<UserAgentConfig> userAgentConfigurations) {
        SpotinstElastigroupClientGcp spotinstElastigroupClientGcp =
                new SpotinstElastigroupClientGcp(authToken, account, userAgentConfigurations);
        return spotinstElastigroupClientGcp;
    }

    public static SpotOceanAzureAksClusterClient getOceanAzureAksClusterClient(String authToken, String account) {
        SpotOceanAzureAksClusterClient spotOceanAzureAksClusterClient = new SpotOceanAzureAksClusterClient(authToken, account);
        return spotOceanAzureAksClusterClient;
    }

    public static SpotinstAdminAccountClient getAdminAccountClient(String authToken, String account) {
        SpotinstAdminAccountClient spotAdminAccountClient = new SpotinstAdminAccountClient(authToken, account);
        return spotAdminAccountClient;
    }



    //endregion
}
