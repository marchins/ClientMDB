/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GestoreAccountLocale;

import EmailValidator.EmailValidator;
import Exceptions.VincoliInputException;
import LogicaDominio.Account;
import MultilanguageLabels.ErrorLabels;
import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author Alessio
 */
public class GestoreAccountLocale {
    

    public static void registrazione(String username, String password, String nome, String cognome, String email, Date dataNascita) throws VincoliInputException {        
        checkUsername(username);
        checkPassword(password);
        checkNome(nome);
        checkCognome(cognome);
        checkEmail(email);
        checkData(dataNascita);
        
        /* 
           if(! GestoreAccountRemoto.verificaAccount(username,password,nome,cognome,email,dataNascita)) {
                throw new RegistrazioneException();
           }
        */
   
        System.out.println("Registrazione avvenuta con successo.");
    } 
    
    private static void memorizzaAccount(Account account) {
        EntityManagerFactory emf = javax.persistence.Persistence.createEntityManagerFactory("ClientMDBPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(account);
                em.getTransaction().commit();
        } catch (Exception e) {
        em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }
    
    public static void login(String username, String password) {
       // Account account = GestoreAccountRemoto.verificaDatiLogin(username,password);
       // this.memorizzaAccount(account); 
       Account account = new Account(); 
       account.setNome("Carco");
       account.setCognome("Monti");
       account.setUsername(username);
       account.setPassword(password);
       account.setEmail("carcomonti@gmail.com");
       account.setDataNascita("2009-10-20");
       memorizzaAccount(account);
       // this.sincronizzaDati(username,password);
    }
    
    
    
    private static void checkUsername(String username) throws VincoliInputException {
        if(username == null) {
            throw new VincoliInputException("Username non specificato.");
        }
        
        if(! (username.length()>=4 && username.length()<=20) ) {
            throw new VincoliInputException(ErrorLabels.USER_LENGTH_ERROR_ITA);
        }
        if(! StringUtils.isAlphanumeric(username)) {
            throw new VincoliInputException("Lo username deve essere una stringa alfanumerica");
        }
    }
    
    private static void checkPassword(String password) throws VincoliInputException {
        if(password == null) {
            throw new VincoliInputException("Password non specificata.");
        }
        if(! (password.length()>=8 && password.length()<=20) ) {
            throw new VincoliInputException("la password deve avere lunghezza compresa tra 8 e 20 caratteri alfanumerici");
        }
        if(! StringUtils.isAlphanumeric(password)) {
            throw new VincoliInputException("La password deve essere una stringa alfanumerica");
        }
    }
    
    private static void checkNome(String nome) throws VincoliInputException {
        if(nome == null) {
            throw new VincoliInputException("Nome non specificato.");
        }
        if(! (nome.length()>=1 && nome.length()<=50) ) {
            throw new VincoliInputException("il nome deve avere una lunghezza comprea tra 1 e 50 caratteri alfanumerici");
        }
        if(! StringUtils.isAlphanumeric(nome)) {
            throw new VincoliInputException("il nome deve essere una stringa alfanumerica");
        }
    }
    
    private static void checkCognome(String cognome) throws VincoliInputException {
        if(cognome == null) {
            throw new VincoliInputException("Cognome non specificato.");
        }
        if(! (cognome.length()>=1 && cognome.length()<=50) ) {
            throw new VincoliInputException("il cognome deve avere una lunghezza comprea tra 1 e 50 caratteri alfanumerici");
        }
        if(! StringUtils.isAlphanumeric(cognome)) {
            throw new VincoliInputException("il cognome deve essere una stringa alfanumerica");
        }
    }
    
    private static void checkEmail(String email)throws VincoliInputException {
        if(email == null) {
            throw new VincoliInputException("Indirizzo email non specificato.");
        }
        EmailValidator ev = new EmailValidator();
        if(!ev.validate(email)) {
            throw new VincoliInputException("Indirizzo Email non valido");
        }
    }
    
   
    private static void checkData(Date dataNascita)throws VincoliInputException {
        if(dataNascita == null) {
            throw new VincoliInputException("Data di nascita non specificata.");    
        }
         // TODO
         // Verifica del formato della data
    }
}
