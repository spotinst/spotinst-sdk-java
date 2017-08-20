package com.spotinst.sdkjava.enums;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;

/**
 * Created by aharontwizer on 9/21/15.
 */
public enum AwsInstanceStatusEnum {

    // On-Demand
    PENDING("pending", 1),
    RUNNING("running", 2),
    SHUTTING_DOWN("shutting-down", 3),
    TERMINATED("terminated", 4),
    STOPPING("stopping", 5),
    STOPPED("stopped", 6);

    private static final Logger LOGGER = (Logger) LoggerFactory.getLogger(AwsInstanceStatusEnum.class);
    private String awsName;
    private Integer code;
    private AwsInstanceStatusEnum(String awsName, Integer code) {
        this.awsName = awsName;
        this.code = code;
    }

    public static AwsInstanceStatusEnum fromAwsName(String awsName) {
        AwsInstanceStatusEnum retVal = null;
        for (AwsInstanceStatusEnum awsImageStatusEnum : AwsInstanceStatusEnum.values()) {
            if (awsName.equals(awsImageStatusEnum.awsName)) {
                retVal = awsImageStatusEnum;
                break;
            }
        }

        if (retVal == null) {
            LOGGER.error("Tried to create Aws instance statusenum from AWS name : " + awsName + ", but we don't support such status ");
        }

        return retVal;
    }

    public static AwsInstanceStatusEnum fromAwsCode(Integer awsCode) {
        AwsInstanceStatusEnum retVal = null;

        for (AwsInstanceStatusEnum awsStatusEnum : AwsInstanceStatusEnum.values()) {
            if (Objects.equals(awsStatusEnum.getCode(), awsCode)) {
                retVal = awsStatusEnum;
                break;
            }
        }

        if (retVal == null) {
            LOGGER.error("Tried to create Aws instance status Enum from AWS code : " + awsCode + ", but we don't support such status ");
        }

        return retVal;
    }

    public String getAwsName() {
        return awsName;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
