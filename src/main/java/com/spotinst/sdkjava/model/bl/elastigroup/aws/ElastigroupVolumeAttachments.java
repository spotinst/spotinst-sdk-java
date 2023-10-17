package com.spotinst.sdkjava.model.bl.elastigroup.aws;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Aditya on 11/10/23.
 */

public class ElastigroupVolumeAttachments {
    //region Members
    @JsonIgnore
    private Set<String> isSet;
    private List<ElastigroupVolume> volumes;


    //endregion

    //region Constructor

    private ElastigroupVolumeAttachments() {
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

    public List<ElastigroupVolume> getVolumes() {
        return volumes;
    }

    public void setVolumes(List<ElastigroupVolume> volumes) {
        isSet.add("volumes");
        this.volumes = volumes;
    }

    //endregion

    //region Builder class
    public static class Builder {

        private ElastigroupVolumeAttachments volumeAttachments;

        private Builder() {
            this.volumeAttachments = new ElastigroupVolumeAttachments();
        }

        public static Builder get() {
            return new Builder();
        }

        public Builder setVolumes(final List<ElastigroupVolume> volumes) {
            volumeAttachments.setVolumes(volumes);
            return this;
        }
        public ElastigroupVolumeAttachments build() {
            return volumeAttachments;
        }
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
