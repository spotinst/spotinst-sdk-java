package com.spotinst.sdkjava.model.requests.admin.account.messageCenter;

import java.util.Date;

public class ListAllMessagesRequest {

    private Date nonStickyMinTimestamp ;
    private Date nonStickyMaxTimestamp;
    private Integer limit;
    private Boolean isStarred;

    private ListAllMessagesRequest() {
    }

    //Getters & Setters

    public Date getNonStickyMaxTimestamp() {
        return nonStickyMaxTimestamp;
    }

    public void setNonStickyMaxTimestamp(Date nonStickyMaxTimestamp) {
        this.nonStickyMaxTimestamp = nonStickyMaxTimestamp;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Boolean getStarred() {
        return isStarred;
    }

    public void setStarred(Boolean starred) {
        isStarred = starred;
    }

    public Date getNonStickyMinTimestamp() {
        return nonStickyMinTimestamp ;
    }

    public void setNonStickyMinTimestamp(Date nonStickyMinTimestamp) {
        this.nonStickyMinTimestamp = nonStickyMinTimestamp;
    }



    //Builder class
    public static class Builder {

        private ListAllMessagesRequest listAllMessagesRequest;

        private Builder() {
            this.listAllMessagesRequest = new ListAllMessagesRequest();
        }

        public static ListAllMessagesRequest.Builder get() {
            return new Builder();
        }

        public ListAllMessagesRequest.Builder setNonStickyMinTimestamp(final Date nonStickyMinTimestamp) {
            listAllMessagesRequest.setNonStickyMinTimestamp(nonStickyMinTimestamp);
            return this;
        }

        public ListAllMessagesRequest.Builder setNonStickyMaxTimestamp(final Date nonStickyMaxTimestamp) {
            listAllMessagesRequest.setNonStickyMaxTimestamp(nonStickyMaxTimestamp);
            return this;
        }

        public ListAllMessagesRequest.Builder setLimit(final Integer limit) {
            listAllMessagesRequest.setLimit(limit);
            return this;
        }

        public ListAllMessagesRequest.Builder setStarred(final Boolean starred) {
            listAllMessagesRequest.setStarred(starred);
            return this;
        }

        public ListAllMessagesRequest build() {
            return listAllMessagesRequest;
        }
    }
}
