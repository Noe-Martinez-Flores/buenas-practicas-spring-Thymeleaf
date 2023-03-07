package mx.edu.utez.BuenasPracticas.modules.person.interfacePerson;

import org.springframework.data.repository.CrudRepository;

import mx.edu.utez.BuenasPracticas.modules.person.model.Person;


public interface IPerson extends CrudRepository <Person, Integer>{
    
}
