/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * @author Khushpreet Kaur 8 july2023
 */
package ca.sheridancollege.project;

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

