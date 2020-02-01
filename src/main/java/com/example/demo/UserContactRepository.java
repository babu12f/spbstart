package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserContactRepository extends  JpaRepository<UserContact, Integer>  {
}
