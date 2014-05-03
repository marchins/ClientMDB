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
public enum Stato {
    LETTO("Letto"), 
    IN_LETTURA("In lettura"),
    NON_LETTO("Non letto"),
    ABBANDONATO("Abbandonato"); 
    
    private final String representation;

    Stato(String representation) {
        this.representation = representation;
    }


    public String getRepresentation() {
	return representation;
    }
	
    public static Stato fromString(String representation) {
	for (Stato s : Stato.values()) {
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
