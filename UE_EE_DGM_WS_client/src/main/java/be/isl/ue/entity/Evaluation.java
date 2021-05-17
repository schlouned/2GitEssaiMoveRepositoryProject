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

public class Evaluation extends AbstractEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer evaluationId;
    private String comment;
    private String result;
    private Indicator indicator;
    private StudentOrganizedUe studentOrganizedUe;

    //Method from abstract class AbstractEntity
    @Override
    public Integer getId() {
        return evaluationId;
    }
    
    public Evaluation() {
    }

    public Evaluation(Integer evaluationId) {
        this.evaluationId = evaluationId;
    }

    public Integer getEvaluationId() {
        return evaluationId;
    }

    public void setEvaluationId(Integer evaluationId) {
        this.evaluationId = evaluationId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public Indicator getIndicator() {
        return indicator;
    }

    public void setIndicator(Indicator indicator) {
        this.indicator = indicator;
    }

    public StudentOrganizedUe getStudentOrganizedUe() {
        return studentOrganizedUe;
    }

    public void setStudentOrganizedUe(StudentOrganizedUe studentOrganizedUe) {
        this.studentOrganizedUe = studentOrganizedUe;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (evaluationId != null ? evaluationId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Evaluation)) {
            return false;
        }
        Evaluation other = (Evaluation) object;
        if ((this.evaluationId == null && other.evaluationId != null) || (this.evaluationId != null && !this.evaluationId.equals(other.evaluationId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "be.isl.ue.entity.Evaluation[ evaluationId=" + evaluationId + " ]";
    }
    
}
