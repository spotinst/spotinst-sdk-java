package com.spotinst.sdkjava.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.spotinst.sdkjava.client.rest.JsonMapper;
import com.spotinst.sdkjava.model.api.spotStorage.ApiAzureStorageVolume;
import com.spotinst.sdkjava.model.bl.spotStorage.VolumeAzureStorage;
import com.spotinst.sdkjava.model.bl.spotStorage.VolumeConverter;

import java.util.HashMap;
import java.util.Map;


public class VolumeUpdateRequest {
    //region Members
    @JsonProperty("group")
    private VolumeAzureStorage volumeAzureStorage;
    //endregion

    //region Private Constructor
    private VolumeUpdateRequest() {
    }
    //endregion

    //region Getters & Setters

    public VolumeAzureStorage getVolume() {
        return volumeAzureStorage;
    }

    public void setVolume(VolumeAzureStorage volume) {
        this.volumeAzureStorage = volume;
    }

    //endregion
    public static class Builder {
        private VolumeUpdateRequest volumeCreationRequest;

        private Builder() {
            this.volumeCreationRequest = new VolumeUpdateRequest();
        }

        public static Builder get() {
            Builder builder = new Builder();
            return builder;
        }

        public Builder setVolume(final VolumeAzureStorage volume) {
            volumeCreationRequest.setVolume(volume);
            return this;
        }

        public VolumeUpdateRequest build() {
            return volumeCreationRequest;
        }

    }

    //region Json methods
    public String toJson() {
        ApiAzureStorageVolume apiElastigroupToCreate = VolumeConverter.toDal(volumeAzureStorage);

        Map<String, ApiAzureStorageVolume> groupRequest = new HashMap<>();
        groupRequest.put("group", apiElastigroupToCreate);
        String volumeJson = JsonMapper.toJson(groupRequest);

        return volumeJson;
    }
    //endregion

}
