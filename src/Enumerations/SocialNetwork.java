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
public enum SocialNetwork {

    FACEBOOK("Facebook"),
    GOOGLE_PLUS("Google Plus"),
    TWITTER("Twitter");

    private final String representation;

    SocialNetwork(String representation) {
        this.representation = representation;
    }

    public String getRepresentation() {
        return representation;
    }

    public static SocialNetwork fromString(String representation) {
        for (SocialNetwork s : SocialNetwork.values()) {
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
