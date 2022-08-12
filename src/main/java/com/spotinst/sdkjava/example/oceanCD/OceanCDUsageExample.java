package com.spotinst.sdkjava.example.oceanCD;

import com.spotinst.sdkjava.SpotinstClient;
import com.spotinst.sdkjava.model.OceanCDClient;
import com.spotinst.sdkjava.model.bl.oceanCD.CanarySteps;
import com.spotinst.sdkjava.model.bl.oceanCD.Strategy;
import com.spotinst.sdkjava.model.bl.oceanCD.StrategyCanary;

import java.util.Arrays;
import java.util.List;

public class OceanCDUsageExample {

    private final static String auth_token = "your-token";

    public static void main(String[] args) throws InterruptedException {
        OceanCDClient oceanCDClient = SpotinstClient.getOceanCDClient(auth_token);

        //Create Strategy
        System.out.println("----------Create Strategy-------------");
        String strategyName = createStrategy(oceanCDClient);

        //Get Strategy
        System.out.println("----------Get Strategy--------------");
        Strategy getStrategyResponse = getStrategy (oceanCDClient, strategyName);

        //Get All Strategy
        System.out.println("----------List All Strategies--------------");
        List<Strategy> listGetStrategyResponse = getAllStrategies(oceanCDClient);

        //Update Strategy
        System.out.println("----------Update Strategy-------------");
        Boolean updateStatus = updateStrategy(oceanCDClient, strategyName);

        //Create Patch
        System.out.println("----------Patch Strategy-------------");
        Boolean patchStatus = patchStrategy(oceanCDClient, strategyName);
    }

    private static String createStrategy(OceanCDClient client) {
        System.out.println("-------------------------start creating Ocean CD Strategy------------------------");

        //Build Steps
        CanarySteps.Builder canaryStepsBuilder = CanarySteps.Builder.get();
        List<CanarySteps> canarySteps = Arrays.asList(canaryStepsBuilder.setName("Start").setSetWeight(100).build());

        //Build Canary
        StrategyCanary.Builder strategyCanaryBuilder = StrategyCanary.Builder.get();
        StrategyCanary strategyCanary = strategyCanaryBuilder.setSteps(canarySteps).build();

        //Build Strategy
        Strategy.Builder strategyBuilder = Strategy.Builder.get();
        Strategy strategy = strategyBuilder.setName("Test-Strategy").setCanary(strategyCanary).build();

        Strategy createdStrategy = client.createStrategy(strategy);
        System.out.println("Strategy successfully created: " + createdStrategy.getName());

        return createdStrategy.getName();

    }

    private static Strategy getStrategy (OceanCDClient client, String strategyName) {

        System.out.println(String.format("Get Ocean CD Strategy. Strategy Name: %s", strategyName));

        return client.getStrategy(strategyName);
    }

    private static List<Strategy> getAllStrategies (OceanCDClient client) {

        System.out.println("Get All Ocean CD Strategies");

        return client.getAllStrategies();
    }

    private static Boolean updateStrategy(OceanCDClient client, String strategyName) {
        System.out.println("-------------------------start updating Ocean CD Strategy------------------------");

        //Build Steps
        CanarySteps.Builder canaryStepsBuilder = CanarySteps.Builder.get();
        List<CanarySteps> canarySteps = Arrays.asList(canaryStepsBuilder.setName("End").setSetWeight(50).build());

        //Build Canary
        StrategyCanary.Builder strategyCanaryBuilder = StrategyCanary.Builder.get();
        StrategyCanary strategyCanary = strategyCanaryBuilder.setSteps(canarySteps).build();

        //Build Strategy
        Strategy.Builder strategyBuilder = Strategy.Builder.get();
        Strategy strategy = strategyBuilder.setCanary(strategyCanary).build();

        Boolean updateStatus = client.updateStrategy(strategy, strategyName);
        if (updateStatus) {
            System.out.println("Strategy successfully updated");
        }
        else {
            System.out.println("Strategy successfully updated");
        }

        return updateStatus;
    }

    private static Boolean patchStrategy(OceanCDClient client, String strategyName) {
        System.out.println("-------------------------start patching Ocean CD Strategy------------------------");

        //Build Steps
        CanarySteps.Builder canaryStepsBuilder = CanarySteps.Builder.get();
        List<CanarySteps> canarySteps = Arrays.asList(canaryStepsBuilder.setSetWeight(70).build());

        //Build Canary
        StrategyCanary.Builder strategyCanaryBuilder = StrategyCanary.Builder.get();
        StrategyCanary strategyCanary = strategyCanaryBuilder.setSteps(canarySteps).build();

        //Build Strategy
        Strategy.Builder strategyBuilder = Strategy.Builder.get();
        Strategy strategy = strategyBuilder.setCanary(strategyCanary).build();

        Boolean patchStatus = client.patchStrategy(strategy, strategyName);
        if (patchStatus) {
            System.out.println("Strategy successfully updated");
        }
        else {
            System.out.println("Strategy successfully updated");
        }

        return patchStatus;
    }

}

