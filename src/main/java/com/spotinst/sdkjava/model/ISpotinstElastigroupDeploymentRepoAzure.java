package com.spotinst.sdkjava.model;

import com.spotinst.sdkjava.model.bl.azure.elastiGroup.V3.Deployment.GroupDeploymentAzure;
import com.spotinst.sdkjava.model.filters.SortFilter;
import com.spotinst.sdkjava.model.bl.azure.elastiGroup.V3.Deployment.DeploymentDetails.GroupDeploymentDetailsAzure;

import java.util.List;


interface ISpotinstElastigroupDeploymentRepoAzure {

    RepoGenericResponse<GroupDeploymentAzure> get(String deploymentId, String authToken, String account, String groupId);

    RepoGenericResponse<List<GroupDeploymentAzure>> getAll(SortFilter filter, String authToken, String account, String groupId);

    RepoGenericResponse<GroupDeploymentAzure> create(GroupDeploymentCreationRequestAzure creationRequestAzure, String authToken, String account, String groupId);

    RepoGenericResponse<GroupDeploymentDetailsAzure> getDetails(String deploymentId, String authToken, String account, String groupId);

}
