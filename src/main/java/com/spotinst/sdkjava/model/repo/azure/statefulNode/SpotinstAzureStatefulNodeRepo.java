package com.spotinst.sdkjava.model.repo.azure.statefulNode;

import com.spotinst.sdkjava.exception.ExceptionHelper;
import com.spotinst.sdkjava.exception.SpotinstHttpException;
import com.spotinst.sdkjava.model.ISpotAzureStatefulNodeRepo;
import com.spotinst.sdkjava.model.RepoGenericResponse;
import com.spotinst.sdkjava.model.api.azure.statefulNode.ApiStatefulNode;
import com.spotinst.sdkjava.model.api.azure.statefulNode.ApiStatefulNodeDeallocationConfig;
import com.spotinst.sdkjava.model.bl.azure.statefulNode.StatefulNode;
import com.spotinst.sdkjava.model.bl.azure.statefulNode.StatefulNodeDeallocationConfig;
import com.spotinst.sdkjava.model.converters.azure.statefulNode.StatefulNodeConverter;
import com.spotinst.sdkjava.model.service.azure.statefulNode.SpotinstAzureStatefulNodeService;
import com.sun.org.apache.xpath.internal.operations.Bool;


public class SpotinstAzureStatefulNodeRepo implements ISpotAzureStatefulNodeRepo {

    @Override
    public RepoGenericResponse<StatefulNode> createNode(StatefulNode NodeToCreate, String authToken, String account) {

        RepoGenericResponse<StatefulNode> retVal;

        try {
            ApiStatefulNode apiStatefulNodeToCreate = StatefulNodeConverter.toDal(NodeToCreate);
            ApiStatefulNode apiCreatedNode          = SpotinstAzureStatefulNodeService
                    .createNode(apiStatefulNodeToCreate, authToken, account);

            StatefulNode createdStatefulNode = StatefulNodeConverter.toBl(apiCreatedNode);
            retVal = new RepoGenericResponse<>(createdStatefulNode);
        }
        catch (SpotinstHttpException ex) {
            retVal = ExceptionHelper.handleHttpException(ex);
        }

        return retVal;
    }

    @Override
    public RepoGenericResponse<StatefulNode> getNode(String nodeId, String authToken, String account) {

        RepoGenericResponse<StatefulNode> retVal;

        try {
            ApiStatefulNode apiGetNode          = SpotinstAzureStatefulNodeService
                    .getNode(nodeId, authToken, account);

            StatefulNode getStatefulNode = StatefulNodeConverter.toBl(apiGetNode);
            retVal = new RepoGenericResponse<>(getStatefulNode);
        }
        catch (SpotinstHttpException ex) {
            retVal = ExceptionHelper.handleHttpException(ex);
        }

        return retVal;
    }


    @Override
    public RepoGenericResponse<StatefulNode> updateNode(StatefulNode NodeToUpdate ,String nodeId, String authToken, String account) {

        RepoGenericResponse<StatefulNode> retVal;

        try {
            ApiStatefulNode apiStatefulNodeToUpdate = StatefulNodeConverter.toDal(NodeToUpdate);
            ApiStatefulNode apiUpdatedNode =
                    SpotinstAzureStatefulNodeService.updateNode(apiStatefulNodeToUpdate, nodeId, authToken, account);

            StatefulNode updatedStatefulNode = StatefulNodeConverter.toBl(apiUpdatedNode);
            retVal = new RepoGenericResponse<>(updatedStatefulNode);
        }
        catch (SpotinstHttpException ex) {
            retVal = ExceptionHelper.handleHttpException(ex);
        }

        return retVal;
    }

    @Override
    public RepoGenericResponse<Boolean> deleteNode(StatefulNodeDeallocationConfig NodeToDelete , String nodeId, String authToken, String account) {

        RepoGenericResponse<Boolean> retVal;

        try {
            ApiStatefulNodeDeallocationConfig apiStatefulNodeToDelete = StatefulNodeConverter.toDal(NodeToDelete);
            Boolean apiDeletedNode =
                    SpotinstAzureStatefulNodeService.deleteNode(apiStatefulNodeToDelete, nodeId, authToken, account);

            retVal = new RepoGenericResponse<>(apiDeletedNode);
        }
        catch (SpotinstHttpException ex) {
            retVal = ExceptionHelper.handleHttpException(ex);
        }

        return retVal;
    }

}
