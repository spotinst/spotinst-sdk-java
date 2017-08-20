package com.spotinst.sdkjava.client.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.spotinst.sdkjava.exception.HttpError;

import java.util.List;

/**
 * Created by aharontwizer on 7/18/15.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ErrorsInnerResponse  extends BaseInnerResponse {
    public ErrorsInnerResponse() {

    }

    @JsonProperty
    private List<HttpError> errors;

    public List<HttpError> getErrors() {
        return errors;
    }

    public void setErrors(List<HttpError> errors) {
        this.errors = errors;
    }
}
