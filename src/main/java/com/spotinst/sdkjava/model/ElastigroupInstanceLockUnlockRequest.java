package com.spotinst.sdkjava.model;

public class ElastigroupInstanceLockUnlockRequest {
    //region Members
    private String accountId;
    private Integer ttlInMinutes;
    //endregion

    //region Private Constructor

    private ElastigroupInstanceLockUnlockRequest() {
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

    //Builder class
    public static class Builder {
        private ElastigroupInstanceLockUnlockRequest elastigroupInstanceLockUnlockRequest;

        private Builder() {
            this.elastigroupInstanceLockUnlockRequest = new ElastigroupInstanceLockUnlockRequest();
        }

        public static ElastigroupInstanceLockUnlockRequest.Builder get() {
            ElastigroupInstanceLockUnlockRequest.Builder builder = new ElastigroupInstanceLockUnlockRequest.Builder();
            return builder;
        }

        public ElastigroupInstanceLockUnlockRequest.Builder setAccountId(final String accountId) {
            elastigroupInstanceLockUnlockRequest.setAccountId(accountId);
            return this;
        }

        public ElastigroupInstanceLockUnlockRequest.Builder setTtlInMinutes(final Integer ttlValue) {
            elastigroupInstanceLockUnlockRequest.setTtlInMinutes(ttlValue);
            return this;
        }

        public ElastigroupInstanceLockUnlockRequest build() {
            return elastigroupInstanceLockUnlockRequest;
        }
    }
}

