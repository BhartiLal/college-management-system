package com.university.college.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name ="college")
public class College implements Serializable{
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="location")
	private String location;
	
	
	@OneToMany(mappedBy="college" , fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
	private List<Department> listOfDept = new ArrayList<>();
	
	

	public College(String name, String location) {
		super();
		this.name = name;
		this.location = location;
	}

	public College() {
		// TODO Auto-generated constructor stub
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

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	
	public List<Department> getListOfDept() {
		return listOfDept;
	}

	public void setListOfDept(List<Department> listOfDept) {
		this.listOfDept = listOfDept;
	}
	
	
	
	
}
