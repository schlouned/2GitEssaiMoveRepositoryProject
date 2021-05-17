/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package start;

import be.isl.ue.entity.Person;
import be.isl.ue.entity.Section;
import be.isl.ue.ue_ee_dgm_ws_client.WSclient;
import jakarta.ws.rs.core.GenericType;
import jakarta.ws.rs.core.Response;
import java.util.List;

/**
 *
 * @author Schloune Denis
 */
public class StartSection {

    public static void main(String[] args) {
        sectionTest();
    }

    //personStart
    public static void sectionTest() {
        //variable
        WSclient wsSection = new WSclient("Sections");
        WSclient wsPerson = new WSclient("Persons");
        GenericType<Person> gTypePerson = new GenericType<Person>() {};
        GenericType<Section> gTypeSection = new GenericType<Section>() {};
        GenericType<List<Section>> gTypeSectionList = new GenericType<List<Section>>() {};
        
        //count
        System.out.println("Number of section: ");
        System.out.println(wsSection.countREST());
        System.out.println("************");
        System.out.println("");

        //findAll
        Response response = wsSection.findAll_JSON(Response.class);
        List<Section> sections = response.readEntity(gTypeSectionList);
        System.out.println("Section List:");
        System.out.println("************");
        for (Section s : sections) {
            System.out.println(s.getName());
        }
        System.out.println("");

        //create  new section        
        Section section = new Section();
        section.setName("SectionWebService");
        section.setDescription("try to create a web service section");
        response = wsPerson.find_JSON(Response.class, "1");
        Person person = response.readEntity(gTypePerson);
        section.setPerson(person);
        wsSection.create_JSON(section);

        //check if the new section is created
        response = wsSection.findByName_JSON(Response.class, "SectionWebService");
        sections = response.readEntity(gTypeSectionList);
        System.out.println("Section List (add):");
        System.out.println("******************");
        Section sectionTest = sections.get(0);
        for (Section s : sections) {
            System.out.println(s.getName());
        }
        System.out.println("");

        //modify a section
        Integer idSectionTest = sectionTest.getSectionId();
        String idStr = idSectionTest.toString();
        sectionTest.setName("Modification");
        wsSection.edit_JSON(sectionTest, idStr);

        //check if the modification has work
        response = wsSection.find_JSON(Response.class, idStr);
        Section newSection = new Section();
        newSection = response.readEntity(gTypeSection);
        System.out.println("Section List (modification):");
        System.out.println("***************************");
        System.out.println(newSection.getName());
        System.out.println("");

        //suppress a section
        wsSection.remove(idStr);

        //check if the suppression has work
        response = wsSection.find_JSON(Response.class, idStr);
        newSection = response.readEntity(gTypeSection);
        System.out.println("Section List (suppression):");
        System.out.println("***************************");
        if (newSection != null) {
            System.out.println(newSection.getName());
        } else {
            System.out.println("null");
        }

    }
}
