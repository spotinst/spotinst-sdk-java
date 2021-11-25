package com.spotinst.sdkjava.model.repo.azure.statefulNode;

import com.spotinst.sdkjava.exception.ExceptionHelper;
import com.spotinst.sdkjava.exception.SpotinstHttpException;
import com.spotinst.sdkjava.model.ISpotAzureStatefulNodeRepo;
import com.spotinst.sdkjava.model.RepoGenericResponse;
import com.spotinst.sdkjava.model.api.azure.statefulNode.ApiStatefulNode;
import com.spotinst.sdkjava.model.bl.azure.statefulNode.StatefulNode;
import com.spotinst.sdkjava.model.converters.azure.statefulNode.StatefulNodeConverter;
import com.spotinst.sdkjava.model.service.azure.statefulNode.SpotinstAzureStatefulNodeService;


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


}
