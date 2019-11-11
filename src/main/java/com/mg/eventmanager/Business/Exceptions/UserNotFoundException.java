package com.mg.eventmanager.Business.Exceptions;

public class UserNotFoundException extends Exception {
    public UserNotFoundException() {
        super();
    }

    @Override
    public String getMessage() {
        return "User wasn't found!";
    }
}
