package com.microservices.backofficeagentapi.services;

import com.microservices.backofficeagentapi.models.*;
import com.microservices.backofficeagentapi.repository.AgentRepository;
import com.microservices.backofficeagentapi.repository.ClientRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.runner.Runner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
class BackOffAgentServiceTest {
    @Autowired
    private BackOffAgentService backOffAgentService;

    @MockBean
    private AgentRepository agentRepository;

    @MockBean
    private ClientRepository clientRepository;


    @Test
    void subscribeClient() {
        SubClientRequest clientReq = new SubClientRequest();
        clientReq.setClientFirstName("Hoshi");
        clientReq.setClientLastName("Zora");
        clientReq.setClientEmail("email@gmail.com");
        clientReq.setClientTel("0689455248");
        clientReq.setClientAccountType("20000");


        ClientModel client = new ClientModel();
        client.setClientFirstName("Hoshi");
        client.setClientLastName("Zora");
        client.setClientEmail("email@gmail.com");
        client.setClientTel("0689455248");
        client.setClientAccountType("20000");
        client.setAgentId("agent1");

        when(clientRepository.save(client)).thenReturn(client);
        assertEquals(client.getAgentId(), backOffAgentService.subscribeClient(clientReq).getAgentId());
    }

    @Test
    void subscribeAgent() {
        SubscriptionRequest agentReq = new SubscriptionRequest();
        agentReq.setAgentFirstName("Hoshi");
        agentReq.setAgentLastName("Zora");
        agentReq.setAgentAddress("Hay al fallah");
        agentReq.setAgentBirth("15-8-1660");
        agentReq.setAgentEmail("email@gmail.com");
        agentReq.setAgentImmatriculation("azs45ere8");
        agentReq.setAgentIdNum("fg784512");
        agentReq.setAgentPatent("eza7854dsq");
        agentReq.setAgentTel("0645879562");

        AgentModel agentModel = new AgentModel();
        agentModel.setAgentFirstName("Hoshi");
        agentModel.setAgentLastName("Zora");
        agentModel.setAgentIdNum("fg784512");
        agentModel.setAgentBirth("15-8-1660");
        agentModel.setAgentAddress("Hay al fallah");
        agentModel.setAgentEmail("email@gmail.com");
        agentModel.setAgentTel("0645879562");
        agentModel.setAgentImmatriculation("azs45ere8");
        agentModel.setAgentPatent("eza7854dsq");
        agentModel.setUsername("Hoshi Zora");

        assertEquals(agentModel.getUsername(), backOffAgentService.subscribeAgent(agentReq).getUsername());
    }

    @Test
    void authenticateAgent() {
        AuthenticationRequest authenticationRequest = new AuthenticationRequest();
        authenticationRequest.setUsername("testLogin");
        authenticationRequest.setPassword("testPassword");

        AgentModel agent = new AgentModel();
        agent.setUsername("testLogin");
        agent.setPassword("testPassword");

        when(agentRepository.findByUsername(authenticationRequest.getUsername())).thenReturn(agent);
        assertEquals(backOffAgentService.authenticateAgent(authenticationRequest), "success");

    }

    @Test
    void authenticateBackoffice() {
        AuthenticationRequest authenticationRequest = new AuthenticationRequest();
        authenticationRequest.setUsername("admin");
        authenticationRequest.setPassword("password");
        assertEquals(backOffAgentService.authenticateBackoffice(authenticationRequest),"success");
    }
}