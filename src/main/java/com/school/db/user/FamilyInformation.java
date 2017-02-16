/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.school.db.user;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Salah Atwa
 */
@Entity  
@Table(name = "FAMILY_INFO")


@ManagedBean(name = "familyInfo")
@SessionScoped
public class FamilyInformation implements Serializable {
    
    @Id  
    @GeneratedValue(strategy=GenerationType.AUTO) 
    @Column(name = "id" , nullable = false) 
    private long id;
    
    @Column(name = "father_name")
    private String fatherName;
    
    @Column(name = "father_phone")
    private String fatherPhone;
    
    @Column(name = "father_job")
    private String fatherJob;
    
    @Column(name = "father_address")
    private String fatherAddress;
    
    @Column(name = "father_email")
    private String fatherEmail;

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
     * @return the fatherName
     */
    public String getFatherName() {
        return fatherName;
    }

    /**
     * @param fatherName the fatherName to set
     */
    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    /**
     * @return the fatherPhone
     */
    public String getFatherPhone() {
        return fatherPhone;
    }

    /**
     * @param fatherPhone the fatherPhone to set
     */
    public void setFatherPhone(String fatherPhone) {
        this.fatherPhone = fatherPhone;
    }

    /**
     * @return the fatherJob
     */
    public String getFatherJob() {
        return fatherJob;
    }

    /**
     * @param fatherJob the fatherJob to set
     */
    public void setFatherJob(String fatherJob) {
        this.fatherJob = fatherJob;
    }

    /**
     * @return the fatherAddress
     */
    public String getFatherAddress() {
        return fatherAddress;
    }

    /**
     * @param fatherAddress the fatherAddress to set
     */
    public void setFatherAddress(String fatherAddress) {
        this.fatherAddress = fatherAddress;
    }

    /**
     * @return the fatherEmail
     */
    public String getFatherEmail() {
        return fatherEmail;
    }

    /**
     * @param fatherEmail the fatherEmail to set
     */
    public void setFatherEmail(String fatherEmail) {
        this.fatherEmail = fatherEmail;
    }

   
}
