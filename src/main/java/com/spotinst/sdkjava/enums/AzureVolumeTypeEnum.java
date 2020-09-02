package com.spotinst.sdkjava.enums;


import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by aharontwizer on 8/24/15.
 */
public enum AzureVolumeTypeEnum {
    //region Enums
    STANDARD("standard"),
    IO1("io1"),
    GP2("gp2");
    //endregion

    //region Members
    private static final Logger LOGGER = (Logger) LoggerFactory.getLogger(AzureVolumeTypeEnum.class);
    private String name;
    //endregion

    //region Constructors
    AzureVolumeTypeEnum(String name) {
        this.name = name;
    }
    //endregion

    //region Methods
    public static AzureVolumeTypeEnum fromName(String name) {
        AzureVolumeTypeEnum retVal = null;
        for (AzureVolumeTypeEnum volumeType : AzureVolumeTypeEnum.values()) {
            if (StringUtils.equalsIgnoreCase(name, volumeType.name)) {
                retVal = volumeType;
                break;
            }
        }

        if (retVal == null) {
            LOGGER.error("Tried to create volume type enum for name : " + name + ", but we don't support such type ");
        }

        return retVal;
    }
    //endregion

    //region Getters & Setters
    public String getName() {
        return name;
    }
    //endregion
}
