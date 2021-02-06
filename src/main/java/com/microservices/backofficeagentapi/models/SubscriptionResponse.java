package com.microservices.backofficeagentapi.models;

public class SubscriptionResponse {
    private String response;

    public SubscriptionResponse(String response) {
        this.response = response;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }
}
