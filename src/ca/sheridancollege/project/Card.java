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
 * @author Khushpreet Kaur
 * @Student Id: 991685679
 * @date: 08/July/2023
 */
public abstract class Card {
    //default modifier for child classes
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


    /**
     * Students should implement this method for their specific children classes
     *
     * @return a String representation of a card. Could be an UNO card, a regular playing card etc.
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





