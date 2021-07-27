package com.spotinst.sdkjava.model;

import com.spotinst.sdkjava.exception.SpotinstValidationException;
import org.apache.commons.lang3.StringUtils;

public class VolumeGetRequest {
    //region Members
    private String volumeId;
    //endregion

    //region Private Constructor
    private VolumeGetRequest() {
    }
    //endregion

    //region Getter and Setter methods
    public String getVolumeId() {
        return volumeId;
    }

    public void setVolumeId(String volumeId) {
        this.volumeId = volumeId;
    }
    //endregion

    //region Builder class
    public static class Builder {
        private VolumeGetRequest volumeGetRequest;

        private Builder() {
            this.volumeGetRequest = new VolumeGetRequest();
        }

        public static VolumeGetRequest.Builder get() {
            VolumeGetRequest.Builder builder = new VolumeGetRequest.Builder();
            return builder;
        }

        public VolumeGetRequest.Builder setVolumeId(final String volumeId) {
            volumeGetRequest.setVolumeId(volumeId);
            return this;
        }

        public VolumeGetRequest build() {
            if (StringUtils.isEmpty(volumeGetRequest.getVolumeId())) {
                throw new SpotinstValidationException("Invalid Request - volumeId must be set");
            }
            return volumeGetRequest;
        }

    }
    //endregion
}
