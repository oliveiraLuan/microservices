package com.luandeoliveira.hr_payroll.services;

import com.luandeoliveira.hr_payroll.entities.Payment;
import com.luandeoliveira.hr_payroll.entities.Worker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class PaymentService {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${hr-worker-host}")
    private String hrWorkerHost;

    private static final String WORKERS_ENDPOINT = "/workers/{id}";

    public Payment getPayment(Long workerId, Integer days){

        Map<String, String> pathVariables = new HashMap<>();
        pathVariables.put("id", workerId.toString());

        Worker worker = restTemplate.getForObject(hrWorkerHost + WORKERS_ENDPOINT, Worker.class, pathVariables);

        return new Payment(worker.getName(), worker.getDailyIncome(), days);
    }
}
