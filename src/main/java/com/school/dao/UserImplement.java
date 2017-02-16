/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.school.dao;

import com.school.db.setting.HibernateDriver;
import com.school.db.user.Stuff;
import java.io.Serializable;
import java.util.List;
import org.hibernate.SQLQuery;

/**
 *
 * @author Salah Atwa
 */
public class UserImplement implements UserDAO, Serializable {

    private final HibernateDriver hibernateDriver=HibernateDriver.getInstance();
    
    @Override
    public List<Stuff> getAllUsers() {
        return null;
    }

    @Override
    public void deleteUser(Stuff user) {

    }

    @Override
    public Stuff getUser(String userEmail, String userPassword) {
        Stuff user = null;
        try {
            hibernateDriver.openSession();

            String getUserSql="Select u.ID , u.USER_TYPE ,u.JOIN_DATE,u.FAMILY_INFO_ID,u.PERSONAL_INFO_ID,u.CLASS_ID,u.STAGE_ID from USERS u INNER JOIN PERSONAL_INFO p ON p.EMAIL= :userEmail and p.PASSWORD= :userPassword";
            SQLQuery query=hibernateDriver.getSession().createSQLQuery(getUserSql);
            query.addEntity(Stuff.class);
            query.setParameter("userEmail", userEmail);
            query.setParameter("userPassword", userPassword);
            user=(Stuff) query.uniqueResult();
            
            
            hibernateDriver.closeSession();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return user;
    }

    @Override
    public void updateUser(Stuff user) {
        hibernateDriver.getSession().saveOrUpdate(user);
    }

   

   

}
