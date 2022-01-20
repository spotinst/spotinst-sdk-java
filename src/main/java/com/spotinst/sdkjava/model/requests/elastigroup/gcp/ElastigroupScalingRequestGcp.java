package com.spotinst.sdkjava.model.requests.elastigroup.gcp;

/**
 * Created by Saikumar Jalda on 01/20/2022.
 */

public class ElastigroupScalingRequestGcp {
    //region Members
    private String elastigroupId;
    private Integer adjustment;
    //endregion

    //region Private Constructor

    private ElastigroupScalingRequestGcp() {
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
        private ElastigroupScalingRequestGcp elastigroupScalingRequestGcp;

        private Builder() {
            this.elastigroupScalingRequestGcp = new ElastigroupScalingRequestGcp();
        }

        public static Builder get() {
            Builder builder = new Builder();
            return builder;
        }

        public Builder setElastigroupId(final String elastigroupId) {
            elastigroupScalingRequestGcp.setElastigroupId(elastigroupId);
            return this;
        }

        public Builder setAdjustment(final Integer adjustment) {
            elastigroupScalingRequestGcp.setAdjustment(adjustment);
            return this;
        }


        public ElastigroupScalingRequestGcp build() {
            // TODO : Validations
            return elastigroupScalingRequestGcp;
        }

    }
}
