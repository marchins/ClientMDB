/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Exceptions.CategoriaGiaEsistenteException;
import GestoreAccountLocale.GestoreAccountLocale;
import GestoreLibreriaLocale.GestoreLibreriaLocale;
import LogicaDominio.Categoria;
import LogicaDominio.CopiaUtente;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
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
    public void test1() throws CategoriaGiaEsistenteException {
        GestoreLibreriaLocale.creaCategoria("categoria1");
        CopiaUtente libro = new CopiaUtente();
        
    }
}
