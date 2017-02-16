/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.school.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author Salah Atwa
 */
@ManagedBean (name = "yearBean" ,eager = true)
@ApplicationScoped
public class YearBean implements Serializable{
    
    
    private List<String> year = new ArrayList<String>();


    @PostConstruct
    public void init()
    {
        
        for (int i = 2017; i > 1994; i--) {
            getYear().add(i+"");
        }
    }
    
    public YearBean() {
    }

    /**
     * @return the year
     */
    public List<String> getYear() {
        return year;
    }

    /**
     * @param year the year to set
     */
    public void setYear(List<String> year) {
        this.year = year;
    }
     
}
