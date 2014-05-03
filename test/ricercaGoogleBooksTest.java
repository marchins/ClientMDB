/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import GestoreGoogleBooks.GestoreGoogleBooks;
import java.io.IOException;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Alessio
 */
public class ricercaGoogleBooksTest {
    
    @Test
    public void test1() throws IOException {
        GestoreGoogleBooks.ricercaPerISBN("9788858501122");
    }
    
}
