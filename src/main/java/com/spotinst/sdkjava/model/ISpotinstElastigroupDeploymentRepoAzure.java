package com.spotinst.sdkjava.model;

import com.spotinst.sdkjava.model.bl.azure.elastiGroup.V3.Deployment.GroupDeploymentCreateAzure;
import com.spotinst.sdkjava.model.bl.azure.elastiGroup.V3.Deployment.GroupDeploymentGetAzure;
import com.spotinst.sdkjava.model.filters.SortQueryParam;
import com.spotinst.sdkjava.model.bl.azure.elastiGroup.V3.Deployment.DeploymentDetails.GroupDeploymentDetailsAzure;

import java.util.List;


interface ISpotinstElastigroupDeploymentRepoAzure {

    RepoGenericResponse<GroupDeploymentGetAzure> get(String deploymentId, String authToken, String account, String groupId);

    RepoGenericResponse<List<GroupDeploymentGetAzure>> getAll(String groupId, String authToken, String account, Integer limit, SortQueryParam sortQueryParam);

    RepoGenericResponse<GroupDeploymentCreateAzure> create(GroupDeploymentCreationRequestAzure creationRequestAzure, String authToken, String account, String groupId);

    RepoGenericResponse<GroupDeploymentDetailsAzure> getDetails(String deploymentId, String authToken, String account, String groupId);

}
