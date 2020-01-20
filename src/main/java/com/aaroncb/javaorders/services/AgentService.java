package com.aaroncb.javaorders.services;

import com.aaroncb.javaorders.models.Agent;

import java.util.List;

public interface AgentService {

    List<Agent> findAllAgents();

    Agent findAgentById(long id);
}
