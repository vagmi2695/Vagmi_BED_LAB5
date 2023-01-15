package com.vagmi.sm.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.vagmi.sm.entity.Employee;
import com.vagmi.sm.service.EmployeeService;



@Controller
@RequestMapping("/employees")
public class EmpController {
	
	@Autowired
	private EmpService empService;
	
	@RequestMapping("/list")
	public String listBooks(Model theModel) {

		// get Books from db
		List<Employee> theEmployee = empService.findAll();

		// add to the spring model
		theModel.addAttribute("Employee", theEmployee);

		return "list-employee";
	}
	
	@RequestMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {

		// create model attribute to bind form data
		Employee theEmployee = new Employee();

		theModel.addAttribute("Employee", theEmployee);

		return "Employee-form";
	}
	
	@PostMapping("/save")
	public String saveEmployee(@RequestParam("id") int id, @RequestParam("Employee First Name") String fname,
			@RequestParam("Employee Last Name") String lname, @RequestParam("Employee Email") String email) {

		System.out.println(id);
		Employee theEmployee;
		if (id != 0) {
			theEmployee = empService.findById(id);
			theEmployee.setName(fname);
			theEmployee.setDepartment(lname);
			theEmployee.setCountry(email);
		} else
			theEmployee = new Employee(fname, lname, email);
		// save the Book
		empService.save(theEmployee);

		// use a redirect to prevent duplicate submissions
		return "redirect:/employees/list";
	}
	
	@RequestMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("empId") int theempId, Model theModel) {

		// get the Book from the service
		Employee theEmployee = empService.findById(theempId);

		// set Book as a model attribute to pre-populate the form
		theModel.addAttribute("Employee", theEmployee);

		// send over to our form
		return "Employee-form";
	}
	
	@RequestMapping("/delete")
	public String delete(@RequestParam("empId") int theempId) {

		// delete the Book
		empService.deleteById(theempId);

		// redirect to /Books/list
		return "redirect:/employees/list";

	}


}

