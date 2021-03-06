/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.isl.ue.entity;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.logging.Logger;


/***********************************************
 * Class linked to the organizedUe table
 * 
 * @author Schloune Denis
 ***********************************************/


public class OrganizedUe extends AbstractEntity implements Serializable, Comparable<OrganizedUe> {
    //********************************************
    //members
    //********************************************
    private static final long serialVersionUID = 1L;
    private Integer organizedUeId;
    private Date endDate;
    private String name;
    private Date startDate;
    private Collection<Person> persons;
    private Collection<Indicator> indicators;
    private Collection<StudentOrganizedUe> studentOrganizedUes;
    private Collection<Planning> plannings;
    private Level level;
    private Ue ue;

    //**********************************************
    //constructors
    //********************************************** 
    //default constructor
    public OrganizedUe() {
    }

    public OrganizedUe(Integer organizedUeId) {
        this.organizedUeId = organizedUeId;
    }
    
    //parametrable constructor
    public OrganizedUe(Integer organizedUeId, Date startDate, Date endDate, Level level, Ue ue, String name) {
        this.organizedUeId = organizedUeId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.level = level;
        this.ue = ue;
        this.name = name;
    }
    
    //parametrable constructor with a startDate and a endDate parameter in String
     public OrganizedUe(Integer organizedUeId, String startDate, String endDate, Level level, Ue ue, String name) {
        this.organizedUeId = organizedUeId;
        this.startDate = null;
        this.endDate = null;
        this.level = level;
        this.ue = ue;
        this.name = name;
        
        this.setStartDate(startDate);
        this.setEndDate(endDate);
    }

     //Method from abstract class AbstractEntity
    @Override
    public Integer getId() {
        return organizedUeId;
    }
    
    //*****************************
    //getter and setter
    //*****************************
    public Integer getOrganizedUeId() {
        return organizedUeId;
    }

    public void setOrganizedUeId(Integer organizedUeId) {
        this.organizedUeId = organizedUeId;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
    //setEndDate from a string -> conversion
       public void setEndDate(String date){
         try { 
           SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date convertedDate = dateFormat.parse(date);
            this.endDate = convertedDate;
        } catch (ParseException ex) {
            Logger.getLogger(OrganizedUe.class.getName()).log(Level.SEVERE, null, ex);
             this.endDate = null;
        }    
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }
    //setStartDate from a string -> conversion
    public void setStartDate(String date){
         try { 
           SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date convertedDate = dateFormat.parse(date);
            this.startDate = convertedDate;
        } catch (ParseException ex) {
            Logger.getLogger(OrganizedUe.class.getName()).log(Level.SEVERE, null, ex);
             this.startDate = null;
        }    
    }

    public Collection<Person> getPersons() {
        return persons;
    }

    public void setPersons(Collection<Person> persons) {
        this.persons = persons;
    }

    public Collection<Indicator> getIndicators() {
        return indicators;
    }

    public void setIndicators(Collection<Indicator> indicators) {
        this.indicators = indicators;
    }

    public Collection<StudentOrganizedUe> getStudentOrganizedUes() {
        return studentOrganizedUes;
    }

    public void setStudentOrganizedUes(Collection<StudentOrganizedUe> studentOrganizedUes) {
        this.studentOrganizedUes = studentOrganizedUes;
    }

    public Collection<Planning> getPlannings() {
        return plannings;
    }

    public void setPlannings(Collection<Planning> plannings) {
        this.plannings = plannings;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public Ue getUe() {
        return ue;
    }

    public void setUe(Ue ue) {
        this.ue = ue;
    }

    //************************************************
    //methods
    //************************************************
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (organizedUeId != null ? organizedUeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrganizedUe)) {
            return false;
        }
        OrganizedUe other = (OrganizedUe) object;
        if ((this.organizedUeId == null && other.organizedUeId != null) || (this.organizedUeId != null && !this.organizedUeId.equals(other.organizedUeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return name;
    }
    
    //compareTo: I decided to use the id and the name to
    //discriminate an organized ue
    public int compareTo(OrganizedUe o){
        //******************************************************************************************
        //mandatory to only use id because of primeface component p:datatable on organizedUe.xhtml
        //******************************************************************************************
        //Boolean nameBool = false;
        
       //if(this.name != null && this.name.length() > 0 && o.getName() != null && o.getName().length() > 0){
            //nameBool = true;
        //}
        //if(!nameBool){
            return this.organizedUeId.compareTo(o.getOrganizedUeId());
           // return 0;
        //}
        //return this.name.toLowerCase().compareTo(o.name.toLowerCase());
    }
    
}
