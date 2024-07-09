package com.luandeoliveira.hr_worker.services;

import com.luandeoliveira.hr_worker.dto.WorkerDTO;
import com.luandeoliveira.hr_worker.entities.Worker;
import com.luandeoliveira.hr_worker.repositories.WorkerRepository;
import com.luandeoliveira.hr_worker.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class WorkerService {

    @Autowired
    private WorkerRepository workerRepository;

    public List<WorkerDTO> findAll() {
        return workerRepository
                .findAll()
                .stream()
                .map(worker -> new WorkerDTO(worker))
                .collect(Collectors.toList());
    }

    public WorkerDTO findById(Long id) {
        if(!workerRepository.existsById(id)){
            throw new ResourceNotFoundException("Worker with id " + id + " does not exists");
        }
        Worker worker = workerRepository.findById(id).get();
        return new WorkerDTO(worker);
    }
}
