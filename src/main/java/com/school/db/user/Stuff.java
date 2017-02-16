/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.school.db.user;

import java.io.Serializable;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author Salah Atwa
 */

@Entity  
@Table(name = "Users")  
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "user_type",discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue(value="Admin")

@ManagedBean(name = "stuff")
@SessionScoped
public class Stuff implements Serializable {
    
    @Id  
    @GeneratedValue(strategy=GenerationType.AUTO) 
    @Column(name = "id", nullable = false) 
    private long id;
    
    @Column(insertable = false,updatable = false)
    private String user_type;
    
    @ManagedProperty(value = "#{personalInfo}")
    @OneToOne(fetch = FetchType.EAGER,targetEntity = PersonalInfo.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "personal_info_id" ,nullable = false)
    private PersonalInfo personalInfo;
    
    @ManagedProperty(value = "#{familyInfo}")
    @OneToOne(fetch = FetchType.EAGER,targetEntity = FamilyInformation.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "family_info_id" )
    private FamilyInformation familyInfo;
    
    @Column(name = "join_date" ,nullable = false)  
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date joinDate=new Date();
   
//    @ManagedProperty(value = "#{nationality}")
    @OneToMany(fetch = FetchType.EAGER ,targetEntity = Nationality.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id" ,nullable = false)
    private Set<Nationality> nationalities=new LinkedHashSet();

    public Stuff() {
        
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
     * @return the personalInfo
     */
    public PersonalInfo getPersonalInfo() {
        return personalInfo;
    }

    /**
     * @param personalInfo the personalInfo to set
     */
    public void setPersonalInfo(PersonalInfo personalInfo) {
        this.personalInfo = personalInfo;
    }

    /**
     * @return the familyInfo
     */
    public FamilyInformation getFamilyInfo() {
        return familyInfo;
    }

    /**
     * @param familyInfo the familyInfo to set
     */
    public void setFamilyInfo(FamilyInformation familyInfo) {
        this.familyInfo = familyInfo;
    }

    /**
     * @return the joinDate
     */
    public Date getJoinDate() {
        return joinDate;
    }

    /**
     * @param joinDate the joinDate to set
     */
    public void setJoinDate(Date joinDate) {
        this.joinDate = joinDate;
    }



    /**
     * @return the nationalities
     */
    public Set<Nationality> getNationalities() {
        return nationalities;
    }

    /**
     * @param nationalities the nationalities to set
     */
    public void setNationalities(Set<Nationality> nationalities) {
        this.nationalities = nationalities;
    }

    /**
     * @return the user_type
     */
    public String getUser_type() {
        return user_type;
    }

    /**
     * @param user_type the user_type to set
     */
    public void setUser_type(String user_type) {
        this.user_type = user_type;
    }

  
}
