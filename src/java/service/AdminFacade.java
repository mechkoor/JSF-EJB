/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entities.Admin;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author ayoub mechkour
 */
@Stateless
public class AdminFacade extends AbstractFacade<Admin> {
    @PersistenceContext(unitName = "controlJsfPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AdminFacade() {
        super(Admin.class);
    }

      public Admin findUserByUsernameAndPassword(String username, String password) {
        try {
            Query query = em.createQuery("SELECT a FROM Admin a WHERE a.username = :username AND a.password = :password");
            query.setParameter("username", username);
            query.setParameter("password", password);
            return (Admin) query.getSingleResult();
        } catch (NoResultException e) {
            return null; // Aucun utilisateur trouvé
        }
    }
    
}
