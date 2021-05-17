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

public class Indicator extends AbstractEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer indicatorId;
    private String description;
    private Boolean isCriteria;
    private String maxPossible;
    private String name;
    private Capacity capacity;
    private Collection<Indicator> indicators;
    private Indicator parentIndicator;
    private OrganizedUe organizedUeId;
    private Collection<Evaluation> evaluations;

    //Method from abstract class AbstractEntity
    @Override
    public Integer getId() {
        return indicatorId;
    }
    
    public Indicator() {
    }

    public Indicator(Integer indicatorId) {
        this.indicatorId = indicatorId;
    }

    public Integer getIndicatorId() {
        return indicatorId;
    }

    public void setIndicatorId(Integer indicatorId) {
        this.indicatorId = indicatorId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getIsCriteria() {
        return isCriteria;
    }

    public void setIsCriteria(Boolean isCriteria) {
        this.isCriteria = isCriteria;
    }

    public String getMaxPossible() {
        return maxPossible;
    }

    public void setMaxPossible(String maxPossible) {
        this.maxPossible = maxPossible;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Capacity getCapacity() {
        return capacity;
    }

    public void setCapacity(Capacity capacity) {
        this.capacity = capacity;
    }

    public Collection<Indicator> getIndicators() {
        return indicators;
    }

    public void setIndicators(Collection<Indicator> indicators) {
        this.indicators = indicators;
    }

    public Indicator getParentIndicator() {
        return parentIndicator;
    }

    public void setParentIndicator(Indicator parentIndicator) {
        this.parentIndicator = parentIndicator;
    }

    public OrganizedUe getOrganizedUeId() {
        return organizedUeId;
    }

    public void setOrganizedUeId(OrganizedUe organizedUeId) {
        this.organizedUeId = organizedUeId;
    }

    public Collection<Evaluation> getEvaluations() {
        return evaluations;
    }

    public void setEvaluations(Collection<Evaluation> evaluations) {
        this.evaluations = evaluations;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (indicatorId != null ? indicatorId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Indicator)) {
            return false;
        }
        Indicator other = (Indicator) object;
        if ((this.indicatorId == null && other.indicatorId != null) || (this.indicatorId != null && !this.indicatorId.equals(other.indicatorId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "be.isl.ue.entity.Indicator[ indicatorId=" + indicatorId + " ]";
    }
    
}
