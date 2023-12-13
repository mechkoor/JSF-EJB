/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entities.Machine;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author ayoub mechkour
 */
@Stateless
public class MachineFacade extends AbstractFacade<Machine> {
    @PersistenceContext(unitName = "controlJsfPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MachineFacade() {
        super(Machine.class);
    }
    
    public List<Object[]> getnbrMachineParYear() {
        String jpqlQuery = "SELECT FUNCTION('YEAR', m.dateAchat), COUNT(m) FROM Machine m GROUP BY FUNCTION('YEAR', m.dateAchat)";
         Query query = getEntityManager().createQuery(jpqlQuery);
        return query.getResultList();
    }
    
}
