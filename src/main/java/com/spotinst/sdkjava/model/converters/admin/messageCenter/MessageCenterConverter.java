package com.spotinst.sdkjava.model.converters.admin.messageCenter;

import com.spotinst.sdkjava.model.api.admin.messageCenter.*;
import com.spotinst.sdkjava.model.bl.admin.messageCenter.*;

import java.util.List;
import java.util.stream.Collectors;

public class MessageCenterConverter {

    //region BL -> DAL

    public static ApiBulkDeleteMessages toDal(BulkDeleteMessages bulkDeleteMessages) {
        ApiBulkDeleteMessages apiBulkDeleteMessages = null;

        if (bulkDeleteMessages != null) {
            apiBulkDeleteMessages = new ApiBulkDeleteMessages();

            if (bulkDeleteMessages.isIdsSet()) {
                apiBulkDeleteMessages.setIds(bulkDeleteMessages.getIds());
            }
        }
        return apiBulkDeleteMessages;
    }

    public static ApiEntities toDal(Entities entities) {
        ApiEntities apiEntities = null;

        if (entities != null) {
            apiEntities = new ApiEntities();

            if (entities.isIsStarredSet()) {
                apiEntities.setIsStarred(entities.getIsStarred());
            }
            if (entities.isMarkedReadAtSet()) {
                apiEntities.setMarkedReadAt(entities.getMarkedReadAt());
            }
            if (entities.isMessageIdSet()) {
                apiEntities.setMessageId(entities.getMessageId());
            }
        }
        return apiEntities;
    }

    public static ApiBulkUpdateMessages toDal(BulkUpdateMessages bulkUpdateMessages) {
        ApiBulkUpdateMessages apiBulkUpdateMessages = null;

        if (bulkUpdateMessages != null) {
            apiBulkUpdateMessages = new ApiBulkUpdateMessages();

            if (bulkUpdateMessages.isEntitiesSet()) {
                List<ApiEntities> apiEntities = bulkUpdateMessages.getEntities()
                        .stream().map(MessageCenterConverter::toDal).collect(Collectors.toList());
                apiBulkUpdateMessages.setEntities(apiEntities);
            }
        }
        return apiBulkUpdateMessages;
    }

    public static ApiUpdateMessage toDal(UpdateMessage updateMessage) {
        ApiUpdateMessage apiUpdateMessage = null;

        if (updateMessage != null) {
            apiUpdateMessage = new ApiUpdateMessage();

            if (updateMessage.isIsStarredSet()) {
                apiUpdateMessage.setIsStarred(updateMessage.getIsStarred());
            }
            if (updateMessage.isMarkedReadAtSet()) {
                apiUpdateMessage.setMarkedReadAt(updateMessage.getMarkedReadAt());
            }
        }
        return apiUpdateMessage;
    }

    public static ApiCreateMessage toDal(CreateMessage createMessage) {
        ApiCreateMessage apiCreateMessage = null;

        if (createMessage != null) {
            apiCreateMessage = new ApiCreateMessage();

            if (createMessage.isTitleSet()) {
                apiCreateMessage.setTitle(createMessage.getTitle());
            }
            if (createMessage.isContentSet()) {
                apiCreateMessage.setContent(createMessage.getContent());
            }
            if (createMessage.isStickyUntilSet()) {
                apiCreateMessage.setStickyUntil(createMessage.getStickyUntil());
            }
            if (createMessage.isTypeSet()) {
                apiCreateMessage.setType(createMessage.getType());
            }
            if (createMessage.isMainIconSet()) {
                apiCreateMessage.setMainIcon(createMessage.getMainIcon());
            }
            if (createMessage.isHyperlinkSet()) {
                apiCreateMessage.setHyperlink(createMessage.getHyperlink());
            }
            if (createMessage.isSecondaryIconSet()) {
                apiCreateMessage.setSecondaryIcon(createMessage.getSecondaryIcon());
            }
            if (createMessage.isTimestampSet()) {
                apiCreateMessage.setTimestamp(createMessage.getTimestamp());
            }
            if (createMessage.isAudienceSpecificationSet()) {
                apiCreateMessage.setAudienceSpecification(createMessage.getAudienceSpecification());
            }
            if (createMessage.isOrganizationAudienceSpecificationSet()) {
                apiCreateMessage.setOrganizationAudienceSpecification(createMessage.getOrganizationAudienceSpecification());
            }
            if (createMessage.isUserAudienceSpecificationSet()) {
                List<ApiUsersAudienceSpecification> apiUsersAudienceSpecification = createMessage.getUserAudienceSpecification()
                        .stream().map(MessageCenterConverter::toDal).collect(Collectors.toList());
                apiCreateMessage.setUserAudienceSpecification(apiUsersAudienceSpecification);
            }
        }

        return apiCreateMessage;
    }

    private static ApiUsersAudienceSpecification toDal(UserAudienceSpecification userOrganizationMapping) {
        ApiUsersAudienceSpecification apiUsersAudienceSpecification = null;

        if (userOrganizationMapping != null) {
            apiUsersAudienceSpecification = new ApiUsersAudienceSpecification();

            if (userOrganizationMapping.isOrganizationIdSet()) {
                apiUsersAudienceSpecification.setOrganizationId(userOrganizationMapping.getOrganizationId());
            }
            if (userOrganizationMapping.isUserIdsSet()) {
                apiUsersAudienceSpecification.setUserIds(userOrganizationMapping.getUserIds());
            }

        }

        return apiUsersAudienceSpecification;
    }

    public static GetMessageResponse toBl(ApiGetMessageResponse apiGetMessageResponse) {
        GetMessageResponse getMessageResponse = null;

        if (apiGetMessageResponse != null) {
            getMessageResponse = new GetMessageResponse();

            if (apiGetMessageResponse.isIdSet()) {
                getMessageResponse.setId(apiGetMessageResponse.getId());
            }
            if (apiGetMessageResponse.isMarkedReadAtSet()) {
                getMessageResponse.setMarkedReadAt(apiGetMessageResponse.getMarkedReadAt());
            }
            if (apiGetMessageResponse.isIsStarredSet()) {
                getMessageResponse.setIsStarred(apiGetMessageResponse.getIsStarred());
            }
            if (apiGetMessageResponse.isMetadataSet()) {
                Metadata metadata = MessageCenterConverter.toBl(apiGetMessageResponse.getMetadata());
                getMessageResponse.setMetadata(metadata);
            }
            if (apiGetMessageResponse.isTitleSet()) {
                getMessageResponse.setTitle(apiGetMessageResponse.getTitle());
            }
            if (apiGetMessageResponse.isContentSet()) {
                getMessageResponse.setContent(apiGetMessageResponse.getContent());
            }
            if (apiGetMessageResponse.isStickyUntilSet()) {
                getMessageResponse.setStickyUntil(apiGetMessageResponse.getStickyUntil());
            }
            if (apiGetMessageResponse.isTypeSet()) {
                getMessageResponse.setType(apiGetMessageResponse.getType());
            }
            if (apiGetMessageResponse.isMainIconSet()) {
                getMessageResponse.setMainIcon(apiGetMessageResponse.getMainIcon());
            }
            if (apiGetMessageResponse.isHyperlinkSet()) {
                getMessageResponse.setHyperlink(apiGetMessageResponse.getHyperlink());
            }
            if (apiGetMessageResponse.isSecondaryIconSet()) {
                getMessageResponse.setSecondaryIcon(apiGetMessageResponse.getSecondaryIcon());
            }
            if (apiGetMessageResponse.isTimestampSet()) {
                getMessageResponse.setTimestamp(apiGetMessageResponse.getTimestamp());
            }

        }

        return getMessageResponse;
    }

    public static Metadata toBl(ApiMetadata apiMetadata) {
        Metadata metadata = null;

        if (apiMetadata != null) {
            metadata = new Metadata();

            if (apiMetadata.isBannerSet()) {
                metadata.setBanner(apiMetadata.getBanner());
            }
        }
        return metadata;
    }
}