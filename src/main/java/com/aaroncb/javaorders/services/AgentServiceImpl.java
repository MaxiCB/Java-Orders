package com.aaroncb.javaorders.services;

import com.aaroncb.javaorders.models.Agent;
import com.aaroncb.javaorders.models.Customer;
import com.aaroncb.javaorders.repos.AgentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;

@Transactional
@Service(value = "agentService")
public class AgentServiceImpl implements AgentService {

    @Autowired
    private AgentRepository agentRepository;

    @Override
    public Agent findAgentById(long id) throws EntityNotFoundException
    {
        return agentRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Agent " + Long.toString(id) + " Not Found"));
    }
}
