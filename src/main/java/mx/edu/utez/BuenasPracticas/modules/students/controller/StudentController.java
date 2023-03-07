package mx.edu.utez.BuenasPracticas.modules.students.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import mx.edu.utez.BuenasPracticas.modules.students.service.IStudentService;



@Controller
@RequestMapping("/students")
public class StudentController {
    
    
    @Autowired
    private IStudentService studentService;

    @GetMapping("/list")
    public String getAllStudents(Model model) {
        model.addAttribute("students",studentService.getAllStudents());
        System.out.println("=====================================");
        System.out.println(studentService.getAllStudents());
        return "index";
    }
}
