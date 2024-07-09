package com.luandeoliveira.hr_worker.controllers;

import com.luandeoliveira.hr_worker.dto.WorkerDTO;
import com.luandeoliveira.hr_worker.services.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping
    public ResponseEntity<List<WorkerDTO>> findAll(){
        List<WorkerDTO> workers = workerService.findAll();
        return ResponseEntity.ok(workers);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<WorkerDTO> findById(@PathVariable Long id){
        WorkerDTO dto = workerService.findById(id);
        return ResponseEntity.ok(dto);
    }
}
