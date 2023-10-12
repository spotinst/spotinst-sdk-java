package com.spotinst.sdkjava.model.api.elastigroup.aws;


import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.spotinst.sdkjava.client.rest.IPartialUpdateEntity;
import com.spotinst.sdkjava.model.ElastigroupVolume;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonFilter("PartialUpdateEntityFilter")
public class ApiElastigroupVolumeAttachments implements IPartialUpdateEntity {
    //region Members
    @JsonIgnore
    private Set<String> isSet;
    private List<ApiElastigroupVolume> volumes;


    //endregion

    //region Constructor

    public ApiElastigroupVolumeAttachments() {
        isSet = new HashSet<>();
    }
    //endregion

    //region Getters & Setters


    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public List<ApiElastigroupVolume> getVolumes() {
        return volumes;
    }

    public void setVolumes(List<ApiElastigroupVolume> volumes) {
        isSet.add("volumes");
        this.volumes = volumes;
    }

    //endregion

    //region isSet methods

    // Is volumes Set boolean method
    @JsonIgnore
    public boolean isVolumesSet() {
        return isSet.contains("volumes");
    }

    //endregion
}
