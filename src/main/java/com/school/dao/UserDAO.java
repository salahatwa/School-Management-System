/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.school.dao;

import com.school.db.user.Stuff;
import java.util.List;

/**
 * THIS class contain all methods that we need to perform on database
 * @author Salah Atwa
 */

public interface UserDAO {
    
    public List<Stuff> getAllUsers();
    
    public void deleteUser(Stuff user);
    
    public Stuff getUser(String userEmail,String userPassword);
    
    public void updateUser(Stuff user);
    
    
}
