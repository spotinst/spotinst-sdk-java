package com.spotinst.sdkjava.model;

/**
 * Created by yossi.elman on 24/05/2020.
 */
public class ApiProcessSuspension {

    //region Members
    private String  name;
    private Integer ttlInMinutes;
    //endregion

    //region Getter and Setter methods
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getTtlInMinutes() {
        return ttlInMinutes;
    }

    public void setTtlInMinutes(Integer ttlInMinutes) {
        this.ttlInMinutes = ttlInMinutes;
    }
    //endregion
}
