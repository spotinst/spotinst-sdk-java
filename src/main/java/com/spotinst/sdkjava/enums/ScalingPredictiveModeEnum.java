package com.spotinst.sdkjava.enums;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public enum ScalingPredictiveModeEnum {

    FORECAST_ONLY("FORECAST_ONLY"),
    FORECAST_AND_SCALE("FORECAST_AND_SCALE");

    private static final Logger LOGGER = (Logger) LoggerFactory.getLogger(ScalingPredictiveModeEnum.class);
    private final String name;

    private ScalingPredictiveModeEnum(String name) {
        this.name = name;
    }

    public static ScalingPredictiveModeEnum fromName(String name) {
        ScalingPredictiveModeEnum retVal = null;
        for (ScalingPredictiveModeEnum availabilityTypeEnum : ScalingPredictiveModeEnum.values()) {
            if (name.equals(availabilityTypeEnum.name)) {
                retVal = availabilityTypeEnum;
                break;
            }
        }

        if (retVal == null) {
            LOGGER.error("Tried to create predictive-scaling mode enum for: " + name + ", but we don't support such type ");
        }
        return retVal;
    }

    public String getName() {
        return name;
    }
}
