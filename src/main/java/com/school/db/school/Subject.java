/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.school.db.school;

import com.school.db.exam.Exam;
import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Salah Atwa
 */
@Entity  
@Table(name = "SUBJECT")
public class Subject implements Serializable {
   
    @Id  
    @GeneratedValue(strategy=GenerationType.AUTO) 
    @Column(name = "id" , nullable = false) 
    private long id;
    
    @Column(name = "subject_name")
    private String subjectName;
    
    @Column(name = "minimum_degree")
    private int minDegree;
    
    @Column(name = "maximum_degree")
    private int maxDegree;
    
    // Subject has many-to-one with Stage class
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Stage.class ,cascade = CascadeType.ALL)
    @JoinColumn(name = "stage_id", nullable = false)
    private Stage stage;
    
    @OneToMany(fetch = FetchType.LAZY ,targetEntity = Exam.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "subject_id" ,nullable = false)
    private Set<Exam> exams=new LinkedHashSet<Exam>();

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
     * @return the subjectName
     */
    public String getSubjectName() {
        return subjectName;
    }

    /**
     * @param subjectName the subjectName to set
     */
    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    /**
     * @return the minDegree
     */
    public int getMinDegree() {
        return minDegree;
    }

    /**
     * @param minDegree the minDegree to set
     */
    public void setMinDegree(int minDegree) {
        this.minDegree = minDegree;
    }

    /**
     * @return the maxDegree
     */
    public int getMaxDegree() {
        return maxDegree;
    }

    /**
     * @param maxDegree the maxDegree to set
     */
    public void setMaxDegree(int maxDegree) {
        this.maxDegree = maxDegree;
    }

    /**
     * @return the stage
     */
    public Stage getStage() {
        return stage;
    }

    /**
     * @param stage the stage to set
     */
    public void setStage(Stage stage) {
        this.stage = stage;
    }

    /**
     * @return the exams
     */
    public Set<Exam> getExams() {
        return exams;
    }

    /**
     * @param exams the exams to set
     */
    public void setExams(Set<Exam> exams) {
        this.exams = exams;
    }

   
    
}
