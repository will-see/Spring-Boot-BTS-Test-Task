package com.petrov.springboot.repository;

import com.petrov.springboot.model.Hours;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HoursRepository extends JpaRepository<Hours, Long> {
    List<Hours> findByWorkerId(Long workerId);
}
