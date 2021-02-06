package com.microservices.backofficeagentapi.models;

public class SubscriptionRequest {
    private String agentFirstName;
    private String agentLastName;
    private String agentIdNum;
    private String agentBirth;
    private String agentAddress;
    private String agentEmail;
    private String agentTel;
    private String agentImmatriculation;
    private String agentPatent;
    private String agentCIN;

    public SubscriptionRequest() {
    }

    public String getAgentFirstName() {
        return agentFirstName;
    }

    public void setAgentFirstName(String agentFirstName) {
        this.agentFirstName = agentFirstName;
    }

    public String getAgentLastName() {
        return agentLastName;
    }

    public void setAgentLastName(String agentLastName) {
        this.agentLastName = agentLastName;
    }

    public String getAgentIdNum() {
        return agentIdNum;
    }

    public void setAgentIdNum(String agentIdNum) {
        this.agentIdNum = agentIdNum;
    }

    public String getAgentBirth() {
        return agentBirth;
    }

    public void setAgentBirth(String agentBirth) {
        this.agentBirth = agentBirth;
    }

    public String getAgentAddress() {
        return agentAddress;
    }

    public void setAgentAddress(String agentAddress) {
        this.agentAddress = agentAddress;
    }

    public String getAgentEmail() {
        return agentEmail;
    }

    public void setAgentEmail(String agentEmail) {
        this.agentEmail = agentEmail;
    }

    public String getAgentTel() {
        return agentTel;
    }

    public void setAgentTel(String agentTel) {
        this.agentTel = agentTel;
    }

    public String getAgentImmatriculation() {
        return agentImmatriculation;
    }

    public void setAgentImmatriculation(String agentImmatriculation) {
        this.agentImmatriculation = agentImmatriculation;
    }

    public String getAgentPatent() {
        return agentPatent;
    }

    public void setAgentPatent(String agentPatent) {
        this.agentPatent = agentPatent;
    }

    public String getAgentCIN() {
        return agentCIN;
    }

    public void setAgentCIN(String agentCIN) {
        this.agentCIN = agentCIN;
    }
}
