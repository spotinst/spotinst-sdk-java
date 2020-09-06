package com.spotinst.sdkjava.model;

/**
 * @author Caduri Katzav
 */
public class ApiDeleteGroupRequest {
    //region Members
    private StatefulDeallocationConfig statefulDeallocation;
    //endregion

    //region Getters & Setters
    public StatefulDeallocationConfig getStatefulDeallocation() {
        return statefulDeallocation;
    }

    public void setStatefulDeallocation(StatefulDeallocationConfig statefulDeallocation) {
        this.statefulDeallocation = statefulDeallocation;
    }
    //endregion

    //region Builder class
    public static class Builder {
        private ApiDeleteGroupRequest deleteRequest;

        private Builder() {
            this.deleteRequest = new ApiDeleteGroupRequest();
        }

        public static ApiDeleteGroupRequest.Builder get() {
            ApiDeleteGroupRequest.Builder builder = new ApiDeleteGroupRequest.Builder();
            return builder;
        }

        public ApiDeleteGroupRequest.Builder setStatefulDeallocation(final StatefulDeallocationConfig statefulDeallocation) {
            deleteRequest.setStatefulDeallocation(statefulDeallocation);
            return this;
        }

        public ApiDeleteGroupRequest build() {
            // TODO : Validations
            return deleteRequest;
        }
    }
    //endregion
}