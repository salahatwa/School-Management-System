/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.school.db.user;

import com.school.db.exam.Answers;
import com.school.db.school.Classes;
import com.school.db.school.Stage;
import com.school.db.school.Subject;
import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Salah Atwa
 */
@Entity
@DiscriminatorValue(value = "Student")
public class Student extends Stuff implements Serializable{

    @ManyToOne(fetch = FetchType.LAZY,targetEntity = Classes.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "class_id")
    private Classes classNum;

    // Student Many-to-one with Stage class 
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Stage.class ,cascade = CascadeType.ALL)
    @JoinColumn(name = "stage_id")
    private Stage stage;

    // Student has Many-to-Many relation with Subject Class
    @ManyToMany(fetch = FetchType.LAZY,targetEntity = Subject.class,cascade = {CascadeType.ALL})
    @JoinTable(name = "student_subject",
            joinColumns = {@JoinColumn(name = "student_id")},
            inverseJoinColumns = {@JoinColumn(name = "subject_id")})
    private Set<Subject> subjects;

    // one student can answer to many questions
    @OneToMany(fetch = FetchType.LAZY,targetEntity = Answers.class, cascade = {CascadeType.ALL})
    @JoinColumn(name = "student_id", nullable = false)
    private Set<Answers> answerses;
    
    
    @OneToMany(fetch = FetchType.LAZY,targetEntity = StudentNotes.class, cascade ={CascadeType.ALL})
    @JoinColumn(name = "student_id")
    private Set<StudentNotes> notes;

   

    public Student() {
        this.notes = new LinkedHashSet<StudentNotes>();
        this.answerses = new LinkedHashSet<Answers>();
        this.subjects = new LinkedHashSet<Subject>();
    }
    
    
    
    
    
    /**
     * @return the classNum
     */
    public Classes getClassNum() {
        return classNum;
    }

    /**
     * @param classNum the classNum to set
     */
    public void setClassNum(Classes classNum) {
        this.classNum = classNum;
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
     * @return the subjects
     */
    public Set<Subject> getSubjects() {
        return subjects;
    }

    /**
     * @param subjects the subjects to set
     */
    public void setSubjects(Set<Subject> subjects) {
        this.subjects = subjects;
    }

    /**
     * @return the answerses
     */
    public Set<Answers> getAnswerses() {
        return answerses;
    }

    /**
     * @param answerses the answerses to set
     */
    public void setAnswerses(Set<Answers> answerses) {
        this.answerses = answerses;
    }

    /**
     * @return the notes
     */
    public Set<StudentNotes> getNotes() {
        return notes;
    }

    /**
     * @param notes the notes to set
     */
    public void setNotes(Set<StudentNotes> notes) {
        this.notes = notes;
    }

   

   

   

   

}
