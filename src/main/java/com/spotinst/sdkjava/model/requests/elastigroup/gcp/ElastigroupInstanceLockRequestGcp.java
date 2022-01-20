package com.spotinst.sdkjava.model.requests.elastigroup.gcp;

public class ElastigroupInstanceLockRequestGcp {
    //region Members
    private String accountId;
    private Integer ttlInMinutes;
    //endregion

    //region Private Constructor

    private ElastigroupInstanceLockRequestGcp() {
    }

    //endregion

    //region Getters & Setters

    public String getAccountId() {
        return this.accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public Integer getTtlInMinutes() {
        return this.ttlInMinutes;
    }

    public void setTtlInMinutes(Integer ttlValue) {
        this.ttlInMinutes = ttlValue;
    }
    //endregion

    //Builder class
    public static class Builder {
        private ElastigroupInstanceLockRequestGcp elastigroupInstanceLockUnlockRequestGcp;

        private Builder() {
            this.elastigroupInstanceLockUnlockRequestGcp = new ElastigroupInstanceLockRequestGcp();
        }

        public static ElastigroupInstanceLockRequestGcp.Builder get() {
            ElastigroupInstanceLockRequestGcp.Builder builder = new ElastigroupInstanceLockRequestGcp.Builder();
            return builder;
        }

        public ElastigroupInstanceLockRequestGcp.Builder setAccountId(final String accountId) {
            elastigroupInstanceLockUnlockRequestGcp.setAccountId(accountId);
            return this;
        }

        public ElastigroupInstanceLockRequestGcp.Builder setTtlInMinutes(final Integer ttlValue) {
            elastigroupInstanceLockUnlockRequestGcp.setTtlInMinutes(ttlValue);
            return this;
        }

        public ElastigroupInstanceLockRequestGcp build() {
            return elastigroupInstanceLockUnlockRequestGcp;
        }
    }
}

