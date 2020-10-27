package com.spotinst.sdkjava.model;

import com.spotinst.sdkjava.exception.ExceptionHelper;
import com.spotinst.sdkjava.exception.SpotinstHttpException;
import com.spotinst.sdkjava.model.api.azure.elastiGroup.V3.Deployment.ApiDeploymentAzure;
import com.spotinst.sdkjava.model.api.azure.elastiGroup.V3.Deployment.ApiGroupDeploymentDetailsAzure;
import com.spotinst.sdkjava.model.api.azure.elastiGroup.V3.Deployment.ApiGroupDeploymentRequestAzure;
import com.spotinst.sdkjava.model.bl.azure.elastiGroup.V3.Deployment.DeploymentDetails.GroupDeploymentDetailsAzure;
import com.spotinst.sdkjava.model.bl.azure.elastiGroup.V3.Deployment.GroupDeploymentAzure;
import com.spotinst.sdkjava.model.converters.ElastigroupDeploymentConverterAzure;
import com.spotinst.sdkjava.model.converters.ElastigroupDeploymentDetailsConverterAzure;
import com.spotinst.sdkjava.model.filters.SortFilter;

import java.util.List;
import java.util.stream.Collectors;

public class SpotinstElastigroupDeploymentRepoAzure implements ISpotinstElastigroupDeploymentRepoAzure {

    public RepoGenericResponse<GroupDeploymentAzure> create(
            GroupDeploymentCreationRequestAzure deploymentCreationRequestAzure, String authToken, String account,
            String groupId) {
        RepoGenericResponse<GroupDeploymentAzure> retVal;
        SpotinstElastigroupServiceAzure           serviceAzure = new SpotinstElastigroupServiceAzure();

        try {
            ApiGroupDeploymentRequestAzure apiDeploymentToCreate =
                    ElastigroupDeploymentConverterAzure.toDal(deploymentCreationRequestAzure);

            ApiDeploymentAzure apiCreatedDeployment =
                    serviceAzure.createDeployment(apiDeploymentToCreate, authToken, account, groupId);
            GroupDeploymentAzure createdDeployment = ElastigroupDeploymentConverterAzure.toBl(apiCreatedDeployment);
            retVal = new RepoGenericResponse<>(createdDeployment);
        }
        catch (SpotinstHttpException ex) {
            retVal = ExceptionHelper.handleHttpException(ex);
        }

        return retVal;
    }

    public RepoGenericResponse<List<GroupDeploymentAzure>> getAll(SortFilter filter, String authToken, String account,
                                                                  String groupId) {
        RepoGenericResponse<List<GroupDeploymentAzure>> retVal;
        SpotinstElastigroupServiceAzure                 serviceAzure = new SpotinstElastigroupServiceAzure();

        try {
            List<ApiDeploymentAzure> apiDeployments =
                    serviceAzure.getAllDeployments(filter, authToken, account, groupId);

            List<GroupDeploymentAzure> deployments =
                    apiDeployments.stream().map(ElastigroupDeploymentConverterAzure::toBl).collect(Collectors.toList());

            retVal = new RepoGenericResponse<>(deployments);
        }
        catch (SpotinstHttpException ex) {
            retVal = ExceptionHelper.handleHttpException(ex);
        }

        return retVal;
    }

    public RepoGenericResponse<GroupDeploymentAzure> get(String deploymentId, String authToken, String account,
                                                         String groupId) {
        RepoGenericResponse<GroupDeploymentAzure> retVal;
        SpotinstElastigroupServiceAzure           serviceAzure = new SpotinstElastigroupServiceAzure();

        try {
            ApiDeploymentAzure apiDeployment =
                    serviceAzure.getDeployment(deploymentId, authToken, account, groupId);

            GroupDeploymentAzure deployment = ElastigroupDeploymentConverterAzure.toBl(apiDeployment);

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
