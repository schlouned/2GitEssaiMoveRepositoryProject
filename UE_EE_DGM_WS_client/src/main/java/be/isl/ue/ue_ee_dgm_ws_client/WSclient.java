/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.isl.ue.ue_ee_dgm_ws_client;

import jakarta.ws.rs.ClientErrorException;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.MediaType;
import java.text.MessageFormat;

/**
 *
 * @author Schloune Denis
 */
public class WSclient {
    //members
    //***************************
    private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI = "http://localhost:8080/ue_dgm/ue";

    //constructors
    //***************************    
     public WSclient(String path) {       
        this.client = ClientBuilder.newClient();
        this.webTarget = client.target(BASE_URI).path(path);
    }
    
     //methods
     //**************************
     //count
     public String countREST() throws ClientErrorException{
         WebTarget resource = webTarget;
         resource = resource.path("count");
         return resource.request(MediaType.TEXT_PLAIN).get(String.class);
     }
     
     //edit
     public void edit_JSON(Object requestEntity, String id) throws ClientErrorException{
         webTarget.path(MessageFormat.format("{0}", new Object[]{id})).request(MediaType.APPLICATION_JSON).put(
                 jakarta.ws.rs.client.Entity.entity(requestEntity, MediaType.APPLICATION_JSON));
     }
     
     //create
     public void create_JSON(Object requestEntity)throws ClientErrorException{
         webTarget.request(MediaType.APPLICATION_JSON).post(
                 jakarta.ws.rs.client.Entity.entity(requestEntity, MediaType.APPLICATION_JSON));
                 
     }
     
     //remove
     public void remove(String id)throws ClientErrorException{ 
         webTarget.path(MessageFormat.format("{0}", new Object[]{id})).request().delete();
     }
    
     //find
     public <T> T find_JSON(Class<T> responseType, String id)throws ClientErrorException{
         WebTarget resource = webTarget;
         resource = resource.path(MessageFormat.format("{0}", new Object[]{id}));
         return resource.request(MediaType.APPLICATION_JSON).get(responseType);
     }
     
     public <T> T findByName_JSON(Class<T> responseType, String name)throws ClientErrorException{
         WebTarget resource = webTarget;
         if(name != null){
             resource = resource.queryParam("name", name);
         }
         return resource.request(MediaType.APPLICATION_JSON).get(responseType);
     }
     
     //findAlll
     public <T> T findAll_JSON(Class<T> responseType)throws ClientErrorException{
         WebTarget resource = webTarget;
         resource = resource.path("All");
         return resource.request(MediaType.APPLICATION_JSON).get(responseType);
     } 
     
     //findRange
     public <T> T findRange_JSON(Class<T> responseType, String from, String to)throws ClientErrorException{
         WebTarget resource = webTarget;
          resource = resource.path(MessageFormat.format("{0}/{1}", new Object[]{from, to}));
         return resource.request(MediaType.APPLICATION_JSON).get(responseType);
     }
        
}
