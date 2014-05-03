/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import GestoreLibreriaLocale.GestoreLibreriaLocale;
import LogicaDominio.Libro;
import java.io.IOException;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Alessio
 */
public class ricercaGoogleBooksTest {
    
    @Test
    public void test1() throws IOException {
        List<Libro> risultati = GestoreLibreriaLocale.ricercaPerISBN("9788858501122");
        assertEquals(1,risultati.size());
        assertEquals("Dennis Lehane",risultati.get(0).getAutore());
        assertEquals("9788858501122",risultati.get(0).getIsbn());
    }
    
}
