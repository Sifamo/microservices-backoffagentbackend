package com.microservices.backofficeagentapi.Resources;

import com.microservices.backofficeagentapi.models.*;
import com.microservices.backofficeagentapi.services.BackOffAgentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;


@RestController
public class AuthController {

    @Autowired
    private BackOffAgentService backOffAgentService;

    @CrossOrigin(origins="http://localhost:4200")
//    @PostMapping("/subClient")
    @RequestMapping(value = "/subClient", consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
    private ResponseEntity<?> subscribeClient(@RequestBody SubClientRequest subClientRequest){

        if(backOffAgentService.subscribeClient(subClientRequest) == null){
            return ResponseEntity.ok(new SubscriptionResponse("error"));

        }
        return ResponseEntity.ok(new SubscriptionResponse("success"));
    }

    @CrossOrigin(origins="http://localhost:4200")
    @PostMapping("/subAgent")
    private ResponseEntity<?> subscribeAgent(@RequestBody SubscriptionRequest subscriptionRequest){
        if(backOffAgentService.subscribeAgent(subscriptionRequest) == null){
            return ResponseEntity.ok(new SubscriptionResponse("error"));

        }
        return ResponseEntity.ok(new SubscriptionResponse("success"));
    }

    @CrossOrigin(origins="http://localhost:4200")
    @PostMapping("/agentAuth")
    private ResponseEntity<?> authenticateAgent(@RequestBody AuthenticationRequest authenticationRequest) {
        if(backOffAgentService.authenticateAgent(authenticationRequest).equals("error")){
            return ResponseEntity.ok(new SubscriptionResponse("error"));

        }
        return ResponseEntity.ok(new SubscriptionResponse("success"));
    }

    @CrossOrigin(origins="http://localhost:4200")
    @PostMapping("/backoffauth")
    private ResponseEntity<?> authenticateBackoffice(@RequestBody AuthenticationRequest authenticationRequest) {
        System.out.println(authenticationRequest);
        if(backOffAgentService.authenticateBackoffice(authenticationRequest).equals("error")){
            return ResponseEntity.ok(new SubscriptionResponse("error"));

        }
        return ResponseEntity.ok(new SubscriptionResponse("success"));

    }


}
