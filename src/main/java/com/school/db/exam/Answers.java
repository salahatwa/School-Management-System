/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.school.db.exam;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


/**
 *
 * @author Salah Atwa
 */
@Entity  
@Table(name = "answers")
public class Answers implements Serializable {
    
    @Id  
    @GeneratedValue(strategy=GenerationType.AUTO) 
    @Column(name = "id" , nullable = false) 
    private long id;
    
     // student answer has One-To-One with questions
    @OneToOne(fetch = FetchType.LAZY,targetEntity = Question_Choise.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "choise_id" ,nullable = false)
    private Question_Choise choice;
    
    // student answer has One-To-One with questions
    @OneToOne(fetch = FetchType.LAZY,targetEntity =Question.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "question_id" ,nullable = false)
    private Question questions=new Question();
    

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
     * @return the questions
     */
    public Question getQuestions() {
        return questions;
    }

    /**
     * @param questions the questions to set
     */
    public void setQuestions(Question questions) {
        this.questions = questions;
    }

    /**
     * @return the choice
     */
    public Question_Choise getChoice() {
        return choice;
    }

    /**
     * @param choice the choice to set
     */
    public void setChoice(Question_Choise choice) {
        this.choice = choice;
    }

    
 
    
}
