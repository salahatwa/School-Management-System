/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.school.dao;

import com.school.db.school.Stage;
import com.school.db.setting.HibernateDriver;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;

/**
 *
 * @author Salah Atwa
 */
public class StageImplement implements StageDAO{
    private final HibernateDriver hibernateDriver=HibernateDriver.getInstance();

    @Override
    public List<Stage> getAllStages() {
      List<Stage> stages=null;
      try
      {
          hibernateDriver.openSession();
           Criteria cr = hibernateDriver.getSession().createCriteria(Stage.class);
           stages=cr.list();
          hibernateDriver.closeSession();
      }
      catch(HibernateException ex){ex.printStackTrace();}
     return stages;
    }

    @Override
    public void insertStage(Stage stage) {
    
        try {
            hibernateDriver.openSession();
            hibernateDriver.getSession().save(stage);
            System.out.println("STAGE ADDED SUCCESSFULY");
            hibernateDriver.closeSession();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void deleteStage(Stage stage) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateStage(Stage stage) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
