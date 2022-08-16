package com.spotinst.sdkjava.example.oceanCD;

import com.spotinst.sdkjava.SpotinstClient;
import com.spotinst.sdkjava.model.OceanCDClient;
import com.spotinst.sdkjava.model.bl.oceanCD.*;

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
        Strategy getStrategyResponse = getStrategy(oceanCDClient, strategyName);

        //Get All Strategy
        System.out.println("----------List All Strategies--------------");
        List<Strategy> listStrategyResponse = getAllStrategies(oceanCDClient);

        //Update Strategy
        System.out.println("----------Update Strategy-------------");
        Boolean updateStatus = updateStrategy(oceanCDClient, strategyName);

        //Patch Strategy
        System.out.println("----------Patch Strategy-------------");
        Boolean patchStatus = patchStrategy(oceanCDClient, strategyName);

        //Delete Strategy
        System.out.println("----------Delete Strategy-------------");
        Boolean deleteStatus = deleteStrategy(oceanCDClient, strategyName);

        //Create RolloutSpec
        System.out.println("----------Create RolloutSpec-------------");
        String rolloutSpecName = createRolloutSpec(oceanCDClient);

        //Get RolloutSpec
        System.out.println("----------Get RolloutSpec--------------");
        RolloutSpec getRolloutSpecResponse = getRolloutSpec(oceanCDClient, rolloutSpecName);

        //Get All RolloutSpec
        System.out.println("----------List All RolloutSpecs--------------");
        List<RolloutSpec> listRolloutSpecResponse = getAllRolloutSpecs(oceanCDClient);


        //Update RolloutSpec
        System.out.println("----------Update RolloutSpec-------------");
        Boolean updateRolloutSpecStatus = updateRolloutSpec(oceanCDClient, rolloutSpecName);

        //Patch RolloutSpec
            System.out.println("----------Patch RolloutSpec-------------");
        Boolean patchRolloutSpecStatus = patchRolloutSpec(oceanCDClient, rolloutSpecName);

        //Delete RolloutSpec
            System.out.println("----------Delete RolloutSpec-------------");
        Boolean deleteRoloutSpecStatus = deleteRolloutSpec(oceanCDClient, rolloutSpecName);
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

    private static Boolean deleteStrategy(OceanCDClient client, String strategyName) {
        System.out.println("------------------------Delete Ocean CD Strategy------------------------");


        Boolean deleteStatus = client.deleteStrategy(strategyName);

        if (deleteStatus) {
            System.out.println("Strategy successfully deleted");
        }
        else {
            System.out.println("Strategy successfully deleted");
        }

        return deleteStatus;
    }

    private static String createRolloutSpec(OceanCDClient client) {
        System.out.println("-------------------------start creating Ocean CD RolloutSpec------------------------");

        //Build RolloutSpecTraffic
        RolloutSpecTraffic.Builder rolloutSpecTrafficBuilder = RolloutSpecTraffic.Builder.get();
        RolloutSpecTraffic rolloutSpecTraffic = rolloutSpecTrafficBuilder.setStableService("rollouts-demo-stable").setCanaryService("rollouts-demo-canary").build();

        //Build RolloutSpecStrategy
        RolloutSpecStrategy.Builder rolloutSpecStrategyBuilder = RolloutSpecStrategy.Builder.get();
        RolloutSpecStrategy rolloutSpecStrategy = rolloutSpecStrategyBuilder.setName("Test-Strategy").build();

        //Build RolloutSpecSpotDeployment
        RolloutSpecSpotDeployment.Builder rolloutSpecSpotDeploymentBuilder = RolloutSpecSpotDeployment.Builder.get();
        RolloutSpecSpotDeployment rolloutSpecSpotDeployment = rolloutSpecSpotDeploymentBuilder.setName("nginx-deployment").setNamespace("default").setClusterId("EKS_Cluster_OceanCD").build();

        //Build RolloutSpec
        RolloutSpec.Builder rolloutSpecBuilder = RolloutSpec.Builder.get();
        RolloutSpec rolloutSpec = rolloutSpecBuilder.setName("Test-RolloutSpec").setStrategy(rolloutSpecStrategy).setSpotDeployment(rolloutSpecSpotDeployment).setTraffic(rolloutSpecTraffic).build();


        RolloutSpec createdRolloutSpec = client.createRolloutSpec(rolloutSpec);
        System.out.println("RolloutSpec successfully created: " + createdRolloutSpec.getName());

        return createdRolloutSpec.getName();

    }

    private static RolloutSpec getRolloutSpec (OceanCDClient client, String rolloutSpecName) {

        System.out.println(String.format("Get Ocean CD RolloutSpec. RolloutSpec Name: %s", rolloutSpecName));

        return client.getRolloutSpec(rolloutSpecName);
    }

    private static List<RolloutSpec> getAllRolloutSpecs (OceanCDClient client) {

        System.out.println("Get All Ocean CD RolloutSpecs");
        return client.getAllRolloutSpecs();
    }

    private static Boolean updateRolloutSpec(OceanCDClient client, String rolloutSpecName) {
        System.out.println("-------------------------start updating Ocean CD RolloutSpec------------------------");

        //Build RolloutSpecTraffic
        RolloutSpecTraffic.Builder rolloutSpecTrafficBuilder = RolloutSpecTraffic.Builder.get();
        RolloutSpecTraffic rolloutSpecTraffic = rolloutSpecTrafficBuilder.setStableService("rollouts-demo-stable1").setCanaryService("rollouts-demo-canary1").build();

        //Build RolloutSpecStrategy
        RolloutSpecStrategy.Builder rolloutSpecStrategyBuilder = RolloutSpecStrategy.Builder.get();
        RolloutSpecStrategy rolloutSpecStrategy = rolloutSpecStrategyBuilder.setName("Test-Strategy").build();

        //Build RolloutSpecSpotDeployment
        RolloutSpecSpotDeployment.Builder rolloutSpecSpotDeploymentBuilder = RolloutSpecSpotDeployment.Builder.get();
        RolloutSpecSpotDeployment rolloutSpecSpotDeployment = rolloutSpecSpotDeploymentBuilder.setName("nginx-deployment1").setNamespace("default").setClusterId("EKS_Cluster_OceanCD").build();

        //Build RolloutSpec
        RolloutSpec.Builder rolloutSpecBuilder = RolloutSpec.Builder.get();
        RolloutSpec rolloutSpec = rolloutSpecBuilder.setStrategy(rolloutSpecStrategy).setTraffic(rolloutSpecTraffic).setSpotDeployment(rolloutSpecSpotDeployment).build();


        Boolean updateStatus = client.updateRolloutSpec(rolloutSpec, rolloutSpecName);
        if (updateStatus) {
            System.out.println("RolloutSpec successfully updated");
        }
        else {
            System.out.println("RolloutSpec successfully updated");
        }

        return updateStatus;
    }

    private static Boolean patchRolloutSpec(OceanCDClient client, String rolloutSpecName) {
        System.out.println("-------------------------start patching Ocean CD RolloutSpec------------------------");

        //Build RolloutSpecTraffic
        RolloutSpecTraffic.Builder rolloutSpecTrafficBuilder = RolloutSpecTraffic.Builder.get();
        RolloutSpecTraffic rolloutSpecTraffic = rolloutSpecTrafficBuilder.setStableService("rollouts-demo-stable2").build();

        //Build RolloutSpec
        RolloutSpec.Builder rolloutSpecBuilder = RolloutSpec.Builder.get();
        RolloutSpec rolloutSpec = rolloutSpecBuilder.setTraffic(rolloutSpecTraffic).build();


        Boolean patchStatus = client.patchRolloutSpec(rolloutSpec, rolloutSpecName);

        if (patchStatus) {
            System.out.println("RolloutSpec successfully updated");
        }
        else {
            System.out.println("RolloutSpec successfully updated");
        }

        return patchStatus;
    }

    private static Boolean deleteRolloutSpec(OceanCDClient client, String rolloutSpecName) {
        System.out.println("------------------------Delete Ocean CD RolloutSpec------------------------");


        Boolean deleteStatus = client.deleteRolloutSpec(rolloutSpecName);

        if (deleteStatus) {
            System.out.println("RolloutSpec successfully deleted");
        }
        else {
            System.out.println("RolloutSpec successfully deleted");
        }

        return deleteStatus;
    }

}

