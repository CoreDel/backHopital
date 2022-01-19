package com.inti.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inti.entities.Hopital;

@Repository
public interface HopitalRepository extends JpaRepository<Hopital, Long>{

}
