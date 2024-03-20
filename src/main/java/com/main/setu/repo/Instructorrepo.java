package com.main.setu.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.main.setu.model.Instructor;

@Repository
public interface Instructorrepo extends JpaRepository<Instructor,Integer> {
	
    void deleteById(int id);


}