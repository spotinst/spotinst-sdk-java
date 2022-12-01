package com.spotinst.sdkjava.model.requests.admin.account;

import java.util.List;

public class UpdateAccountRequest {
    private String name;
    private List<String> slackNotificationChannels;

    private UpdateAccountRequest() {
    }

    //Getters & Setters
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getSlackNotificationChannels() {
        return this.slackNotificationChannels;
    }

    public void setSlackNotificationChannels(List<String> slackChannels) {
        this.slackNotificationChannels = slackChannels;
    }

    //Builder class
    public static class Builder {

        private UpdateAccountRequest request;

        private Builder() {
            this.request = new UpdateAccountRequest();
        }

        public static UpdateAccountRequest.Builder get() {
            return new Builder();
        }

        public UpdateAccountRequest.Builder setName(final String name) {
            request.setName(name);
            return this;
        }

        public UpdateAccountRequest.Builder setSlackNotificationChannels(final List<String> slackChannels) {
            request.setSlackNotificationChannels(slackChannels);
            return this;
        }

        public UpdateAccountRequest build() {
            return request;
        }
    }
}