package com.spotinst.sdkjava.model.bl.spotStorage;

public class AzureStorageVolumeDeletionRequest {
    //region Members
    private String volumeId;
    //endregion

    //region Private constructor
    private AzureStorageVolumeDeletionRequest() {
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
        private AzureStorageVolumeDeletionRequest volumeDeletionRequest;

        private Builder() {
            this.volumeDeletionRequest = new AzureStorageVolumeDeletionRequest();
        }

        public static AzureStorageVolumeDeletionRequest.Builder get() {
            return new Builder();
        }

        public AzureStorageVolumeDeletionRequest.Builder setVolumeId(final String volumeId) {
            volumeDeletionRequest.setVolumeId(volumeId);
            return this;
        }

        public AzureStorageVolumeDeletionRequest build() {
            return volumeDeletionRequest;
        }

    }
    //endregion
}
