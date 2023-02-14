package com.workman.capstone.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.workman.capstone.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

	 User findByEmail(String email);
}
