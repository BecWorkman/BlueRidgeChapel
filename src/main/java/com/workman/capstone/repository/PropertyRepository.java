package com.workman.capstone.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.workman.capstone.model.Property;


@Repository
public interface PropertyRepository extends JpaRepository<Property, Long>{

}
