
import Exceptions.VincoliInputException;
import GestoreAccountLocale.GestoreAccountLocale;
import MultilanguageLabels.ErrorLabels;
import java.util.Date;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Blanco
 */
public class registrazioneTest {
    @Rule
    public ExpectedException exception = ExpectedException.none();
  
    @Test
    public void test1() throws VincoliInputException{
        exception.expect(VincoliInputException.class);
        exception.expectMessage(ErrorLabels.USER_NOT_SPECIFICIED_ITA);
        GestoreAccountLocale.registrazione(null, "password", "nome", "cognome", "email", new Date());
    }
    
    @Test
    public void test2() throws VincoliInputException{
        exception.expect(VincoliInputException.class);
        exception.expectMessage(ErrorLabels.USER_LENGTH_ERROR_ITA);
        GestoreAccountLocale.registrazione("pr", "password", "nome", "cognome", "email", new Date());
    }
    
    @Test
    public void test3() throws VincoliInputException{
        exception.expect(VincoliInputException.class);
        exception.expectMessage(ErrorLabels.USER_LENGTH_ERROR_ITA);
        GestoreAccountLocale.registrazione("provaprovaprovaprovaprovaprovaprovaprovaprova", "password", "nome", "cognome", "email", new Date());
    }
    
    @Test
    public void test4() throws VincoliInputException{
        exception.expect(VincoliInputException.class);
        exception.expectMessage(ErrorLabels.USER_IS_NOT_ALPHANUMERIC_ITA);
        GestoreAccountLocale.registrazione("?prova!", "password", "nome", "cognome", "email", new Date());
    }
    
    @Test
    public void test5() throws VincoliInputException{
        exception.expect(VincoliInputException.class);
        exception.expectMessage(ErrorLabels.PASSWORD_NOT_SPECIFIED_ITA);
        GestoreAccountLocale.registrazione("prova", null, "nome", "cognome", "email", new Date());
    }
    
    @Test
    public void test6() throws VincoliInputException{
        exception.expect(VincoliInputException.class);
        exception.expectMessage(ErrorLabels.PASSWORD_LENGTH_ERROR_ITA);
        GestoreAccountLocale.registrazione("prova", "pass", "nome", "cognome", "email", new Date());
    }
    
    @Test
    public void test7() throws VincoliInputException{
        exception.expect(VincoliInputException.class);
        exception.expectMessage(ErrorLabels.PASSWORD_LENGTH_ERROR_ITA);
        GestoreAccountLocale.registrazione("prova", "passpasspasspasspasspasspasspasspass", "nome", "cognome", "email", new Date());
    }
}
