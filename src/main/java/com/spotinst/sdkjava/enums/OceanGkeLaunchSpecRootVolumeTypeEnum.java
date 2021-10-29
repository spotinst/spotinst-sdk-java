package com.spotinst.sdkjava.enums;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public enum OceanGkeLaunchSpecRootVolumeTypeEnum {

    //region Enums
    PD_STANDARD("pd-standard"),
    PD_SSD("pd-ssd");
    //endregion

    //region Members
    private static final Logger LOGGER = LoggerFactory.getLogger(OceanGkeLaunchSpecRootVolumeTypeEnum.class);
    private              String name;
    //endregion

    //region Constructors

    OceanGkeLaunchSpecRootVolumeTypeEnum(String name) {
        this.name = name;
    }

    //endregion

    //region Getters & Setters

    public String getName() {
        return name;
    }

    //endregion

    //region Methods
    public static OceanGkeLaunchSpecRootVolumeTypeEnum fromName(String name) {
        OceanGkeLaunchSpecRootVolumeTypeEnum retVal = null;

        for (OceanGkeLaunchSpecRootVolumeTypeEnum typeEnum : OceanGkeLaunchSpecRootVolumeTypeEnum.values()) {
            if (StringUtils.equalsIgnoreCase(typeEnum.name, name)) {
                retVal = typeEnum;
                break;
            }
        }

        if (retVal == null) {
            LOGGER.error(String.format("Tried to create Root volume type enum from: %s, but we don't support such type",
                                       name));
        }

        return retVal;
    }
    //endregion
}
