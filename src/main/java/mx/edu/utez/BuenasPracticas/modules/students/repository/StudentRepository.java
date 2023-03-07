package mx.edu.utez.BuenasPracticas.modules.students.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mx.edu.utez.BuenasPracticas.modules.students.model.StudentModel;

@Repository
public interface StudentRepository extends JpaRepository<StudentModel, Long>{
    
}
