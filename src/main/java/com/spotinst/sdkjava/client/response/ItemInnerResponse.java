package com.spotinst.sdkjava.client.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by aharontwizer on 7/18/15.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ItemInnerResponse<T>  extends BaseInnerResponse {
    public ItemInnerResponse() {

    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public T getItem() {
        return item;
    }

    public void setItem(T item) {
        this.item = item;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @JsonProperty
    private String kind;

    @JsonProperty
    private T item;

    @JsonProperty
    private int count;
}
