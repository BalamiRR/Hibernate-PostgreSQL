package com.fuatkara.demo.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="student")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "first_name")
	private String firstname;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "email")
	private String email;
	
	@ManyToMany(fetch = FetchType.LAZY, 
			cascade = {CascadeType.DETACH, 
					CascadeType.MERGE, 
					CascadeType.PERSIST, 
					CascadeType.REFRESH}
	)
	@JoinTable(
			name = "course_student", //Name of Join class
			joinColumns = @JoinColumn(name = "student_id"), //  JOIN ON Student_id = Course_id  yapiyoruz.   
			inverseJoinColumns = @JoinColumn(name = "course_id")
			)
	private List<Course> courses;
	
	public Student() {
		
	}

	public Student(String firstname, String lastName, String email) {
		this.firstname = firstname;
		this.lastName = lastName;
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public String toString() {
		return "Student [id=" + id + ", firstname=" + firstname + ", lastName=" + lastName + ", email=" + email + "]";
	}

	
	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}
	
	
}