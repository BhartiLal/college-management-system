package com.university.college.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "department")
public class Department {
	
	@Id
	@Column(name = "deptId")
	private int deptId;

	@Column(name = "deptName")
	private String deptName;

	@Column(name = "hodName")
	private String hodName;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "id", nullable = false)
	private College college;

	@OneToMany(mappedBy="department" , fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
	List<Faculty> listOfFaculties = new ArrayList<>();

	public String getDeptName() {
		return deptName;
	}

	public int getDeptId() {
		return deptId;
	}

	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getHodName() {
		return hodName;
	}

	public void setHodName(String hodName) {
		this.hodName = hodName;
	}

//	public List<Faculty> getListOfFaculties() {
//		return listOfFaculties;
//	}
//
//	public void setListOfFaculties(List<Faculty> listOfFaculties) {
//		this.listOfFaculties = listOfFaculties;
//	}

}
