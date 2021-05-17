/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.isl.ue.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

/**
 *
 * @author Schloune Denis
 */
public class Planning extends AbstractEntity implements Serializable, Comparable<Planning> {

    private static final long serialVersionUID = 1L;
    private Integer planningId;
    private String room;
    private Date seanceDate;
    private Date startHour;
    private OrganizedUe organizedUe;
    private Person person;
    private Collection<Presence> presences;

    //Method from abstract class AbstractEntity
    @Override
    public Integer getId() {
        return planningId;
    }

    public Planning() {
    }

    public Planning(Integer planningId) {
        this.planningId = planningId;
    }

    public Integer getPlanningId() {
        return planningId;
    }

    public void setPlanningId(Integer planningId) {
        this.planningId = planningId;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public Date getSeanceDate() {
        return seanceDate;
    }

    public void setSeanceDate(Date seanceDate) {
        this.seanceDate = seanceDate;
    }

    public Date getStartHour() {
        return startHour;
    }

    public void setStartHour(Date startHour) {
        this.startHour = startHour;
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

    public Collection<Presence> getPresences() {
        return presences;
    }

    public void setPresences(Collection<Presence> presences) {
        this.presences = presences;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (planningId != null ? planningId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Planning)) {
            return false;
        }
        Planning other = (Planning) object;
        if ((this.planningId == null && other.planningId != null) || (this.planningId != null && !this.planningId.equals(other.planningId))) {
            return false;
        }
        return true;
    }

    /*  @Override
    public String toString() {
        return " Ue: " + organizedUe.getName() + " Date: " + seanceDate;
    }*/
    @Override
    public String toString() {
        return organizedUe.getName();
    }

    public Date getPlanningDate() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setPlanningDate(Date startDate) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int compareTo(Planning o){
        return this.planningId.compareTo(o.getPlanningId());
    }
}
