package com.spotinst.sdkjava.model;

import com.fasterxml.jackson.annotation.JsonInclude;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class BeanstalkDeleteConfig {
    //region Members
    private Boolean rollbackToAsg;

    //endregion

    //region Getters & Setters

    public Boolean getRollbackToAsg() {
        return rollbackToAsg;
    }

    public void setRollbackToAsg(Boolean rollbackToAsg) {
        this.rollbackToAsg = rollbackToAsg;
    }


    //endregion

    //region Builder class
    public static class Builder {
        private BeanstalkDeleteConfig beanstalkDeleteConfig;

        private Builder() {
            this.beanstalkDeleteConfig = new BeanstalkDeleteConfig();
        }

        public static BeanstalkDeleteConfig.Builder get() {
            return new Builder();
        }

        public BeanstalkDeleteConfig.Builder setRollbackToAsg(final Boolean rollbackToAsg) {
            beanstalkDeleteConfig.setRollbackToAsg(rollbackToAsg);
            return this;
        }

        public BeanstalkDeleteConfig build() {
            return beanstalkDeleteConfig;
        }
    }
    //endregion
}
