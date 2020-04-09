package org.step.fourth.synchronization.exceptions;

public class LockWaitingException extends RuntimeException {

    public LockWaitingException(String message) {
        super(message);
    }
}
