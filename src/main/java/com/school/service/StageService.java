/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.school.service;

import com.school.db.school.Stage;
import com.school.dao.StageDAO;
import com.school.dao.StageImplement;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Salah Atwa
 */
@ManagedBean (name = "stageService" )
@SessionScoped
public class StageService implements Serializable{
    
    private StageDAO stageDAO;
    
    @ManagedProperty(value = "#{stage}")
    private Stage stage;

    public StageService() {
     stageDAO=new StageImplement();
    }
    
     public void addStage()
    { 
        getStageDAO().insertStage(getStage());
    }
     
     public void saveStage(Stage stage)
     {
        System.out.println("Stage ID:"+stage.getId()+"\t"+stage.getStageName());
        getStageDAO().updateStage(stage);
     }
     
     public void deleteStage(Stage stage)
     {
        getStageDAO().deleteStage(stage);
     }
    
    public List<Stage> getAllStages()
    {
      return  getStageDAO().getAllStages();
    }
    
   

    /**
     * @return the stageDAO
     */
    public StageDAO getStageDAO() {
        return stageDAO;
    }

    /**
     * @param stageDAO the stageDAO to set
     */
    public void setStageDAO(StageDAO stageDAO) {
        this.stageDAO = stageDAO;
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
        System.out.println("Selected stage:"+stage.getStageName()+"\t"+stage.getStageYear());
    }
    
}
