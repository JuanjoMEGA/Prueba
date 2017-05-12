/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JPA.controles;

import JPA.clases.Smartphones;
import JPA.clases.exceptions.NonexistentEntityException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author jjmelgar
 */
public class SmartphonesJpaController implements Serializable {

    public SmartphonesJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Smartphones smartphones) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(smartphones);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Smartphones smartphones) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            smartphones = em.merge(smartphones);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = smartphones.getId();
                if (findSmartphones(id) == null) {
                    throw new NonexistentEntityException("The smartphones with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Smartphones smartphones;
            try {
                smartphones = em.getReference(Smartphones.class, id);
                smartphones.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The smartphones with id " + id + " no longer exists.", enfe);
            }
            em.remove(smartphones);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Smartphones> findSmartphonesEntities() {
        return findSmartphonesEntities(true, -1, -1);
    }

    public List<Smartphones> findSmartphonesEntities(int maxResults, int firstResult) {
        return findSmartphonesEntities(false, maxResults, firstResult);
    }

    private List<Smartphones> findSmartphonesEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Smartphones.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Smartphones findSmartphones(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Smartphones.class, id);
        } finally {
            em.close();
        }
    }

    public int getSmartphonesCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Smartphones> rt = cq.from(Smartphones.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
