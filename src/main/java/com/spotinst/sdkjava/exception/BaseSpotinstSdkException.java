package com.spotinst.sdkjava.exception;

/**
 * Created by talzur on 11/01/2017.
 */
/**
 *
 * Base class for all exceptions thrown by the spotinst SDK.
 * Exception may be a client side com.spotinst.sdkjava.exception or an unmarshalled service com.spotinst.sdkjava.exception.
 */
class BaseSpotinstSdkException extends RuntimeException {
    private static final long serialVersionUID = 1L;
    /**
     * Creates a new BaseSpotinstSdkException with a specified message, and a root
     * cause.
     *
     * @param message
     *            An error message describing why the com.spotinst.sdkjava.exception was thrown.
     * @param t
     *            The cause of this com.spotinst.sdkjava.exception.
     */
    public BaseSpotinstSdkException(String message, Throwable t) {
        super(message, t);
    }
    /**
     * Creates a new BaseSpotinstSdkException with a specified message.
     *
     * @param message
     *            An error message describing why the com.spotinst.sdkjava.exception was thrown.
     */

    public BaseSpotinstSdkException(String message) {
        super(message);
    }
    /**
     * Creates a new BaseSpotinstSdkException with the root cause.
     *
     * @param t
     *          The cause of this com.spotinst.sdkjava.exception.
     */

    public BaseSpotinstSdkException(Throwable t) {
        super(t);
    }
}
