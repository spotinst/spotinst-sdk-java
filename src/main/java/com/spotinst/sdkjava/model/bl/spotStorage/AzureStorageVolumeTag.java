package com.spotinst.sdkjava.model.bl.spotStorage;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.Set;

public class AzureStorageVolumeTag {
    //region Members
    @JsonIgnore
    private Set<String> isSet;
    private String      tagKey;
    private String      tagValue;
    //endregion

    //region Constructor
    private AzureStorageVolumeTag() {
        isSet = new HashSet<>();
    }
    //endregion

    //region getters &setters
    public Set<String> getIsSet() {
        return isSet;
    }

    public void setIsSet(Set<String> isSet) {
        this.isSet = isSet;
    }

    public String getTagKey() {
        return tagKey;
    }

    public void setTagKey(String tagKey) {
        isSet.add("tagKey");
        this.tagKey = tagKey;
    }

    public String getTagValue() {
        return tagValue;
    }

    public void setTagValue(String tagValue) {
        isSet.add("tagValue");
        this.tagValue = tagValue;
    }
    //end region

    //region Builder class
    public static class Builder {
        //region Members
        private AzureStorageVolumeTag volumeTag;
        //endregion


        private Builder() {
            this.volumeTag = new AzureStorageVolumeTag();
        }

        public static Builder get() {
            return new Builder();
        }

        //region Build methods
        public Builder setTagKey(final String tagKey) {
            volumeTag.setTagKey(tagKey);
            return this;
        }

        public Builder setTagValue(final String tagValue) {
            volumeTag.setTagValue(tagValue);
            return this;
        }

        public AzureStorageVolumeTag build() {
            // Validations
            return volumeTag;
        }
        //endregion
    }
    //endregion

    //region isSet methods
    // Is tagKey Set boolean method
    @JsonIgnore
    public boolean isTagKeySet() {
        return isSet.contains("tagKey");
    }

    // Is tagValue Set boolean method
    @JsonIgnore
    public boolean isTagValueSet() {
        return isSet.contains("tagValue");
    }
    //endregion
}
