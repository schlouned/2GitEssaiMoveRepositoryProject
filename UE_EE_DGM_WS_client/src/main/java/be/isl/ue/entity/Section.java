/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.isl.ue.entity;

import java.io.Serializable;
import java.util.Collection;
import jakarta.json.bind.annotation.JsonbTransient;


/***********************************************
 * Class linked to the section table
 * 
 * @author Schloune Denis
 ***********************************************/

public class Section extends AbstractEntity implements Serializable ,Comparable<Section> {
    //********************************************
    //members
    //********************************************
    private static final long serialVersionUID = 1L;
    private Integer sectionId;
    private String description;
    private String name;
    private Person person;
    private Collection<Ue> ues;

    //**********************************************
    //constructors
    //**********************************************   
    //default constructor
    public Section() {
    }

    public Section(Integer sectionId) {
        this.sectionId = sectionId;
    }
    
    //parametrable constructor
    public Section(Integer sectionId, String name, String description, Person person) {
        this.sectionId = sectionId;
        this.name = name;
        this.description = description;
        this.person = person;
    }

     //Method from abstract class AbstractEntity
    @Override
    public Integer getId() {
        return sectionId;
    }
    //*****************************
    //getter and setter
    //*****************************
    public Integer getSectionId() {
        return sectionId;
    }

    public void setSectionId(Integer sectionId) {
        this.sectionId = sectionId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @JsonbTransient
    public Collection<Ue> getUes() {
        return ues;
    }

    public void setUes(Collection<Ue> ues) {
        this.ues = ues;
    }

    //************************************************
    //methods
    //************************************************
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sectionId != null ? sectionId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Section)) {
            return false;
        }
        Section other = (Section) object;
        if ((this.sectionId == null && other.sectionId != null) || (this.sectionId != null && !this.sectionId.equals(other.sectionId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return name;
    }
    
    //compareTo: I decided to use name and description to
    //discriminate a section
    public int compareTo(Section s){
        Boolean nameBool = false;
        
        
        if(this.name != null && this.name.length() > 0 && s.getName() != null && s.getName().length() > 0){
            nameBool = true;
         
        }
        
      
       if(!nameBool){
//            return this.sectionId.compareTo(s.getSectionId());
            return 0;
        }
       
        return this.name.toLowerCase().compareTo(s.name.toLowerCase()); 
        
     
    } 
    
}
