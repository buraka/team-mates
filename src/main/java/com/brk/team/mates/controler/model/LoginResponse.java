package com.brk.team.mates.controler.model;

public class LoginResponse {

    private final boolean successful;

    public LoginResponse(boolean successful) {
        this.successful = successful;
    }

    public boolean isSuccessful() {
        return successful;
    }
}
