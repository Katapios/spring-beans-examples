package com.katapios.springexamples.mvc.dao;

import com.katapios.springexamples.mvc.models.Person;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {
    private List<Person> people;
    private static int PEOPLE_COUNT;

    {
        people = new ArrayList<>();

        people.add(new Person(++PEOPLE_COUNT, "Dennis", 32, "damin@da.ru"));
        people.add(new Person(++PEOPLE_COUNT, "Ivan",43, "damin@bd.ru"));
        people.add(new Person(++PEOPLE_COUNT, "Dmitri",13, "damin@re.ru"));
        people.add(new Person(++PEOPLE_COUNT, "Arkadiy",26, "damin@ue.ru"));
    }

    public List<Person> index() {
        return people;
    }

    public Person show(int id){
        return people.stream()
                .filter(person->person.getId() == id)
                .findAny().orElse(null);
    }

    public void save(Person person) {
        person.setId(++PEOPLE_COUNT);
        people.add(person);
    }

    public void update(int id, Person updatedPerson) {
        Person personToBeUpdate = show(id);
        personToBeUpdate.setName(updatedPerson.getName());
        personToBeUpdate.setAge(updatedPerson.getAge());
        personToBeUpdate.setEmail(updatedPerson.getEmail());
    }

    public void delete(int id) {
        people.removeIf(p -> p.getId() == id);
    }
}
