
package com.university.college.repository;

import java.util.ArrayList;
import java.util.List;

import javax.crypto.spec.DESedeKeySpec;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.university.college.model.College;
import com.university.college.model.Department;
import com.university.college.model.Faculty;

@Repository
public class CollegeRepositoryImpl implements CollegeRepository {

	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/*
	 * // private Session getSession() { // Session session = null; // try { //
	 * session=sessionFactory.getCurrentSession(); // } catch (HibernateException e)
	 * 
	 * { // session = sessionFactory.openSession(); // } // return session; // }
	 */

	@Override
	public List<College> getAllCollege() {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		List<College> clgList = session.createQuery("from College").list();
		tx.commit();
		session.close();
		return clgList;
	}

	@SuppressWarnings("deprecation")
	@Override
	public College getCollegeById(int id) {

		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		College clg = (College) session.get(College.class, new Integer(id));
		tx.commit();
		session.close();
		return clg;

	}

	public void addCollege(College college) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.persist(college);
		tx.commit();
		session.close();
	}

	public void updateCollege(int id) {
		// Session session = this.sessionFactory.getCurrentSession();
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.update(id);
		tx.commit();
		session.close();

	}

	@SuppressWarnings("deprecation")
	public void deleteCollege(int id) {
		// Session session = this.sessionFactory.getCurrentSession();
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		College clg = (College) session.get(College.class, new Integer(id));
		if (null != clg) {
			session.delete(clg);
		}
		tx.commit();
		session.close();
	}

	public College getCollegeByName(String name) {
		// Session session = this.sessionFactory.getCurrentSession();
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		College clg = (College) session.get(College.class, new String(name));
		tx.commit();
		session.close();
		return clg;
	}

	@Override
	public void addDepartment(Department department) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.persist(department);
		tx.commit();
		session.close();
	}

	@SuppressWarnings("deprecation")

	@Override
	public Department getDepartmentByCollege(int id) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Department dept = (Department) session.get(Department.class, new Integer(id));
		tx.commit();
		session.close();
		return dept;
	}

	@Override
	public List<Department> getAllDepartmentByCollegeName(String collegeName) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		College clg = (College) session.get(College.class, new String(collegeName));
		List<Department> dept = (List<Department>) session.get(Department.class, new Integer(clg.getId()));

		return dept;
	}

	@Override
	public void addFaculty(Faculty faculty) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.persist(faculty);
		tx.commit();
		session.close();
	}

	@SuppressWarnings("deprecation")

	@Override
	public Faculty getFaculty(int facultyId) {
		// Session session = this.sessionFactory.getCurrentSession();
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Faculty faculty = (Faculty) session.get(Faculty.class, new Integer(facultyId));
		tx.commit();
		session.close();
		return faculty;
	}

	@Override
	public void addHOD(int deptID, String HodName) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Department dept = (Department) session.get(Department.class, deptID);

		dept.setHodName(HodName);
		tx.commit();
		session.close();

	}

	@SuppressWarnings("deprecation")
	@Override
	public String getHodName(int deptId) {
		// Session session = this.sessionFactory.getCurrentSession();
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		String hodName = (String) session.get(Department.class, new Integer(deptId));
		tx.commit();
		session.close();
		return hodName;
	}

	@Override
	public Faculty getFacultyByName(String facultyName) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Faculty faculty = (Faculty) session.get(Department.class, new String(facultyName));
		tx.commit();
		session.close();
		return faculty;
	}

	@SuppressWarnings("deprecation")
	@Override
	public List<Faculty> getAllFacultyByDepartmentName(String DeptName) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Department dept = (Department) session.get(College.class, new String(DeptName));
		List<Faculty> faculties = (List<Faculty>) session.get(Faculty.class, new Integer(dept.getDeptId()));

		return faculties;

		
	}

}
