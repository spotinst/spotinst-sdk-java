package com.spotinst.sdkjava.enums;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by aharontwizer on 9/21/15.
 */
public enum AwsImageStatusEnum {

    PENDING("pending"),
    AVAILABLE("available"),
    INVALID("invalid"),
    DEREGISTERED("deregistered"),
    TRANSIENT("transient"),
    FAILED("failed"),
    ERROR("error");


    private static final Logger LOGGER = LoggerFactory.getLogger(AwsImageStatusEnum.class);
    private String name;

    AwsImageStatusEnum(String name) {
        this.name = name;
    }

    public static AwsImageStatusEnum fromName(String name) {
        AwsImageStatusEnum retVal = null;
        for (AwsImageStatusEnum awsImageStatusEnum : AwsImageStatusEnum.values()) {
            if (name.equals(awsImageStatusEnum.name)) {
                retVal = awsImageStatusEnum;
                break;
            }
        }

        if (retVal == null) {
            LOGGER.error("Tried to create image status enum for awsName : " + name + ", but we don't support such type ");
        }

        return retVal;
    }

    public String getName() {
        return name;
    }
}
