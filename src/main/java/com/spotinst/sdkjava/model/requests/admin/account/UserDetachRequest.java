package com.spotinst.sdkjava.model.requests.admin.account;

public class UserDetachRequest {

    private String userEmail;

    private UserDetachRequest() {
    }

    //Getters & Setters
    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String account) {
        this.userEmail = account;
    }



    //Builder class
    public static class Builder {

        private UserDetachRequest accountDeletionRequest;

        private Builder() {
            this.accountDeletionRequest = new UserDetachRequest();
        }

        public static UserDetachRequest.Builder get() {
            return new Builder();
        }

        public UserDetachRequest.Builder setAccountId(final String account) {
            accountDeletionRequest.setUserEmail(account);
            return this;
        }

        public UserDetachRequest build() {
            return accountDeletionRequest;
        }

    }

}
