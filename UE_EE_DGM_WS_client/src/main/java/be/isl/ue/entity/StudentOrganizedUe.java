/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.isl.ue.entity;

import java.io.Serializable;
import java.util.Collection;

/**
 *
 * @author Schloune Denis
 */
public class StudentOrganizedUe extends AbstractEntity implements Serializable ,Comparable<StudentOrganizedUe> {

    private static final long serialVersionUID = 1L;
    protected StudentOrganizedUePK studentOrganizedUePK;
    private String comment;
    private OrganizedUe organizedUe;
    private Person person;
    private Collection<Evaluation> evaluations;

    public StudentOrganizedUe() {
    }

    public StudentOrganizedUe(StudentOrganizedUePK studentOrganizedUePK) {
        this.studentOrganizedUePK = studentOrganizedUePK;
    }

    public StudentOrganizedUe(int personId, int organizedUeId) {
        this.studentOrganizedUePK = new StudentOrganizedUePK(personId, organizedUeId);
    }

    public StudentOrganizedUePK getStudentOrganizedUePK() {
        return studentOrganizedUePK;
    }

    public void setStudentOrganizedUePK(StudentOrganizedUePK studentOrganizedUePK) {
        this.studentOrganizedUePK = studentOrganizedUePK;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public OrganizedUe getOrganizedUe() {
        return organizedUe;
    }

    public void setOrganizedUe(OrganizedUe organizedUe) {
        this.organizedUe = organizedUe;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Collection<Evaluation> getEvaluations() {
        return evaluations;
    }

    //public void setEvaluations(Collection<Evaluation> evaluations) {
    //    this.evaluations = evaluations;
    //}

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (studentOrganizedUePK != null ? studentOrganizedUePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StudentOrganizedUe)) {
            return false;
        }
        StudentOrganizedUe other = (StudentOrganizedUe) object;
        if ((this.studentOrganizedUePK == null && other.studentOrganizedUePK != null) || (this.studentOrganizedUePK != null && !this.studentOrganizedUePK.equals(other.studentOrganizedUePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "[ studentOrganizedUePK=" + studentOrganizedUePK + " ]";
    }
    
     //Method from abstract class AbstractEntity
    @Override
    public Integer getId() {
        return 0;
    }
    
     public int compareTo(StudentOrganizedUe s){

        return 0;
        
     
    }
    
}
