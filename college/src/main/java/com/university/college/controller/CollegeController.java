package com.university.college.controller;

// Importing all the relevant libraries.
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.university.college.model.College;
import com.university.college.model.Department;
import com.university.college.model.Faculty;
import com.university.college.service.CollegeService;

@RestController
public class CollegeController {

	@Autowired
	private CollegeService collegeService;

	@GetMapping("/Welcome")
	public String getWelcome() {
		return "Welcome to the College!";
	}

	@RequestMapping(value = "/addCollege", method = RequestMethod.POST, headers = "Accept=application/json")
	public void addCollege(@RequestBody College college) {
		collegeService.addCollege(college);

	}

	@RequestMapping(value = "/getAllCollege", method = RequestMethod.GET, headers = "Accept=application/json")
	public List<College> getAllCollege() {
		return collegeService.getAllCollege();
	}

	@RequestMapping(value = "/getCollegeById/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public College getCollegeById(@PathVariable int id) {
		return collegeService.getCollegeById(id);
	}

	@RequestMapping(value = "/updateCollege/{id}", method = RequestMethod.PUT, headers = "Accept=application/json")
	public void updateCollege(@PathVariable("id") int id) {
		collegeService.updateCollege(id);
	}

	@RequestMapping(value = "/deleteCollege/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public void deleteCollege(@PathVariable("id") int id) {
		collegeService.deleteCollege(id);
	}

	@RequestMapping(value = "/getCollegeByName/{name}", method = RequestMethod.GET, headers = "Accept=application/json")
	public College getCollegeByName(@PathVariable String name) {
		return collegeService.getCollegeByName(name);
	}

	@RequestMapping(value = "/addDepartment", method = RequestMethod.POST, headers = "Accept=application/json")
	public void addDepartment(@RequestBody Department department) {
		collegeService.addDepartment(department);

	}

	@RequestMapping(value = "/getDepartment/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public Department getDepartmentByCollege(@PathVariable int id) {
		return collegeService.getDepartmentByCollege(id);
	}

	@RequestMapping(value = "/getAllDepartmentByCollegeName/{collegeName}", method = RequestMethod.GET, headers = "Accept=application/json")
	public List<Department> getAllDepartmentByCollegeName(@PathVariable String collegeName) {
		return collegeService.getAllDepartmentByCollegeName(collegeName);
	}

	@RequestMapping(value = "/addFaculty", method = RequestMethod.POST, headers = "Accept=application/json")
	public void addFaculty(@RequestBody Faculty faculty) {
		collegeService.addFaculty(faculty);

	}

	@RequestMapping(value = "/getFaculty/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public Faculty getFaculty(@PathVariable int id) {
		return collegeService.getFaculty(id);
	}

	@RequestMapping(value = "/getFacultyByName", method = RequestMethod.GET, headers = "Accept=application/json")
	public void getFacultyByName(@PathVariable String facultyName) {
		collegeService.getFacultyByName(facultyName);

	}

	@RequestMapping(value = "/getAllFacultyByDepartmentName/{facultyName}", method = RequestMethod.GET, headers = "Accept=application/json")
	public List<Faculty> getAllFacultyByDepartmentName(@PathVariable String facultyName) {
		return collegeService.getAllFacultyByDepartmentName(facultyName);
	}
	
	// Endpoint to addHod in college.
	@RequestMapping(value = "/addHod", method = RequestMethod.PUT, headers = "Accept=application/json")
	public void addHod(@PathVariable int deptId, String hodName) {
		collegeService.addHOD(deptId, hodName);

	}
	//Endpoint to fecth the hod name.
	@RequestMapping(value = "/getHodName/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public String getHodName(@PathVariable int id) {
		return collegeService.getHodName(id);
	}

}
