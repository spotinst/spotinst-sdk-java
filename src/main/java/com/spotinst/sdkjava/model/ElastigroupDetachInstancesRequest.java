package com.spotinst.sdkjava.model;

import com.spotinst.sdkjava.client.rest.JsonMapper;

import java.util.List;

/**
 * @author: sniramsalem
 * @since: 12/12/2016
 */
public class ElastigroupDetachInstancesRequest {
    //region Members
    private List<String> instancesToDetach;
    private Boolean shouldTerminateInstances;
    private Boolean shouldDecrementTargetCapacity;
    private Integer drainingTimeout;
    //endregion

    //region Private constructor
    private ElastigroupDetachInstancesRequest() {
    }
    //endregion

    //region Getters & Setters

    public List<String> getInstancesToDetach() {
        return instancesToDetach;
    }

    public void setInstancesToDetach(List<String> instancesToDetach) {
        this.instancesToDetach = instancesToDetach;
    }

    public Boolean getShouldTerminateInstances() {
        return shouldTerminateInstances;
    }

    public void setShouldTerminateInstances(Boolean shouldTerminateInstances) {
        this.shouldTerminateInstances = shouldTerminateInstances;
    }

    public Boolean getShouldDecrementTargetCapacity() {
        return shouldDecrementTargetCapacity;
    }

    public void setShouldDecrementTargetCapacity(Boolean shouldDecrementTargetCapacity) {
        this.shouldDecrementTargetCapacity = shouldDecrementTargetCapacity;
    }

    public Integer getDrainingTimeout() {
        return drainingTimeout;
    }

    public void setDrainingTimeout(Integer drainingTimeout) {
        this.drainingTimeout = drainingTimeout;
    }

    //endregion

    //region Builder class
    public static class Builder {
        private ElastigroupDetachInstancesRequest detachRequest;

        private Builder() {
            this.detachRequest = new ElastigroupDetachInstancesRequest();
        }

        public static Builder get() {
            return new Builder();
        }

        public ElastigroupDetachInstancesRequest.Builder setInstancesToDetach(final List<String> instancesToDetach) {
            detachRequest.setInstancesToDetach(instancesToDetach);
            return this;
        }

        public ElastigroupDetachInstancesRequest.Builder setShouldTerminateInstances(final Boolean shouldTerminateInstances) {
            detachRequest.setShouldTerminateInstances(shouldTerminateInstances);
            return this;
        }

        public ElastigroupDetachInstancesRequest.Builder setShouldDecrementTargetCapacity(final Boolean shouldDecrementTargetCapacity) {
            detachRequest.setShouldDecrementTargetCapacity(shouldDecrementTargetCapacity);
            return this;
        }

        public ElastigroupDetachInstancesRequest.Builder setDrainingTimeout(final Integer drainingTimeout) {
            detachRequest.setDrainingTimeout(drainingTimeout);
            return this;
        }

        public ElastigroupDetachInstancesRequest build() {
            // TODO : Validations
            return detachRequest;
        }
    }
    //endregion

    //region Json Methods
    public String toJson() {
        ApiDetachInstancesRequest apiDetachInstancesRequest = ApiDetachInstancesRequestConverter.toDal(this);
        return JsonMapper.toJson(apiDetachInstancesRequest);
    }
    //endregion
}
