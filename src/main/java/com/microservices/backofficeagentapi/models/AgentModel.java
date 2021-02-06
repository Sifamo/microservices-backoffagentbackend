package com.microservices.backofficeagentapi.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "agents")
public class AgentModel {
    @Id
    private String id;
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
    private String username;
    private String password;

    public AgentModel() {
    }

    public String getId() {
        return id;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
