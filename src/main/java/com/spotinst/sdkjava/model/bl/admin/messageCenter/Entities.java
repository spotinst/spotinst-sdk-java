package com.spotinst.sdkjava.model.bl.admin.messageCenter;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Entities {
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
    public Entities() {
        isSet = new HashSet<>();
    }
    //endregion

    //region Builder class
    public static class Builder {
        private Entities createMessage;

        private Builder() {
            this.createMessage = new Entities();
        }

        public static Builder get() {
            return new Builder();
        }

        public Builder setMessageId(String messageId) {
            createMessage.setMessageId(messageId);
            return this;
        }

        public Builder setIsStarred(Boolean isStarred) {
            createMessage.setIsStarred(isStarred);
            return this;
        }

        public Builder setMarkedReadAt(Date markedReadAt) {
            createMessage.setMarkedReadAt(markedReadAt);
            return this;
        }

        public Entities build() {
            return createMessage;
        }
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
