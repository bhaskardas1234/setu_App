package com.main.setu.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.main.setu.model.Instructor;
import com.main.setu.model.admin;

public interface adminrepo extends JpaRepository<admin,String> {
	admin findByAdminName(String adminName);
}
