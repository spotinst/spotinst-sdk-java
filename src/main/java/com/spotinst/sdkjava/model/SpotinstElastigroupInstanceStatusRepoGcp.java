package com.spotinst.sdkjava.model;

import com.spotinst.sdkjava.exception.ExceptionHelper;
import com.spotinst.sdkjava.exception.SpotinstHttpException;
import com.spotinst.sdkjava.model.api.gcp.ApiGroupActiveInstanceStatusGcp;
import java.util.List;
import java.util.stream.Collectors;

public class SpotinstElastigroupInstanceStatusRepoGcp implements ISpotinstElastigroupInstanceStatusRepoGcp {

    @Override
    public RepoGenericResponse<List<GroupActiveInstanceStatusGcp>> getAll(String elastigroupId, String authToken,
                                                                          String account) {
        RepoGenericResponse<List<GroupActiveInstanceStatusGcp>> retVal;

        try {
            List<GroupActiveInstanceStatusGcp> groupActiveInstanceStatus;
            List<ApiGroupActiveInstanceStatusGcp> apiGroupActiveInstanceStatus =
                    SpotinstElastigroupServiceGcp.getGroupStatus(elastigroupId, authToken, account);

            groupActiveInstanceStatus =
                    apiGroupActiveInstanceStatus.stream().map(ApiElastigroupInstanceStatusConverterGcp::toBl)
                                            .collect(Collectors.toList());

            retVal = new RepoGenericResponse<>(groupActiveInstanceStatus);
        }
        catch (SpotinstHttpException ex) {
            retVal = ExceptionHelper.handleHttpException(ex);
        }

        return retVal;
    }
}