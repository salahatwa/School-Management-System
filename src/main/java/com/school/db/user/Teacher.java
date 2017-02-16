/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.school.db.user;

import com.school.db.exam.Exam;
import com.school.db.school.Classes;
import com.school.db.school.Stage;
import com.school.db.school.Subject;
import java.util.LinkedHashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Salah Atwa
 */

@Entity  
@DiscriminatorValue(value = "Teacher")
public class Teacher extends Stuff{
    
    // Many-to-many
    @ManyToMany(fetch = FetchType.LAZY,targetEntity = Classes.class,cascade = {CascadeType.ALL})
    @JoinTable(name = "teachers_classes",
            joinColumns = {@JoinColumn(name = "teacher_id")},
            inverseJoinColumns = {@JoinColumn(name = "class_id")})
    private Set<Classes> classes=new LinkedHashSet<Classes>();
    
    // Teacher many-to-many relation with Stage
    @ManyToMany(fetch = FetchType.LAZY,targetEntity = Stage.class,cascade = {CascadeType.ALL})
    @JoinTable(name = "teachers_stages",
            joinColumns = {@JoinColumn(name = "teacher_id")},
            inverseJoinColumns = {@JoinColumn(name = "stage_id")})
    private Set<Stage> stages=new LinkedHashSet<Stage>();
    
    // Teacher has Many-to-Many relation with Subject Class
    @ManyToMany(fetch = FetchType.LAZY,targetEntity = Subject.class,cascade = {CascadeType.ALL})
    @JoinTable(name = "teachers_subjects",
            joinColumns = {@JoinColumn(name = "teacher_id")},
            inverseJoinColumns = {@JoinColumn(name = "subject_id")})
    private Set<Subject> subjects=new LinkedHashSet<Subject>();
    
    @OneToMany(fetch = FetchType.LAZY,targetEntity = Exam.class,cascade = {CascadeType.ALL})
    @JoinColumn(name = "teacher_id")
    private Set<Exam> exams=new LinkedHashSet<Exam>();
    
    //Teacher can put many notes to student
    @OneToMany(fetch = FetchType.EAGER,targetEntity = StudentNotes.class, cascade = {CascadeType.ALL})
    @JoinColumn(name = "teacher_id")
    private Set<StudentNotes> noteses=new LinkedHashSet<StudentNotes>();

   

    public Teacher() {
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
     * @return the stages
     */
    public Set<Stage> getStages() {
        return stages;
    }

    /**
     * @param stages the stages to set
     */
    public void setStages(Set<Stage> stages) {
        this.stages = stages;
    }

    /**
     * @return the classes
     */
    public Set<Classes> getClasses() {
        return classes;
    }

    /**
     * @param classes the classes to set
     */
    public void setClasses(Set<Classes> classes) {
        this.classes = classes;
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

    /**
     * @return the noteses
     */
    public Set<StudentNotes> getNoteses() {
        return noteses;
    }

    /**
     * @param noteses the noteses to set
     */
    public void setNoteses(Set<StudentNotes> noteses) {
        this.noteses = noteses;
    }

 
    
}
