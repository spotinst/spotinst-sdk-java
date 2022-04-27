package com.spotinst.sdkjava.model.requests.elastigroup;

public class ElastigroupInstanceUnLockRequest {
    //region Members
    private String accountId;
    //endregion

    //region Private Constructor

    private ElastigroupInstanceUnLockRequest() {
    }

    //endregion

    //region Getters & Setters

    public String getAccountId() {
        return this.accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }
    //endregion

    //region Builder class
    public static class Builder {
        private ElastigroupInstanceUnLockRequest elastigroupInstanceLockUnlockRequest;

        private Builder() {
            this.elastigroupInstanceLockUnlockRequest = new ElastigroupInstanceUnLockRequest();
        }

        public static ElastigroupInstanceUnLockRequest.Builder get() {
            return new Builder();
        }

        public ElastigroupInstanceUnLockRequest.Builder setAccountId(final String accountId) {
            elastigroupInstanceLockUnlockRequest.setAccountId(accountId);
            return this;
        }

        public ElastigroupInstanceUnLockRequest build() {
            return elastigroupInstanceLockUnlockRequest;
        }
    }
    //endregion
}

