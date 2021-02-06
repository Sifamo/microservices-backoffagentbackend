package com.microservices.backofficeagentapi.models;

public class SubClientRequest {
    private String clientFirstName;
    private String clientLastName;
    private String clientEmail;
    private String clientTel;
    private String clientAccountType;

    public String getClientFirstName() {
        return clientFirstName;
    }

    public void setClientFirstName(String clientFirstName) {
        this.clientFirstName = clientFirstName;
    }

    public String getClientLastName() {
        return clientLastName;
    }

    public void setClientLastName(String clientLastName) {
        this.clientLastName = clientLastName;
    }

    public String getClientEmail() {
        return clientEmail;
    }

    public void setClientEmail(String clientEmail) {
        this.clientEmail = clientEmail;
    }

    public String getClientTel() {
        return clientTel;
    }

    public void setClientTel(String clientTel) {
        this.clientTel = clientTel;
    }

    public String getClientAccountType() {
        return clientAccountType;
    }

    public void setClientAccountType(String clientAccountType) {
        this.clientAccountType = clientAccountType;
    }

    @Override
    public String toString() {
        return "SubClientRequest{" +
                "clientFirstName='" + clientFirstName + '\'' +
                ", clientLastName='" + clientLastName + '\'' +
                ", clientEmail='" + clientEmail + '\'' +
                ", clientTel='" + clientTel + '\'' +
                ", clientAccountType='" + clientAccountType + '\'' +
                '}';
    }
}
