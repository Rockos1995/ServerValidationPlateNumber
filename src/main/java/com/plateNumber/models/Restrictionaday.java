/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.plateNumber.models;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Oswal
 */
@Entity
@Table(name = "restrictionaday")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Restrictionaday.findAll", query = "SELECT r FROM Restrictionaday r")
    , @NamedQuery(name = "Restrictionaday.findByIdRestriction", query = "SELECT r FROM Restrictionaday r WHERE r.idRestriction = :idRestriction")
    , @NamedQuery(name = "Restrictionaday.findByNumberPlate", query = "SELECT r FROM Restrictionaday r WHERE r.numberPlate = :numberPlate")})
public class Restrictionaday implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idRestriction")
    private Integer idRestriction;
    @Column(name = "numberPlate")
    private Integer numberPlate;
    @JoinColumn(name = "idDay", referencedColumnName = "idDay")
    @ManyToOne
    private Day idDay;

    public Restrictionaday() {
    }

    public Restrictionaday(Integer idRestriction) {
        this.idRestriction = idRestriction;
    }

    public Integer getIdRestriction() {
        return idRestriction;
    }

    public void setIdRestriction(Integer idRestriction) {
        this.idRestriction = idRestriction;
    }

    public Integer getNumberPlate() {
        return numberPlate;
    }

    public void setNumberPlate(Integer numberPlate) {
        this.numberPlate = numberPlate;
    }

    public Day getIdDay() {
        return idDay;
    }

    public void setIdDay(Day idDay) {
        this.idDay = idDay;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRestriction != null ? idRestriction.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Restrictionaday)) {
            return false;
        }
        Restrictionaday other = (Restrictionaday) object;
        if ((this.idRestriction == null && other.idRestriction != null) || (this.idRestriction != null && !this.idRestriction.equals(other.idRestriction))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.plateNumber.models.Restrictionaday[ idRestriction=" + idRestriction + " ]";
    }
    
}
