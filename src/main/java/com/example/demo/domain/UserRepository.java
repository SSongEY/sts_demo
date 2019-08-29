package com.example.demo.domain;

import org.springframework.data.jpa.repository.JpaRepository;

///DAO 역할?
public interface UserRepository extends JpaRepository<User, Long>{


}
