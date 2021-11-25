package com.spotinst.sdkjava.model;

import com.spotinst.sdkjava.exception.HttpError;
import com.spotinst.sdkjava.exception.SpotinstHttpException;
import com.spotinst.sdkjava.model.bl.azure.statefulNode.StatefulNode;
import com.spotinst.sdkjava.model.requests.azure.statefulNode.StatefulNodeCreationRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;

public class SpotinstAzureStatefulNodeClient {
    private static final Logger                      LOGGER =
            LoggerFactory.getLogger(SpotinstAzureStatefulNodeClient.class);
    //Members
    private              String                      authToken;
    private              String                      account;
    private              ISpotAzureStatefulNodeRepo  spotAzureStatefulNodeRepo;

    //Constructor
    public SpotinstAzureStatefulNodeClient(String authToken, String account) {
        this.authToken = authToken;
        this.account = account;
        this.spotAzureStatefulNodeRepo = SpotinstRepoManager.getInstance().getSpotAzureStatefulNodeRepo();
    }

    private ISpotAzureStatefulNodeRepo getSpotAzureStatefulNodeRepo() {
        return spotAzureStatefulNodeRepo;

    }


    //Methods
    public StatefulNode createNode(StatefulNodeCreationRequest statefulNodeCreationRequest) {
        StatefulNode retVal;

        StatefulNode statefulNodeToCreate = statefulNodeCreationRequest.getNode();

        RepoGenericResponse<StatefulNode> creationResponse =
                getSpotAzureStatefulNodeRepo().createNode(statefulNodeToCreate, authToken, account);

        if (creationResponse.isRequestSucceed()) {
            retVal = creationResponse.getValue();
        }
        else {
            List<HttpError> httpExceptions = creationResponse.getHttpExceptions();
            HttpError       httpException  = httpExceptions.get(0);
            LOGGER.error(String.format(
                    "Error encountered while attempting to create Azure stateful Node. Code: %s. Message: %s.",
                    httpException.getCode(), httpException.getMessage()));
            throw new SpotinstHttpException(httpException.getMessage());
        }

        return retVal;
    }

    public StatefulNode getNode(String nodeId) {
        StatefulNode retVal;

        RepoGenericResponse<StatefulNode> getNodeResponse =
                getSpotAzureStatefulNodeRepo().getNode(nodeId, authToken, account);

        if (getNodeResponse.isRequestSucceed()) {
            retVal = getNodeResponse.getValue();
        }
        else {
            List<HttpError> httpExceptions = getNodeResponse.getHttpExceptions();
            HttpError       httpException  = httpExceptions.get(0);
            LOGGER.error(String.format(
                    "Error encountered while attempting to get Azure stateful Node. Code: %s. Message: %s.",
                    httpException.getCode(), httpException.getMessage()));
            throw new SpotinstHttpException(httpException.getMessage());
        }

        return retVal;
    }


}
