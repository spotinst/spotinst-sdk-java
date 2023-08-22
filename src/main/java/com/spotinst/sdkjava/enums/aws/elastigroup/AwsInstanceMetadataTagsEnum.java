package com.spotinst.sdkjava.enums.aws.elastigroup;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public enum AwsInstanceMetadataTagsEnum {

    ENABLED("enabled"),
    DISABLED("disabled");

    private static final Logger LOGGER = LoggerFactory.getLogger(AwsInstanceMetadataTagsEnum.class);
    private String name;

    AwsInstanceMetadataTagsEnum(String name) {
        this.name = name;
    }

    public static AwsInstanceMetadataTagsEnum fromName(String name) {
        AwsInstanceMetadataTagsEnum retVal = null;

        for (AwsInstanceMetadataTagsEnum tag : AwsInstanceMetadataTagsEnum.values()) {
            if (name.equalsIgnoreCase(tag.name)) {
                retVal = tag;
                break;
            }
        }

        if (retVal == null) {
            LOGGER.error("Tried to create instanceMetadataTags enum for: " + name + ", but we don't support such type ");
        }

        return retVal;
    }

    public String getName() {
        return name;
    }
}
