package com.spotinst.sdkjava.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.spotinst.sdkjava.client.rest.JsonMapper;
import com.spotinst.sdkjava.model.api.spotStorage.ApiAzureStorageVolume;
import com.spotinst.sdkjava.model.bl.spotStorage.AzureStorageVolume;
import com.spotinst.sdkjava.model.bl.spotStorage.AzureStorageVolumeConverter;

import java.util.HashMap;
import java.util.Map;


public class VolumeUpdateRequest {
    //region Members
    @JsonProperty("volume")
    private AzureStorageVolume volumeAzureStorage;
    //endregion

    //region Private Constructor
    private VolumeUpdateRequest() {
    }
    //endregion

    //region Getters & Setters

    public AzureStorageVolume getVolume() {
        return volumeAzureStorage;
    }

    public void setVolume(AzureStorageVolume volume) {
        this.volumeAzureStorage = volume;
    }

    //endregion
    public static class Builder {
        private VolumeUpdateRequest volumeCreationRequest;

        private Builder() {
            this.volumeCreationRequest = new VolumeUpdateRequest();
        }

        public static Builder get() {
            return new Builder();
        }

        public Builder setVolume(final AzureStorageVolume volume) {
            volumeCreationRequest.setVolume(volume);
            return this;
        }

        public VolumeUpdateRequest build() {
            return volumeCreationRequest;
        }

    }

    //region Json methods
    public String toJson() {
        ApiAzureStorageVolume volumeToCreate = AzureStorageVolumeConverter.toDal(volumeAzureStorage);

        Map<String, ApiAzureStorageVolume> groupRequest = new HashMap<>();
        groupRequest.put("volume", volumeToCreate);

        return JsonMapper.toJson(groupRequest);
    }
    //endregion

}
