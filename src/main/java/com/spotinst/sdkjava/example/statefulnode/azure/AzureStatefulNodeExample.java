package com.spotinst.sdkjava.example.statefulnode.azure;

import com.spotinst.sdkjava.SpotinstClient;
import com.spotinst.sdkjava.model.SpotinstAzureStatefulNodeClient;
import com.spotinst.sdkjava.model.bl.azure.statefulNode.StatefulNode;
import com.spotinst.sdkjava.model.requests.azure.statefulNode.StatefulNodeCreationRequest;

public class AzureStatefulNodeExample {

    private final static String auth_token = "auth_token";
    private final static String act_id     = "act-id";


    public static void main(String[] args) throws InterruptedException {

        SpotinstAzureStatefulNodeClient nodeClient = SpotinstClient.getAzureStatefulNodeClient(auth_token, act_id);

        System.out.println("----------Creation of azure stateful node--------------");
        String nodeId = createStatefulNode(nodeClient);


    }

    private static String createStatefulNode(SpotinstAzureStatefulNodeClient client) {

        // Build Stateful Node
        StatefulNode.Builder statefulNodeBuilder = StatefulNode.Builder.get();
        StatefulNode statefulNode = statefulNodeBuilder.setName("Automation-java-SDK-StatefulNode-Bansi").setRegion("eastus").setResourceGroupName("ManualQAResourceGroup")
                                                       .setDescription("stateful node for tests").build();
                                                       //.setCompute(compute).setStrategy(strategy).setScheduling(scheduling).setPersistent(persistent).setHealth(health).build();

        // Build node creation request
        StatefulNodeCreationRequest.Builder nodeCreationRequestBuilder =  StatefulNodeCreationRequest.Builder.get();
        StatefulNodeCreationRequest creationRequest  = nodeCreationRequestBuilder.setNode(statefulNode).build();

        // Convert node to API object json
        System.out.println(creationRequest.toJson());

        // Create stateful Node
        StatefulNode createdNode = client.createNode(creationRequest);
        System.out.println("Cluster successfully created: " + createdNode.getId());

        return createdNode.getId();

    }


}