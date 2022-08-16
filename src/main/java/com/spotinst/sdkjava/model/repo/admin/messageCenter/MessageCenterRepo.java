package com.spotinst.sdkjava.model.repo.admin.messageCenter;

import com.spotinst.sdkjava.exception.ExceptionHelper;
import com.spotinst.sdkjava.exception.SpotinstHttpException;
import com.spotinst.sdkjava.model.IMessageCenterRepo;
import com.spotinst.sdkjava.model.RepoGenericResponse;
import com.spotinst.sdkjava.model.api.admin.messageCenter.*;
import com.spotinst.sdkjava.model.bl.admin.messageCenter.*;
import com.spotinst.sdkjava.model.converters.admin.messageCenter.MessageCenterConverter;
import com.spotinst.sdkjava.model.requests.admin.messageCenter.ListAllMessagesRequest;
import com.spotinst.sdkjava.model.service.admin.messageCenter.MessageCenterService;

import java.util.List;
import java.util.stream.Collectors;

public class MessageCenterRepo implements IMessageCenterRepo {

    @Override
    public RepoGenericResponse<Boolean> create(CreateMessage messageToCreate, String authToken) {

        RepoGenericResponse<Boolean> retVal;
        try {
            ApiCreateMessage apiCreateMessage = MessageCenterConverter.toDal(messageToCreate);
            Boolean createMessageStatus = MessageCenterService.createMessage(apiCreateMessage,authToken);
            retVal = new RepoGenericResponse<>(createMessageStatus);

        }
        catch (SpotinstHttpException e) {
            retVal = ExceptionHelper.handleHttpException(e);
        }
        return retVal;
    }

    @Override
    public RepoGenericResponse<List<GetMessageResponse>> getAll(ListAllMessagesRequest listAllMessagesRequest, String authToken) {

        RepoGenericResponse<List<GetMessageResponse>> retVal;
        try {
            List<ApiGetMessageResponse> getAllMessages = MessageCenterService.getAllMessages(listAllMessagesRequest,authToken);
            List<GetMessageResponse> allMessages = getAllMessages.stream().map(MessageCenterConverter::toBl).collect(Collectors.toList());
            retVal = new RepoGenericResponse<>(allMessages);

        }
        catch (SpotinstHttpException e) {
        retVal = ExceptionHelper.handleHttpException(e);
        }
        return retVal;
    }

    @Override
    public RepoGenericResponse<Boolean> update(UpdateMessage messageToUpdate, String messageId, String authToken) {
        RepoGenericResponse<Boolean> retVal;
        try {
            ApiUpdateMessage apiMessageToUpdate = MessageCenterConverter.toDal(messageToUpdate);
            Boolean updateMessageStatus = MessageCenterService.updateMessage(apiMessageToUpdate,messageId,authToken);
            retVal = new RepoGenericResponse<>(updateMessageStatus);

        }
        catch (SpotinstHttpException e) {
            retVal = ExceptionHelper.handleHttpException(e);
        }
        return retVal;
    }

    @Override
    public RepoGenericResponse<Boolean> bulkUpdate(BulkUpdateMessages messagesToUpdate, String authToken) {
        RepoGenericResponse<Boolean> retVal;
        try {
            ApiBulkUpdateMessages apiMessageToUpdate = MessageCenterConverter.toDal(messagesToUpdate);
            Boolean updateMessageStatus = MessageCenterService.bulkUpdateMessages(apiMessageToUpdate,authToken);
            retVal = new RepoGenericResponse<>(updateMessageStatus);

        }
        catch (SpotinstHttpException e) {
            retVal = ExceptionHelper.handleHttpException(e);
        }
        return retVal;
    }

    @Override
    public RepoGenericResponse<Boolean> bulkDelete(BulkDeleteMessages messagesToDelete, String authToken) {
        RepoGenericResponse<Boolean> retVal;
        try {
            ApiBulkDeleteMessages apiBulkDeleteMessages = MessageCenterConverter.toDal(messagesToDelete);
            Boolean deleteMessageStatus = MessageCenterService.bulkDeleteMessages(apiBulkDeleteMessages,authToken);
            retVal = new RepoGenericResponse<>(deleteMessageStatus);
        }
        catch (SpotinstHttpException e) {
            retVal = ExceptionHelper.handleHttpException(e);
        }
        return retVal;
    }

    @Override
    public RepoGenericResponse<Boolean> delete(String messageId, String authToken) {
        RepoGenericResponse<Boolean> retVal;
        try {
            Boolean deleteMessageStatus = MessageCenterService.deleteMessage(messageId,authToken);
            retVal = new RepoGenericResponse<>(deleteMessageStatus);

        }
        catch (SpotinstHttpException e) {
            retVal = ExceptionHelper.handleHttpException(e);
        }
        return retVal;
    }
}
