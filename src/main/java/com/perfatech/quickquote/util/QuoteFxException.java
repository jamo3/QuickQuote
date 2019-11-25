package com.perfatech.quickquote.util;

/*
 * A general exception in the application. Every QuoteFxException also holds a
 * flag that indicates whether or not the application can recover from it.
 */
public class QuoteFxException extends Exception {

    private static final long serialVersionUID = 56617506908768378L;
    private final boolean recoverable;
    
    public QuoteFxException(String message, Throwable cause, boolean recoverable) {
        super(message, cause);
        this.recoverable = recoverable;
    }

    public boolean isRecoverable() {
        return recoverable;
    }
}
