package com.main.setu.model;

import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;

@Entity
@Component
@Table(name="instructor")
public class Instructor {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name;
	private String designation;
	private String linkdin;
	private String email;
	private String bio;
	private String teach_course;
	@Lob
	@Column(columnDefinition="MEDIUMBLOB")
    private String image;
	public Instructor() {
		super();
	}
	public Instructor(int id, String name, String designation, String linkdin, String email, String bio,
			String teach_course, String image) {
		super();
		this.id = id;
		this.name = name;
		this.designation = designation;
		this.linkdin = linkdin;
		this.email = email;
		this.bio = bio;
		this.teach_course = teach_course;
		this.image = image;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getLinkdin() {
		return linkdin;
	}
	public void setLinkdin(String linkdin) {
		this.linkdin = linkdin;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getBio() {
		return bio;
	}
	public void setBio(String bio) {
		this.bio = bio;
	}
	public String getTeach_course() {
		return teach_course;
	}
	public void setTeach_course(String teach_course) {
		this.teach_course = teach_course;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	
	
	
}
