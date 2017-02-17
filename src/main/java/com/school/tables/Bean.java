/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.school.tables;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.event.AjaxBehaviorEvent;

/**
 *
 * @author Salah Atwa
 */
@ManagedBean
@SessionScoped
public class Bean implements Serializable{
    private List<Field> m_lFields;

    public Bean()
    {
        m_lFields = new ArrayList();

        m_lFields.add(new Field());
    }

    public void setFields(List<Field> p_lFields)
    {
        m_lFields = p_lFields;
    }

    public List<Field> getFields()
    {
        return m_lFields;
    }

    public void onButtonRemoveFieldClick(final Field p_oField)
    {
        m_lFields.remove(p_oField);
    }

    public void onButtonAddFieldClick()
    {
        m_lFields.add(new Field());
    }
}