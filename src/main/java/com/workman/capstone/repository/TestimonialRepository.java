package com.workman.capstone.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.workman.capstone.model.Testimonial;

@Repository
public interface TestimonialRepository extends JpaRepository<Testimonial, Long>{

}
