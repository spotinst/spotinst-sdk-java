package com.spotinst.sdkjava.client.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by snir on 13/12/15.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class KeyValuePair {
    //region Members
    private String key;
    private String value;
    //endregion

    //region Constructors
    public KeyValuePair() {
    }

    public KeyValuePair(String key, String value) {
        this.key = key;
        this.value = value;
    }

    //endregion

    //region Getters & Setters

    //region Key
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
    //endregion

    //region Value
    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
    //endregion

    //endregion
}
