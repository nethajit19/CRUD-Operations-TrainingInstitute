package com.example.TrainingInstitute.Model;



import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity 
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long empid;
	private String empname;
	private Character gender;
	private Integer age;
	private Date joiningdate;
	private String city;
	private String img;
	
	
	public Long getEmpid() {
		return empid;
	}
	public void setEmpid(Long empid) {
		this.empid = empid;
	}
	public String getEmpname() {
		return empname;
	}
	public void setEmpname(String empname) {
		this.empname = empname;
	}
	public Character getGender() {
		return gender;
	}
	public void setGender(Character gender) {
		this.gender = gender;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Date getJoiningdate() {
		return joiningdate;
	}
	public void setJoiningdate(Date joiningdate) {
		this.joiningdate = joiningdate;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	
	
	 
	
	
	

}
