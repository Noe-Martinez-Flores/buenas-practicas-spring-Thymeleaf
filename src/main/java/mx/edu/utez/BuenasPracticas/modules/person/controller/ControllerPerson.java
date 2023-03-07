package mx.edu.utez.BuenasPracticas.modules.person.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.validation.Errors;

import mx.edu.utez.BuenasPracticas.modules.person.model.Person;
import mx.edu.utez.BuenasPracticas.modules.person.service.PersonServiceImp;

@Controller
@RequestMapping("/person")
public class ControllerPerson {

    @Autowired
    private PersonServiceImp service;

    @GetMapping(value = "/list")
    public String getAllStudents(Model model) {
        List<Person> list = service.getAllPerson();
        model.addAttribute("persons", list);
        System.out.println(model.getAttribute("persons"));
        return "index";
    }

    @GetMapping(value = "/new")
    public String newPerson(Model model) {
        model.addAttribute("person", new Person());
        return "form";
    }

    @PostMapping(value = "/save")
    public String savePerson(@Valid Person person, Errors errors, Model model) {

        if (errors.hasErrors()) {
            return "form";
        } else {
            System.out.println("===============================");
            System.out.println(person.toString());
            service.savePerson(person);
            return "redirect:/person/list";
        }

    }

    @GetMapping(value = "/edit/{id}")
    public String editPerson(@PathVariable int id ,Model model ){
        Optional<Person> person = service.getPersonById(id);
        System.out.println(person.toString());
        model.addAttribute("person", person);
        return "form";
    };

    @GetMapping(value = "/delete/{id}")
    public String deletePerson(@PathVariable int id ,Model model ){
        service.deletePerson(id);
        return "redirect:/person/list";
    };

    // @InitBinder
    // public void initBinder(WebDataBinder binder) {
    //     SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    //     binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    // }

}
