/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GestoreLibreriaLocale;

import Exceptions.CategoriaGiaEsistenteException;
import LogicaDominio.Account;
import LogicaDominio.Categoria;
import LogicaDominio.CopiaUtente;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Blanco
 */
public class GestoreLibreriaLocale {
    
    public static void creaCategoria(String nome) throws CategoriaGiaEsistenteException {
        EntityManagerFactory emf = javax.persistence.Persistence.createEntityManagerFactory("ClientMDBPU");
        EntityManager em = emf.createEntityManager();
        
        List<Categoria> result = em.createQuery("SELECT c FROM Categoria c WHERE c.nome = '" + nome +"'", Categoria.class).getResultList();

        if(result.size()>0) {
           throw new CategoriaGiaEsistenteException(); 
        } else {
            Account account = em.createQuery("SELECT c FROM Account c", Account.class).getSingleResult();
            Categoria categoria = new Categoria();
            categoria.setNome(nome);
            categoria.setAccount(account);
            em.getTransaction().begin();
            em.persist(categoria);
            em.getTransaction().commit();
            //GestoreLibreriaRemoto.creaCategoria(Categoria, autenticazione)
            em.close();
        }  
    }
    
    public static void rimuoviCategoria(Categoria categoria) {
        EntityManagerFactory emf = javax.persistence.Persistence.createEntityManagerFactory("ClientMDBPU");
        EntityManager em = emf.createEntityManager();
        Categoria categoriaDaRimuovere = em.merge(categoria);
        em.remove(categoriaDaRimuovere);
        em.getTransaction().begin();
        em.getTransaction().commit();
        em.close();
        //GestoreLibreriaRemoto.rimuoviCategoria(Categoria, autenticazione)
    }
    
    public static List<Categoria> visualizzaElencoCategorie() {
        EntityManagerFactory emf = javax.persistence.Persistence.createEntityManagerFactory("ClientMDBPU");
        EntityManager em = emf.createEntityManager();
        List<Categoria> result = em.createQuery("SELECT c FROM Categoria c ", Categoria.class).getResultList();
        return result;
    }
    
    public static List<CopiaUtente> visualizzaContenutoCategoria(Categoria categoria) {
        EntityManagerFactory emf = javax.persistence.Persistence.createEntityManagerFactory("ClientMDBPU");
        EntityManager em = emf.createEntityManager();
        List<CopiaUtente> result;
        result = em.createQuery("SELECT c.copieLibriAssociate FROM Categoria c WHERE c.nome = '" + categoria.getNome() +"'",CopiaUtente.class).getResultList();
        return result;
    }
    
    public static void assegnaCategoriaACopia(CopiaUtente libro, Categoria categoria) {
        libro.getCategorieAssegnate().add(categoria);
        EntityManagerFactory emf = javax.persistence.Persistence.createEntityManagerFactory("ClientMDBPU");
        EntityManager em = emf.createEntityManager();
        CopiaUtente copiaAttached= em.merge(libro);
        em.remove(copiaAttached);
        em.getTransaction().begin();
        em.getTransaction().commit();
        em.close();
        
    }
    

}
