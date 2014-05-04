/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Exceptions;

import MultilanguageLabels.ErrorLabels;

/**
 *
 * @author Alessio
 */
public class CategoriaGiaAssegnataException extends Exception {
    
    public CategoriaGiaAssegnataException() {
        super(ErrorLabels.CATEGORY_ALREADY_ASSIGNED_ITA);
    } 
            
}
