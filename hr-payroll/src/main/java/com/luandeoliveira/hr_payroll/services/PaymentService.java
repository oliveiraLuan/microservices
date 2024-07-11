package com.luandeoliveira.hr_payroll.services;

import com.luandeoliveira.hr_payroll.entities.Payment;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    public Payment getPayment(Long workerId, Integer days){
        return new Payment("Luan de Oliveira", 3500.0, days);
    }
}
