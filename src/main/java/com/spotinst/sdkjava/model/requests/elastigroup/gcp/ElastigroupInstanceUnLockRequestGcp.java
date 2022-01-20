package com.spotinst.sdkjava.model.requests.elastigroup.gcp;

public class ElastigroupInstanceUnLockRequestGcp {
    //region Members
    private String accountId;
    //endregion

    //region Private Constructor

    private ElastigroupInstanceUnLockRequestGcp() {
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
        private ElastigroupInstanceUnLockRequestGcp elastigroupInstanceLockUnlockRequestGcp;

        private Builder() {
            this.elastigroupInstanceLockUnlockRequestGcp = new ElastigroupInstanceUnLockRequestGcp();
        }

        public static ElastigroupInstanceUnLockRequestGcp.Builder get() {
            ElastigroupInstanceUnLockRequestGcp.Builder builder = new ElastigroupInstanceUnLockRequestGcp.Builder();
            return builder;
        }

        public ElastigroupInstanceUnLockRequestGcp.Builder setAccountId(final String accountId) {
            elastigroupInstanceLockUnlockRequestGcp.setAccountId(accountId);
            return this;
        }

        public ElastigroupInstanceUnLockRequestGcp build() {
            return elastigroupInstanceLockUnlockRequestGcp;
        }
    }
    //endregion
}

