/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.school.db.exam;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;

/**
 *
 * @author Salah Atwa
 */
@Entity  
@Table(name = "exams")
public class Exam implements Serializable {
    
    @Id  
    @GeneratedValue(strategy=GenerationType.AUTO) 
    @Column(name = "id" , nullable = false) 
    private long id;
    
     // Subject has many-to-one with Stage class
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "exam_type", nullable = false)
    private ExamType examType;
    
    @Column(name = "exam_date")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date examDate;
    
    // Exam one-to-many Question
    @OneToMany(fetch = FetchType.LAZY ,cascade = CascadeType.ALL)
    @JoinColumn(name = "exam_id" ,nullable = false)
    private Set<Question> questions=new LinkedHashSet<Question>();

    
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
     * @return the examDate
     */
    public Date getExamDate() {
        return examDate;
    }

    /**
     * @param examDate the examDate to set
     */
    public void setExamDate(Date examDate) {
        this.examDate = examDate;
    }

    /**
     * @return the questions
     */
    public Set<Question> getQuestions() {
        return questions;
    }

    /**
     * @param questions the questions to set
     */
    public void setQuestions(Set<Question> questions) {
        this.questions = questions;
    }

    /**
     * @return the examType
     */
    public ExamType getExamType() {
        return examType;
    }

    /**
     * @param examType the examType to set
     */
    public void setExamType(ExamType examType) {
        this.examType = examType;
    }
    
    
}
