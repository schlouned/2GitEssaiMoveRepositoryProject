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
 * Class linked to the capacity table
 * 
 * @author Schloune Denis
 ***********************************************/

public class Capacity extends AbstractEntity implements Serializable, Comparable <Capacity> {
    //********************************************
    //members
    //********************************************
    private static final long serialVersionUID = 1L;
    private Integer capacityId;
    private String description;
    private Boolean isThresholdOfSuccess;
    private String name;
    private Collection<Indicator> indicators;
    private Ue ue;

    //**********************************************
    //constructors
    //**********************************************   
    //default constructor
    public Capacity() {
    }

    public Capacity(Integer capacityId) {
        this.capacityId = capacityId;
    }
    
    //parametrable constructor
    public Capacity(Integer capacityId, String name, String description, Boolean isThresholdOfSuccess, Ue ue) {
        this.capacityId = capacityId;
        this.name = name;
        this.description = description;
        this.isThresholdOfSuccess = isThresholdOfSuccess;
        this.ue = ue;
    }
    
    //Method from abstract class AbstractEntity
    @Override
    public Integer getId() {
        return capacityId;
    }
    
    //*****************************
    //getter and setter
    //*****************************
    public Integer getCapacityId() {
        return capacityId;
    }

    public void setCapacityId(Integer capacityId) {
        this.capacityId = capacityId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getIsThresholdOfSuccess() {
        return isThresholdOfSuccess;
    }

    public void setIsThresholdOfSuccess(Boolean isThresholdOfSuccess) {
        this.isThresholdOfSuccess = isThresholdOfSuccess;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    @JsonbTransient
    public Collection<Indicator> getIndicators() {
        return indicators;
    }

    public void setIndicators(Collection<Indicator> indicators) {
        this.indicators = indicators;
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
        hash += (capacityId != null ? capacityId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Capacity)) {
            return false;
        }
        Capacity other = (Capacity) object;
        if ((this.capacityId == null && other.capacityId != null) || (this.capacityId != null && !this.capacityId.equals(other.capacityId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return name;
    }
    
     //compareTo: I decided to use the name and the capacity to
    //discriminate a capacity
    public int compareTo(Capacity c){
        Boolean nameBool = false;
        
        if(this.name != null && this.name.length() > 0 && c.getName() != null && c.getName().length() > 0){
            nameBool = true;
        }
        if(!nameBool){
            return this.capacityId.compareTo(c.getCapacityId());
        }
        return this.name.compareTo(c.name);
    }
}
