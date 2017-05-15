/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package respaldo;

import JPA.clases.Smartphone;
import JPA.controles.SmartphonesJpaController;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 *
 * @author jjmelgar
 */
@ManagedBean
@RequestScoped
public class b_smartphone {

    private Integer id;
    private int sid;
    private SmartphonesJpaController jcsmarthphone;
    private EntityManagerFactory emf;
    
    public b_smartphone() {
       emf = Persistence.createEntityManagerFactory("YouPhonePU");
    }

    public b_smartphone(Integer id, int sid) {
        this.id = id;
        this.sid = sid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public SmartphonesJpaController getJcsmarthphone() {
        return jcsmarthphone;
    }

    public void setJcsmarthphone(SmartphonesJpaController jcsmarthphone) {
        this.jcsmarthphone = jcsmarthphone;
    }

    public EntityManagerFactory getEmf() {
        return emf;
    }

    public void setEmf(EntityManagerFactory emf) {
        this.emf = emf;
    }
     
    public List cogerMoviles(){
        jcsmarthphone = new SmartphonesJpaController(emf);
        List lista = jcsmarthphone.findSmartphonesEntities();
        
        return lista;
    }
    
    
    
}
