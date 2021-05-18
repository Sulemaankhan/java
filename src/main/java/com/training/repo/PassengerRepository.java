package com.training.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.training.entity.Passengers;

public interface PassengerRepository extends JpaRepository<Passengers, Long> {

}
