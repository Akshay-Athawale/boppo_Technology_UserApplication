package com.boppo.userApplication.respository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.boppo.userApplication.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

	Optional<User> findByEmail(String email);

	List<User> findByEmailAndPassword(String email, String pass);

	List<User> findByPasswordOrEmail(String name, String email, PageRequest of);
}
