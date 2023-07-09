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
 */
public abstract class Card {
    private final String value;
    private boolean flipped;

    public Card(String value) {
        this.value = value;
        this.flipped = false;
    }

    public String getValue() {
        return value;
    }

    public boolean isFlipped() {
        return flipped;
    }

    public void flip() {
        flipped = !flipped;
    }

    @Override
    public String toString() {
        if (flipped) {
            return value;
        } else {
            return "*";
        }
    }
}