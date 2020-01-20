package com.aaroncb.javaorders.controllers;

import com.aaroncb.javaorders.models.Agent;
import com.aaroncb.javaorders.models.Customer;
import com.aaroncb.javaorders.services.AgentService;
import com.aaroncb.javaorders.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/agents")
public class AgentController {

    @Autowired
    private AgentService agentService;

    @GetMapping(value = "/agent/{id}",
            produces = {"application/json"})
    public ResponseEntity<?> getAgentById(
            @PathVariable
                    Long id)
    {
        Agent agent = agentService.findAgentById(id);
        return new ResponseEntity<>(agent,
                HttpStatus.OK);
    }
}
