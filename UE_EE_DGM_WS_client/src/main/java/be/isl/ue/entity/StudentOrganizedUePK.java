/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.isl.ue.entity;

import java.io.Serializable;

/**
 *
 * @author Schloune Denis
 */
public class StudentOrganizedUePK implements Serializable {
    private int personId;
    private int organizedUeId;

    public StudentOrganizedUePK() {
    }

    public StudentOrganizedUePK(int personId, int organizedUeId) {
        this.personId = personId;
        this.organizedUeId = organizedUeId;
    }

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public int getOrganizedUeId() {
        return organizedUeId;
    }

    public void setOrganizedUeId(int organizedUeId) {
        this.organizedUeId = organizedUeId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) personId;
        hash += (int) organizedUeId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StudentOrganizedUePK)) {
            return false;
        }
        StudentOrganizedUePK other = (StudentOrganizedUePK) object;
        if (this.personId != other.personId) {
            return false;
        }
        if (this.organizedUeId != other.organizedUeId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "[ personId=" + personId + ", organizedUeId=" + organizedUeId + " ]";
    }
    
}
