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
import org.apache.commons.lang.StringUtils;

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
        if (username == null) {
            throw new VincoliInputException(ErrorLabels.USER_NOT_SPECIFICIED_ITA);
        }

        if (!(username.length() >= 4 && username.length() <= 20)) {
            throw new VincoliInputException(ErrorLabels.USER_LENGTH_ERROR_ITA);
        }
        if (!StringUtils.isAlphanumeric(username)) {
            throw new VincoliInputException(ErrorLabels.USER_IS_NOT_ALPHANUMERIC_ITA);
        }
    }

    private static void checkPassword(String password) throws VincoliInputException {
        if (password == null) {
            throw new VincoliInputException(ErrorLabels.PASSWORD_NOT_SPECIFIED_ITA);
        }
        if (!(password.length() >= 8 && password.length() <= 20)) {
            throw new VincoliInputException(ErrorLabels.PASSWORD_LENGTH_ERROR_ITA);
        }
        if (!StringUtils.isAlphanumeric(password)) {
            throw new VincoliInputException(ErrorLabels.PASSWORD_IS_NOT_ALPHANUMERIC_ITA);
        }
    }

    private static void checkNome(String nome) throws VincoliInputException {
        if (nome == null) {
            throw new VincoliInputException(ErrorLabels.NOME_NOT_SPECIFICIED_ITA);
        }
        if (!(nome.length() >= 1 && nome.length() <= 50)) {
            throw new VincoliInputException(ErrorLabels.NOME_LENGTH_ERROR_ITA);
        }
        if (!StringUtils.isAlphanumeric(nome)) {
            throw new VincoliInputException(ErrorLabels.NOME_IS_NOT_ALPHANUMERIC_ITA);
        }
    }

    private static void checkCognome(String cognome) throws VincoliInputException {
        if (cognome == null) {
            throw new VincoliInputException(ErrorLabels.COGNOME_NOT_SPECIFICIED_ITA);
        }
        if (!(cognome.length() >= 1 && cognome.length() <= 50)) {
            throw new VincoliInputException(ErrorLabels.COGNOME_LENGTH_ERROR_ITA);
        }
        if (!StringUtils.isAlphanumeric(cognome)) {
            throw new VincoliInputException(ErrorLabels.COGNOME_IS_NOT_ALPHANUMERIC_ITA);
        }
    }

    private static void checkEmail(String email) throws VincoliInputException {
        if (email == null) {
            throw new VincoliInputException(ErrorLabels.EMAIL_NOT_SPECIFICIED_ITA);
        }
        EmailValidator ev = new EmailValidator();
        if (!ev.validate(email)) {
            throw new VincoliInputException(ErrorLabels.EMAIL_NOT_VALID_ITA);
        }
    }

    private static void checkData(Date dataNascita) throws VincoliInputException {
        if (dataNascita == null) {
            throw new VincoliInputException(ErrorLabels.DATA_NOT_SPECIFICIED_ITA);
        }
         // TODO
        // Verifica del formato della data
    }
}
