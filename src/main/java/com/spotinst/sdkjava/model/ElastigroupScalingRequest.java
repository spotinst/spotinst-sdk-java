package com.spotinst.sdkjava.model;

import com.spotinst.sdkjava.client.rest.JsonMapper;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by aharontwizer on 8/24/15.
 */

public class ElastigroupScalingRequest {
    //region Members
    private String elastigroupId;
    private Integer adjustment;
    //endregion

    //region Private Constructor

    private ElastigroupScalingRequest() {
    }

    //endregion

    //region Getters & Setters

    public String getElastigroupId() {
        return elastigroupId;
    }

    public void setElastigroupId(String elastigroupId) {
        this.elastigroupId = elastigroupId;
    }

    public Integer getAdjustment() {
        return adjustment;
    }

    public void setAdjustment(Integer adjustment) {
        this.adjustment = adjustment;
    }

    //endregion
    public static class Builder {
        private ElastigroupScalingRequest elastigroupScalingRequest;

        private Builder() {
            this.elastigroupScalingRequest = new ElastigroupScalingRequest();
        }

        public static Builder get() {
            Builder builder = new Builder();
            return builder;
        }

        public Builder setElastigroupId(final String elastigroupId) {
            elastigroupScalingRequest.setElastigroupId(elastigroupId);
            return this;
        }

        public Builder setAdjustment(final Integer adjustment) {
            elastigroupScalingRequest.setAdjustment(adjustment);
            return this;
        }


        public ElastigroupScalingRequest build() {
            // TODO : Validations
            return elastigroupScalingRequest;
        }

    }
}
