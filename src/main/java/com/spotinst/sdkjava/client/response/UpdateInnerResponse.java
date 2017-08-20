package com.spotinst.sdkjava.client.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by aharontwizer on 7/18/15.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class UpdateInnerResponse extends BaseInnerResponse {
    public UpdateInnerResponse() {

    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    @JsonProperty
    private String kind;

    @JsonProperty
    private Integer affectedRows;


    public Integer getAffectedRows() {
        return affectedRows;
    }

    public void setAffectedRows(Integer affectedRows) {
        this.affectedRows = affectedRows;
    }
}
