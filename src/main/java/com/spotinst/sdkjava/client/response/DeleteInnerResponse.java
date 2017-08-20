package com.spotinst.sdkjava.client.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by ohadmuchnik on 3/13/16.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class DeleteInnerResponse extends BaseInnerResponse {
    public DeleteInnerResponse() {

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

    @JsonProperty("removed")
    private Boolean removed;


    public Integer getAffectedRows() {
        return affectedRows;
    }

    public void setAffectedRows(Integer affectedRows) {
        this.affectedRows = affectedRows;
    }

    @JsonProperty("removed")
    public Boolean isRemoved() {
        return removed;
    }

    @JsonProperty("removed")
    public void setRemoved(Boolean removed) {
        this.removed = removed;
    }
}
