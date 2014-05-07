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
public class RegistrazioneException extends Exception {

    public RegistrazioneException() {
        super(ErrorLabels.REGISTRATION_ERROR_ITA);
    }

}
