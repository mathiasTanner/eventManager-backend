package com.mg.eventmanager.Business.Exceptions;

public class MaxParticipantReachedException extends Exception {
    public MaxParticipantReachedException() {
        super();
    }

    @Override
    public String getMessage() {
        return "Maximum number of participants reached";
    }
}
