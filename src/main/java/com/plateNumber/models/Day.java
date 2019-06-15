/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.plateNumber.models;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Oswal
 */
@Entity
@Table(name = "day")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Day.findAll", query = "SELECT d FROM Day d")
    , @NamedQuery(name = "Day.findByIdDay", query = "SELECT d FROM Day d WHERE d.idDay = :idDay")
    , @NamedQuery(name = "Day.findByNameDay", query = "SELECT d FROM Day d WHERE d.nameDay = :nameDay")})
public class Day implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idDay")
    private Integer idDay;
    @Size(max = 50)
    @Column(name = "nameDay")
    private String nameDay;
    @OneToMany(mappedBy = "idDay")
    private Collection<Restrictionaday> restrictionadayCollection;

    public Day() {
    }

    public Day(Integer idDay) {
        this.idDay = idDay;
    }

    public Integer getIdDay() {
        return idDay;
    }

    public void setIdDay(Integer idDay) {
        this.idDay = idDay;
    }

    public String getNameDay() {
        return nameDay;
    }

    public void setNameDay(String nameDay) {
        this.nameDay = nameDay;
    }

    @XmlTransient
    public Collection<Restrictionaday> getRestrictionadayCollection() {
        return restrictionadayCollection;
    }

    public void setRestrictionadayCollection(Collection<Restrictionaday> restrictionadayCollection) {
        this.restrictionadayCollection = restrictionadayCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDay != null ? idDay.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Day)) {
            return false;
        }
        Day other = (Day) object;
        if ((this.idDay == null && other.idDay != null) || (this.idDay != null && !this.idDay.equals(other.idDay))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.plateNumber.models.Day[ idDay=" + idDay + " ]";
    }
    
}
