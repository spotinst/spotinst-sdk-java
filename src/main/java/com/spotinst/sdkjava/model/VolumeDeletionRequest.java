package com.spotinst.sdkjava.model;


public class VolumeDeletionRequest {
    //region Members
    private String volumeId;
    //endregion

    //region Private constructor
    private VolumeDeletionRequest() {
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
        private VolumeDeletionRequest volumeDeletionRequest;

        private Builder() {
            this.volumeDeletionRequest = new VolumeDeletionRequest();
        }

        public static VolumeDeletionRequest.Builder get() {
            VolumeDeletionRequest.Builder builder = new VolumeDeletionRequest.Builder();
            return builder;
        }

        public VolumeDeletionRequest.Builder setVolumeId(final String volumeId) {
            volumeDeletionRequest.setVolumeId(volumeId);
            return this;
        }

        public VolumeDeletionRequest build() {
            return volumeDeletionRequest;
        }

    }
    //endregion
}
