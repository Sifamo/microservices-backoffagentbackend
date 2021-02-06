package com.microservices.backofficeagentapi.services;

import com.microservices.backofficeagentapi.models.*;
import com.microservices.backofficeagentapi.repository.AgentRepository;
import com.microservices.backofficeagentapi.repository.ClientRepository;
import org.json.JSONObject;
import org.passay.CharacterRule;
import org.passay.EnglishCharacterData;
import org.passay.PasswordGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.*;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Service
public class BackOffAgentService {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private AgentRepository agentRepository;

    @Autowired
    private AuthenticationManager authenticationManager;


    @Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

    @Autowired
    private RestTemplate restTemplate;

    public ClientModel subscribeClient(SubClientRequest subClientRequest){

        String clientFirstName = subClientRequest.getClientFirstName();
        String clientLastName = subClientRequest.getClientLastName();
        String clientEmail = subClientRequest.getClientEmail();
        String clientTel = subClientRequest.getClientTel();
        String clientAccountType = subClientRequest.getClientAccountType();
        System.out.println("here");


        ClientModel client = new ClientModel();

        client.setId("");
        client.setClientFirstName(clientFirstName);
        client.setClientLastName(clientLastName);
        client.setClientEmail(clientEmail);
        client.setClientTel(clientTel);
        client.setClientAccountType(clientAccountType);
        client.setAgentId("agent1");


//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_JSON);
//        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

//        Map<String,String> map = new HashMap<>();
//        map.put("id", "");
//        map.put("clientFirstName", subClientRequest.getClientFirstName());
//        map.put("clientLastName", subClientRequest.getClientLastName());
//        map.put("clientEmail", subClientRequest.getClientEmail());
//        map.put("clientTel", subClientRequest.getClientTel());
//        map.put("clientAccountType", subClientRequest.getClientAccountType());
//        map.put("agentId", "agent");
//
//
//        HttpEntity<ClientModel> entity = new HttpEntity<>(client);
//        ResponseEntity<?> response = restTemplate.postForEntity(url, client, String.class);

//        JSONObject jsonObject = new JSONObject();
//        jsonObject.put("id","");
//        jsonObject.put("clientFirstName","zineb");
//        jsonObject.put("clientLastName","khalis");
//        jsonObject.put("clientEmail","s@sesting.com");
//        jsonObject.put("clientTel","0222");
//        jsonObject.put("clientAccountType","200");
//        jsonObject.put("agentId","agent");

//        String url = "https://cmi-service0.herokuapp.com/clients";
//        HttpEntity<ClientModel> entity = new HttpEntity<ClientModel>(client);
//        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, entity, String.class);
//
//        if(response.getStatusCode() == HttpStatus.ACCEPTED){
            try {
                clientRepository.save(client);
            } catch(Exception e){
                return null;
            }
            return client;
//        }
//        else{
//            return null;
//        }
    }

    public AgentModel subscribeAgent(SubscriptionRequest subscriptionRequest){

        String agentFirstName = subscriptionRequest.getAgentFirstName();
        String agentLastName = subscriptionRequest.getAgentLastName();
        String agentIdNum = subscriptionRequest.getAgentIdNum();
        String agentBirth = subscriptionRequest.getAgentBirth();
        String agentAddress = subscriptionRequest.getAgentAddress();
        String agentEmail = subscriptionRequest.getAgentEmail();
        String agentTel = subscriptionRequest.getAgentTel();
        String agentImmatriculation = subscriptionRequest.getAgentImmatriculation();
        String agentPatent = subscriptionRequest.getAgentPatent();
        String agentCIN = subscriptionRequest.getAgentCIN();
        String agentUsername = agentFirstName + " " + agentLastName;

        CharacterRule digits = new CharacterRule(EnglishCharacterData.Digit);
        CharacterRule alpha = new CharacterRule(EnglishCharacterData.Alphabetical);
        CharacterRule special = new CharacterRule(EnglishCharacterData.Special);
        PasswordGenerator gen = new PasswordGenerator();

        String agentPassword = gen.generatePassword(10, digits, alpha, special);

        AgentModel agentModel = new AgentModel();
        agentModel.setAgentFirstName(agentFirstName);
        agentModel.setAgentLastName(agentLastName);
        agentModel.setAgentIdNum(agentIdNum);
        agentModel.setAgentBirth(agentBirth);
        agentModel.setAgentAddress(agentAddress);
        agentModel.setAgentEmail(agentEmail);
        agentModel.setAgentTel(agentTel);
        agentModel.setAgentImmatriculation(agentImmatriculation);
        agentModel.setAgentPatent(agentPatent);
        agentModel.setAgentCIN(agentCIN);
        agentModel.setUsername(agentUsername);
        agentModel.setPassword(agentPassword);

        try {
            agentRepository.save(agentModel);

        } catch(Exception e){
            return null;
        }

        return agentModel;
    }

    public String authenticateAgent(AuthenticationRequest authenticationRequest) {

        String username = authenticationRequest.getUsername();
        String password = authenticationRequest.getPassword();

        try{
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch(Exception e){
            return "error";
        }
        return "success";

//        String url = "";
//
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_JSON);
//        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
//
//        Map<String,Object> map = new HashMap<>();
//        map.put("username", username);
//        map.put("password", password);
//
//        HttpEntity<Map<String, Object>> entity = new HttpEntity<>(map, headers);
//
//        ResponseEntity<?> response = this.restTemplate.postForEntity(url, entity, Object.class);
//        String token = response.getHeaders().getFirst(HttpHeaders.AUTHORIZATION);
//        if(response.getStatusCode() != HttpStatus.CREATED)
//            return ResponseEntity.ok(token);
//        return ResponseEntity.ok(new SubscriptionResponse("Error during agent subscription" + username));

    }

    public String authenticateBackoffice(AuthenticationRequest authenticationRequest) {
        String username = authenticationRequest.getUsername();
        String password = authenticationRequest.getPassword();

        System.out.println(username);

        if(username.equals("admin") && password.equals("password"))
            return "success";

        return "error";


    }

}
