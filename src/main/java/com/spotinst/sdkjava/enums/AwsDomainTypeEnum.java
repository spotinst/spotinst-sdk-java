package com.spotinst.sdkjava.enums;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by aharontwizer on 8/24/15.
 */
public enum AwsDomainTypeEnum {
    //region Enums
    STANDARD("standard"),
    VPC("vpc");
    //endregion

    //region Members
    private static final Logger LOGGER = LoggerFactory.getLogger(AwsDomainTypeEnum.class);
    private String name;
    //endregion

    //region Constructors
    AwsDomainTypeEnum(String name) {
        this.name = name;
    }
    //endregion

    //region Methods
    public static AwsDomainTypeEnum fromName(String name) {
        AwsDomainTypeEnum retVal = null;

        for (AwsDomainTypeEnum domainType : AwsDomainTypeEnum.values()) {
            if (StringUtils.equalsIgnoreCase(name, domainType.name)) {
                retVal = domainType;
                break;
            }
        }

        if (retVal == null) {
            LOGGER.error("Tried to create domain type enum for name : " + name + ", but we don't support such type ");
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
