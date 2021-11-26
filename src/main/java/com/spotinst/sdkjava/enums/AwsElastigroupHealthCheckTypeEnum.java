package com.spotinst.sdkjava.enums;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public enum AwsElastigroupHealthCheckTypeEnum {

    //region Enums
    ELB("elb"),
    ECS_CLUSTER_INSTANCE("ecs-cluster-instance"),
    TARGET_GROUP("target-group"),
    OPSWORKS("opsworks"),
    NOMAD_NODE("nomad-node"),
    MULTAI_TARGET_SET("multai-target-set"),
    HCS("hcs"),
    EC2("ec2"),
    NONE("none");
    //endregion

    //region Members
    private static final Logger LOGGER = LoggerFactory.getLogger(AwsElastigroupHealthCheckTypeEnum.class);
    private              String name;
    //endregion

    //region Constructors

    AwsElastigroupHealthCheckTypeEnum(String name) {
        this.name = name;
    }

    //endregion

    //region Getters & Setters

    public String getName() {
        return name;
    }

    //endregion

    //region Methods
    public static AwsElastigroupHealthCheckTypeEnum fromName(String name) {
        AwsElastigroupHealthCheckTypeEnum retVal = null;

        for (AwsElastigroupHealthCheckTypeEnum typeEnum : AwsElastigroupHealthCheckTypeEnum.values()) {
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
