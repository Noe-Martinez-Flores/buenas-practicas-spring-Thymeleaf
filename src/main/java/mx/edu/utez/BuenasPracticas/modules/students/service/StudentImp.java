package mx.edu.utez.BuenasPracticas.modules.students.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.edu.utez.BuenasPracticas.modules.students.model.StudentModel;

@Service
public class StudentImp implements IStudentService{

    @Autowired
    private IStudentService studentService;

    @Override
    public List<StudentModel> getAllStudents() {
        return studentService.getAllStudents();
    }
    
}
