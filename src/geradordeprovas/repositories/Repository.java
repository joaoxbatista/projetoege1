/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geradordeprovas.repositories;

import geradordeprovas.util.HibernateUtil;
import java.io.Serializable;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


public abstract class Repository{
    SessionFactory factory;
    Session session;
    Transaction transaction;
    
    public Repository(){
        this.factory = HibernateUtil.getSessionFactory();
    }
    
    
}
