package com.training.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.training.entity.Ticked;

public interface TickedRepository extends JpaRepository<Ticked, Long>{

}
