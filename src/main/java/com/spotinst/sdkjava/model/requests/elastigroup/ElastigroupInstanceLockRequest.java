package com.spotinst.sdkjava.model.requests.elastigroup;

public class ElastigroupInstanceLockRequest {
    //region Members
    private String accountId;
    private Integer ttlInMinutes;
    //endregion

    //region Private Constructor

    private ElastigroupInstanceLockRequest() {
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
        private ElastigroupInstanceLockRequest elastigroupInstanceLockUnlockRequest;

        private Builder() {
            this.elastigroupInstanceLockUnlockRequest = new ElastigroupInstanceLockRequest();
        }

        public static ElastigroupInstanceLockRequest.Builder get() {
            ElastigroupInstanceLockRequest.Builder builder = new ElastigroupInstanceLockRequest.Builder();
            return builder;
        }

        public ElastigroupInstanceLockRequest.Builder setAccountId(final String accountId) {
            elastigroupInstanceLockUnlockRequest.setAccountId(accountId);
            return this;
        }

        public ElastigroupInstanceLockRequest.Builder setTtlInMinutes(final Integer ttlValue) {
            elastigroupInstanceLockUnlockRequest.setTtlInMinutes(ttlValue);
            return this;
        }

        public ElastigroupInstanceLockRequest build() {
            return elastigroupInstanceLockUnlockRequest;
        }
    }
}

