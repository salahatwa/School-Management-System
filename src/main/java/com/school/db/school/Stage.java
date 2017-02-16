/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.school.db.school;

import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Set;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Salah Atwa
 */
@Entity  
@Table(name = "STAGE")
@ManagedBean(name = "stage")
@SessionScoped
public class Stage implements Serializable {
    
    @Id  
    @GeneratedValue(strategy=GenerationType.AUTO) 
    @Column(name = "id" , nullable = false) 
    private long id;
    
    @Column(name = "stage_name" , nullable = false)
    private String stageName;
    
    @Column(name = "stage_year" ,nullable = false)
    private String stageYear;
    
    @OneToMany(fetch = FetchType.EAGER,targetEntity = RowsOFStage.class ,cascade = CascadeType.ALL)
    @JoinColumn(name = "stage_id")
    private Set<RowsOFStage> stageRowses;

    public Stage() {
        this.stageRowses = new LinkedHashSet<>();
    }

    /**
     * @return the id
     */
    public long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * @return the stageName
     */
    public String getStageName() {
        return stageName;
    }

    /**
     * @param stageName the stageName to set
     */
    public void setStageName(String stageName) {
        this.stageName = stageName;
    }

    /**
     * @return the stageYear
     */
    public String getStageYear() {
        return stageYear;
    }

    /**
     * @param stageYear the stageYear to set
     */
    public void setStageYear(String stageYear) {
        this.stageYear = stageYear;
    }

    /**
     * @return the stageRowses
     */
    public Set<RowsOFStage> getStageRowses() {
        return stageRowses;
    }

    /**
     * @param stageRowses the stageRowses to set
     */
    public void setStageRowses(Set<RowsOFStage> stageRowses) {
        this.stageRowses = stageRowses;
    }
    
    
}
