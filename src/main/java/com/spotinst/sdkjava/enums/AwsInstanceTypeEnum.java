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
    P2_16XLARGE("p2.16xlarge", AwsInstanceFamilyEnum.P2),

    R4_16XLARGE("r4.16xlarge", AwsInstanceFamilyEnum.R4),

    R4_2XLARGE("r4.2xlarge", AwsInstanceFamilyEnum.R4),

    R4_4XLARGE("r4.4xlarge", AwsInstanceFamilyEnum.R4),

    R4_8XLARGE("r4.8xlarge", AwsInstanceFamilyEnum.R4),

    R4_LARGE("r4.large", AwsInstanceFamilyEnum.R4),

    R4_XLARGE("r4.xlarge", AwsInstanceFamilyEnum.R4),

    T2_2XLARGE("t2.2xlarge", AwsInstanceFamilyEnum.T2),

    T2_XLARGE("t2.xlarge", AwsInstanceFamilyEnum.T2),

    G3_4XLARGE("g3.4xlarge", AwsInstanceFamilyEnum.G3),
    G3_8XLARGE("g3.8xlarge", AwsInstanceFamilyEnum.G3),
    G3_16XLARGE("g3.16xlarge", AwsInstanceFamilyEnum.G3),
    F1_2XLARGE("f1.2xlarge", AwsInstanceFamilyEnum.F1),
    F1_16XLARGE("f1.16xlarge", AwsInstanceFamilyEnum.F1),
    I3_LARGE("i3.large", AwsInstanceFamilyEnum.I3),
    I3_XLARGE("i3.xlarge", AwsInstanceFamilyEnum.I3),
    I3_2XLARGE("i3.2xlarge", AwsInstanceFamilyEnum.I3),
    I3_4XLARGE("i3.4xlarge", AwsInstanceFamilyEnum.I3),
    I3_8XLARGE("i3.8xlarge", AwsInstanceFamilyEnum.I3),
    I3_16XLARGE("i3.16xlarge", AwsInstanceFamilyEnum.I3),
    P3_2XLARGE("p3.2xlarge", AwsInstanceFamilyEnum.P3),
    P3_8XLARGE("p3.8xlarge", AwsInstanceFamilyEnum.P3),
    P3_16XLARGE("p3.16xlarge", AwsInstanceFamilyEnum.P3),
    C5_LARGE("c5.large", AwsInstanceFamilyEnum.C5),
    C5_XLARGE("c5.xlarge", AwsInstanceFamilyEnum.C5),
    C5_2XLARGE("c5.2xlarge", AwsInstanceFamilyEnum.C5),
    C5_4XLARGE("c5.4xlarge", AwsInstanceFamilyEnum.C5),
    C5_9XLARGE("c5.9xlarge", AwsInstanceFamilyEnum.C5),
    C5_18XLARGE("c5.18xlarge", AwsInstanceFamilyEnum.C5),
    X1E_XLARGE("x1e.xlarge", AwsInstanceFamilyEnum.X1E),
    X1E_2XLARGE("x1e.2xlarge", AwsInstanceFamilyEnum.X1E),
    X1E_4XLARGE("x1e.4xlarge", AwsInstanceFamilyEnum.X1E),
    X1E_8XLARGE("x1e.8xlarge", AwsInstanceFamilyEnum.X1E),
    X1E_16XLARGE("x1e.16xlarge", AwsInstanceFamilyEnum.X1E),
    X1E_32XLARGE("x1e.32xlarge", AwsInstanceFamilyEnum.X1E),
    M5_LARGE("m5.large", AwsInstanceFamilyEnum.M5),
    M5_XLARGE("m5.xlarge", AwsInstanceFamilyEnum.M5),
    M5_2XLARGE("m5.2xlarge", AwsInstanceFamilyEnum.M5),
    M5_4XLARGE("m5.4xlarge", AwsInstanceFamilyEnum.M5),
    M5_8XLARGE("m5.8xlarge", AwsInstanceFamilyEnum.M5),
    M5_12XLARGE("m5.12xlarge", AwsInstanceFamilyEnum.M5),
    M5_24XLARGE("m5.24xlarge", AwsInstanceFamilyEnum.M5),
    H1_2XLARGE("h1.2xlarge", AwsInstanceFamilyEnum.H1),
    H1_4XLARGE("h1.4xlarge", AwsInstanceFamilyEnum.H1),
    H1_8XLARGE("h1.8xlarge", AwsInstanceFamilyEnum.H1),
    H1_16XLARGE("h1.16xlarge", AwsInstanceFamilyEnum.H1),

    C5D_18XLARGE("c5d.18xlarge", AwsInstanceFamilyEnum.C5D),
    C5D_12XLARGE("c5d.12xlarge", AwsInstanceFamilyEnum.C5D),
    C5D_24XLARGE("c5d.24xlarge", AwsInstanceFamilyEnum.C5D),
    C5D_2XLARGE("c5d.2xlarge", AwsInstanceFamilyEnum.C5D),
    C5D_4XLARGE("c5d.4xlarge", AwsInstanceFamilyEnum.C5D),
    C5D_9XLARGE("c5d.9xlarge", AwsInstanceFamilyEnum.C5D),
    C5D_LARGE("c5d.large", AwsInstanceFamilyEnum.C5D),
    C5D_XLARGE("c5d.xlarge", AwsInstanceFamilyEnum.C5D),

    M5D_12XLARGE("m5d.12xlarge", AwsInstanceFamilyEnum.M5D),
    M5D_16XLARGE("m5d.16xlarge", AwsInstanceFamilyEnum.M5D),
    M5D_24XLARGE("m5d.24xlarge", AwsInstanceFamilyEnum.M5D),
    M5D_2XLARGE("m5d.2xlarge", AwsInstanceFamilyEnum.M5D),
    M5D_4XLARGE("m5d.4xlarge", AwsInstanceFamilyEnum.M5D),
    M5D_LARGE("m5d.large", AwsInstanceFamilyEnum.M5D),
    M5D_XLARGE("m5d.xlarge", AwsInstanceFamilyEnum.M5D),

    M5DN_LARGE("m5dn.large", AwsInstanceFamilyEnum.M5DN),
    M5DN_XLARGE("m5dn.xlarge", AwsInstanceFamilyEnum.M5DN),
    M5DN_2XLARGE("m5dn.2xlarge", AwsInstanceFamilyEnum.M5DN),
    M5DN_4XLARGE("m5dn.4xlarge", AwsInstanceFamilyEnum.M5DN),
    M5DN_8XLARGE("m5dn.8xlarge", AwsInstanceFamilyEnum.M5DN),
    M5DN_12XLARGE("m5dn.12xlarge", AwsInstanceFamilyEnum.M5DN),
    M5DN_16XLARGE("m5dn.16xlarge", AwsInstanceFamilyEnum.M5DN),
    M5DN_24XLARGE("m5dn.24xlarge", AwsInstanceFamilyEnum.M5DN),
    M5DN_METAL("m5dn.metal", AwsInstanceFamilyEnum.M5DN),

    M5N_LARGE("m5n.large", AwsInstanceFamilyEnum.M5N),
    M5N_XLARGE("m5n.xlarge", AwsInstanceFamilyEnum.M5N),
    M5N_2XLARGE("m5n.2xlarge", AwsInstanceFamilyEnum.M5N),
    M5N_4XLARGE("m5n.4xlarge", AwsInstanceFamilyEnum.M5N),
    M5N_8XLARGE("m5n.8xlarge", AwsInstanceFamilyEnum.M5N),
    M5N_12XLARGE("m5n.12xlarge", AwsInstanceFamilyEnum.M5N),
    M5N_16XLARGE("m5n.16xlarge", AwsInstanceFamilyEnum.M5N),
    M5N_24XLARGE("m5n.24xlarge", AwsInstanceFamilyEnum.M5N),
    M5N_METAL("m5n.metal", AwsInstanceFamilyEnum.M5N),

    R5N_LARGE("r5n.large", AwsInstanceFamilyEnum.R5N),
    R5N_XLARGE("r5n.xlarge", AwsInstanceFamilyEnum.R5N),
    R5N_2XLARGE("r5n.2xlarge", AwsInstanceFamilyEnum.R5N),
    R5N_4XLARGE("r5n.4xlarge", AwsInstanceFamilyEnum.R5N),
    R5N_8XLARGE("r5n.8xlarge", AwsInstanceFamilyEnum.R5N),
    R5N_12XLARGE("r5n.12xlarge", AwsInstanceFamilyEnum.R5N),
    R5N_16XLARGE("r5n.16xlarge", AwsInstanceFamilyEnum.R5N),
    R5N_24XLARGE("r5n.24xlarge", AwsInstanceFamilyEnum.R5N),
    R5N_METAL("r5n.metal", AwsInstanceFamilyEnum.R5N),

    R5DN_LARGE("r5dn.large", AwsInstanceFamilyEnum.R5DN),
    R5DN_XLARGE("r5dn.xlarge", AwsInstanceFamilyEnum.R5DN),
    R5DN_2XLARGE("r5dn.2xlarge", AwsInstanceFamilyEnum.R5DN),
    R5DN_4XLARGE("r5dn.4xlarge", AwsInstanceFamilyEnum.R5DN),
    R5DN_8XLARGE("r5dn.8xlarge", AwsInstanceFamilyEnum.R5DN),
    R5DN_12XLARGE("r5dn.12xlarge", AwsInstanceFamilyEnum.R5DN),
    R5DN_16XLARGE("r5dn.16xlarge", AwsInstanceFamilyEnum.R5DN),
    R5DN_24XLARGE("r5dn.24xlarge", AwsInstanceFamilyEnum.R5DN),
    R5DN_METAL("r5dn.metal", AwsInstanceFamilyEnum.R5DN),

    M5A_LARGE("m5a.large", AwsInstanceFamilyEnum.M5A),
    M5A_XLARGE("m5a.xlarge", AwsInstanceFamilyEnum.M5A),
    M5A_2XLARGE("m5a.2xlarge", AwsInstanceFamilyEnum.M5A),
    M5A_4XLARGE("m5a.4xlarge", AwsInstanceFamilyEnum.M5A),
    M5A_8XLARGE("m5a.8xlarge", AwsInstanceFamilyEnum.M5A),
    M5A_12XLARGE("m5a.12xlarge", AwsInstanceFamilyEnum.M5A),
    M5A_24XLARGE("m5a.24xlarge", AwsInstanceFamilyEnum.M5A),

    P4D_24XLARGE("p4d.24xlarge", AwsInstanceFamilyEnum.P4D),

    R5A_LARGE("r5a.large", AwsInstanceFamilyEnum.R5A),
    R5A_XLARGE("r5a.xlarge", AwsInstanceFamilyEnum.R5A),
    R5A_2XLARGE("r5a.2xlarge", AwsInstanceFamilyEnum.R5A),
    R5A_4XLARGE("r5a.4xlarge", AwsInstanceFamilyEnum.R5A),
    R5A_12XLARGE("r5a.12xlarge", AwsInstanceFamilyEnum.R5A),
    R5A_24XLARGE("r5a.24xlarge", AwsInstanceFamilyEnum.R5A),

    R5D_LARGE("r5d.large", AwsInstanceFamilyEnum.R5D),
    R5D_XLARGE("r5d.xlarge", AwsInstanceFamilyEnum.R5D),
    R5D_2XLARGE("r5d.2xlarge", AwsInstanceFamilyEnum.R5D),
    R5D_4XLARGE("r5d.4xlarge", AwsInstanceFamilyEnum.R5D),
    R5D_12XLARGE("r5d.12xlarge", AwsInstanceFamilyEnum.R5D),
    R5D_24XLARGE("r5d.24xlarge", AwsInstanceFamilyEnum.R5D),

    I3_METAL("i3.metal", AwsInstanceFamilyEnum.I3),
    R5_12XLARGE("r5.12xlarge", AwsInstanceFamilyEnum.R5),
    R5_24XLARGE("r5.24xlarge", AwsInstanceFamilyEnum.R5),
    R5_2XLARGE("r5.2xlarge", AwsInstanceFamilyEnum.R5),
    R5_4XLARGE("r5.4xlarge", AwsInstanceFamilyEnum.R5),
    R5_8XLARGE("r5.8xlarge", AwsInstanceFamilyEnum.R5),
    R5_LARGE("r5.large", AwsInstanceFamilyEnum.R5),
    R5_XLARGE("r5.xlarge", AwsInstanceFamilyEnum.R5),
    Z1D_12XLARGE("z1d.12xlarge", AwsInstanceFamilyEnum.Z1D),
    Z1D_2XLARGE("z1d.2xlarge", AwsInstanceFamilyEnum.Z1D),
    Z1D_3XLARGE("z1d.3xlarge", AwsInstanceFamilyEnum.Z1D),
    Z1D_6XLARGE("z1d.6xlarge", AwsInstanceFamilyEnum.Z1D),
    Z1D_LARGE("z1d.large", AwsInstanceFamilyEnum.Z1D),
    Z1D_XLARGE("z1d.xlarge", AwsInstanceFamilyEnum.Z1D),
    T3_2XLARGE("t3.2xlarge", AwsInstanceFamilyEnum.T3),
    T3_LARGE("t3.large", AwsInstanceFamilyEnum.T3),
    T3_MEDIUM("t3.medium", AwsInstanceFamilyEnum.T3),
    T3_MICRO("t3.micro", AwsInstanceFamilyEnum.T3),
    T3_NANO("t3.nano", AwsInstanceFamilyEnum.T3),
    T3_SMALL("t3.small", AwsInstanceFamilyEnum.T3),
    T3_XLARGE("t3.xlarge", AwsInstanceFamilyEnum.T3),
    G3S_XLARGE("g3s.xlarge", AwsInstanceFamilyEnum.G3S),
    C5N_18XLARGE("c5n.18xlarge", AwsInstanceFamilyEnum.C5N),
    C5N_2XLARGE("c5n.2xlarge", AwsInstanceFamilyEnum.C5N),
    C5N_4XLARGE("c5n.4xlarge", AwsInstanceFamilyEnum.C5N),
    C5N_9XLARGE("c5n.9xlarge", AwsInstanceFamilyEnum.C5N),
    C5N_LARGE("c5n.large", AwsInstanceFamilyEnum.C5N),
    C5N_XLARGE("c5n.xlarge", AwsInstanceFamilyEnum.C5N),
    A1_2XLARGE("a1.2xlarge", AwsInstanceFamilyEnum.A1),
    A1_4XLARGE("a1.4xlarge", AwsInstanceFamilyEnum.A1),
    A1_LARGE("a1.large", AwsInstanceFamilyEnum.A1),

    T3A_2XLARGE("t3a.2xlarge", AwsInstanceFamilyEnum.T3A),
    T3A_LARGE("t3a.large", AwsInstanceFamilyEnum.T3A),
    T3A_MEDIUM("t3a.medium", AwsInstanceFamilyEnum.T3A),
    T3A_MICRO("t3a.micro", AwsInstanceFamilyEnum.T3A),
    T3A_NANO("t3a.nano", AwsInstanceFamilyEnum.T3A),
    T3A_SMALL("t3a.small", AwsInstanceFamilyEnum.T3A),
    T3A_XLARGE("t3a.xlarge", AwsInstanceFamilyEnum.T3A),

    I3EN_12XLARGE("i3en.12xlarge", AwsInstanceFamilyEnum.I3EN),
    I3EN_24XLARGE("i3en.24xlarge", AwsInstanceFamilyEnum.I3EN),
    I3EN_2XLARGE("i3en.2xlarge", AwsInstanceFamilyEnum.I3EN),
    I3EN_3XLARGE("i3en.3xlarge", AwsInstanceFamilyEnum.I3EN),
    I3EN_6XLARGE("i3en.6xlarge", AwsInstanceFamilyEnum.I3EN),
    I3EN_LARGE("i3en.large", AwsInstanceFamilyEnum.I3EN),
    I3EN_XLARGE("i3en.xlarge", AwsInstanceFamilyEnum.I3EN),
    I3EN_METAL("i3en.metal", AwsInstanceFamilyEnum.I3EN),
    R5AD_12XLARGE("r5ad.12xlarge", AwsInstanceFamilyEnum.R5AD),
    R5AD_24XLARGE("r5ad.24xlarge", AwsInstanceFamilyEnum.R5AD),
    R5AD_2XLARGE("r5ad.2xlarge", AwsInstanceFamilyEnum.R5AD),
    R5AD_4XLARGE("r5ad.4xlarge", AwsInstanceFamilyEnum.R5AD),
    R5AD_LARGE("r5ad.large", AwsInstanceFamilyEnum.R5AD),
    R5AD_XLARGE("r5ad.xlarge", AwsInstanceFamilyEnum.R5AD),
    M5AD_12XLARGE("m5ad.12xlarge", AwsInstanceFamilyEnum.M5AD),
    M5AD_24XLARGE("m5ad.24xlarge", AwsInstanceFamilyEnum.M5AD),
    M5AD_2XLARGE("m5ad.2xlarge", AwsInstanceFamilyEnum.M5AD),
    M5AD_4XLARGE("m5ad.4xlarge", AwsInstanceFamilyEnum.M5AD),
    M5AD_LARGE("m5ad.large", AwsInstanceFamilyEnum.M5AD),
    M5AD_XLARGE("m5ad.xlarge", AwsInstanceFamilyEnum.M5AD),

    M6G_MEDIUM("m6g.medium", AwsInstanceFamilyEnum.M6G),
    M6G_LARGE("m6g.large", AwsInstanceFamilyEnum.M6G),
    M6G_XLARGE("m6g.xlarge", AwsInstanceFamilyEnum.M6G),
    M6G_2XLARGE("m6g.2xlarge", AwsInstanceFamilyEnum.M6G),
    M6G_4XLARGE("m6g.4xlarge", AwsInstanceFamilyEnum.M6G),
    M6G_8XLARGE("m6g.8xlarge", AwsInstanceFamilyEnum.M6G),
    M6G_12XLARGE("m6g.12xlarge", AwsInstanceFamilyEnum.M6G),
    M6G_16XLARGE("m6g.16xlarge", AwsInstanceFamilyEnum.M6G),
    M6G_METAL("m6g.metal", AwsInstanceFamilyEnum.M6G),

    C5A_LARGE("c5a.large", AwsInstanceFamilyEnum.C5A),
    C5A_XLARGE("c5a.xlarge", AwsInstanceFamilyEnum.C5A),
    C5A_2XLARGE("c5a.2xlarge", AwsInstanceFamilyEnum.C5A),
    C5A_4XLARGE("c5a.4xlarge", AwsInstanceFamilyEnum.C5A),
    C5A_8XLARGE("c5a.8xlarge", AwsInstanceFamilyEnum.C5A),
    C5A_12XLARGE("c5a.12xlarge", AwsInstanceFamilyEnum.C5A),
    C5A_16XLARGE("c5a.16xlarge", AwsInstanceFamilyEnum.C5A),
    C5A_24XLARGE("c5a.24xlarge", AwsInstanceFamilyEnum.C5A),

    C6G_MEDIUM("c6g.medium", AwsInstanceFamilyEnum.C6G),
    C6G_LARGE("c6g.large", AwsInstanceFamilyEnum.C6G),
    C6G_XLARGE("c6g.xlarge", AwsInstanceFamilyEnum.C6G),
    C6G_2XLARGE("c6g.2xlarge", AwsInstanceFamilyEnum.C6G),
    C6G_4XLARGE("c6g.4xlarge", AwsInstanceFamilyEnum.C6G),
    C6G_8XLARGE("c6g.8xlarge", AwsInstanceFamilyEnum.C6G),
    C6G_12XLARGE("c6g.12xlarge", AwsInstanceFamilyEnum.C6G),
    C6G_16XLARGE("c6g.16xlarge", AwsInstanceFamilyEnum.C6G),
    C6G_METAL("c6g.metal", AwsInstanceFamilyEnum.C6G),

    R6G_MEDIUM("r6g.medium", AwsInstanceFamilyEnum.R6G),
    R6G_LARGE("r6g.large", AwsInstanceFamilyEnum.R6G),
    R6G_XLARGE("r6g.xlarge", AwsInstanceFamilyEnum.R6G),
    R6G_2XLARGE("r6g.2xlarge", AwsInstanceFamilyEnum.R6G),
    R6G_4XLARGE("r6g.4xlarge", AwsInstanceFamilyEnum.R6G),
    R6G_8XLARGE("r6g.8xlarge", AwsInstanceFamilyEnum.R6G),
    R6G_12XLARGE("r6g.12xlarge", AwsInstanceFamilyEnum.R6G),
    R6G_16XLARGE("r6g.16xlarge", AwsInstanceFamilyEnum.R6G),
    R6G_METAL("r6g.metal", AwsInstanceFamilyEnum.R6G),

    M6GD_MEDIUM("m6gd.medium", AwsInstanceFamilyEnum.M6GD),
    M6GD_LARGE("m6gd.large", AwsInstanceFamilyEnum.M6GD),
    M6GD_XLARGE("m6gd.xlarge", AwsInstanceFamilyEnum.M6GD),
    M6GD_2XLARGE("m6gd.2xlarge", AwsInstanceFamilyEnum.M6GD),
    M6GD_4XLARGE("m6gd.4xlarge", AwsInstanceFamilyEnum.M6GD),
    M6GD_8XLARGE("m6gd.8xlarge", AwsInstanceFamilyEnum.M6GD),
    M6GD_12XLARGE("m6gd.12xlarge", AwsInstanceFamilyEnum.M6GD),
    M6GD_16XLARGE("m6gd.16xlarge", AwsInstanceFamilyEnum.M6GD),
    M6GD_METAL("m6gd.metal", AwsInstanceFamilyEnum.M6GD),

    C6GD_MEDIUM("c6gd.medium", AwsInstanceFamilyEnum.C6GD),
    C6GD_LARGE("c6gd.large", AwsInstanceFamilyEnum.C6GD),
    C6GD_XLARGE("c6gd.xlarge", AwsInstanceFamilyEnum.C6GD),
    C6GD_2XLARGE("c6gd.2xlarge", AwsInstanceFamilyEnum.C6GD),
    C6GD_4XLARGE("c6gd.4xlarge", AwsInstanceFamilyEnum.C6GD),
    C6GD_8XLARGE("c6gd.8xlarge", AwsInstanceFamilyEnum.C6GD),
    C6GD_12XLARGE("c6gd.12xlarge", AwsInstanceFamilyEnum.C6GD),
    C6GD_16XLARGE("c6gd.16xlarge", AwsInstanceFamilyEnum.C6GD),
    C6GD_METAL("c6gd.metal", AwsInstanceFamilyEnum.C6GD),

    D3EN_XLARGE("d3en.xlarge", AwsInstanceFamilyEnum.D3EN),
    D3EN_2XLARGE("d3en.2xlarge", AwsInstanceFamilyEnum.D3EN),
    D3EN_4XLARGE("d3en.4xlarge", AwsInstanceFamilyEnum.D3EN),
    D3EN_6XLARGE("d3en.6xlarge", AwsInstanceFamilyEnum.D3EN),
    D3EN_8XLARGE("d3en.8xlarge", AwsInstanceFamilyEnum.D3EN),
    D3EN_12XLARGE("d3en.12xlarge", AwsInstanceFamilyEnum.D3EN),

    D3_XLARGE("d3.xlarge", AwsInstanceFamilyEnum.D3),
    D3_2XLARGE("d3.2xlarge", AwsInstanceFamilyEnum.D3),
    D3_4XLARGE("d3.4xlarge", AwsInstanceFamilyEnum.D3),
    D3_8XLARGE("d3.8xlarge", AwsInstanceFamilyEnum.D3),

    R5B_LARGE("r5b.large", AwsInstanceFamilyEnum.R5B),
    R5B_XLARGE("r5b.xlarge", AwsInstanceFamilyEnum.R5B),
    R5B_2XLARGE("r5b.2xlarge", AwsInstanceFamilyEnum.R5B),
    R5B_4XLARGE("r5b.4xlarge", AwsInstanceFamilyEnum.R5B),
    R5B_8XLARGE("r5b.8xlarge", AwsInstanceFamilyEnum.R5B),
    R5B_12XLARGE("r5b.12xlarge", AwsInstanceFamilyEnum.R5B),
    R5B_16XLARGE("r5b.16xlarge", AwsInstanceFamilyEnum.R5B),
    R5B_24XLARGE("r5b.24xlarge", AwsInstanceFamilyEnum.R5B),
    R5B_METAL("r5b.metal", AwsInstanceFamilyEnum.R5B),

    M5ZN_LARGE("m5zn.large", AwsInstanceFamilyEnum.M5ZN),
    M5ZN_XLARGE("m5zn.xlarge", AwsInstanceFamilyEnum.M5ZN),
    M5ZN_2XLARGE("m5zn.2xlarge", AwsInstanceFamilyEnum.M5ZN),
    M5ZN_3XLARGE("m5zn.3xlarge", AwsInstanceFamilyEnum.M5ZN),
    M5ZN_6XLARGE("m5zn.6xlarge", AwsInstanceFamilyEnum.M5ZN),
    M5ZN_12XLARGE("m5zn.12xlarge", AwsInstanceFamilyEnum.M5ZN),
    M5ZN_METAL("m5zn.metal", AwsInstanceFamilyEnum.M5ZN),

    R6GD_MEDIUM("r6gd.medium", AwsInstanceFamilyEnum.R6GD),
    R6GD_LARGE("r6gd.large", AwsInstanceFamilyEnum.R6GD),
    R6GD_XLARGE("r6gd.xlarge", AwsInstanceFamilyEnum.R6GD),
    R6GD_2XLARGE("r6gd.2xlarge", AwsInstanceFamilyEnum.R6GD),
    R6GD_4XLARGE("r6gd.4xlarge", AwsInstanceFamilyEnum.R6GD),
    R6GD_8XLARGE("r6gd.8xlarge", AwsInstanceFamilyEnum.R6GD),
    R6GD_12XLARGE("r6gd.12xlarge", AwsInstanceFamilyEnum.R6GD),
    R6GD_16XLARGE("r6gd.16xlarge", AwsInstanceFamilyEnum.R6GD),
    R6GD_METAL("r6gd.metal", AwsInstanceFamilyEnum.R6GD),

    G4AD_4XLARGE("g4ad.4xlarge", AwsInstanceFamilyEnum.G4AD),
    G4AD_8XLARGE("g4ad.8xlarge", AwsInstanceFamilyEnum.G4AD),
    G4AD_16XLARGE("g4ad.16xlarge", AwsInstanceFamilyEnum.G4AD);

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
