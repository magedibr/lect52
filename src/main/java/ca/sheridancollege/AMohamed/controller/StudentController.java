package ca.sheridancollege.AMohamed.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import ca.sheridancollege.AMohamed.beans.Student;
import ca.sheridancollege.AMohamed.database.DatabaseAccess;

@Controller
public class StudentController {
	
	@Autowired
	DatabaseAccess da;
	@GetMapping("/")
	public String index(Model model) {
		
		//insert student
		da.insertStudent();
		model.addAttribute("student",new Student());
		
		
		
		return "index";
		
		
		
		
	}
	@PostMapping("/insertStudent")
public String insertStudent(Model model,@ModelAttribute Student student) {
	
	//insert the student specified by the user to DB
	da.insertStudent(student);
	
	//Add the list to the model for the view to use it
	model.addAttribute("studentList",da.getStudentList());	
	
	//create new student
	model.addAttribute("student",new Student());
	

	
	
	return "index";
}	
	
	
	
	
	
}
