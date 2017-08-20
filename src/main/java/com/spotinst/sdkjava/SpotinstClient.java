package com.spotinst.sdkjava;


import com.spotinst.sdkjava.client.rest.SpotinstHttpContext;
import com.spotinst.sdkjava.model.SpotinstElastigroupClient;
import com.spotinst.sdkjava.model.SpotinstSubscriptionClient;

/**
 * Created by talzur on 12/01/2017.
 */
public class SpotinstClient {

    //region Methods
    public static SpotinstElastigroupClient getElastigroupClient(String authToken) {
        SpotinstElastigroupClient spotinstElastigroupClient = new SpotinstElastigroupClient(authToken);
        return spotinstElastigroupClient;
    }

    public static void setNonDefaultEndpoint(String newEndpoint) {
        SpotinstHttpContext.getInstance().getConfiguration().setEndpoint(newEndpoint);
    }

    public static SpotinstSubscriptionClient getSubscriptionClient(String authToken) {
        SpotinstSubscriptionClient spotinstSubscriptionClient = new SpotinstSubscriptionClient(authToken);
        return spotinstSubscriptionClient;
    }

    //endregion
}
