/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Enumerations;

/**
 *
 * @author Alessio
 */
public enum Formato {
    DIGITALE("Digitale"), 
    CARTACEO("Cartaceo"); 
    
    private final String representation;

    Formato(String representation) {
        this.representation = representation;
    }


    public String getRepresentation() {
	return representation;
    }
	
    public static Formato fromString(String representation) {
	for (Formato s : Formato.values()) {
		if (s.getRepresentation().equals(representation)) {
			return s;
		}
	}
	throw new IllegalArgumentException("No value associated with given representation exists");
    }
	
	/**
	 * Returns a string representing this constant.
     * @return 
	 */
    @Override
    public String toString() {
		return this.getRepresentation();
    }
    
}
