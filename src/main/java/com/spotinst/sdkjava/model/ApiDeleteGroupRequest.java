package com.spotinst.sdkjava.model;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * @author Caduri Katzav
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiDeleteGroupRequest {
    //region Members
    private StatefulDeallocationConfig statefulDeallocation;
    private AmiBackupConfig            amiBackup;
    private BeanstalkDeleteConfig      beanstalk;
    //endregion

    //region Getters & Setters
    public StatefulDeallocationConfig getStatefulDeallocation() {
        return statefulDeallocation;
    }

    public void setStatefulDeallocation(StatefulDeallocationConfig statefulDeallocation) {
        this.statefulDeallocation = statefulDeallocation;
    }

    public AmiBackupConfig getAmiBackup() {
        return amiBackup;
    }

    public void setAmiBackup(AmiBackupConfig amiBackup) {
        this.amiBackup = amiBackup;
    }

    public BeanstalkDeleteConfig getBeanstalk() {
        return beanstalk;
    }

    public void setBeanstalk(BeanstalkDeleteConfig beanstalk) {
        this.beanstalk = beanstalk;
    }
    //endregion

    //region Builder class
    public static class Builder {
        private ApiDeleteGroupRequest deleteRequest;

        private Builder() {
            this.deleteRequest = new ApiDeleteGroupRequest();
        }

        public static ApiDeleteGroupRequest.Builder get() {
            return new Builder();
        }

        public ApiDeleteGroupRequest.Builder setStatefulDeallocation(final StatefulDeallocationConfig statefulDeallocation) {
            deleteRequest.setStatefulDeallocation(statefulDeallocation);
            return this;
        }

        public ApiDeleteGroupRequest.Builder setAmiBackup(final AmiBackupConfig amiBackup) {
            deleteRequest.setAmiBackup(amiBackup);
            return this;
        }

        public ApiDeleteGroupRequest.Builder setBeanstalk(final BeanstalkDeleteConfig beanstalk) {
            deleteRequest.setBeanstalk(beanstalk);
            return this;
        }

        public ApiDeleteGroupRequest build() {
            return deleteRequest;
        }
    }
    //endregion
}
