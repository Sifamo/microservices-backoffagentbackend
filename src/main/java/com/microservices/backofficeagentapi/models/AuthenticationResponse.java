package com.microservices.backofficeagentapi.models;

public class AuthenticationResponse {
    public AuthenticationResponse(String response) {
        this.response = response;
    }

    private String response;

    public AuthenticationResponse() {
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }
}
