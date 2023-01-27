package com.spotinst.sdkjava.model.requests.admin.account;

public class UserDetachRequest {

    private String userEmail;

    private UserDetachRequest() {
    }

    //Getters & Setters
    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String email) {
        this.userEmail = email;
    }

    //Builder class
    public static class Builder {

        private UserDetachRequest request;

        private Builder() {
            this.request = new UserDetachRequest();
        }

        public static UserDetachRequest.Builder get() {
            return new Builder();
        }

        public UserDetachRequest.Builder setUserEmail(final String email) {
            request.setUserEmail(email);
            return this;
        }

        public UserDetachRequest build() {
            return request;
        }

    }

}
