
package com.university.college.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.university.college.model.College;
import com.university.college.model.Department;
import com.university.college.model.Faculty;
import com.university.college.repository.CollegeRepository;

@Component

@Service
public class CollegeService {

	@Autowired
	private CollegeRepository collegeRepo;

	/*
	 * public Response addCollege(College college) { Response resp = new Response();
	 * String message = collegeRepo.addCollege(college); resp.setStatus("success");
	 * resp.setMessage(message);
	 * 
	 * return resp; }
	 */

	@Transactional
	public void addCollege(College college) {
		collegeRepo.addCollege(college);

	}

	@Transactional
	public College getCollegeById(int id) {
		return collegeRepo.getCollegeById(id);
	}

	@Transactional
	public void updateCollege(int id) {
		collegeRepo.updateCollege(id);

	}
	
	@Transactional
	public List<College> getAllCollege(){
		return collegeRepo.getAllCollege();
	}


	@Transactional
	public void deleteCollege(int id) {
		collegeRepo.deleteCollege(id);
	}

	@Transactional
	public College getCollegeByName(String name) {
		return collegeRepo.getCollegeByName(name);
	}

	@Transactional
	public void addDepartment(Department department) {
		collegeRepo.addDepartment(department);
	}

	@Transactional
	public Department getDepartmentByCollege(int id) {
		return collegeRepo.getDepartmentByCollege(id);
	}

	public List<Department> getAllDepartmentByCollegeName(String collegeName){
		return collegeRepo.getAllDepartmentByCollegeName(collegeName);
	}

	
	@Transactional
	public void addFaculty(Faculty faculty) {
		collegeRepo.addFaculty(faculty);
	}

	@Transactional
	public Faculty getFaculty(int id) {
		return collegeRepo.getFaculty(id);

	}

	@Transactional
	public void addHOD( int deptID, String HodName ) {
		collegeRepo.addHOD(deptID, HodName);
	}

	@Transactional
	public void getFacultyByName(String facultyName) {
		collegeRepo.getCollegeByName(facultyName);
	}
	
	@Transactional
	public String getHodName(int deptId) {
		return collegeRepo.getHodName(deptId);
	}
	
	@Transactional
	public List<Faculty> getAllFacultyByDepartmentName(String DeptName){
		return collegeRepo.getAllFacultyByDepartmentName(DeptName);
	}


}
