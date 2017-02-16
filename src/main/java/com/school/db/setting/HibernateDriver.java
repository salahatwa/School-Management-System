/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.school.db.setting;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author salah
 */

@ManagedBean(eager = true)
@ApplicationScoped
public class HibernateDriver {
    
    private Session session ;
    private Transaction transaction ;
    
    // Early intialization
    private static final HibernateDriver hibernateDriver=new HibernateDriver();
     
    public static HibernateDriver getInstance()
    {
        return hibernateDriver;
    }
    
    public void openSession()
    { 
        session=HibernateUtil.getSessionFactory().openSession();
        setTransaction(getSession().beginTransaction());
    }
    
    public void closeSession()
    {
        getTransaction().commit();
        getSession().close();
    }

    /**
     * @return the session
     */
    public  Session getSession() {
        return session;
    }

    /**
     * @param session the session to set
     */
    public void setSession(Session session) {
        this.session = session;
    }

    /**
     * @return the transaction
     */
    public Transaction getTransaction() {
        return transaction;
    }

    /**
     * @param transaction the transaction to set
     */
    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }
    
}
