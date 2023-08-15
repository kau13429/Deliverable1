/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Add your name as an author and the date!
 */
package ca.sheridancollege.project;

/**
 * A class to be used as the base Card class for the project. Must be general enough to be instantiated for any Card
 * game. Students wishing to add to the code should remember to add themselves as a modifier.
 *
 * @author dancye
 * @modifier Khushpreet Kaur, Student Id: 991685679, Date: 14 August 2023
 */

public abstract class Card {
    private final String value;  // The value of the card (e.g., "A", "2", "King", "Diamond")
    private boolean flipped;     // Flag to track if the card is flipped or face-down

    /**
     * Constructor to initialize the Card with a value.
     * By default, the card is not flipped (face-down).
     * 
     * @param value The value of the card.
     */
    public Card(String value) {
        this.value = value;
        this.flipped = false;
    }

    /**
     * Get the value of the card.
     * 
     * @return The value of the card.
     */
    public String getValue() {
        return value;
    }

    /**
     * Check if the card is currently flipped (face-up).
     * 
     * @return true if the card is flipped, false otherwise.
     */
    public boolean isFlipped() {
        return flipped;
    }

    /**
     * Flip the card to change its state from face-up to face-down or vice versa.
     */
    public void flip() {
        flipped = !flipped;
    }

    /**
     * Get a string representation of the card's value.
     * If the card is flipped, its value is revealed; otherwise, it's shown as "*".
     * 
     * @return The string representation of the card.
     */
    @Override
    public String toString() {
        if (flipped) {
            return value;
        } else {
            return "*";
        }
    }
}