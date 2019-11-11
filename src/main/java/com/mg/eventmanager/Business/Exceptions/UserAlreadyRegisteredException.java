package com.mg.eventmanager.Business.Exceptions;

public class UserAlreadyRegisteredException extends Exception{
    public UserAlreadyRegisteredException() {
        super();
    }

    @Override
    public String getMessage() {
        return "User is already registred for this event!";
    }
}
