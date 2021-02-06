package com.microservices.backofficeagentapi.repository;

import com.microservices.backofficeagentapi.models.AgentModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgentRepository extends MongoRepository<AgentModel, Integer> {

    AgentModel findByUsername(String username);
}
