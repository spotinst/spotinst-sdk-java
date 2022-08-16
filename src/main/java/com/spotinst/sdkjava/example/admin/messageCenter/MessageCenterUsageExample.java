package com.spotinst.sdkjava.example.admin.messageCenter;

import com.spotinst.sdkjava.SpotinstClient;
import com.spotinst.sdkjava.enums.admin.messageCenter.AudienceSpecificationEnum;
import com.spotinst.sdkjava.enums.admin.messageCenter.MessageTypeEnum;
import com.spotinst.sdkjava.model.SpotInstMessageCenterClient;
import com.spotinst.sdkjava.model.bl.admin.messageCenter.*;
import com.spotinst.sdkjava.model.requests.admin.messageCenter.ListAllMessagesRequest;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class MessageCenterUsageExample {
    private final static String authToken = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzcG90aW5zdCIsInVpZCI6MTksIm9pZCI6IjExMTExMTExMTExIiwiZXhwIjoxNzUzOTg5NzQ1MTI3LCJpYXQiOjE0Mzg2Mjk3NDV9.K5SYp7shXRh79y_409eLrq_VFKShkyVG4JloWPdy4l4";
    private final static String user_authToken = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJzcG90aW5zdCIsImV4cCI6MTk3NTQ2NjI2NSwiaWF0IjoxNjYwMTA2MjY1LCJ1aWQiOjM4NTIyLCJyb2xlIjoyLCJvaWQiOiI2MDYwNzk4NzQ1MDMifQ.HTTnsruBBADg8nkMYKJXwJtD9SDQ5OwRvKVppwpikIo";

    private final static Long userSpecificationOrganizationId = 606079874503L;
    private final static ArrayList<Long> userIds = new ArrayList<Long>(Arrays.asList(38522L,84402L));

    public static void main(String[] args) throws IOException {

        SpotInstMessageCenterClient spotInstMessageCenterClient = SpotinstClient.getMessageCenterClient(authToken);

        //Create message
        System.out.println("----------Creation of local/global message--------------");
        if(createMessage(spotInstMessageCenterClient)){
            System.out.println("Message has created successfully");
        }
        spotInstMessageCenterClient = SpotinstClient.getMessageCenterClient(user_authToken);

        //Get All Messages
        System.out.println("----------list all created messages--------------");
        List<GetMessageResponse> allMessages = getAllMessages(spotInstMessageCenterClient);

        //Update a message
        System.out.println("----------update a message--------------");
        updateMessages(spotInstMessageCenterClient,allMessages.get(0).getId());

        //Bulk Update messages
        System.out.println("----------bulk update for multiple messages--------------");
        bulkUpdateMessages(spotInstMessageCenterClient,allMessages.get(0).getId(),allMessages.get(1).getId());

        //Bulk Delete messages
        System.out.println("----------bulk delete messages--------------");
        bulkDeleteMessages(spotInstMessageCenterClient,allMessages.get(2).getId(),allMessages.get(3).getId());

        //Delete messages
        System.out.println("----------Delete a message--------------");
        deleteMessage(spotInstMessageCenterClient,allMessages.get(2).getId());

    }

    private static Boolean createMessage(SpotInstMessageCenterClient client) {

        CreateMessage.Builder createMessageBuilder = CreateMessage.Builder.get();
        UserAudienceSpecification.Builder userAudienceSpecificationBuilder = UserAudienceSpecification.Builder.get();


        UserAudienceSpecification userAudienceSpecification = userAudienceSpecificationBuilder.setUserIds(userIds)
                                                                                                .setOrganizationId(userSpecificationOrganizationId).build();

        SimpleDateFormat formatter    = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        String           dateInString = "2022-08-31T10:41:39.809Z";
        Date date         = null;
        try {
            date = formatter.parse(dateInString);
        }
        catch (ParseException e) {
            e.printStackTrace();
        }

        CreateMessage messageRequest = createMessageBuilder.setTitle("Automation Sdk Test Message")
                                                            .setContent("Automation Test Content")
                                                            .setStickyUntil("null")
                                                            .setType(MessageTypeEnum.NOTIFICATION_POLICY)
                                                            .setMainIcon("sad.png")
                                                            .setHyperlink("http://very-sad.com")
                                                            .setSecondaryIcon("superSad.svg")
                                                            .setTimestamp(date)
                                                            .setAudienceSpecification(AudienceSpecificationEnum.USER)
                                                            .setUserAudienceSpecification(new ArrayList<UserAudienceSpecification>(Arrays.asList(userAudienceSpecification))).build();

        Boolean status = client.createMessage(messageRequest);
        return status;
    }

    private static List<GetMessageResponse> getAllMessages(SpotInstMessageCenterClient spotInstMessageCenterClient) {
        // Build request
        ListAllMessagesRequest.Builder listAllMessagesRequest = ListAllMessagesRequest.Builder.get();
        ListAllMessagesRequest request = listAllMessagesRequest.setLimit(100).build();
        List<GetMessageResponse> allMessages = spotInstMessageCenterClient.getAllMessages(request);
        return allMessages;
    }

    private static void updateMessages(SpotInstMessageCenterClient spotInstMessageCenterClient,String messageId) {
        // Build request
        SimpleDateFormat formatter    = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        String           dateInString = "2022-07-31T10:41:39.809Z";
        Date date         = null;
        try {
            date = formatter.parse(dateInString);
        }
        catch (ParseException e) {
            e.printStackTrace();
        }
        UpdateMessage.Builder updateMessageBuilder = UpdateMessage.Builder.get();
        UpdateMessage messageRequest = updateMessageBuilder.setIsStarred(true).setMarkedReadAt(date).build();
        Boolean status = spotInstMessageCenterClient.updateMessage(messageRequest,messageId);
        System.out.println(status);
    }

    private static void bulkUpdateMessages(SpotInstMessageCenterClient spotInstMessageCenterClient,String... messageIds) {
        // Build request
        SimpleDateFormat formatter    = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        String           dateInString = "2022-07-31T10:41:39.809Z";
        Date date         = null;
        try {
            date = formatter.parse(dateInString);
        }
        catch (ParseException e) {
            e.printStackTrace();
        }

        Entities.Builder entities_object1_builder =  Entities.Builder.get();
        Entities entities_object1 = entities_object1_builder.setIsStarred(true).setMessageId(messageIds[0]).build();

        Entities.Builder entities_object2_builder =  Entities.Builder.get();
        Entities entities_object2 = entities_object2_builder.setIsStarred(true).setMarkedReadAt(date).setMessageId(messageIds[1]).build();

        BulkUpdateMessages.Builder updateMessageBuilder = BulkUpdateMessages.Builder.get();
        BulkUpdateMessages messageRequest = updateMessageBuilder.setEntities(new ArrayList<>(Arrays.asList(entities_object1,entities_object2))).build();
        Boolean status = spotInstMessageCenterClient.bulkUpdateMessages(messageRequest);
        System.out.println(status);
    }

    private static void bulkDeleteMessages(SpotInstMessageCenterClient spotInstMessageCenterClient,String... messageIds) {
        // Build request
        BulkDeleteMessages.Builder deleteMessageBuilder = BulkDeleteMessages.Builder.get();
        BulkDeleteMessages messageRequest = deleteMessageBuilder.setIds(new ArrayList<>(Arrays.asList(messageIds))).build();
        Boolean status = spotInstMessageCenterClient.bulkDeleteMessages(messageRequest);
        System.out.println(status);
    }

    private static void deleteMessage(SpotInstMessageCenterClient spotInstMessageCenterClient,String messageId) {
        // Build request
        Boolean status = spotInstMessageCenterClient.deleteMessage(messageId);
        System.out.println(status);
    }
}
