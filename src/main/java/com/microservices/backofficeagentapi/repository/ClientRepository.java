package com.microservices.backofficeagentapi.repository;

import com.microservices.backofficeagentapi.models.ClientModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends MongoRepository<ClientModel, Integer> {
}
