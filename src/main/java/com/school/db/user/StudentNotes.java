/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.school.db.user;

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
@Table(name = "STUDENT_NOTES")
public class StudentNotes implements Serializable{
    
    @Id  
    @GeneratedValue(strategy=GenerationType.AUTO) 
    @Column(name = "id" , nullable = false) 
    private long id;
    
    @Column(name = "note_text")
    private String noteText;
    
    @Column(name = "note_type")
    private String noteType;

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
     * @return the noteText
     */
    public String getNoteText() {
        return noteText;
    }

    /**
     * @param noteText the noteText to set
     */
    public void setNoteText(String noteText) {
        this.noteText = noteText;
    }

    /**
     * @return the noteType
     */
    public String getNoteType() {
        return noteType;
    }

    /**
     * @param noteType the noteType to set
     */
    public void setNoteType(String noteType) {
        this.noteType = noteType;
    }
}
