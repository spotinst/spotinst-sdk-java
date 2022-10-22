package com.spotinst.sdkjava.example.oceanCD;

import com.spotinst.sdkjava.SpotinstClient;
import com.spotinst.sdkjava.model.OceanCDClient;
import com.spotinst.sdkjava.model.bl.oceanCD.*;
import com.spotinst.sdkjava.model.bl.oceanCD.response.Cluster;
import com.spotinst.sdkjava.model.bl.oceanCD.response.ClusterNotification;
import com.spotinst.sdkjava.model.bl.oceanCD.response.RolloutStatus;
import com.spotinst.sdkjava.model.bl.oceanCD.response.RolloutsDetails;
import com.spotinst.sdkjava.model.requests.oceanCD.RolloutActions;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class OceanCDUsageExample {

    private final static String auth_token = "your-token";
    private final static String account_Id = "account_Id";
    private final static String api_key = "api_key";

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

        //Get Rollout Status
        System.out.println("----------Get Rollout Status--------------");
        RolloutStatus rolloutStatusResponse = getRolloutStatus(oceanCDClient, strategyName);

        //Get All Rollouts
        System.out.println("----------List All Rollouts--------------");
        List<RolloutsDetails> listRolloutStatusResponse = getAllRollouts(oceanCDClient);

        //Rollout Actions
        System.out.println("----------Rollout Actions-------------");
        Boolean rolloutStatus = rolloutAction(oceanCDClient, strategyName);

        //Create VerificationProvider
        System.out.println("----------Create VerificationProvider-------------");
        String VerificationProviderName = createVerificationProvider(oceanCDClient);

        //Get VerificationProvider
        System.out.println("----------Get VerificationProvider--------------");
        VerificationProvider getVerificationProviderResponse = getVerificationProvider(oceanCDClient, VerificationProviderName);

        //Get All VerificationProvider
        System.out.println("----------List All VerificationProviders--------------");
        List<VerificationProvider> listVerificationProviderResponse = getAllVerificationProviders(oceanCDClient);


        //Update VerificationProvider
        System.out.println("----------Update VerificationProvider-------------");
        Boolean updateVerificationProviderStatus = updateVerificationProvider(oceanCDClient, VerificationProviderName);

        //Patch VerificationProvider
        System.out.println("----------Patch VerificationProvider-------------");
        Boolean patchVerificationProviderStatus = patchVerificationProvider(oceanCDClient, VerificationProviderName);

        //Delete VerificationProvider
        System.out.println("----------Delete VerificationProvider-------------");
        Boolean deleteVerificationProviderStatus = deleteVerificationProvider(oceanCDClient, VerificationProviderName);

        //Create VerificationTemplate
        System.out.println("----------Create VerificationTemplate-------------");
        String VerificationTemplateName = createVerificationTemplate(oceanCDClient);

        //Get VerificationTemplate
        System.out.println("----------Get VerificationTemplate--------------");
        VerificationTemplate getVerificationTemplateResponse = getVerificationTemplate(oceanCDClient, VerificationTemplateName);

        //Get All VerificationTemplate
        System.out.println("----------List All VerificationTemplates--------------");
        List<VerificationTemplate> listVerificationTemplateResponse = getAllVerificationTemplates(oceanCDClient);


        //Update VerificationTemplate
        System.out.println("----------Update VerificationTemplate-------------");
        Boolean updateVerificationTemplateStatus = updateVerificationTemplate(oceanCDClient, VerificationTemplateName);

        //Patch VerificationTemplate
        System.out.println("----------Patch VerificationTemplate-------------");
        Boolean patchVerificationTemplateStatus = patchVerificationTemplate(oceanCDClient, VerificationTemplateName);

        //Delete VerificationTemplate
        System.out.println("----------Delete VerificationTemplate-------------");
        Boolean deleteVerificationTemplateStatus = deleteVerificationTemplate(oceanCDClient, VerificationTemplateName);

        //Get Cluster
        System.out.println("----------Get Cluster--------------");
        Cluster getClusterResponse = getCluster(oceanCDClient, "clusterId");

        //Get All Clusters
        System.out.println("----------List All Clusters--------------");
        List<Cluster> listClusterResponse = getAllClusters(oceanCDClient);

        //Update Cluster
        System.out.println("----------Update Cluster-------------");
        Boolean updateClusterStatus = updateCluster(oceanCDClient, "clusterId");

        //Delete Cluster
        System.out.println("----------Delete Cluster-------------");
        Boolean deleteClusterStatus = deleteCluster(oceanCDClient, "clusterId");
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
            System.out.println("Strategy is not updated");
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
            System.out.println("Strategy is not updated");
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
            System.out.println("Strategy is not deleted");
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
            System.out.println("RolloutSpec is not updated");
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
            System.out.println("RolloutSpec is not updated");
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
            System.out.println("RolloutSpec is not deleted");
        }

        return deleteStatus;
    }

    private static RolloutStatus getRolloutStatus (OceanCDClient client, String rolloutId) {

        System.out.println(String.format("Get Ocean CD Rollout. Rollout ID: %s", rolloutId));

        return client.getRolloutStatus(rolloutId);
    }

    private static List<RolloutsDetails> getAllRollouts (OceanCDClient client) {

        System.out.println("Get All Ocean CD Rollouts");

        return client.getAllRollouts("1662149664");
    }

    private static Boolean rolloutAction(OceanCDClient client, String rolloutId) {
        System.out.println("-------------------------Rollout Action------------------------");

        //Build Strategy
        RolloutActions.Builder rolloutActionsBuilder = RolloutActions.Builder.get();
        RolloutActions rolloutActions = rolloutActionsBuilder.setAction("promoteFull").build();

        Boolean updateStatus = client.rolloutAction(rolloutActions, rolloutId);

        if (updateStatus) {
            System.out.println("Rollout action is executed");
        }
        else {
            System.out.println("Rollout action is not executed");
        }

        return updateStatus;
    }

    private static String createVerificationProvider(OceanCDClient client) {
        System.out.println("-------------------------start creating Ocean CD VerificationProvider------------------------");

        List<String> clusterIds = Arrays.asList("Cluster1","Cluster2");

        //Build VerificationProviderCloudWatch
        VerificationProviderCloudWatch.Builder verificationProviderCloudWatchBuilder = VerificationProviderCloudWatch.Builder.get();
        VerificationProviderCloudWatch verificationProviderCloudWatch = verificationProviderCloudWatchBuilder.setIamArn("arn:aws:iam::253244684816:role/Automation-Test").build();

        //Build VerificationProvider
        VerificationProvider.Builder VerificationProviderBuilder = VerificationProvider.Builder.get();
        VerificationProvider VerificationProvider = VerificationProviderBuilder.setName("Test-VerificationProvider").setCloudWatch(verificationProviderCloudWatch).setClusterIds(clusterIds).build();


        VerificationProvider createdVerificationProvider = client.createVerificationProvider(VerificationProvider);
        System.out.println("VerificationProvider successfully created: " + createdVerificationProvider.getName());

        return createdVerificationProvider.getName();

    }

    private static VerificationProvider getVerificationProvider (OceanCDClient client, String VerificationProviderName) {

        System.out.println(String.format("Get Ocean CD VerificationProvider. VerificationProvider Name: %s", VerificationProviderName));

        return client.getVerificationProvider(VerificationProviderName);
    }

    private static List<VerificationProvider> getAllVerificationProviders (OceanCDClient client) {

        System.out.println("Get All Ocean CD VerificationProviders");
        return client.getAllVerificationProviders();
    }

    private static Boolean updateVerificationProvider(OceanCDClient client, String VerificationProviderName) {
        System.out.println("-------------------------start updating Ocean CD VerificationProvider------------------------");

        List<String> clusterIds = Arrays.asList("Cluster1","Cluster2");

        //Build VerificationProviderNewRelic
        VerificationProviderNewRelic.Builder verificationProviderNewRelicBuilder = VerificationProviderNewRelic.Builder.get();
        VerificationProviderNewRelic verificationProviderNewRelic = verificationProviderNewRelicBuilder.setAccountId(account_Id).setPersonalApiKey(api_key).build();

        //Build VerificationProvider
        VerificationProvider.Builder VerificationProviderBuilder = VerificationProvider.Builder.get();
        VerificationProvider VerificationProvider = VerificationProviderBuilder.setName("Test-VerificationProvider").setNewRelic(verificationProviderNewRelic).setClusterIds(clusterIds).build();

        Boolean updateStatus = client.updateVerificationProvider(VerificationProvider, VerificationProviderName);
        if (updateStatus) {
            System.out.println("VerificationProvider successfully updated");
        }
        else {
            System.out.println("VerificationProvider is not updated");
        }

        return updateStatus;
    }

    private static Boolean patchVerificationProvider(OceanCDClient client, String VerificationProviderName) {
        System.out.println("-------------------------start patching Ocean CD VerificationProvider------------------------");

        List<String> clusterIds = Arrays.asList("Cluster1","Cluster2");

        //Build VerificationProviderNewRelic
        VerificationProviderNewRelic.Builder verificationProviderNewRelicBuilder = VerificationProviderNewRelic.Builder.get();
        VerificationProviderNewRelic verificationProviderNewRelic = verificationProviderNewRelicBuilder.setAccountId(account_Id).setPersonalApiKey(api_key).build();

        //Build VerificationProvider
        VerificationProvider.Builder VerificationProviderBuilder = VerificationProvider.Builder.get();
        VerificationProvider VerificationProvider = VerificationProviderBuilder.setName("Test-VerificationProvider").setNewRelic(verificationProviderNewRelic).setClusterIds(clusterIds).build();

        Boolean patchStatus = client.patchVerificationProvider(VerificationProvider, VerificationProviderName);

        if (patchStatus) {
            System.out.println("VerificationProvider successfully updated");
        }
        else {
            System.out.println("VerificationProvider is not updated");
        }

        return patchStatus;
    }

    private static Boolean deleteVerificationProvider(OceanCDClient client, String VerificationProviderName) {
        System.out.println("------------------------Delete Ocean CD VerificationProvider------------------------");


        Boolean deleteStatus = client.deleteVerificationProvider(VerificationProviderName);

        if (deleteStatus) {
            System.out.println("VerificationProvider successfully deleted");
        }
        else {
            System.out.println("VerificationProvider is not deleted");
        }

        return deleteStatus;
    }

    private static String createVerificationTemplate(OceanCDClient client) {
        System.out.println("-------------------------start creating Ocean CD VerificationTemplate------------------------");

        //Build VerificationTemplateArgs
        VerificationTemplateArgs.Builder verificationTemplateArgsBuilder = VerificationTemplateArgs.Builder.get();
        VerificationTemplateArgs verificationTemplateArgs = verificationTemplateArgsBuilder.setName("Demo-Test").build();

        List<VerificationTemplateArgs> verificationTemplateArgsCache = Collections.singletonList(verificationTemplateArgs);

        //Build ProviderDatadog
        ProviderDatadog.Builder providerDatadogBuilder = ProviderDatadog.Builder.get();
        ProviderDatadog providerDatadog = providerDatadogBuilder.setQuery("sum:requests.error.count{service:test} / sum:requests.request.count{service:test1}").build();

        //Build MetricsProvider
        MetricsProvider.Builder metricsProviderBuilder = MetricsProvider.Builder.get();
        MetricsProvider metricsProvider          = metricsProviderBuilder.setDatadog(providerDatadog).build();

        //Build VerificationTemplateMetrics
        VerificationTemplateMetrics.Builder verificationTemplateMetricsBuilder = VerificationTemplateMetrics.Builder.get();
        VerificationTemplateMetrics verificationTemplateMetrics          = verificationTemplateMetricsBuilder.setName("5xx=errors").setInterval("2m").setInitialDelay("1m").setSuccessCondition("result[0] < 20").setProvider(metricsProvider).build();

        List<VerificationTemplateMetrics> verificationTemplateMetricsCache = Collections.singletonList(verificationTemplateMetrics);

        //Build VerificationTemplate
        VerificationTemplate.Builder verificationTemplateBuilder = VerificationTemplate.Builder.get();
        VerificationTemplate verificationTemplate          = verificationTemplateBuilder.setName("Test_Template").setArgs(verificationTemplateArgsCache).setMetrics(verificationTemplateMetricsCache).build();

        VerificationTemplate createdVerificationTemplate = client.createVerificationTemplate(verificationTemplate);
        System.out.println("VerificationTemplate successfully created: " + createdVerificationTemplate.getName());

        return createdVerificationTemplate.getName();

    }

    private static VerificationTemplate getVerificationTemplate (OceanCDClient client, String VerificationTemplateName) {

        System.out.println(String.format("Get Ocean CD VerificationTemplate. VerificationTemplate Name: %s", VerificationTemplateName));

        return client.getVerificationTemplate(VerificationTemplateName);
    }

    private static List<VerificationTemplate> getAllVerificationTemplates (OceanCDClient client) {

        System.out.println("Get All Ocean CD VerificationTemplates");
        return client.getAllVerificationTemplates();
    }

    private static Boolean updateVerificationTemplate(OceanCDClient client, String VerificationTemplateName) {
        System.out.println("-------------------------start updating Ocean CD VerificationTemplate------------------------");

        //Build ProviderNewRelic
        ProviderNewRelic.Builder ProviderNewRelicBuilder = ProviderNewRelic.Builder.get();
        ProviderNewRelic providerNewRelic = ProviderNewRelicBuilder.setQuery("sum:requests.error.count{service:test} / sum:requests.request.count{service:test1}").setProfile("Testing").build();

        //Build MetricsProvider
        MetricsProvider.Builder metricsProviderBuilder = MetricsProvider.Builder.get();
        MetricsProvider metricsProvider          = metricsProviderBuilder.setNewRelic(providerNewRelic).build();

        //Build VerificationTemplateMetrics
        VerificationTemplateMetrics.Builder verificationTemplateMetricsBuilder = VerificationTemplateMetrics.Builder.get();
        VerificationTemplateMetrics verificationTemplateMetrics          = verificationTemplateMetricsBuilder.setName("2xx=errors").setInterval("1m").setInitialDelay("2m").setSuccessCondition("result[0] > 20").setProvider(metricsProvider).build();

        List<VerificationTemplateMetrics> verificationTemplateMetricsCache = Collections.singletonList(verificationTemplateMetrics);

        //Build VerificationTemplate
        VerificationTemplate.Builder verificationTemplateBuilder = VerificationTemplate.Builder.get();
        VerificationTemplate verificationTemplate          = verificationTemplateBuilder.setMetrics(verificationTemplateMetricsCache).build();

        Boolean updateStatus = client.updateVerificationTemplate(verificationTemplate, VerificationTemplateName);
        if (updateStatus) {
            System.out.println("VerificationTemplate successfully updated");
        }
        else {
            System.out.println("VerificationTemplate is not updated");
        }

        return updateStatus;
    }

    private static Boolean patchVerificationTemplate(OceanCDClient client, String VerificationTemplateName) {
        System.out.println("-------------------------start patching Ocean CD VerificationTemplate------------------------");

        //Build ProviderNewRelic
        ProviderNewRelic.Builder ProviderNewRelicBuilder = ProviderNewRelic.Builder.get();
        ProviderNewRelic providerNewRelic = ProviderNewRelicBuilder.setProfile("Testing1").build();

        //Build MetricsProvider
        MetricsProvider.Builder metricsProviderBuilder = MetricsProvider.Builder.get();
        MetricsProvider metricsProvider          = metricsProviderBuilder.setNewRelic(providerNewRelic).build();

        //Build VerificationTemplateMetrics
        VerificationTemplateMetrics.Builder verificationTemplateMetricsBuilder = VerificationTemplateMetrics.Builder.get();
        VerificationTemplateMetrics verificationTemplateMetrics          = verificationTemplateMetricsBuilder.setProvider(metricsProvider).build();

        List<VerificationTemplateMetrics> verificationTemplateMetricsCache = Collections.singletonList(verificationTemplateMetrics);

        //Build VerificationTemplate
        VerificationTemplate.Builder verificationTemplateBuilder = VerificationTemplate.Builder.get();
        VerificationTemplate verificationTemplate          = verificationTemplateBuilder.setMetrics(verificationTemplateMetricsCache).build();

        Boolean patchStatus = client.patchVerificationTemplate(verificationTemplate, VerificationTemplateName);

        if (patchStatus) {
            System.out.println("VerificationTemplate successfully updated");
        }
        else {
            System.out.println("VerificationTemplate is not updated");
        }

        return patchStatus;
    }

    private static Boolean deleteVerificationTemplate(OceanCDClient client, String VerificationTemplateName) {
        System.out.println("------------------------Delete Ocean CD VerificationTemplate------------------------");


        Boolean deleteStatus = client.deleteVerificationTemplate(VerificationTemplateName);

        if (deleteStatus) {
            System.out.println("VerificationTemplate successfully deleted");
        }
        else {
            System.out.println("VerificationTemplate is not deleted");
        }

        return deleteStatus;
    }

    private static Cluster getCluster (OceanCDClient client, String clusterId) {

        System.out.println(String.format("Get Ocean CD Cluster. Cluster ID: %s", clusterId));

        return client.getCluster(clusterId);
    }

    private static List<Cluster> getAllClusters (OceanCDClient client) {

        System.out.println("Get All Ocean CD Clusters");

        return client.getAllClusters();
    }

    private static Boolean updateCluster(OceanCDClient client, String clusterId) {
        System.out.println("-------------------------start updating Ocean CD Cluster------------------------");

        List<String> providers = Arrays.asList("Provider1","Provider2");
        //Build Cluster
        ClusterNotification.Builder ClusterBuilder = ClusterNotification.Builder.get();
        ClusterNotification clusterNotification = ClusterBuilder.setMinutesWithoutHeartbeat(2).setProviders(providers).build();

        Boolean updateStatus = client.updateCluster(clusterNotification, clusterId);

        if (updateStatus) {
            System.out.println("Cluster successfully updated");
        }
        else {
            System.out.println("Cluster is not updated");
        }

        return updateStatus;
    }

    private static Boolean deleteCluster(OceanCDClient client, String clusterId) {
        System.out.println("------------------------Delete Ocean CD Cluster------------------------");

        Boolean deleteStatus = client.deleteCluster(clusterId);

        if (deleteStatus) {
            System.out.println("Cluster successfully deleted");
        }
        else {
            System.out.println("Cluster is not deleted");
        }

        return deleteStatus;
    }

}

