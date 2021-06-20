package com.spotinst.sdkjava.model.bl.spotStorage;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.spotinst.sdkjava.client.rest.JsonMapper;
import com.spotinst.sdkjava.model.api.spotStorage.ApiAzureStorageVolume;

import java.util.HashMap;
import java.util.Map;


public class AzureStorageVolumeCreationRequest {
    //region Members
    @JsonProperty("volume")
    private VolumeAzureStorage volume;
    //endregion

    //region Private constructor
    private AzureStorageVolumeCreationRequest() {
    }
    //endregion


    //region Getters & Setters
    public VolumeAzureStorage getVolume() {
        return volume;
    }

    public void setVolume(VolumeAzureStorage volume) {
        this.volume = volume;
    }
    //endregion

    //region Builder class
    public static class Builder {
        private AzureStorageVolumeCreationRequest volumeCreationRequestStorage;

        private Builder() {
            this.volumeCreationRequestStorage = new AzureStorageVolumeCreationRequest();
        }

        public static Builder get() {
            Builder builder = new Builder();
            return builder;
        }

        public Builder setVolume(final VolumeAzureStorage volume) {
            volumeCreationRequestStorage.setVolume(volume);
            return this;
        }

        public AzureStorageVolumeCreationRequest build() {
            return volumeCreationRequestStorage;
        }

    }
    //endregion

    //region Json methods
    public String toJson() {
        ApiAzureStorageVolume apiVolumeToCreate = VolumeConverter.toDal(volume);

        Map<String, ApiAzureStorageVolume> groupRequest = new HashMap<>();
        groupRequest.put("volume", apiVolumeToCreate);
        String retVal = JsonMapper.toJson(groupRequest);

        return retVal;
    }
    //endregion

}
