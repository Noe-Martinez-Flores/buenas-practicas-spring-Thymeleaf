package mx.edu.utez.BuenasPracticas.modules.person.interfacePerson;

import java.util.List;
import java.util.Optional;

import mx.edu.utez.BuenasPracticas.modules.person.model.Person;

public interface IPersonService {
    public List<Person> getAllPerson();
    public Optional<Person> getPersonById(int id);
    public int savePerson(Person person);
    public void deletePerson(int id);
    public boolean existsByEmail(String email);
}
