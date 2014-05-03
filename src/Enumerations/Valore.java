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
public enum Valore {
    UNO("Uno"), 
    DUE("Due"),
    TRE("Tre"),
    QUATTRO("Quattro"),
    CINQUE("Cinque"),
    NON_VALUTATO("Non valutato"); 
    
    private final String representation;

    Valore(String representation) {
        this.representation = representation;
    }


    public String getRepresentation() {
	return representation;
    }
	
    public static Valore fromString(String representation) {
	for (Valore s : Valore.values()) {
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
