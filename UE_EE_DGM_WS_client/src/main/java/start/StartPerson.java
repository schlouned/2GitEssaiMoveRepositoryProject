/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package start;

import be.isl.ue.entity.Person;
import be.isl.ue.ue_ee_dgm_ws_client.WSclient;
import jakarta.ws.rs.core.GenericType;
import jakarta.ws.rs.core.Response;
import java.util.List;

/**
 *
 * @author Schloune Denis
 */
public class StartPerson {

    public static void main(String[] args) {
        personTest();
    }

    //personStart
    public static void personTest() {
        //variable
        WSclient wsPerson = new WSclient("Persons");
        GenericType<Person> gTypePerson = new GenericType<Person>() {};
        GenericType<List<Person>> gTypePersonList = new GenericType<List<Person>>() {};
        
        //count
        System.out.println("Number of person: ");
        System.out.println(wsPerson.countREST());
        System.out.println("************");
        System.out.println("");

        //findAll
        Response response = wsPerson.findAll_JSON(Response.class);
        List<Person> persons = response.readEntity(gTypePersonList);
        System.out.println("Person List:");
        System.out.println("************");
        for (Person p : persons) {
            System.out.println(p.getName() + " " + p.getFirstName());
        }
        System.out.println("");

        //create a new person
        Person person = new Person();
        person.setName("WebService");
        person.setFirstName("Try");
        person.setDateOfBirth("1987-02-13");
        wsPerson.create_JSON(person);

        //check if the new person is created
        response = wsPerson.findByName_JSON(Response.class, "WebService");
        persons = response.readEntity(gTypePersonList);
        System.out.println("Person List (add):");
        System.out.println("******************");
        Person personTest = persons.get(0);
        //personTest.setDateOfBirth("1987-02-13"); // don't recover the date of birth???
        for (Person p : persons) {
            System.out.println(p.getName() + " " + p.getFirstName());
        }
        System.out.println("");

        //modify a person
        Integer idPersonTest = personTest.getPersonId();
        String idStr = idPersonTest.toString();
        personTest.setFirstName("Modification");
        wsPerson.edit_JSON(personTest, idStr);

        //check if the modification has work
        response = wsPerson.find_JSON(Response.class, idStr);
        Person newPerson = new Person();
        newPerson = response.readEntity(gTypePerson);
        System.out.println("Person List (modification):");
        System.out.println("***************************");
        System.out.println(newPerson.getName() + " " + newPerson.getFirstName());
        System.out.println("");

        //suppress a person
        wsPerson.remove(idStr);

        //check if the suppression has work
        response = wsPerson.find_JSON(Response.class, idStr);
        newPerson = response.readEntity(gTypePerson);
        System.out.println("Person List (suppression):");
        System.out.println("***************************");
        if (newPerson != null) {
            System.out.println(newPerson.getName() + " " + newPerson.getFirstName());
        } else {
            System.out.println("null");
        }

    }
}
