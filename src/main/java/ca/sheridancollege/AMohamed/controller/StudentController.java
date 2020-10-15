package ca.sheridancollege.AMohamed.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@GetMapping("/deleteStudentById/{id}")
public String deleteStudentById(Model model,@PathVariable Long id) {
	

		
		//delete record from DB
		da.deleteStudentById(id);
		
		//Update list
		model.addAttribute("studentList", da.getStudentList());
		
		//after every operation
		model.addAttribute("student",new Student());
		
		
		
	    return "index";

	
}	
	
	
	
	
	
	
	
	@GetMapping("/editStudentById/{id}")
public String editStudentById(Model model,@PathVariable Long id) {
	
		
		//Convert the record to update to a Student object
		
		
		Student student = da.getStudentListById(id).get(0);	
	    //comunicate with object with the form for modification
		
		model.addAttribute("student",student );
		
		//Delete the current version
		da.deleteStudentById(id);

		
		//update the list to be displayed/prepared for the new version
		
		model.addAttribute("studentList",da.getStudentList());
		
	
		
		
		
	    return "index";
	
	
	
}
	
}
