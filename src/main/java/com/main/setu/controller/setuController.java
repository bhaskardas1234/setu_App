package com.main.setu.controller;

import java.util.ArrayList;

import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.view.RedirectView;

import com.main.setu.model.Instructor;
import com.main.setu.model.admin;
import com.main.setu.repo.Instructorrepo;
import com.main.setu.service.InstructorService;
import com.main.setu.service.adminService;



@Controller
public class setuController {
	
	
	@Autowired 
	 private InstructorService iservice;
	@Autowired
	private  Instructorrepo instructorRepo;
	@Autowired
	private  adminService aservice;
	
	
	@GetMapping("/")
	public String showHome() {
		return "index.html";
	}
	@GetMapping("/loginpage")
	public String showloginPage() {
		return "loginPage.html";
	}
	
	
	@PostMapping("/login")
	public RedirectView checkAdminDetails( @RequestParam("name") String name, @RequestParam("password") String password) {
		admin validUser=new admin();
		validUser.setAdminName(name);
		validUser.setAdminPassword(password);
		System.out.println(name);
		Boolean flag=aservice.getUserAuth(validUser);
		System.out.println(flag);
		if(flag==true) {
		
			
			 return new RedirectView("/allInstructor", true);
			
			
		}
		else {
			
			 return new RedirectView("/login", true);
		}
		
		
	}
	
	@GetMapping("/add_instructor")
	public String showAddInstructorPage() {
		return "registrationPage.html";
	}
	
	
	
	@PostMapping("/add_instructor_details")
	public RedirectView addInstructor( @RequestParam("name") String name,
            @RequestParam("designation") String designation,
            @RequestParam("linkedin") String linkedin,
            @RequestParam("email") String email,
            @RequestParam("bio") String bio,
            @RequestParam("course") String course,
            @RequestParam("image") MultipartFile image) {
		System.out.println(name + designation+ linkedin+ email+ bio+course+ image);
		iservice.saveInstructorDetails(name, designation, linkedin, email, bio, course, image);
		
		
		
		  return new RedirectView("/allInstructor", true);
		
	}
	
	
	@GetMapping("/allInstructor")
	public String allInstrutor(ModelMap m) {
		//List list=(List)(instructorRepo.findAll());
		
		ArrayList<Instructor> list=(ArrayList<Instructor>) instructorRepo.findAll();
   for (Instructor i: list) {
			System.out.println(i.getEmail());
		}
		
		m.addAttribute("list",list);
		
		return "showDatapage.html";
	}
	
	
	
	
	@GetMapping("/edit/{id}")
	public RedirectView editProduct(@PathVariable("id") int id){
		
		//instructorRepo.deleteById(id);
		return new RedirectView("/allInstructor", true);
	}
	
	@GetMapping("/instructordelete/{id}")
	public RedirectView deleteProduct(@PathVariable("id") int id){
		System.out.println(id);
		
		instructorRepo.deleteById(id);
		return new RedirectView("/allInstructor", true);
	}
	
	
	
	

}
