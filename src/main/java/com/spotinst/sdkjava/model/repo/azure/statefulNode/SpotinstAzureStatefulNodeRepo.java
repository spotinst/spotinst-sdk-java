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
    public RepoGenericResponse<StatefulNode> create(StatefulNode clusterToCreate, String authToken, String account) {

        RepoGenericResponse<StatefulNode> retVal;

        try {
            ApiStatefulNode apiOceanGkeClusterToCreate = StatefulNodeConverter.toDal(clusterToCreate);
            ApiStatefulNode
                            apiCreatedNode          = SpotinstAzureStatefulNodeService
                    .createNode(apiOceanGkeClusterToCreate, authToken, account);

            StatefulNode createdOceanEcsCluster = StatefulNodeConverter.toBl(apiCreatedNode);
            retVal = new RepoGenericResponse<>(createdOceanEcsCluster);
        }
        catch (SpotinstHttpException ex) {
            retVal = ExceptionHelper.handleHttpException(ex);
        }

        return retVal;
    }
}
