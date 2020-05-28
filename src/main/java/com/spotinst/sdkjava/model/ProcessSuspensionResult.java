package com.spotinst.sdkjava.model;

import com.spotinst.sdkjava.enums.ProcessNameEnum;

import java.util.Date;

/**
 * Created by yossi.elman on 24/05/2020.
 */

public class ProcessSuspensionResult {

    //region Members
    private ProcessNameEnum name;
    private Date            expiresAt;
    //endregion

    //region Getter and Setter methods
    public ProcessNameEnum getName() {
        return name;
    }

    public void setName(ProcessNameEnum name) {
        this.name = name;
    }

    public Date getExpiresAt() {
        return expiresAt;
    }

    public void setExpiresAt(Date expiresAt) {
        this.expiresAt = expiresAt;
    }
    //endregion
}
