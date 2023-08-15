/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Add your name as an author and the date!
 */
package ca.sheridancollege.project;

/**
 * A class that models each Player in the game. Players have an identifier, which should be unique.
 *
 * @author dancye
 * @author Paul Bonenfant Jan 2020
 * @modified Prabhnoor Grewal
 * @date 14 August 2023
 * 
 */
public abstract class Player {

    private String name;     // The name of the player
    private int score;       // The score of the player

    /**
     * Constructor to create a player with a given name.
     * The player's score is initially set to zero.
     * 
     * @param name The name of the player.
     */
    public Player(String name) {
        this.name = name;
        this.score = 0;
    }

    /**
     * Get the name of the player.
     * 
     * @return The name of the player.
     */
    public String getName() {
        return name;
    }

    /**
     * Get the score of the player.
     * 
     * @return The score of the player.
     */
    public int getScore() {
        return score;
    }

    /**
     * Increment the player's score by 1.
     */
    public void incrementScore() {
        score++;
    }

    /**
     * Reset the player's score to zero.
     */
    public void resetScore() {
        score=0;
    }
}