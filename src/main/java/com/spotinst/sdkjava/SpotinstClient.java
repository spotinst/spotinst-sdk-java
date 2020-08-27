package com.spotinst.sdkjava;


import com.spotinst.sdkjava.client.http.UserAgentConfig;
import com.spotinst.sdkjava.client.rest.SpotinstHttpContext;
import com.spotinst.sdkjava.model.SpotinstElastigroupClient;
import com.spotinst.sdkjava.model.SpotinstMrScalerAwsClient;
import com.spotinst.sdkjava.model.SpotinstSpectrumClient;
import com.spotinst.sdkjava.model.SpotinstSubscriptionClient;
import com.spotinst.sdkjava.model.SpotinstMrScalerOperatorAwsClient;

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

    public static SpotinstMrScalerOperatorAwsClient getMrScalerOperatorAwsClient(String authToken, String account) {
        SpotinstMrScalerOperatorAwsClient spotinstMrScalerOperatorAwsClient = new SpotinstMrScalerOperatorAwsClient(authToken, account);
        return spotinstMrScalerOperatorAwsClient;
    }

    //endregion
}
