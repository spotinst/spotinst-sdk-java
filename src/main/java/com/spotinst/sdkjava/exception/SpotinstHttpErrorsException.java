package com.spotinst.sdkjava.exception;

/**
 * Created by talzur on 11/01/2017.
 */

import java.util.List;

/**
 * Base class for all exceptions thrown by the spotinst SDK.
 * Exception may be a client side com.spotinst.sdkjava.exception or an unmarshalled service com.spotinst.sdkjava.exception.
 */
public class SpotinstHttpErrorsException extends SpotinstHttpException {

    private List<HttpError> httpErrors;

    public SpotinstHttpErrorsException(String message, List<HttpError> httpErrors) {
        super(message);
        this.httpErrors = httpErrors;
    }

    public SpotinstHttpErrorsException(String message, Throwable cause, List<HttpError> httpErrors) {
        super(message, cause);
        this.httpErrors = httpErrors;
    }

    public List<HttpError> getHttpErrors() {
        return httpErrors;
    }
}
