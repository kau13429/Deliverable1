/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * @author Khushleen Kaur 8 july 2023
 */
package ca.sheridancollege.project;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author khushleen kaur   Date - july, 8 2023
 */
public class GroupOfCards {

    private final List<Player> players;
    private final List<Card> cards;
    private int pairsFound;

    public GroupOfCards(List<Player> players, List<Card> cards) {
        this.players = players;
        this.cards = cards;
        this.pairsFound = 0;
    }

    public void play() {
        int totalPairs = cards.size() / 2;
        int maxTurns = cards.size() * 2;

        Collections.shuffle(cards);

        for (int i = 0; i < maxTurns; i++) {
            Player currentPlayer = players.get(i % players.size());
            System.out.println("Current Player: " + currentPlayer.getName());

            displayBoard();

            int firstIndex = getInput("Enter the index of the first card to flip: ");
            while (firstIndex < 0 || firstIndex >= cards.size() || cards.get(firstIndex).isFlipped()) {
                System.out.println("Invalid index or card already flipped. Please try again.");
                firstIndex = getInput("Enter the index of the first card to flip: ");
            }

            int secondIndex = getInput("Enter the index of the second card to flip: ");
            while (secondIndex < 0 || secondIndex >= cards.size() || cards.get(secondIndex).isFlipped()) {
                System.out.println("Invalid index or card already flipped. Please try again.");
                secondIndex = getInput("Enter the index of the second card to flip: ");
            }

            Card firstCard = cards.get(firstIndex);
            Card secondCard = cards.get(secondIndex);

            firstCard.flip();
            secondCard.flip();

            displayBoard();

            if (firstCard.getValue().equals(secondCard.getValue())) {
                System.out.println("Match found!");
                currentPlayer.incrementScore();
                pairsFound++;
            } else {
                System.out.println("No match.");
                firstCard.flip();
                secondCard.flip();
            }

            if (pairsFound == totalPairs) {
                System.out.println("Game over! All pairs found.");
                break;
            }
        }

        System.out.println("Final Scores:");
        for (Player player : players) {
            System.out.println(player.getName() + ": " + player.getScore());
        }
    }

    private int getInput(String message) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(message);
        int input = scanner.nextInt();
        scanner.nextLine();
        return input;
    }

    private void displayBoard() {
        for (int i = 0; i < cards.size(); i++) {
            System.out.print(cards.get(i) + " ");
            if ((i + 1) % 4 == 0) {
                System.out.println();
            }
        }
        System.out.println();
    }
}