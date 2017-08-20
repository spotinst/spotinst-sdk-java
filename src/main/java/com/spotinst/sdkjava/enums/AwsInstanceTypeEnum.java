package com.spotinst.sdkjava.enums;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by aharontwizer on 8/24/15.
 */
public enum AwsInstanceTypeEnum {

    T1_MICRO("t1.micro", AwsInstanceFamilyEnum.T1),
    M1_SMALL("m1.small", AwsInstanceFamilyEnum.M1),
    M1_MEDIUM("m1.medium", AwsInstanceFamilyEnum.M1),
    M1_LARGE("m1.large", AwsInstanceFamilyEnum.M1),
    M1_XLARGE("m1.xlarge", AwsInstanceFamilyEnum.M1),
    M3_MEDIUM("m3.medium", AwsInstanceFamilyEnum.M3),
    M3_LARGE("m3.large", AwsInstanceFamilyEnum.M3),
    M3_XLARGE("m3.xlarge", AwsInstanceFamilyEnum.M3),
    M3_2XLARGE("m3.2xlarge", AwsInstanceFamilyEnum.M3),
    M4_LARGE("m4.large", AwsInstanceFamilyEnum.M4),
    M4_XLARGE("m4.xlarge", AwsInstanceFamilyEnum.M4),
    M4_2XLARGE("m4.2xlarge", AwsInstanceFamilyEnum.M4),
    M4_4XLARGE("m4.4xlarge", AwsInstanceFamilyEnum.M4),
    M4_10XLARGE("m4.10xlarge", AwsInstanceFamilyEnum.M4),
    M4_16XLARGE("m4.16xlarge", AwsInstanceFamilyEnum.M4),
    T2_NANO("t2.nano", AwsInstanceFamilyEnum.T2),
    T2_MICRO("t2.micro", AwsInstanceFamilyEnum.T2),
    T2_SMALL("t2.small", AwsInstanceFamilyEnum.T2),
    T2_MEDIUM("t2.medium", AwsInstanceFamilyEnum.T2),
    T2_LARGE("t2.large", AwsInstanceFamilyEnum.T2),
    M2_XLARGE("m2.xlarge", AwsInstanceFamilyEnum.M2),
    M2_2XLARGE("m2.2xlarge", AwsInstanceFamilyEnum.M2),
    M2_4XLARGE("m2.4xlarge", AwsInstanceFamilyEnum.M2),
    CR1_8XLARGE("cr1.8xlarge", AwsInstanceFamilyEnum.CR1),
    I2_XLARGE("i2.xlarge", AwsInstanceFamilyEnum.I2),
    I2_2XLARGE("i2.2xlarge", AwsInstanceFamilyEnum.I2),
    I2_4XLARGE("i2.4xlarge", AwsInstanceFamilyEnum.I2),
    I2_8XLARGE("i2.8xlarge", AwsInstanceFamilyEnum.I2),
    HI1_4XLARGE("hi1.4xlarge", AwsInstanceFamilyEnum.HI1),
    HS1_8XLARGE("hs1.8xlarge", AwsInstanceFamilyEnum.HS1),
    C1_MEDIUM("c1.medium", AwsInstanceFamilyEnum.C1),
    C1_XLARGE("c1.xlarge", AwsInstanceFamilyEnum.C1),
    C3_LARGE("c3.large", AwsInstanceFamilyEnum.C3),
    C3_XLARGE("c3.xlarge", AwsInstanceFamilyEnum.C3),
    C3_2XLARGE("c3.2xlarge", AwsInstanceFamilyEnum.C3),
    C3_4XLARGE("c3.4xlarge", AwsInstanceFamilyEnum.C3),
    C3_8XLARGE("c3.8xlarge", AwsInstanceFamilyEnum.C3),
    C4_LARGE("c4.large", AwsInstanceFamilyEnum.C4),
    C4_XLARGE("c4.xlarge", AwsInstanceFamilyEnum.C4),
    C4_2XLARGE("c4.2xlarge", AwsInstanceFamilyEnum.C4),
    C4_4XLARGE("c4.4xlarge", AwsInstanceFamilyEnum.C4),
    C4_8XLARGE("c4.8xlarge", AwsInstanceFamilyEnum.C4),
    CC1_4XLARGE("cc1.4xlarge", AwsInstanceFamilyEnum.CC1),
    CC2_8XLARGE("cc2.8xlarge", AwsInstanceFamilyEnum.CC2),
    G2_2XLARGE("g2.2xlarge", AwsInstanceFamilyEnum.G2),
    G2_8XLARGE("g2.8xlarge", AwsInstanceFamilyEnum.G2),
    CG1_4XLARGE("cg1.4xlarge", AwsInstanceFamilyEnum.CG1),
    R3_LARGE("r3.large", AwsInstanceFamilyEnum.R3),
    R3_XLARGE("r3.xlarge", AwsInstanceFamilyEnum.R3),
    R3_2XLARGE("r3.2xlarge", AwsInstanceFamilyEnum.R3),
    R3_4XLARGE("r3.4xlarge", AwsInstanceFamilyEnum.R3),
    R3_8XLARGE("r3.8xlarge", AwsInstanceFamilyEnum.R3),
    D2_XLARGE("d2.xlarge", AwsInstanceFamilyEnum.D2),
    D2_2XLARGE("d2.2xlarge", AwsInstanceFamilyEnum.D2),
    D2_4XLARGE("d2.4xlarge", AwsInstanceFamilyEnum.D2),
    D2_8XLARGE("d2.8xlarge", AwsInstanceFamilyEnum.D2),
    X1_16XLARGE("x1.16xlarge", AwsInstanceFamilyEnum.X1),
    X1_32XLARGE("x1.32xlarge", AwsInstanceFamilyEnum.X1),
    P2_XLARGE("p2.xlarge", AwsInstanceFamilyEnum.P2),
    P2_8XLARGE("p2.8xlarge", AwsInstanceFamilyEnum.P2),
    P2_16XLARGE("p2.16xlarge", AwsInstanceFamilyEnum.P2);

    private static final Logger LOGGER = (Logger) LoggerFactory.getLogger(AwsInstanceTypeEnum.class);
    private String name;
    private AwsInstanceFamilyEnum family;

    AwsInstanceTypeEnum(String name, AwsInstanceFamilyEnum family) {
        this.name = name;
        this.family = family;
    }

    public static AwsInstanceTypeEnum fromName(String name) {
        AwsInstanceTypeEnum retVal = null;
        for (AwsInstanceTypeEnum instanceTypeEnum : AwsInstanceTypeEnum.values()) {
            if (name.equals(instanceTypeEnum.name)) {
                retVal = instanceTypeEnum;
                break;
            }
        }

        if (retVal == null) {
            LOGGER.error("Tried to create Instance type enum for: " + name + ", but we don't support such type ");
        }
        return retVal;
    }

    /**
     * Get the class of status code.
     *
     * @return the class of status code.
     */
    public AwsInstanceFamilyEnum getFamily() {
        return family;
    }

    public String getName() {
        return name;
    }
}
