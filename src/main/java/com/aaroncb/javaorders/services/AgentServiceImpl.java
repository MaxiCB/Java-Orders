package com.aaroncb.javaorders.services;

import com.aaroncb.javaorders.models.Agent;
import com.aaroncb.javaorders.models.Customer;
import com.aaroncb.javaorders.repos.AgentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Service(value = "agentService")
public class AgentServiceImpl implements AgentService {

    @Autowired
    private AgentRepository agentRepository;

    @Override
    public List<Agent> findAllAgents()
    {
        List<Agent> list = new ArrayList<>();
        agentRepository.findAll()
                .iterator()
                .forEachRemaining(list::add);
        return list;
    }

    @Override
    public Agent findAgentById(long id) throws EntityNotFoundException
    {
        return agentRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Agent " + Long.toString(id) + " Not Found"));
    }
}
