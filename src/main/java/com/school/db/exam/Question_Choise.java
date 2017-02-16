/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.school.db.exam;

import java.io.Serializable;
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
@Table(name = "question_choises")
public class Question_Choise implements Serializable {
    
    @Id  
    @GeneratedValue(strategy=GenerationType.AUTO) 
    @Column(name = "id" , nullable = false) 
    private long id;
    
    @Column(name = "answer_choise")
    private String answerChoise;
    
    @Column(name = "choise_number")
    private String choiseNumber;
    
    @Column(name = "is_true")
    private boolean isTrue;

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
     * @return the answerChoise
     */
    public String getAnswerChoise() {
        return answerChoise;
    }

    /**
     * @param answerChoise the answerChoise to set
     */
    public void setAnswerChoise(String answerChoise) {
        this.answerChoise = answerChoise;
    }

    /**
     * @return the isTrue
     */
    public boolean isIsTrue() {
        return isTrue;
    }

    /**
     * @param isTrue the isTrue to set
     */
    public void setIsTrue(boolean isTrue) {
        this.isTrue = isTrue;
    }

    /**
     * @return the choiseNumber
     */
    public String getChoiseNumber() {
        return choiseNumber;
    }

    /**
     * @param choiseNumber the choiseNumber to set
     */
    public void setChoiseNumber(String choiseNumber) {
        this.choiseNumber = choiseNumber;
    }
    
}
