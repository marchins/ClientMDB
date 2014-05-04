/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import GestoreAccountLocale.GestoreAccountLocale;
import GestoreLibreriaLocale.GestoreLibreriaLocale;
import LogicaDominio.CopiaUtente;
import LogicaDominio.Libro;
import java.io.IOException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;

/**
 *
 * @author Alessio
 */
public class aggiungiLibroTest {
    public static EntityManagerFactory emf;
    public static EntityManager em;
    
    @BeforeClass
    public static void setUpClass() {
        emf = javax.persistence.Persistence.createEntityManagerFactory("ClientMDBPU");
        em = emf.createEntityManager();
        GestoreAccountLocale.login("test", "test");
    }
    
    
    @Test
    public void test1() throws IOException {
        Libro libro = (GestoreLibreriaLocale.ricercaPerISBN("9788858501122")).get(0);
        GestoreLibreriaLocale.aggiungiLibro(libro);
        List<Libro> result = em.createQuery("SELECT l FROM Libro l", Libro.class).getResultList();
        assertEquals(1,result.size());            
        
        Libro libro2 = (GestoreLibreriaLocale.ricercaPerISBN("9788858501122")).get(0);
        GestoreLibreriaLocale.aggiungiLibro(libro2);
        List<CopiaUtente> result2 = em.createQuery("SELECT l FROM CopiaUtente l", CopiaUtente.class).getResultList();
        result = em.createQuery("SELECT l FROM Libro l", Libro.class).getResultList();
        assertEquals(1, result.size());
        assertEquals(2,result2.size());   
    }
    
    
    @Test
    public void test2() throws IOException {
        Libro libro = (GestoreLibreriaLocale.ricercaPerISBN("9788858501122")).get(0);
        GestoreLibreriaLocale.aggiungiLibro(libro);
        List<Libro> result = em.createQuery("SELECT l FROM Libro l", Libro.class).getResultList();
        assertEquals(1,result.size());            
        assertEquals("img/9788858501122.jpg",result.get(0).getCopertina());
    }
   
    
    @After
    public void tearDownTest() {
        em.getTransaction().begin();
        em.createQuery("DELETE FROM CopiaUtente cu").executeUpdate();
        em.createQuery("DELETE FROM Libro l").executeUpdate();
        em.getTransaction().commit();
    }
    
    @AfterClass
    public static void tearDownClass() {
        em.getTransaction().begin();
        em.createQuery("DELETE FROM Account a").executeUpdate();
        em.getTransaction().commit();
        em.close();
    }
    
}
