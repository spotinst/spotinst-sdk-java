package com.spotinst.sdkjava.model;

import com.spotinst.sdkjava.exception.ExceptionHelper;
import com.spotinst.sdkjava.exception.SpotinstHttpException;
import com.spotinst.sdkjava.model.api.azure.elastiGroup.V3.Deployment.ApiCreateDeploymentAzure;
import com.spotinst.sdkjava.model.api.azure.elastiGroup.V3.Deployment.ApiGetDeploymentAzure;
import com.spotinst.sdkjava.model.api.azure.elastiGroup.V3.Deployment.ApiGroupDeploymentDetailsAzure;
import com.spotinst.sdkjava.model.api.azure.elastiGroup.V3.Deployment.ApiGroupDeploymentRequestAzure;
import com.spotinst.sdkjava.model.bl.azure.elastiGroup.V3.Deployment.DeploymentDetails.GroupDeploymentDetailsAzure;
import com.spotinst.sdkjava.model.bl.azure.elastiGroup.V3.Deployment.GroupDeploymentCreateAzure;
import com.spotinst.sdkjava.model.bl.azure.elastiGroup.V3.Deployment.GroupDeploymentGetAzure;
import com.spotinst.sdkjava.model.converters.ElastigroupDeploymentConverterAzure;
import com.spotinst.sdkjava.model.converters.ElastigroupDeploymentDetailsConverterAzure;
import com.spotinst.sdkjava.model.filters.SortQueryParam;

import java.util.List;
import java.util.stream.Collectors;

public class SpotinstElastigroupDeploymentRepoAzure implements ISpotinstElastigroupDeploymentRepoAzure {

    public RepoGenericResponse<GroupDeploymentCreateAzure> create(
            GroupDeploymentCreationRequestAzure deploymentCreationRequestAzure, String authToken, String account,
            String groupId) {
        RepoGenericResponse<GroupDeploymentCreateAzure> retVal;
        SpotinstElastigroupServiceAzure                 serviceAzure = new SpotinstElastigroupServiceAzure();

        try {
            ApiGroupDeploymentRequestAzure apiDeploymentCreationRequest =
                    ElastigroupDeploymentConverterAzure.toDal(deploymentCreationRequestAzure);

            ApiCreateDeploymentAzure apiCreatedDeployment =
                    serviceAzure.createDeployment(apiDeploymentCreationRequest, authToken, account, groupId);
            GroupDeploymentCreateAzure
                    createdDeployment = ElastigroupDeploymentConverterAzure.toBlCreate(apiCreatedDeployment);
            retVal = new RepoGenericResponse<>(createdDeployment);
        }
        catch (SpotinstHttpException ex) {
            retVal = ExceptionHelper.handleHttpException(ex);
        }

        return retVal;
    }

    public RepoGenericResponse<List<GroupDeploymentGetAzure>> getAll(String groupId, String authToken, String account,
                                                                     Integer limit, SortQueryParam sortQueryParam) {
        RepoGenericResponse<List<GroupDeploymentGetAzure>> retVal;
        SpotinstElastigroupServiceAzure                       serviceAzure = new SpotinstElastigroupServiceAzure();

        try {
            List<ApiGetDeploymentAzure> apiDeployments =
                    serviceAzure.getAllDeployments(groupId, authToken, account, limit, sortQueryParam);

            List<GroupDeploymentGetAzure> deployments =
                    apiDeployments.stream().map(ElastigroupDeploymentConverterAzure::toBlGet).collect(Collectors.toList());

            retVal = new RepoGenericResponse<>(deployments);
        }
        catch (SpotinstHttpException ex) {
            retVal = ExceptionHelper.handleHttpException(ex);
        }

        return retVal;
    }

    public RepoGenericResponse<GroupDeploymentGetAzure> get(String deploymentId, String authToken, String account,
                                                               String groupId) {
        RepoGenericResponse<GroupDeploymentGetAzure> retVal;
        SpotinstElastigroupServiceAzure                 serviceAzure = new SpotinstElastigroupServiceAzure();

        try {
            ApiGetDeploymentAzure apiDeployment =
                    serviceAzure.getDeployment(deploymentId, authToken, account, groupId);

            GroupDeploymentGetAzure deployment = ElastigroupDeploymentConverterAzure.toBlGet(apiDeployment);

            retVal = new RepoGenericResponse<>(deployment);
        }
        catch (SpotinstHttpException ex) {
            retVal = ExceptionHelper.handleHttpException(ex);
        }

        return retVal;
    }

    public RepoGenericResponse<GroupDeploymentDetailsAzure> getDetails(String deploymentId, String authToken, String account,
                                                                String groupId) {
        RepoGenericResponse<GroupDeploymentDetailsAzure> retVal;
        SpotinstElastigroupServiceAzure           serviceAzure = new SpotinstElastigroupServiceAzure();

        try {
            ApiGroupDeploymentDetailsAzure apiDeployment = serviceAzure.getDeploymentDetails(deploymentId, authToken, account, groupId);

            GroupDeploymentDetailsAzure deployment = ElastigroupDeploymentDetailsConverterAzure.toBl(apiDeployment);

            retVal = new RepoGenericResponse<>(deployment);
        }
        catch (SpotinstHttpException ex) {
            retVal = ExceptionHelper.handleHttpException(ex);
        }

        return retVal;
    }

}
