/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GestoreLibreriaLocale;

import LogicaDominio.Account;
import LogicaDominio.Categoria;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Blanco
 */
public class GestoreLibreriaLocale {
    
    public static void creaCategoria(String nome) {
        EntityManagerFactory emf = javax.persistence.Persistence.createEntityManagerFactory("ClientMDBPU");
        EntityManager em = emf.createEntityManager();
        
        List<Categoria> result = em.createQuery("SELECT c FROM Categoria c WHERE c.nome = '" + nome +"'",Categoria.class).getResultList();

        if(result.size()>0) {
           System.out.println("Esiste già una categoria con questo nome"); 
        } else {
            Account account = em.createQuery("SELECT c FROM Account c",Account.class).getSingleResult();
            Categoria categoria = new Categoria();
            categoria.setNome(nome);
            categoria.setAccount(account);
            em.getTransaction().begin();
            try {
                em.persist(categoria);
                em.getTransaction().commit();
                //GestoreLibreriaRemoto.creaCategoria(Categoria, autenticazione)
            } catch (Exception e) {
            em.getTransaction().rollback();
            } finally {
                em.close();
            }
        }  
    }
    
    public static void rimuoviCategoria(Categoria categoria) {
        EntityManagerFactory emf = javax.persistence.Persistence.createEntityManagerFactory("ClientMDBPU");
        EntityManager em = emf.createEntityManager();
        em.remove(categoria);
        //GestoreLibreriaRemoto.rimuoviCategoria(Categoria, autenticazione)
    }
    
    public static List<Categoria> visualizzaElencoCategorie() {
        EntityManagerFactory emf = javax.persistence.Persistence.createEntityManagerFactory("ClientMDBPU");
        EntityManager em = emf.createEntityManager();
        List<Categoria> result = em.createQuery("SELECT c FROM Categoria c ",Categoria.class).getResultList();
        return result;
    }
    
    
    

}
