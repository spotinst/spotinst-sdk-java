package com.spotinst.sdkjava.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Date;

/**
 * Created by yossi.elman on 24/05/2020.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
class ApiProcessSuspensionResult {

    //region Members
    private String name;
    private Date   expiresAt;
    //endregion

    //region Getter and Setter methods
    public String getName() {
        return name;
    }

    public void setName(String name) {
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
