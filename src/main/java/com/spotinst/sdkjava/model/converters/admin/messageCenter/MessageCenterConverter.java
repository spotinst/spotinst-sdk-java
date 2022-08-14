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
            if (createMessage.isIsStarredSet()) {
                apiCreateMessage.setIsStarred(createMessage.getStarred());
            }
            if (createMessage.isMarkedReadAtSet()) {
                apiCreateMessage.setMarkedReadAt(createMessage.getMarkedReadAt());
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

    public static GetMessage toBl(ApiGetMessage apiGetMessage) {
        GetMessage getMessage = null;

        if (apiGetMessage != null) {
            getMessage = new GetMessage();

            if (apiGetMessage.isIdSet()) {
                getMessage.setId(apiGetMessage.getId());
            }
            if (apiGetMessage.isMarkedReadAtSet()) {
                getMessage.setMarkedReadAt(apiGetMessage.getMarkedReadAt());
            }
            if (apiGetMessage.isIsStarredSet()) {
                getMessage.setIsStarred(apiGetMessage.getIsStarred());
            }
            if (apiGetMessage.isMetadataSet()) {
                Metadata metadata = MessageCenterConverter.toBl(apiGetMessage.getMetadata());
                getMessage.setMetadata(metadata);
            }
            if (apiGetMessage.isTitleSet()) {
                getMessage.setTitle(apiGetMessage.getTitle());
            }
            if (apiGetMessage.isContentSet()) {
                getMessage.setContent(apiGetMessage.getContent());
            }
            if (apiGetMessage.isStickyUntilSet()) {
                getMessage.setStickyUntil(apiGetMessage.getStickyUntil());
            }
            if (apiGetMessage.isTypeSet()) {
                getMessage.setType(apiGetMessage.getType());
            }
            if (apiGetMessage.isMainIconSet()) {
                getMessage.setMainIcon(apiGetMessage.getMainIcon());
            }
            if (apiGetMessage.isHyperlinkSet()) {
                getMessage.setHyperlink(apiGetMessage.getHyperlink());
            }
            if (apiGetMessage.isSecondaryIconSet()) {
                getMessage.setSecondaryIcon(apiGetMessage.getSecondaryIcon());
            }
            if (apiGetMessage.isTimestampSet()) {
                getMessage.setTimestamp(apiGetMessage.getTimestamp());
            }

        }

        return getMessage;
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