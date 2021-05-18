/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.isl.ue.entity;

import jakarta.json.bind.annotation.JsonbTransient;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Collection;
import java.util.Date;
import java.util.logging.Logger;


/***********************************************
 * Class linked to the person table
 * 
 * @author Schloune Denis
 ***********************************************/

public class Person extends AbstractEntity implements Serializable, Comparable<Person> {
    //********************************************
    //members
    //********************************************
    private static final long serialVersionUID = 1L;
    private Integer personId;
    private String address;   
    private String city;
    private String country;
    private LocalDate dateOfBirth;
    private String email;
    private String firstName;
    private Boolean isJuryMember;
    private Boolean isTeacher;
    private String name;
    private String mobile;
    private String postalCode;
    private Collection<OrganizedUe> organizedUes;
    private Collection<StudentOrganizedUe> studentOrganizedUes;
    private Collection<Section> sections;
    private Collection<Planning> plannings;
    private Collection<Presence> presences;

    //**********************************************
    //constructors
    //**********************************************   
    //default constructor
    public Person() {
    }

    public Person(Integer personId) {
        this.personId = personId;
    }
    
    //parametrable constructor
    public Person(Integer personId, String firstName, String lastName, String mobile, String email, String address, String postalCode, String city, String country, Boolean isTeacher, LocalDate dateOfBirth, Boolean isJuryMember) {
        this.personId = personId;
        this.firstName = firstName;
        this.name = lastName;
        this.mobile = mobile;
        this.email = email;
        this.address = address;
        this.postalCode = postalCode;
        this.city = city;
        this.country = country;
        this.isTeacher = isTeacher;
        this.dateOfBirth = dateOfBirth;
        this.isJuryMember = isJuryMember;
    }
    
    // parametrable constructor with a dateOfBirth parameter in String
     public Person(Integer personId, String firstName, String lastName, String mobile, String email, String address, String postalCode, String city, String country, Boolean isTeacher, String dateOfBirth, Boolean isJuryMember) {
        this.personId = personId;
        this.firstName = firstName;
        this.name = lastName;
        this.mobile = mobile;
        this.email = email;
        this.address = address;
        this.postalCode = postalCode;
        this.city = city;
        this.country = country;
        this.isTeacher = isTeacher;
        this.dateOfBirth = null;
        this.isJuryMember = isJuryMember;
        
        this.setDateOfBirth(dateOfBirth);
    }
     
    //Method from abstract class AbstractEntity
    public Integer getId() {
        return personId;
    }
    
    //*****************************
    //getter and setter
    //*****************************
    public Integer getPersonId() {
        return personId;
    }

    public void setPersonId(Integer personId) {
        this.personId = personId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
    
    //setDateOfBirth from a string -> conversion
    //setDateOfBirth from a string -> conversion
    public void setDateOfBirth(String date) {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date convertedDate = dateFormat.parse(date);
            this.dateOfBirth = this.convertToLocalDateViaInstant(convertedDate);
        } catch (ParseException ex) {
            Logger.getLogger(Person.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            this.dateOfBirth = null;
        }
    }
    public LocalDate convertToLocalDateViaInstant(Date dateToConvert) {
        return dateToConvert.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
    }
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Boolean getIsJuryMember() {
        return isJuryMember;
    }

    public void setIsJuryMember(Boolean isJuryMember) {
        this.isJuryMember = isJuryMember;
    }

    public Boolean getIsTeacher() {
        return isTeacher;
    }

    public void setIsTeacher(Boolean isTeacher) {
        this.isTeacher = isTeacher;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }
    
    @JsonbTransient
    public Collection<OrganizedUe> getOrganizedUes() {
        return organizedUes;
    }

    public void setOrganizedUes(Collection<OrganizedUe> organizedUes) {
        this.organizedUes = organizedUes;
    }
    
    @JsonbTransient
    public Collection<StudentOrganizedUe> getStudentOrganizedUes() {
        return studentOrganizedUes;
    }

    public void setStudentOrganizedUes(Collection<StudentOrganizedUe> studentOrganizedUes) {
        this.studentOrganizedUes = studentOrganizedUes;
    }

    @JsonbTransient
    public Collection<Section> getSections() {
        return sections;
    }

    public void setSections(Collection<Section> sections) {
        this.sections = sections;
    }
    
    @JsonbTransient
    public Collection<Planning> getPlannings() {
        return plannings;
    }

    public void setPlannings(Collection<Planning> plannings) {
        this.plannings = plannings;
    }
    
    @JsonbTransient
    public Collection<Presence> getPresences() {
        return presences;
    }

    public void setPresences(Collection<Presence> presences) {
        this.presences = presences;
    }

    //************************************************
    //methods
    //************************************************
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (personId != null ? personId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Person)) {
            return false;
        }
        Person other = (Person) object;
        if ((this.personId == null && other.personId != null) || (this.personId != null && !this.personId.equals(other.personId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return name + " " + firstName;
    }
    
    //compareTo: I decided to use firstName, name and dateOfBirth to
    //discriminate a person, I just need to convert a Date in String with the method dateToString below
    public int compareTo(Person p) { 
        Boolean lastNameBool = false;
        Boolean firstNameBool = false;
        Boolean dateOfBirthBool = false;
        String strThis = "";
        String strP = "";
        
        if(this.name != null && this.name.length() > 0 && p.getName() != null && p.getName().length() > 0){
            lastNameBool = true;
            strThis += this.name;
            strP += p.getName();
        }
        if(this.firstName != null && this.firstName.length() > 0 && p.getFirstName() != null && p.getFirstName().length() > 0){
            firstNameBool = true;
            strThis += this.firstName;
            strP += p.getFirstName();
        }
        if(this.dateOfBirth != null && p.getDateOfBirth() != null){
            dateOfBirthBool = true;
            strThis += this.dateOfBirth;
            strP += p.getDateOfBirth();
        }
        if(!(firstNameBool || lastNameBool || dateOfBirthBool)){
//            return this.personId.compareTo(p.personId);
            return 0;
        }
        //Put every string in lower case to have the right sort in the list//       
        strThis = strThis.toLowerCase();
        strP = strP.toLowerCase();
        //*******************************
        
        return strThis.compareTo(strP);
        
    }
    
   /* @Override
    public Person clone(){
        Person clone = new Person();
        
        clone.personId = this.personId;
        clone.firstName = this.firstName;
        clone.name = this.name;
        clone.mobile = this.mobile;
        clone.email = this.email;
        clone.address = this.address;
        clone.postalCode = this.postalCode;
        clone.city = this.city;
        clone.country = this.country;
        clone.isTeacher = this.isTeacher;
        clone.dateOfBirth = this.dateOfBirth;
        clone.isJuryMember = this.isJuryMember;
        
        return clone;        
    }*/
    
}
