package com.microservices.backofficeagentapi.services;

import com.microservices.backofficeagentapi.models.AgentModel;
import com.microservices.backofficeagentapi.repository.AgentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private AgentRepository agentRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AgentModel foundAgent = agentRepository.findByUsername(username);
        if(foundAgent == null) return null;

        String login = foundAgent.getUsername();
        String pwd = foundAgent.getPassword();

        return new User(login, pwd, new ArrayList<>());
    }
    
}
