/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.school.dao;

import com.school.db.school.Stage;
import java.util.List;

/**
 *
 * @author Salah Atwa
 */
public interface StageDAO {
    
    public List<Stage> getAllStages();
    
    public void insertStage(Stage stage);
    
    public void deleteStage(Stage stage);
    
    public void updateStage(Stage stage);
    
}
