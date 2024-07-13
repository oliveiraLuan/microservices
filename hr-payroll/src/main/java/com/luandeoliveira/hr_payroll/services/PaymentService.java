package com.luandeoliveira.hr_payroll.services;

import com.luandeoliveira.hr_payroll.dto.WorkerDTO;
import com.luandeoliveira.hr_payroll.entities.Payment;
import com.luandeoliveira.hr_payroll.entities.Worker;
import com.luandeoliveira.hr_payroll.feignclients.WorkerFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {
    @Autowired
    private WorkerFeignClient workerFeignClient;

    public Payment getPayment(Long workerId, Integer days){
        WorkerDTO worker = workerFeignClient.findById(workerId).getBody();
        return new Payment(worker.getName(), worker.getDailyIncome(), days);
    }
}
