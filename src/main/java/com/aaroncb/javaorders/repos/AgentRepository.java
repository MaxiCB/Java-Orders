package com.aaroncb.javaorders.repos;

import com.aaroncb.javaorders.models.Agent;
import org.springframework.data.repository.CrudRepository;

public interface AgentRepository extends CrudRepository<Agent, Long> {
}
