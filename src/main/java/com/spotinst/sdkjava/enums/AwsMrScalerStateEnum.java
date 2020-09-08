package com.spotinst.sdkjava.enums;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public enum AwsMrScalerStateEnum {
    //region Enums
    starting("starting"),
    waiting("waiting"),
    running("running"),
    boostrapping("boostrapping");
    //endregion

    //region Members
    private static final Logger LOGGER = (Logger) LoggerFactory.getLogger(AwsVolumeTypeEnum.class);
    private              String name;
    //endregion

    //region Constructors
    AwsMrScalerStateEnum(String name) {
        this.name = name;
    }
    //endregion

    //region Methods
    public static AwsMrScalerStateEnum fromName(String name) {
        AwsMrScalerStateEnum retVal = null;
        for (AwsMrScalerStateEnum volumeType : AwsMrScalerStateEnum.values()) {
            if (StringUtils.equalsIgnoreCase(name, volumeType.name)) {
                retVal = volumeType;
                break;
            }
        }

        if (retVal == null) {
            LOGGER.error("Tried to create MrScaler state enum for name : " + name + ", but we don't support such type ");
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
