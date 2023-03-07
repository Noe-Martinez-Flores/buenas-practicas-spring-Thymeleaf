package mx.edu.utez.BuenasPracticas.modules.person.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.edu.utez.BuenasPracticas.modules.person.interfacePerson.IPerson;
import mx.edu.utez.BuenasPracticas.modules.person.interfacePerson.IPersonService;
import mx.edu.utez.BuenasPracticas.modules.person.model.Person;

@Service
public class PersonServiceImp implements IPersonService {

    @Autowired
    private IPerson data;


    @Override
    public List<Person> getAllPerson() {
        return (List<Person>)data.findAll();
    }

    @Override
    public Optional<Person> getPersonById(int id) {
       return data.findById(id);
    }

    @Override
    public int savePerson(Person person) {
       int response = 0;
       Person personDB = data.save(person);
       if ( personDB != null) {
           response = 1;
       }
       return response;
    }

    @Override
    public void deletePerson(int id) {
        data.deleteById(id);
    }

    @Override
    public boolean existsByEmail(String email) {
        List<Person> list =(List<Person>) data.findAll();
        for (Person person : list) {
            if (person.getEmail() == email) {
                return true;
            }
        }
        return false;
    }
    
}
