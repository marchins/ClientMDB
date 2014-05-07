/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bootable;

import GestoreLibreriaLocale.GestoreLibreriaLocale;
import LogicaDominio.Categoria;
import java.util.List;

/**
 *
 * @author Blanco
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //GestoreAccountLocale.login("hodor","hodorpass");
        //GestoreLibreriaLocale.creaCategoria("prova");
        //GestoreLibreriaLocale.creaCategoria("prova2");
        //GestoreLibreriaLocale.creaCategoria("categori palle di neve abbondanti");

        List<Categoria> categorie = GestoreLibreriaLocale.visualizzaElencoCategorie();
        for (Categoria categoria : categorie) {
            System.out.println(categoria.getNome());
        }
        Categoria categoriaDaEliminare = categorie.get(0);
        GestoreLibreriaLocale.rimuoviCategoria(categoriaDaEliminare);
        System.out.println("NUOVE CATEGORIE");
        List<Categoria> categorie2 = GestoreLibreriaLocale.visualizzaElencoCategorie();
        for (Categoria categoria : categorie2) {
            System.out.println(categoria.getNome());
        }

    }
}
