/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Bootable;

import GestoreAccountLocale.GestoreAccountLocale;
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
        GestoreLibreriaLocale.creaCategoria("prova");
        GestoreLibreriaLocale.creaCategoria("prova2");
        GestoreLibreriaLocale.creaCategoria("categori palle di neve abbondanti");
        List<Categoria> categorie = GestoreLibreriaLocale.visualizzaElencoCategorie();
        for (Categoria categoria : categorie) {
            System.out.println(categoria.getNome());
        }
        //GestoreAccountLocale.login("hodor","hodorpass");
    }
    
}
