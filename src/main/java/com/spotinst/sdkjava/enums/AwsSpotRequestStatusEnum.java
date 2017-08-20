package com.spotinst.sdkjava.enums;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by aharontwizer on 9/21/15.
 */
public enum AwsSpotRequestStatusEnum {

    // Pending Evaluation
    PENDING_EVALUATION("pending-evaluation", 100, AwsSpotRequestStatusFamilyEnum.PENDING_EVALUATION),

    // Holding
    CAPACITY_NOT_AVAILABLE("capacity-not-available", 102, AwsSpotRequestStatusFamilyEnum.HOLDING),
    TERMINATED_CAPACITY_OVERSUBSCRIBED("terminated-capacity-oversubscribed", 103, AwsSpotRequestStatusFamilyEnum.HOLDING),
    PRICE_TOO_LOW("price-too-low", 104, AwsSpotRequestStatusFamilyEnum.HOLDING),
    NOT_SCHEDULED_YET("not-scheduled-yet", 105, AwsSpotRequestStatusFamilyEnum.HOLDING),
    LAUNCH_GROUP_CONSTRAINT("launch-group-constraint", 106, AwsSpotRequestStatusFamilyEnum.HOLDING),
    AZ_GROUP_CONSTRAINT("az-group-constraint", 107, AwsSpotRequestStatusFamilyEnum.HOLDING),
    PLACEMENT_GROUP_CONSTRAINT("placement-group-constraint", 108, AwsSpotRequestStatusFamilyEnum.HOLDING),
    CONSTRAINT_NOT_FULFILLABLE("constraint-not-fulfillable", 109, AwsSpotRequestStatusFamilyEnum.HOLDING),
    CAPACITY_OVERSUBSCRIBED("capacity-oversubscribed", 110, AwsSpotRequestStatusFamilyEnum.HOLDING),

    // Pending fulfillment
    PENDING_FULFILLMENT("pending-fulfillment", 200, AwsSpotRequestStatusFamilyEnum.PENDING_FULFILLMENT),

    // Fulfilled
    FULFILLED("fulfilled", 300, AwsSpotRequestStatusFamilyEnum.FULFILLED),

    // Fulfilled-terminal
    MARKED_FOR_TERMINATION("marked-for-termination", 301, AwsSpotRequestStatusFamilyEnum.FULFILLED_TERMINAL),
    REQUEST_CANCELED_AND_INSTANCE_RUNNING("request-canceled-and-instance-running", 401, AwsSpotRequestStatusFamilyEnum.FULFILLED_TERMINAL),
    INSTANCE_TERMINATED_BY_USER("instance-terminated-by-user", 402, AwsSpotRequestStatusFamilyEnum.FULFILLED_TERMINAL),
    SPOT_INSTANCE_TERMINATED_BY_USER("spot-instance-terminated-by-user", 403, AwsSpotRequestStatusFamilyEnum.FULFILLED_TERMINAL),
    INSTANCE_TERMINATED_BY_PRICE("instance-terminated-by-price", 404, AwsSpotRequestStatusFamilyEnum.FULFILLED_TERMINAL),
    INSTANCE_TERMINATED_NO_CAPACITY("instance-terminated-no-capacity", 405, AwsSpotRequestStatusFamilyEnum.FULFILLED_TERMINAL),
    INSTANCE_TERMINATED_CAPACITY_OVERSUBSCRIBED("instance-terminated-capacity-oversubscribed", 406, AwsSpotRequestStatusFamilyEnum.FULFILLED_TERMINAL),
    INSTANCE_TERMINATED_LAUNCH_GROUP_CONSTRAINT("instance-terminated-launch-group-constraint", 407, AwsSpotRequestStatusFamilyEnum.FULFILLED_TERMINAL),

    // Fulfillment-terminal
    BAD_PARAMETERS("bad-parameters", 101, AwsSpotRequestStatusFamilyEnum.FULFILLMENT_TERMINAL),
    SCHEDULE_EXPIRED("schedule-expired", 501, AwsSpotRequestStatusFamilyEnum.FULFILLMENT_TERMINAL),
    SYSTEM_ERROR("system-error", 502, AwsSpotRequestStatusFamilyEnum.FULFILLMENT_TERMINAL),
    CANCELED_BEFORE_FULFILLMENT("canceled-before-fulfillment", 503, AwsSpotRequestStatusFamilyEnum.FULFILLMENT_TERMINAL),

    // Spotinst custom codes
    SPOTINST_REALTIME_PRICE_IS_TOO_HIGH("market-banned-spot-prices-too-high", 601, null);

    private static final Logger LOGGER = (Logger) LoggerFactory.getLogger(AwsSpotRequestStatusEnum.class);
    private String awsName;
    private Integer code;
    private AwsSpotRequestStatusFamilyEnum statusFamily;
    private AwsSpotRequestStatusEnum(String awsName, Integer code, AwsSpotRequestStatusFamilyEnum statusFamily) {
        this.awsName = awsName;
        this.code = code;
        this.statusFamily = statusFamily;
    }

    public static AwsSpotRequestStatusEnum fromAwsName(String awsName) {
        AwsSpotRequestStatusEnum retVal = null;
        for (AwsSpotRequestStatusEnum awsImageStatusEnum : AwsSpotRequestStatusEnum.values()) {
            if (awsName.equals(awsImageStatusEnum.awsName)) {
                retVal = awsImageStatusEnum;
                break;
            }
        }

        if (retVal == null) {
            LOGGER.error("Tried to create Aws spot request status enum from AWS name : " + awsName + ", but we don't support such status ");
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

    public AwsSpotRequestStatusFamilyEnum getStatusFamily() {
        return statusFamily;
    }

    public void setStatusFamily(AwsSpotRequestStatusFamilyEnum statusFamily) {
        this.statusFamily = statusFamily;
    }
}
