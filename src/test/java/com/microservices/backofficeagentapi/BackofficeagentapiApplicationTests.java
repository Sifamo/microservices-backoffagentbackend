package com.microservices.backofficeagentapi;

import com.microservices.backofficeagentapi.models.*;
import com.microservices.backofficeagentapi.repository.AgentRepository;
import com.microservices.backofficeagentapi.repository.ClientRepository;
import com.microservices.backofficeagentapi.services.BackOffAgentService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import sun.management.Agent;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
class BackofficeagentapiApplicationTests {

        @Test
    void contextLoads() {
    }

}
