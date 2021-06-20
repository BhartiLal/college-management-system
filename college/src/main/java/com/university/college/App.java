package com.university.college;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.university.college.model.College;
//import com.university.college.repository.CollegeRepository;
import com.university.college.repository.CollegeRepository;

public class App {

	@Autowired
	private CollegeRepository repo;

	public static void main(String[] args) {

		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"file:src/main/webapp/WEB-INF/dispatcher-servlet-context.xml");
		CollegeRepository repo = (CollegeRepository) ctx.getBean("collegeRepository");
		System.out.println("Welcome!");
		College college = new College();
		college.setName("Vsics");
		college.setLocation("Chennai");
		repo.addCollege(college);
		System.out.println("College" + " " + repo.getCollegeById(1).getName());

		((ConfigurableApplicationContext) ctx).close();

	}

}
