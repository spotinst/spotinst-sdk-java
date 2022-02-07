package com.spotinst.sdkjava.model;

import com.spotinst.sdkjava.exception.SpotinstValidationException;

import java.util.Date;

public class ElastigroupGetAllRequestGcp {
    //region Members
    private Date    minCreatedAt;
    private Date    maxCreatedAt;
    private Date    activeFrom;
    private Date    activeTo;
    private Boolean includeDeleted;
    private String  name;
    //endregion

    //region Private Constructor
    private ElastigroupGetAllRequestGcp() {
    }
    //endregion

    //region Getter and Setter methods
    public Date getMinCreatedAt() {
        return minCreatedAt;
    }

    public void setMinCreatedAt(Date minCreatedAt) {
        this.minCreatedAt = minCreatedAt;
    }

    public Date getMaxCreatedAt() {
        return maxCreatedAt;
    }

    public void setMaxCreatedAt(Date maxCreatedAt) {
        this.maxCreatedAt = maxCreatedAt;
    }

    public Date getActiveFrom() {
        return activeFrom;
    }

    public void setActiveFrom(Date activeFrom) {
        this.activeFrom = activeFrom;
    }

    public Date getActiveTo() {
        return activeTo;
    }

    public void setActiveTo(Date activeTo) {
        this.activeTo = activeTo;
    }

    public Boolean getIncludeDeleted() {
        return includeDeleted;
    }

    public void setIncludeDeleted(Boolean includeDeleted) {
        this.includeDeleted = includeDeleted;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    //endregion

    //region Builder class
    public static class Builder {
        private ElastigroupGetAllRequestGcp elastigroupGetAllRequest;

        private Builder() {
            this.elastigroupGetAllRequest = new ElastigroupGetAllRequestGcp();
        }

        public static ElastigroupGetAllRequestGcp.Builder get() {
            ElastigroupGetAllRequestGcp.Builder builder = new ElastigroupGetAllRequestGcp.Builder();
            return builder;
        }

        public ElastigroupGetAllRequestGcp.Builder setMaxCreatedAt(final Date maxCreatedAt) {
            elastigroupGetAllRequest.setMaxCreatedAt(maxCreatedAt);
            return this;
        }

        public ElastigroupGetAllRequestGcp.Builder setMinCreatedAt(final Date minCreatedAt) {
            elastigroupGetAllRequest.setMinCreatedAt(minCreatedAt);
            return this;
        }

        public ElastigroupGetAllRequestGcp.Builder setActiveTo(final Date activeTo) {
            elastigroupGetAllRequest.setActiveTo(activeTo);
            return this;
        }

        public ElastigroupGetAllRequestGcp.Builder setActiveFrom(final Date activeFrom) {
            elastigroupGetAllRequest.setActiveFrom(activeFrom);
            return this;
        }

        public ElastigroupGetAllRequestGcp.Builder setIncludeDeleted(final Boolean includeDeleted) {
            elastigroupGetAllRequest.setIncludeDeleted(includeDeleted);
            return this;
        }

        public ElastigroupGetAllRequestGcp.Builder setName(final String name) {
            elastigroupGetAllRequest.setName(name);
            return this;
        }

        public ElastigroupGetAllRequestGcp build() {
            if (elastigroupGetAllRequest.getMinCreatedAt() != null && elastigroupGetAllRequest.getActiveTo() != null) {
                throw new SpotinstValidationException(
                        "Invalid Request - Cannot specify both 'minCreatedAt' and 'activeTo' parameters");
            }

            if (elastigroupGetAllRequest.getMinCreatedAt() != null &&
                elastigroupGetAllRequest.getActiveFrom() != null) {
                throw new SpotinstValidationException(
                        "Invalid Request - Cannot specify both 'minCreatedAt' and 'activeFrom' parameters");
            }

            if (elastigroupGetAllRequest.getMaxCreatedAt() != null && elastigroupGetAllRequest.getActiveTo() != null) {
                throw new SpotinstValidationException(
                        "Invalid Request - Cannot specify both 'maxCreatedAt' and 'activeTo' parameters");
            }

            if (elastigroupGetAllRequest.getMaxCreatedAt() != null &&
                elastigroupGetAllRequest.getActiveFrom() != null) {
                throw new SpotinstValidationException(
                        "Invalid Request - Cannot specify both 'maxCreatedAt' and 'activeFrom' parameters");
            }

            return elastigroupGetAllRequest;
        }
    }
    //endregion
}