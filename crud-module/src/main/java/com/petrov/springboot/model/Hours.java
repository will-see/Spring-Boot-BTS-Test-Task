package com.petrov.springboot.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "hours")
public class Hours extends BaseEntity{

    @Column(name = "start_time")
    private int startTime;
    @Column(name = "end_time")
    private int endTime;
    @Column(name = "worker_id")
    private Long workerId;
}
