package com.soa.admin_manager.repository;

import com.soa.admin_manager.model.Administrator;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Administrator, Integer> {

}
