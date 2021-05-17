/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package start;

import be.isl.ue.entity.Person;
import be.isl.ue.entity.Section;
import be.isl.ue.entity.Ue;
import be.isl.ue.ue_ee_dgm_ws_client.WSclient;
import jakarta.ws.rs.core.GenericType;
import jakarta.ws.rs.core.Response;
import java.util.List;

/**
 *
 * @author Schloune Denis
 */
public class StartUe {

    public static void main(String[] args) {
        ueTest();
    }

    //personStart
    public static void ueTest() {
        //variable
        WSclient wsSection = new WSclient("Sections");
        WSclient wsUe = new WSclient("Ues");
        GenericType<Ue> gTypeUe = new GenericType<Ue>() {};
        GenericType<Section> gTypeSection = new GenericType<Section>() {};
        GenericType<List<Ue>> gTypeUeList = new GenericType<List<Ue>>() {};
        
        //count
        System.out.println("Number of Ue: ");
        System.out.println(wsUe.countREST());
        System.out.println("************");
        System.out.println("");

        //findAll
        Response response = wsUe.findAll_JSON(Response.class);
        List<Ue> ues = response.readEntity(gTypeUeList);
        System.out.println("Ue List:");
        System.out.println("************");
        for (Ue u : ues) {
            System.out.println(u.getName());
        }
        System.out.println("");

        //create  new ue        
        Ue ue = new Ue();
        ue.setName("UeWebService");
        ue.setDescription("try to create a web service ue");
        response = wsSection.find_JSON(Response.class, "33");
        Section section = response.readEntity(gTypeSection);
        ue.setSection(section);
        wsUe.create_JSON(ue);

        //check if the new ue is created
        response = wsUe.findByName_JSON(Response.class, "UeWebService");
        ues = response.readEntity(gTypeUeList);
        System.out.println("Ue List (add):");
        System.out.println("******************");
        Ue ueTest = ues.get(0);
        for (Ue u : ues) {
            System.out.println(u.getName());
        }
        System.out.println("");

        //modify a section
        Integer idUeTest = ueTest.getUeId();
        String idStr = idUeTest.toString();
        ueTest.setName("ModificationUe");
        wsUe.edit_JSON(ueTest, idStr);

        //check if the modification has work
        response = wsUe.find_JSON(Response.class, idStr);
        Ue newUe = new Ue();
        newUe = response.readEntity(gTypeUe);
        System.out.println("Ue List (modification):");
        System.out.println("***************************");
        System.out.println(newUe.getName());
        System.out.println("");

        //suppress a section
        wsUe.remove(idStr);

        //check if the suppression has work
        response = wsSection.find_JSON(Response.class, idStr);
        newUe = response.readEntity(gTypeUe);
        System.out.println("Ue List (suppression):");
        System.out.println("***************************");
        if (newUe != null) {
            System.out.println(newUe.getName());
        } else {
            System.out.println("null");
        }

    }
}
