/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Exceptions;

import MultilanguageLabels.ErrorLabels;

/**
 *
 * @author Blanco
 */
public class CategoriaGiaEsistenteException extends Exception {
    public CategoriaGiaEsistenteException() {
        super(ErrorLabels.CATEGORY_ALREADY_EXISTS_ITA);
    }
}
