/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Exceptions.CategoriaGiaEsistenteException;
import GestoreAccountLocale.GestoreAccountLocale;
import GestoreLibreriaLocale.GestoreLibreriaLocale;
import LogicaDominio.Categoria;
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
public class creaCategoriaTest {
    public static EntityManagerFactory emf;
    public static EntityManager em;
    
    @BeforeClass
    public static void setUpClass() {
        emf = javax.persistence.Persistence.createEntityManagerFactory("ClientMDBPU");
        em = emf.createEntityManager();
        GestoreAccountLocale.login("test", "test");
    }
    /*
    @Test
    public void test1() throws CategoriaGiaEsistenteException {
        GestoreLibreriaLocale.creaCategoria("categoria1");
        List<Categoria> result = em.createQuery("SELECT c FROM Categoria c",Categoria.class).getResultList();
        assertEquals(1, result.size());
        assertEquals("categoria1", result.get(0).getNome());
    }
    */
    @Test
    public void test2() throws CategoriaGiaEsistenteException {
        GestoreLibreriaLocale.creaCategoria("categoria2");
        GestoreLibreriaLocale.creaCategoria("categoria3");
        GestoreLibreriaLocale.creaCategoria("categoria4");
        List<Categoria> result = em.createQuery("SELECT c FROM Categoria c",Categoria.class).getResultList();
        assertEquals(3, result.size());
    }
    /*
    @Test(expected=CategoriaGiaEsistenteException.class)
    public void test3() throws CategoriaGiaEsistenteException {
        GestoreLibreriaLocale.creaCategoria("categoria5");
        GestoreLibreriaLocale.creaCategoria("categoria5");
    }
    
    @After
    public void tearDownTest() {
        em.getTransaction().begin();
        em.createQuery("DELETE FROM Categoria c").executeUpdate();
        em.getTransaction().commit();
    }
    
    @AfterClass
    public static void tearDownClass() {
        em.getTransaction().begin();
        em.createQuery("DELETE FROM Account a").executeUpdate();
        em.getTransaction().commit();
        em.close();
    }
    */
    
}
