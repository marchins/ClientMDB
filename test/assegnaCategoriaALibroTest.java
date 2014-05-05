/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Exceptions.CategoriaGiaAssegnataException;
import Exceptions.CategoriaGiaEsistenteException;
import GestoreAccountLocale.GestoreAccountLocale;
import GestoreLibreriaLocale.GestoreLibreriaLocale;
import LogicaDominio.Categoria;
import LogicaDominio.CopiaUtente;
import LogicaDominio.Libro;
import java.io.IOException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Blanco
 */
public class assegnaCategoriaALibroTest {
    
    public static EntityManagerFactory emf;
    public static EntityManager em;
    
    @BeforeClass
    public static void setUpClass() {
        emf = javax.persistence.Persistence.createEntityManagerFactory("ClientMDBPU");
        em = emf.createEntityManager();
        GestoreAccountLocale.login("test", "test");
    }
    
    @Test
    public void test1() throws CategoriaGiaEsistenteException, IOException, CategoriaGiaAssegnataException {
        String nome = "categoria1";
        GestoreLibreriaLocale.creaCategoria(nome);
        List<Libro> risultati = GestoreLibreriaLocale.ricercaPerISBN("9788858501122");
        assertEquals(1,risultati.size());
        GestoreLibreriaLocale.aggiungiLibro(risultati.get(0));
        
        Categoria categoria = em.createQuery("SELECT c FROM Categoria c WHERE c.nome = '" + nome +"'", Categoria.class).getSingleResult();
        CopiaUtente copiaUtente = em.createQuery("SELECT c FROM CopiaUtente c WHERE c.libro.isbn = '" + risultati.get(0).getIsbn() +"'", CopiaUtente.class).getSingleResult();
        System.out.println(copiaUtente.getLibro().getIsbn());
        System.out.println(categoria.getNome());
        GestoreLibreriaLocale.assegnaCategoriaACopia(copiaUtente,categoria);
    }
    
    
    @After
    public void tearDownTest() {
        em.getTransaction().begin();
        List<Categoria> result = em.createQuery("SELECT c FROM Categoria c", Categoria.class).getResultList();
        for(Categoria cat : result){
            GestoreLibreriaLocale.rimuoviCategoria(cat);
        }
        /*em.createQuery("DELETE FROM Categoria cat").executeUpdate();
        em.createQuery("DELETE FROM CopiaUtente c").executeUpdate();
        em.createQuery("DELETE FROM Account a").executeUpdate();
        em.createQuery("DELETE FROM Libro l").executeUpdate();*/
        
        em.getTransaction().commit();
    }
    
    /*
    @AfterClass
    public static void tearDownClass() {
        em.getTransaction().begin();
        em.createQuery("DELETE FROM Account a").executeUpdate();
        em.getTransaction().commit();
        em.close();
    }
    */
}
