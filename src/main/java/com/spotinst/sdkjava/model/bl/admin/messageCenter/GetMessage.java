package com.spotinst.sdkjava.model.bl.admin.messageCenter;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GetMessage {
    //region Members
    @JsonIgnore
    private Set<String> isSet;
    private String title;
    private String content;
    private String stickyUntil;
    private String type;
    private String mainIcon;
    private String hyperlink;
    private String secondaryIcon;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    private Date timestamp;
    private String audienceSpecification;
    private List<Long>  organizationAudienceSpecification;
    private List<UserAudienceSpecification> userAudienceSpecification;
    private String id;
    private Boolean isStarred;
    private Date markedReadAt;
    private Metadata metadata;
    //endregion


    public String getId() {
        return id;
    }

    public void setId(String id) {
        isSet.add("id");
        this.id = id;
    }

    public Boolean getStarred() {
        return isStarred;
    }

    public void setStarred(Boolean starred) {
        isSet.add("isStarred");
        isStarred = starred;
    }

    public Date getMarkedReadAt() {
        return markedReadAt;
    }

    public void setMarkedReadAt(Date markedReadAt) {
        isSet.add("markedReadAt");
        this.markedReadAt = markedReadAt;
    }

    public Metadata getMetadata() {
        return metadata;
    }

    public void setMetadata(Metadata metadata) {
        isSet.add("metadata");
        this.metadata = metadata;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        isSet.add("title");
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        isSet.add("content");
        this.content = content;
    }

    public String getStickyUntil() {
        return stickyUntil;
    }

    public void setStickyUntil(String stickyUntil) {
        isSet.add("stickyUntil");
        this.stickyUntil = stickyUntil;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        isSet.add("type");
        this.type = type;
    }

    public String getMainIcon() {
        return mainIcon;
    }

    public void setMainIcon(String mainIcon) {
        isSet.add("mainIcon");
        this.mainIcon = mainIcon;
    }

    public String getHyperlink() {
        return hyperlink;
    }

    public void setHyperlink(String hyperlink) {
        isSet.add("hyperlink");
        this.hyperlink = hyperlink;
    }

    public String getSecondaryIcon() {
        return secondaryIcon;
    }

    public void setSecondaryIcon(String secondaryIcon) {
        isSet.add("secondaryIcon");
        this.secondaryIcon = secondaryIcon;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        isSet.add("timestamp");
        this.timestamp = timestamp;
    }

    public String getAudienceSpecification() {
        return audienceSpecification;
    }

    public void setAudienceSpecification(String audienceSpecification) {
        isSet.add("audienceSpecification");
        this.audienceSpecification = audienceSpecification;
    }

    public List<Long> getOrganizationAudienceSpecification() {
        return organizationAudienceSpecification;
    }

    public void setOrganizationAudienceSpecification(List<Long> organizationAudienceSpecification) {
        isSet.add("organizationAudienceSpecification");
        this.organizationAudienceSpecification = organizationAudienceSpecification;
    }

    public List<UserAudienceSpecification> getUserAudienceSpecification() {
        return userAudienceSpecification;
    }

    public void setUserAudienceSpecification(List<UserAudienceSpecification> userAudienceSpecification) {
        isSet.add("userAudienceSpecification");
        this.userAudienceSpecification = userAudienceSpecification;
    }

    //region Constructor
    public GetMessage() {
        isSet = new HashSet<>();
    }
    //endregion

    //region Getters & Setters
    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    //endregion

    //region Builder class
    public static class Builder {
        private GetMessage createMessage;

        private Builder() {
            this.createMessage = new GetMessage();
        }

        public static Builder get() {
            return new Builder();
        }

        public Builder setTitle(final String title) {
            createMessage.setTitle(title);
            return this;
        }

        public Builder setContent(final String content) {
            createMessage.setContent(content);
            return this;
        }

        public Builder setStickyUntil(String stickyUntil) {
            createMessage.setStickyUntil(stickyUntil);
            return this;
        }

        public Builder setType(String type) {
            createMessage.setType(type);
            return this;
        }

        public Builder setMainIcon(String mainIcon) {
            createMessage.setMainIcon(mainIcon);
            return this;
        }

        public Builder setHyperlink(String hyperlink) {
            createMessage.setHyperlink(hyperlink);
            return this;
        }

        public Builder setSecondaryIcon(String secondaryIcon) {
            createMessage.setSecondaryIcon(secondaryIcon);
            return this;
        }

        public Builder setTimestamp(Date timestamp) {
            createMessage.setTimestamp(timestamp);
            return this;
        }

        public Builder setAudienceSpecification(String audienceSpecification) {
            createMessage.setAudienceSpecification(audienceSpecification);
            return this;
        }

        public Builder setOrganizationAudienceSpecification(List<Long> organizationAudienceSpecification) {
            createMessage.setOrganizationAudienceSpecification(organizationAudienceSpecification);
            return this;
        }

        public Builder setId(String id) {
            createMessage.setId(id);
            return this;
        }

        public Builder setStarred(Boolean starred) {
            createMessage.setStarred(starred);
            return this;
        }

        public Builder setMarkedReadAt(Date markedReadAt) {
            createMessage.setMarkedReadAt(markedReadAt);
            return this;
        }

        public Builder setMetadata(Metadata metadata) {
            createMessage.setMetadata(metadata);
            return this;
        }

        public Builder setUserAudienceSpecification(List<UserAudienceSpecification> userAudienceSpecification) {
            createMessage.setUserAudienceSpecification(userAudienceSpecification);
            return this;
        }

        public GetMessage build() {
            return createMessage;
        }
    }
    //endregion

    //region isSet methods
    // Is id Set boolean method
    @JsonIgnore
    public boolean isIdSet() {
        return isSet.contains("id");
    }

    // Is starred Set boolean method
    @JsonIgnore
    public boolean isStarredSet() {
        return isSet.contains("isStarred");
    }

    // Is markedReadAt Set boolean method
    @JsonIgnore
    public boolean isMarkedReadAtSet() {
        return isSet.contains("markedReadAt");
    }

    // Is metadata Set boolean method
    @JsonIgnore
    public boolean isMetadataSet() {
        return isSet.contains("metadata");
    }

    // Is title Set boolean method
    @JsonIgnore
    public boolean isTitleSet() {
        return isSet.contains("title");
    }

    // Is content Set boolean method
    @JsonIgnore
    public boolean isContentSet() {
        return isSet.contains("content");
    }

    // Is StickyUntil Set boolean method
    @JsonIgnore
    public boolean isStickyUntilSet() {
        return isSet.contains("stickyUntil");
    }

    // Is Type Set boolean method
    @JsonIgnore
    public boolean isTypeSet() {
        return isSet.contains("type");
    }

    // Is MainIcon Set boolean method
    @JsonIgnore
    public boolean isMainIconSet() {
        return isSet.contains("mainIcon");
    }

    // Is Hyperlink Set boolean method
    @JsonIgnore
    public boolean isHyperlinkSet() {
        return isSet.contains("hyperlink");
    }

    // Is SecondaryIcon Set boolean method
    @JsonIgnore
    public boolean isSecondaryIconSet() {
        return isSet.contains("secondaryIcon");
    }

    // Is Timestamp Set boolean method
    @JsonIgnore
    public boolean isTimestampSet() {
        return isSet.contains("timestamp");
    }

    // Is AudienceSpecification Set boolean method
    @JsonIgnore
    public boolean isAudienceSpecificationSet() {
        return isSet.contains("audienceSpecification");
    }

    // Is OrganizationAudienceSpecification Set boolean method
    @JsonIgnore
    public boolean isOrganizationAudienceSpecificationSet() {
        return isSet.contains("organizationAudienceSpecification");
    }

    // Is UserAudienceSpecification Set boolean method
    @JsonIgnore
    public boolean isUserAudienceSpecificationSet() {
        return isSet.contains("userAudienceSpecification");
    }

    //endregion
}
