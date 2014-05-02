/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GestoreLibreriaLocale;

import LogicaDominio.Categoria;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Blanco
 */
public class GestoreLibreriaLocale {
    
    public static void creaCategoria(String nome) {
        Categoria categoria = new Categoria();
        categoria.setNome(nome);
        EntityManagerFactory emf = 
                javax.persistence.Persistence.createEntityManagerFactory("ClientMDBPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(categoria);
                em.getTransaction().commit();
        } catch (Exception e) {
        em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

}
