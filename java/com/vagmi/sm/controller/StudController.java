package com.arpit.sm.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.arpit.sm.entity.Student;
import com.arpit.sm.service.StudService;



@Controller
@RequestMapping("/students")
public class StudController {
	
	@Autowired
	private StudService studService;
	
	@RequestMapping("/list")
	public String listBooks(Model theModel) {

		// get Books from db
		List<Student> theStudent = studService.findAll();

		// add to the spring model
		theModel.addAttribute("Student", theStudent);

		return "list-student";
	}
	
	@RequestMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {

		// create model attribute to bind form data
		Student theStudent = new Student();

		theModel.addAttribute("Student", theStudent);

		return "Student-form";
	}
	
	@PostMapping("/save")
	public String saveStudent(@RequestParam("id") int id, @RequestParam("name") String fname,
			@RequestParam("dept_name") String deptName, @RequestParam("country") String country) {

		System.out.println(id);
		Student theStudent;
		if (id != 0) {
			theStudent = studService.findById(id);
			theStudent.setName(fname);
			theStudent.setDepartment(deptName);
			theStudent.setCountry(country);
		} else
			theStudent = new Student(fname, deptName, country);
		// save the Book
		studService.save(theStudent);

		// use a redirect to prevent duplicate submissions
		return "redirect:/students/list";
	}
	
	@RequestMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("studId") int thestudId, Model theModel) {

		// get the Book from the service
		Student theStudent = studService.findById(thestudId);

		// set Book as a model attribute to pre-populate the form
		theModel.addAttribute("Student", theStudent);

		// send over to our form
		return "Student-form";
	}
	
	@RequestMapping("/delete")
	public String delete(@RequestParam("studId") int thestudId) {

		// delete the Book
		studService.deleteById(thestudId);

		// redirect to /Books/list
		return "redirect:/students/list";

	}


}

