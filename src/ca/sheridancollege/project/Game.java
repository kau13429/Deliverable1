/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Add your name as an author and the date!
 * @Arshdeep kaur 
 * 8 july 2023
 */
package ca.sheridancollege.project;

import ca.sheridancollege.project.Card;
import ca.sheridancollege.project.GroupOfCards;
import ca.sheridancollege.project.Player;
import java.util.ArrayList;
import java.util.List;

public class Game {
    public static void main(String[] args) {
        List<Player> players = new ArrayList<>();
        players.add(new Player("Player 1") {});
        players.add(new Player("Player 2") {});

        List<Card> cards = new ArrayList<>();
        cards.add(new Card("A") {});
        cards.add(new Card("A") {});
        cards.add(new Card("B") {});
        cards.add(new Card("B") {});
        cards.add(new Card("C") {});
        cards.add(new Card("C") {});
        cards.add(new Card("D") {});
        cards.add(new Card("D") {});

        GroupOfCards game = new GroupOfCards(players, cards);
        game.play();
    }
}