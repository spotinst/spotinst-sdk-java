package com.spotinst.sdkjava.model;

import com.spotinst.sdkjava.model.bl.admin.messageCenter.*;
import com.spotinst.sdkjava.model.requests.admin.messageCenter.ListAllMessagesRequest;

import java.util.List;

public interface IMessageCenterRepo extends IRepository<CreateMessage, Void, String> {

    RepoGenericResponse<Boolean> create(CreateMessage messageToCreate, String authToken);

    RepoGenericResponse<List<GetMessageResponse>> getAll(ListAllMessagesRequest listAllMessagesRequest, String authToken);

    RepoGenericResponse<Boolean> update(UpdateMessage messageToUpdate, String messageId, String authToken);

    RepoGenericResponse<Boolean> bulkUpdate(BulkUpdateMessages messageToUpdate, String authToken);

    RepoGenericResponse<Boolean> bulkDelete(BulkDeleteMessages messageToDelete, String authToken);

    RepoGenericResponse<Boolean> delete(String messageId, String authToken);

}
