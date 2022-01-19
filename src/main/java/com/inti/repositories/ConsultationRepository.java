package com.inti.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inti.entities.Consultation;

@Repository
public interface ConsultationRepository extends JpaRepository<Consultation, Long> {

}
