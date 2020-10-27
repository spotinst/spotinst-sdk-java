package com.spotinst.sdkjava.enums;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public enum GenerationEnumAzure {
    //region Enums
    OLD("old"),
    NEW("new");

    //endregion

    //region Members
    private static final Logger LOGGER = LoggerFactory.getLogger(GenerationEnumAzure.class);
    private              String name;
    //endregion

    //region Constructors
    GenerationEnumAzure(String name) {
        this.name = name;
    }
    //endregion

    //region Methods
    public static GenerationEnumAzure fromName(String name) {
        GenerationEnumAzure retVal = null;

        for (GenerationEnumAzure replacementGeneration : GenerationEnumAzure.values()) {
            if (StringUtils.equalsIgnoreCase(name, replacementGeneration.name)) {
                retVal = replacementGeneration;
                break;
            }
        }

        if (retVal == null) {
            LOGGER.error(
                    "Tried to create replacement generation enum for: " + name + ", but we don't support such type ");
        }

        return retVal;
    }
    //endregion

    //region Getters & Setters
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }

    //endregion
}
