package mx.edu.utez.BuenasPracticas.modules.person.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import lombok.Data;

@Data
@Entity
@Table(name = "person")
public class Person {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    
    private int id;

    @Column(name = "name", nullable = false, length = 50)
    @NotEmpty(message = "El nombre no puede estar vacio")
    @NotNull(message = "El nombre no puede ser nulo")
    private String name;

    @Column(name = "last_name", nullable = false, length = 50)
    @NotBlank(message = "El apellido no puede estar vacio")
    @NotNull(message = "El apellido no puede ser nulo")
    private String lastName;

    @Column(name = "second_last_name", nullable = false, length = 50)
    @NotBlank(message = "El segundo apellido no puede estar vacio")
    @NotNull(message = "El segundo apellido no puede ser nulo")
    private String secondlastName;

    @Column(name = "email", nullable = false, unique = true)
    @NotBlank(message = "El email no puede estar vacio")
    @NotNull(message = "El email no puede ser nulo")
    @Email(message = "El email no es valido")
    private String email;

    // @Column(name = "password", nullable = false)
    // @NotBlank(message = "La contraseña no puede estar vacia")
    // @NotNull(message = "La contraseña no puede ser nula")
    // private String password;

    @Column(name = "phone", nullable = false)
    @NotBlank(message = "El telefono no puede estar vacio")
    @NotNull(message = "El telefono no puede ser nulo")
    private String phone;

    @Column(name = "birth_day", nullable = false)
    @NotNull(message = "La fecha de nacimiento no puede estar vacia")
    @Past(message = "La fecha de nacimiento no puede ser mayor a la fecha actual")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthDay;

    public Person() {
    }

    public Person(int id, String name, String lastName, String secondlastName, String email, String password, String phone,
            Date birthDay) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.secondlastName = secondlastName;
        this.email = email;
        this.phone = phone;
        this.birthDay = birthDay;
    }

    

    public Person(String name, String lastName, String secondlastName, String email, String password, String phone,
            Date birthDay) {
        this.name = name;
        this.lastName = lastName;
        this.secondlastName = secondlastName;
        this.email = email;
        
        this.phone = phone;
        this.birthDay = birthDay;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSecondlastName() {
        return secondlastName;
    }

    public void setSecondlastName(String secondlastName) {
        this.secondlastName = secondlastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    @Override
    public String toString() {
        return "Person [id=" + id + ", name=" + name + ", lastName=" + lastName + ", secondlastName=" + secondlastName
                + ", email=" + email + ", phone=" + phone + ", birthDay=" + birthDay + "]";
    }

    

}
