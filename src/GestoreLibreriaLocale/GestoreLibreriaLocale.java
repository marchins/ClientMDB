/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GestoreLibreriaLocale;

import Enumerations.Formato;
import Exceptions.CategoriaGiaEsistenteException;
import Exceptions.CategoriaGiaAssegnataException;
import GestoreGoogleBooks.GestoreGoogleBooks;
import LogicaDominio.Account;
import LogicaDominio.Categoria;
import LogicaDominio.CopiaUtente;
import LogicaDominio.Libro;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Blanco
 */
public class GestoreLibreriaLocale {

    public static List<Libro> ricercaPerTitolo(String titolo) throws MalformedURLException, IOException {
        return GestoreGoogleBooks.ricercaLibroTramiteParametro(titolo, GestoreGoogleBooks.TITOLO);

    }

    public static List<Libro> ricercaPerAutore(String autore) throws MalformedURLException, IOException {
        return GestoreGoogleBooks.ricercaLibroTramiteParametro(autore, GestoreGoogleBooks.AUTORE);

    }

    public static List<Libro> ricercaPerISBN(String isbn) throws MalformedURLException, IOException {
        return GestoreGoogleBooks.ricercaLibroTramiteParametro(isbn, GestoreGoogleBooks.ISBN);

    }

    public static void aggiungiLibro(Libro libro) {
        EntityManagerFactory emf = javax.persistence.Persistence.createEntityManagerFactory("ClientMDBPU");
        EntityManager em = emf.createEntityManager();
        List<Libro> result = em.createQuery("SELECT l FROM Libro l WHERE l.isbn = '" + libro.getIsbn() + "'", Libro.class).getResultList();
        Account account = em.createQuery("SELECT a FROM Account a", Account.class).getSingleResult();

        CopiaUtente copiaUtente = new CopiaUtente();
        copiaUtente.setLibro(libro);
        copiaUtente.setFormato(Formato.CARTACEO);
        copiaUtente.setAccount(account);
        em.getTransaction().begin();
        if (result.size() > 0) {
            List<Libro> copie = em.createQuery("SELECT l.copieUtente FROM Libro l WHERE l.isbn = '" + libro.getIsbn() + "'", Libro.class).getResultList();
            copiaUtente.setNumeroCopia(copie.size() + 1);
            //TODO setCopertinaLocale
        } else {
            copiaUtente.setNumeroCopia(1);
            em.persist(libro);
        }
        em.persist(copiaUtente);
        em.getTransaction().commit();
        em.close();
        //GestoreLibreriaRemoto.aggiungiLibro(libro,copiaUtente, autenticazione)
    }

    public static void creaCategoria(String nome) throws CategoriaGiaEsistenteException {
        EntityManagerFactory emf = javax.persistence.Persistence.createEntityManagerFactory("ClientMDBPU");
        EntityManager em = emf.createEntityManager();

        List<Categoria> result = em.createQuery("SELECT c FROM Categoria c WHERE c.nome = '" + nome + "'", Categoria.class).getResultList();

        if (result.size() > 0) {
            throw new CategoriaGiaEsistenteException();
        } else {
            Account account = em.createQuery("SELECT c FROM Account c", Account.class).getSingleResult();
            Categoria categoria = new Categoria();
            categoria.setNome(nome);
            categoria.setAccount(account);
            em.getTransaction().begin();
            //System.out.println("pippo" + categoria);
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
        result = em.createQuery("SELECT c.copieLibriAssociate FROM Categoria c WHERE c.nome = '" + categoria.getNome() + "'", CopiaUtente.class).getResultList();
        return result;
    }

    public static void assegnaCategoriaACopia(CopiaUtente copia, Categoria categoria) throws CategoriaGiaAssegnataException {
        if (!copia.getCategorieAssegnate().contains(categoria)) {
            EntityManagerFactory emf = javax.persistence.Persistence.createEntityManagerFactory("ClientMDBPU");
            EntityManager em = emf.createEntityManager();
            copia.getCategorieAssegnate().add(categoria);
            categoria.getCopieLibriAssociate().add(copia);
            em.getTransaction().begin();
            em.merge(copia);
            em.merge(categoria);
            em.getTransaction().commit();
            em.close();
        } else {
            throw new CategoriaGiaAssegnataException();
        }
    }

}
