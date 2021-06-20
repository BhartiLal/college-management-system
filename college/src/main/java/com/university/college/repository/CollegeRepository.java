package com.university.college.repository;

import java.util.List;

import com.university.college.model.College;
import com.university.college.model.Department;
import com.university.college.model.Faculty;



public interface CollegeRepository {
	
	public void addCollege(College college);
	public College getCollegeById(int id);
	public List<College> getAllCollege();
	public void updateCollege(int id);
	public void deleteCollege(int id);
	public College getCollegeByName(String name);
	public void addDepartment(Department department);
	public List<Department> getAllDepartmentByCollegeName(String collegeName);
	public Department getDepartmentByCollege(int id);
	public void addFaculty( Faculty faculty );
	public Faculty getFaculty( int facultyId );
	public void addHOD( int deptID, String HodName );
	public Faculty getFacultyByName(String facultyName);
	public List<Faculty> getAllFacultyByDepartmentName(String DeptName);
	public String getHodName( int deptId );
}
