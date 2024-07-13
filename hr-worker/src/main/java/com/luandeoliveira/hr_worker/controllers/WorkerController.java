package com.luandeoliveira.hr_worker.controllers;

import com.luandeoliveira.hr_worker.dto.WorkerDTO;
import com.luandeoliveira.hr_worker.services.WorkerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value ="/workers")
public class WorkerController {

    @Autowired
    private WorkerService workerService;

    @Autowired
    private Environment environment;

    private static final Logger LOGGER = LoggerFactory.getLogger(WorkerController.class);

    @GetMapping
    public ResponseEntity<List<WorkerDTO>> findAll(){
        List<WorkerDTO> workers = workerService.findAll();
        return ResponseEntity.ok(workers);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<WorkerDTO> findById(@PathVariable Long id){
        LOGGER.info("PORTA = " + environment.getProperty("local.server.port"));
        WorkerDTO dto = workerService.findById(id);
        return ResponseEntity.ok(dto);
    }
}
