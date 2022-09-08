package com.spotinst.sdkjava.model.requests.oceanCD;

public class RolloutActions {
    //region Members
    private String action;
    //endregion

    //region Private Constructor

    public RolloutActions() {
    }

    //endregion

    //region Getters & Setters

    public String getAction() {
        return this.action;
    }

    public void setAction(String action) {
        this.action = action;
    }
    //endregion

    //Builder class
    public static class Builder {
        private RolloutActions rolloutActions;

        private Builder() {
            this.rolloutActions = new RolloutActions();
        }

        public static RolloutActions.Builder get() {
            return new Builder();
        }

        public RolloutActions.Builder setAction(final String action) {
            rolloutActions.setAction(action);
            return this;
        }

        public RolloutActions build() {
            return rolloutActions;
        }
    }
}

