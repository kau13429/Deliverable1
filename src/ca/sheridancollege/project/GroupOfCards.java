/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author khushleen kaur   Date - july, 8 2023
 */
public class GroupOfCards {

    // List of players participating in the game
    private final List<Player> players;
    
    // List of cards used in the game
    private final List<Card> cards;
    
    // Counter to keep track of matched card pairs
    private int pairsFound;

    // Constructor to initialize the game with players and cards
    public GroupOfCards(List<Player> players, List<Card> cards) {
        this.players = players;
        this.cards = cards;
        this.pairsFound = 0;
    }

    /**
     * Starts and manages the gameplay of the memory card game.
     */
    public void play() {
        // Calculate the total number of pairs in the game
        int totalPairs = cards.size() / 2;
        
        // Calculate the maximum number of turns based on the number of cards
        int maxTurns = cards.size() * 2;

        // Shuffle the cards to randomize their order
        Collections.shuffle(cards);

        // Loop through the game turns
        for (int i = 0; i < maxTurns; i++) {
            // Determine the current player for this turn
            Player currentPlayer = players.get(i % players.size());
            System.out.println("Current Player: " + currentPlayer.getName());

            // Display the current state of the game board
            displayBoard();

            // Prompt for the index of the first card to flip
            int firstIndex = getInput("Enter the index of the first card to flip: ");
            while (firstIndex < 0 || firstIndex >= cards.size() || cards.get(firstIndex).isFlipped()) {
                System.out.println("Invalid index or card already flipped. Please try again.");
                firstIndex = getInput("Enter the index of the first card to flip: ");
            }

            // Prompt for the index of the second card to flip
            int secondIndex = getInput("Enter the index of the second card to flip: ");
            while (secondIndex < 0 || secondIndex >= cards.size() || cards.get(secondIndex).isFlipped()) {
                System.out.println("Invalid index or card already flipped. Please try again.");
                secondIndex = getInput("Enter the index of the second card to flip: ");
            }

            // Get the card objects at the chosen indices
            Card firstCard = cards.get(firstIndex);
            Card secondCard = cards.get(secondIndex);

            // Flip the chosen cards
            firstCard.flip();
            secondCard.flip();

            // Display the updated game board
            displayBoard();

            // Check if a match is found between the flipped cards
            if (firstCard.getValue().equals(secondCard.getValue())) {
                System.out.println("Match found!");
                // Update player's score and increment pairsFound
                currentPlayer.incrementScore();
                pairsFound++;
            } else {
                System.out.println("No match.");
                // Flip the cards back if no match is found
                firstCard.flip();
                secondCard.flip();
            }

            // Check if all pairs have been found, end the game if true
            if (pairsFound == totalPairs) {
                System.out.println("Game over! All pairs found.");
                break;
            }
        }

        // Display final scores of all players
        System.out.println("Final Scores:");
        for (Player player : players) {
            System.out.println(player.getName() + ": " + player.getScore());
        }
    }

    // Helper method to get input from the user
    private int getInput(String message) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(message);
        int input = scanner.nextInt();
        scanner.nextLine(); // Consume newline left by nextInt()
        return input;
    }

    // Helper method to display the current state of the game board
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