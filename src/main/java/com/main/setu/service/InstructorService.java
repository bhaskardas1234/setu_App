package com.main.setu.service;

import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.main.setu.model.Instructor;
import com.main.setu.repo.Instructorrepo;



@Service
public class InstructorService {
	@Autowired
	private  Instructorrepo instructorRepo;
	public void saveInstructorDetails(String name ,String designation,String linkdin,String email,String bio,String course,MultipartFile file) {
		Instructor i=new Instructor();
		i.setName(name);
		i.setDesignation(designation);
		i.setLinkdin(linkdin);
		i.setEmail(email);
		i.setBio(bio);
		i.setTeach_course(course);
		
		try {
			i.setImage(Base64.getEncoder().encodeToString(file.getBytes()));
		}
		catch(Exception e) {
		
		System.out.println(e);
	     }
		
		
		instructorRepo.save(i);
		
		
	
	
	}
}
