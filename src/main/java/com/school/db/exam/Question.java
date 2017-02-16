/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.school.db.exam;

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
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Salah Atwa
 */
@Entity  
@Table(name = "questions")
public class Question implements Serializable {
    
    @Id  
    @GeneratedValue(strategy=GenerationType.AUTO) 
    @Column(name = "id" , nullable = false) 
    private long id;
    
    @Column(name = "question_number")
    private int questionNumber;
    
    @Column(name = "question_title")
    private String questionTitle;
    
    @OneToMany(fetch = FetchType.EAGER ,targetEntity =Question_Choise.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "question_id" ,nullable = false)
    private Set<Question_Choise> questionChoises=new LinkedHashSet<Question_Choise>();
   
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
     * @return the questionNumber
     */
    public int getQuestionNumber() {
        return questionNumber;
    }

    /**
     * @param questionNumber the questionNumber to set
     */
    public void setQuestionNumber(int questionNumber) {
        this.questionNumber = questionNumber;
    }

    /**
     * @return the questionChoises
     */
    public Set<Question_Choise> getQuestionChoises() {
        return questionChoises;
    }

    /**
     * @param questionChoises the questionChoises to set
     */
    public void setQuestionChoises(Set<Question_Choise> questionChoises) {
        this.questionChoises = questionChoises;
    }

    /**
     * @return the questionTitle
     */
    public String getQuestionTitle() {
        return questionTitle;
    }

    /**
     * @param questionTitle the questionTitle to set
     */
    public void setQuestionTitle(String questionTitle) {
        this.questionTitle = questionTitle;
    }
    
}
