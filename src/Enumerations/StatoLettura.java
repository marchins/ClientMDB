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
public enum StatoLettura {

    LETTO("Letto"),
    IN_LETTURA("In lettura"),
    NON_LETTO("Non letto"),
    ABBANDONATO("Abbandonato"),
    NON_SPECIFICATO("Non specificato");

    private final String representation;

    StatoLettura(String representation) {
        this.representation = representation;
    }

    public String getRepresentation() {
        return representation;
    }

    public static StatoLettura fromString(String representation) {
        for (StatoLettura s : StatoLettura.values()) {
            if (s.getRepresentation().equals(representation)) {
                return s;
            }
        }
        throw new IllegalArgumentException("No value associated with given representation exists");
    }

    /**
     * Returns a string representing this constant.
     *
     * @return
     */
    @Override
    public String toString() {
        return this.getRepresentation();
    }

}
