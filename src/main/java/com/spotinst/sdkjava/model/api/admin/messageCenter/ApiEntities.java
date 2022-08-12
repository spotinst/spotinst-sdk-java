package com.spotinst.sdkjava.model.api.admin.messageCenter;

import com.fasterxml.jackson.annotation.*;
import com.spotinst.sdkjava.client.rest.IPartialUpdateEntity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonFilter("PartialUpdateEntityFilter")
public class ApiEntities implements IPartialUpdateEntity {
    //region Members
    @JsonIgnore
    private Set<String> isSet;
    private String messageId;
    private Boolean isStarred;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    private Date markedReadAt;
    //endregion

    //region Getters & Setters
    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        isSet.add("messageId");
        this.messageId = messageId;
    }

    public Boolean getIsStarred() {
        return isStarred;
    }

    public void setIsStarred(Boolean isStarred) {
        isSet.add("isStarred");
        this.isStarred = isStarred;
    }

    public Date getMarkedReadAt() {
        return markedReadAt;
    }

    public void setMarkedReadAt(Date markedReadAt) {
        isSet.add("markedReadAt");
        this.markedReadAt = markedReadAt;
    }

    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    //endregion
    //region Constructor
    public ApiEntities() {
        isSet = new HashSet<>();
    }
    //endregion

    //region isSet methods
    // Is messageId Set boolean method
    @JsonIgnore
    public boolean isMessageIdSet() {
        return isSet.contains("messageId");
    }

    // Is starred Set boolean method
    @JsonIgnore
    public boolean isIsStarredSet() {
        return isSet.contains("isStarred");
    }

    // Is markedReadAt Set boolean method
    @JsonIgnore
    public boolean isMarkedReadAtSet() {
        return isSet.contains("markedReadAt");
    }

    //endregion
}
