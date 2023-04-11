package com.enoca.challenge.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.enoca.challenge.entities.concretes.Worker;

@Repository
public interface WorkerRepository extends JpaRepository<Worker, Integer> {

}
