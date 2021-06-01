package com.spotinst.sdkjava.model.bl.admin.account;

public class AccountDeleteRequest {

    private String accountId;

    private AccountDeleteRequest() {
    }

    //Getters & Setters
    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String account) {
        this.accountId = account;
    }



    //Builder class
    public static class Builder {

        private AccountDeleteRequest accountDeletionRequest;

        private Builder() {
            this.accountDeletionRequest = new AccountDeleteRequest();
        }

        public static AccountDeleteRequest.Builder get() {
            AccountDeleteRequest.Builder builder = new AccountDeleteRequest.Builder();
            return builder;
        }

        public AccountDeleteRequest.Builder setAccountId(final String account) {
            accountDeletionRequest.setAccountId(account);
            return this;
        }

        public AccountDeleteRequest build() {
            return accountDeletionRequest;
        }

    }

}
