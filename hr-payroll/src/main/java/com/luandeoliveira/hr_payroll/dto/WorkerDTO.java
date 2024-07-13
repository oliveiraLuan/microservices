package com.luandeoliveira.hr_payroll.dto;


import java.io.Serializable;
import com.luandeoliveira.hr_payroll.entities.Worker;

public class WorkerDTO implements Serializable {
    private Long id;
    private String name;
    private Double dailyIncome;

    public WorkerDTO(){}

    public WorkerDTO(Worker worker){
        this.id = worker.getId();
        this.name = worker.getName();
        this.dailyIncome = worker.getDailyIncome();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getDailyIncome() {
        return dailyIncome;
    }

    public void setDailyIncome(Double dailyIncome) {
        this.dailyIncome = dailyIncome;
    }
}
