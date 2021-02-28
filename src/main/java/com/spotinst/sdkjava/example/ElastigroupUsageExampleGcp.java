package com.spotinst.sdkjava.example;

import com.spotinst.sdkjava.SpotinstClient;
import com.spotinst.sdkjava.enums.PerformAtEnumGcp;
import com.spotinst.sdkjava.enums.GroupActiveInstanceStatusEnumGcp;
import com.spotinst.sdkjava.model.*;
import com.spotinst.sdkjava.model.bl.gcp.*;


import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ElastigroupUsageExampleGcp {
    private final static String auth_token          = "eeab5e1e5e9b5dcbb1aba6d7023d2ae981c6b48dd13784439bb6061f8beb053a";
    private final static String act_id              = "act-7d8b3fee";
    private static final String SPOTINST_GROUP_NAME = "Gcp_SDK_test_or";

    public static void main(String[] args) throws IOException {
        // Get elastigroup service client
        SpotinstElastigroupClientGcp elastigroupClient = SpotinstClient.getElastigroupClientGcp(auth_token, act_id);

        // Create group
        String elastigroupId = createElastigroup(elastigroupClient);

        // Sleep for provisioning
        System.out.println("Sleeping... waiting for provisioning 7 seconds.");
        sleep(7);

        // Update group
        updateElastigroup(elastigroupClient, elastigroupId);

        // Get group
        ElastigroupGcp group =  getGroup(elastigroupClient,elastigroupId);
        String groupName = group.getName();
        String preFormat     = "groupId: %s - groupName: %s";
        System.out.println(String.format(preFormat, elastigroupId, groupName));

        // Sleep for provisioning
        System.out.println("Sleeping... waiting for provisioning 7 seconds.");
        sleep(7);

        // List all Elastigroups
        getAllElastigroups(elastigroupClient);

        //Get elastigroup status
        getElastigroupStatus(elastigroupClient, elastigroupId);

        // Delete elastigroup
       deleteElastigroup(elastigroupClient, elastigroupId);
    }

    private static String  createElastigroup(SpotinstElastigroupClientGcp client) {
        //Build Instance Type
        ElastigroupInstanceTypesGcp.Builder ElastigroupInstanceTypesGcpBuilder =
                ElastigroupInstanceTypesGcp.Builder.get();

        List<String> PreemtibleList = new ArrayList<>();
        PreemtibleList.add("n1-standard-1");

        ElastigroupInstanceTypesGcp instanceTypesGcp = ElastigroupInstanceTypesGcpBuilder.setOndemand("n1-standard-1")
                                    .setPreemptible(PreemtibleList).build();

        //build Intialize Params
        ElastigroupInitializeParamsGcp.Builder ElastigroupInitializeParamsGcpBuilder =
                ElastigroupInitializeParamsGcp.Builder.get();

        ElastigroupInitializeParamsGcp initializeParamsGcp = ElastigroupInitializeParamsGcpBuilder.setDiskSizeGb(12)
                                       .setDiskType("pd-ssd")
                                       .setSourceImage("https://www.googleapis.com/compute/v1/projects/ubuntu-os-cloud/global/images/ubuntu-1604-xenial-v20181004").build();

        //build disks
        ElastigroupDisksGcp.Builder ElastigroupDisksGcpBuilder =
                ElastigroupDisksGcp.Builder.get();



        ElastigroupDisksGcp disksGcp = ElastigroupDisksGcpBuilder.setAutoDelete(true).setBoot(true).setDeviceName(null)
                                       .setInitializeParams(initializeParamsGcp).setMode("READ_WRITE")
                                       .setSource(null).setType("PERSISTENT").build();

        List<ElastigroupDisksGcp> disksGcpList = new ArrayList<>();
        disksGcpList.add(disksGcp);

        //build Network Interfaces
        ElastigroupNetworkInterfacesGcp.Builder ElastigroupNetworkInterfacesGcpBuilder =
                ElastigroupNetworkInterfacesGcp.Builder.get();

        ElastigroupNetworkInterfacesGcp networkInterfacesGcp=
                ElastigroupNetworkInterfacesGcpBuilder.setNetwork("default").setProjectId(null).build();

        List<ElastigroupNetworkInterfacesGcp> networkInterfacesGcpList = new ArrayList<>();
        networkInterfacesGcpList.add(networkInterfacesGcp);

        //build subnets
        ElastigroupSubnetsGcp.Builder ElastigroupSubnetsGcpBuilder =
                ElastigroupSubnetsGcp.Builder.get();

        Set<String> SubnetsNamesList = new HashSet<String>();
        SubnetsNamesList.add("default");

        ElastigroupSubnetsGcp subnetsGcp =
                ElastigroupSubnetsGcpBuilder.setRegion("us-west1").setSubnetNames(SubnetsNamesList).build();

        List<ElastigroupSubnetsGcp> subnetsGcpList = new ArrayList<>();
        subnetsGcpList.add(subnetsGcp);

        //build launch specification
        ElastigroupLaunchSpecificationGcp.Builder ElastigroupLaunchSpecificationGcpBuilder =
                ElastigroupLaunchSpecificationGcp.Builder.get();

        ElastigroupLaunchSpecificationGcp launchSpecificationGcp = ElastigroupLaunchSpecificationGcpBuilder.setDisks(disksGcpList)
                                          .setNetworkInterfaces(networkInterfacesGcpList).build();

        //build Compute
        ElastigroupComputeGcp.Builder ElastigroupComputeConfigurationGcpBuilder =
                ElastigroupComputeGcp.Builder.get();

        List<String> AvailabilityZonesList = new ArrayList<>();
        AvailabilityZonesList.add("us-west1-a");

        ElastigroupComputeGcp computeConfigurationGcp = ElastigroupComputeConfigurationGcpBuilder
                                           .setAvailabilityZones(AvailabilityZonesList).setInstanceTypes(instanceTypesGcp)
                                           .setLaunchSpecification(launchSpecificationGcp).setSubnets(subnetsGcpList).build();

        //Build group capacity
        ElastigroupCapacityGcp.Builder capacityBuilder =
                ElastigroupCapacityGcp.Builder.get();

        ElastigroupCapacityGcp capacity =
                capacityBuilder.setMinimum(0).setMaximum(0).setTarget(0).build();

        // build revert to preemptible
        ElastigroupRevertToPreemptibleGcp.Builder ElastigroupRevertToPreemptibleGcpBuilder=
                ElastigroupRevertToPreemptibleGcp.Builder.get();

        ElastigroupRevertToPreemptibleGcp revertToPreemptibleGcp = ElastigroupRevertToPreemptibleGcpBuilder.setPerformAt(
                PerformAtEnumGcp.never).build();

        //build strategy
        ElastigroupStrategyGcp.Builder ElastigroupStrategyConfigurationGcpBuilder
                                                    = ElastigroupStrategyGcp.Builder.get();

        List<String> OptimizationWindowsList = new ArrayList<>();
        OptimizationWindowsList.add("Mon:01:00-Mon:04:00");

        ElastigroupStrategyGcp strategyConfigurationGcp = ElastigroupStrategyConfigurationGcpBuilder
                                            .setDrainingTimeout(null)
                                            .setFallbackToOd(true)
                                            .setOnDemandCount(0)
                                            .setPreemptiblePercentage(100)
                                            .setRevertToPreemptible(revertToPreemptibleGcp).build();

        //build elastigroup gcp
        ElastigroupGcp.Builder ElastigroupGcpBuilder = ElastigroupGcp.Builder.get();
        ElastigroupGcp elastigroupGcp =
                ElastigroupGcpBuilder.setName(SPOTINST_GROUP_NAME)
                                     .setDescription("spotinst-automation")
                                     .setCapacity(capacity)
                                     .setCompute(computeConfigurationGcp)
                                     .setStrategy(strategyConfigurationGcp).build();

        // Build gcp elastigroup creation request
        ElastigroupCreationRequestGcp.Builder ElastigroupCreationRequestGcpBuilder =
                ElastigroupCreationRequestGcp.Builder.get();

        ElastigroupCreationRequestGcp creationRequestGcp=
                ElastigroupCreationRequestGcpBuilder.setElastigroup(elastigroupGcp).build();

        // Convert elastigroup to API object json
        System.out.println(creationRequestGcp.toJson());
        // Create elastigroup

        ElastigroupGcp createdElastigroup = client.createElastigroup(creationRequestGcp);
        System.out.println("Elastigroup successfully created: " + createdElastigroup.getId());

        // Get elastigroup Id
        return createdElastigroup.getId();
    }


    private static void updateElastigroup(SpotinstElastigroupClientGcp client, String elastigroupId) {
        //Create group update
        ElastigroupCapacityGcp.Builder updateCapacityBuilder =
                ElastigroupCapacityGcp.Builder.get();

        ElastigroupCapacityGcp updateCapacity =
                updateCapacityBuilder.setMinimum(2).setTarget(2).setMaximum(2).build();

        ElastigroupStrategyGcp.Builder strategyBuilder =
                ElastigroupStrategyGcp.Builder.get();

        ElastigroupStrategyGcp strategyConfigurationGcp =
                strategyBuilder.setOnDemandCount(0).build();

        // Build elastigroup update
        ElastigroupGcp.Builder updateElastigroupBuilder = ElastigroupGcp.Builder.get();
        ElastigroupGcp elastigroupUpdate =
                updateElastigroupBuilder.setCapacity(updateCapacity).setStrategy(strategyConfigurationGcp).setDescription("spotinst-automation").setName(SPOTINST_GROUP_NAME).build();

        // Build elastigroup update request
        ElastigroupUpdateRequestGcp.Builder elastigroupUpdateRequestBuilder =
                ElastigroupUpdateRequestGcp.Builder.get();
        ElastigroupUpdateRequestGcp updateRequest =
                elastigroupUpdateRequestBuilder.setElastigroup(elastigroupUpdate).build();

        // Convert elastigroup update to API object json
        System.out.println(updateRequest.toJson());

        // Update elastigroup
        Boolean updateSuccess = client.updateElastigroup(updateRequest, elastigroupId);
        if (updateSuccess) {
            System.out.println("Elastigroup successfully updated.");
        }
    }

    private static void deleteElastigroup(SpotinstElastigroupClientGcp client, String elastigroupId) {
        ElastigroupDeletionRequestGcp.Builder deletionBuilder = ElastigroupDeletionRequestGcp.Builder.get();
        ElastigroupDeletionRequestGcp        deletionRequest =
                deletionBuilder.setElastigroupId(elastigroupId).build();

        Boolean successfulDeletion = client.deleteElastigroup(deletionRequest);
        if (successfulDeletion) {
            System.out.println("Elastigroup succesfully deleted: " + elastigroupId);
        }
    }

    private static List<ElastigroupGcp> getAllElastigroups(SpotinstElastigroupClientGcp client) {

        ElastigroupGetAllRequestGcp.Builder requestBuilder = ElastigroupGetAllRequestGcp.Builder.get();
        // todo oז: check again - ignores the filter - in the openApi there isnt query params, guess gcp doesnt support filter
        ElastigroupGetAllRequestGcp requestByName =
                requestBuilder.setName(SPOTINST_GROUP_NAME).setIncludeDeleted(true).build();
        return client.getAllElastigroups(requestByName);
    }

    private static void getElastigroupStatus(SpotinstElastigroupClientGcp elastigroupClient, String elastigroupId) {
        ElastigroupGetGroupInstanceStatusRequestGcp.Builder instanceHealthinessRequestBuilder =
                ElastigroupGetGroupInstanceStatusRequestGcp.Builder.get();

        ElastigroupGetGroupInstanceStatusRequestGcp instanceHealthinessRequest =
                instanceHealthinessRequestBuilder.setElastigroupId(elastigroupId).build();
        List<GroupActiveInstanceStatusGcp> elastigroupInstanceHealthinesses =
                elastigroupClient.getInstanceHealthiness(instanceHealthinessRequest);

        List<String> runningInstanceIds = elastigroupInstanceHealthinesses.stream().filter(instance ->
                                                                                                   instance.getStatusName() ==
                                                                                                   GroupActiveInstanceStatusEnumGcp.running)
                                                                          .map(GroupActiveInstanceStatusGcp::getInstanceName)
                                                                          .collect(Collectors.toList());

        List<String> terminatedInstanceIds = elastigroupInstanceHealthinesses.stream().filter(instance ->
                                                                                                      instance.getStatusName() ==
                                                                                                      GroupActiveInstanceStatusEnumGcp.terminated)
                                                                            .map(GroupActiveInstanceStatusGcp::getInstanceName)
                                                                            .collect(Collectors.toList());

        List<String> provisioningInstanceIds = elastigroupInstanceHealthinesses.stream().filter(instance ->
                                                                                                        instance.getStatusName() ==
                                                                                                        GroupActiveInstanceStatusEnumGcp.provisioning)
                                                                                   .map(GroupActiveInstanceStatusGcp::getInstanceName)
                                                                                   .collect(Collectors.toList());

        List<String> stoppingInstanceIds = elastigroupInstanceHealthinesses.stream().filter(instance ->
                                                                                                    instance.getStatusName() ==
                                                                                                    GroupActiveInstanceStatusEnumGcp.stopping)
                                                                                .map(GroupActiveInstanceStatusGcp::getInstanceName)
                                                                                .collect(Collectors.toList());

        List<String> stagingInstanceIds = elastigroupInstanceHealthinesses.stream().filter(instance ->
                                                                                                   instance.getStatusName() ==
                                                                                                   GroupActiveInstanceStatusEnumGcp.staging)
                                                                            .map(GroupActiveInstanceStatusGcp::getInstanceName)
                                                                            .collect(Collectors.toList());

        System.out.println(String.format("%s Running status instances: %s", runningInstanceIds.size(), runningInstanceIds));
        System.out.println(
                String.format("%s Terminated status instances: %s", terminatedInstanceIds.size(), terminatedInstanceIds));
        System.out.println(
                String.format("%s Provisioning status instances: %s", provisioningInstanceIds.size(),
                              provisioningInstanceIds));
        System.out.println(String.format("%s Stopping status instances: %s", stoppingInstanceIds.size(),
                                         stoppingInstanceIds));
        System.out.println(String.format("%s Staging status instances: %s", stagingInstanceIds.size(),
                                         stagingInstanceIds));
    }

    private static ElastigroupGcp getGroup(SpotinstElastigroupClientGcp client, String groupId) {

        ElastigroupGetRequestGcp.Builder requestBuilder = ElastigroupGetRequestGcp.Builder.get();
        ElastigroupGetRequestGcp requestById = requestBuilder.setElastigroupId(groupId).build();
        ElastigroupGcp group = client.getElastigroup(requestById);

        return group;

    }

    private static void sleep(Integer seconds) {
        for (Integer i = 0; i < seconds; i++) {
            try {
                Thread.sleep(1000);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
            if ((i % 5) == 0 && i > 0) {
                System.out.println(i + " seconds have passed.");
            }
        }

    }
}



