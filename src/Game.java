import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    // Instance variables for how players, deck, points, and card also adds scanner and our arrays for the deck constructor
    private ArrayList<Player> players;
    private Deck dc;
    private int playerPoints;
    private Card current;
    Scanner s = new Scanner(System.in);
    private CardView window;
    String[] ranks = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};
    String[] suits = {"Spades" , "Hearts", "Diamonds", "Clubs"};
    int[] points = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10};

    // Holds the cards that the player and house have currently
    private ArrayList<Card> playerCards;
    private ArrayList<Card> houseCards;

    private int housePoints;

    // Tells the front end when to print the winner
    private boolean gameOver;

    // Game Constructor gets name of player and initializes all of our variables
    public Game(){
        gameOver = false;
        players = new ArrayList<Player>();
        dc = new Deck(ranks, suits, points, window);
        System.out.println("What is your name? ");
        String name = s.nextLine();
        Player p = new Player(name);
        players.add(p);
        dc.shuffle();
        playerCards = new ArrayList<Card>();
        houseCards = new ArrayList<Card>();
        window = new CardView(this);
    }

    // Prints the instructions to the console so the user knows how to play
    public void printInstructions(){
        System.out.println("The house will play first but you won't see the card you will be given a card" +
                "then a choice to hit or stand try to get as close to 21 as you can without busting " +
                "whoever is closer wins or if both bust it is a tie");
    }

    // The hit method allows the user to get a new card and add it to their points
    public int hit() {
        System.out.println("Would you like to hit or stand? ");
        String p = s.nextLine();
        if (p.equals("stand")){
            return 0;
        }
        else{
            current = dc.deal();
            playerPoints += current.getPoints();
            System.out.println(current.toString());
            playerCards.add(current);
            window.repaint();
            return 1;
        }
    }

    // House acts as the dealer or the casino when you play always stands on 17
    public int playHouse(){
        int h = 0;
        // House will always stand on 17
        while (h < 17){
            current = dc.deal();
            h += current.getPoints();
            houseCards.add(current);
        }
        // If house busts it will be zero so the user always wins unless they bust
        if (h > 21){
            h = 0;
        }
        return h;
    }

    // Check winner communicates with the front end to tell it who won
    public String checkWinner(){
        if (playerPoints > 21 && housePoints == 0){
            return "Tied";
        }
        else{
            if (playerPoints > housePoints){
                return "Player";
            }
            else if (playerPoints == housePoints){
                return "Tied";
            }
            else{
                return "House";
            }
        }
    }
    // prints the winner in the console based on if statements
    public void printWinner(){
        // Determines what line to print based on the outcome
        if (playerPoints > 21 && housePoints == 0){
            System.out.println("You Both Busted Better Luck Next Time");
        }
        else{
            if (playerPoints > 21 && housePoints != 0){
                System.out.println("You Busted Better Luck Next Time");
            }
            if (playerPoints > housePoints){
                if (housePoints == 0){
                    System.out.println("You Won you had " + playerPoints + " The House Busted");
                }
                else{
                    System.out.println("You Won you had " + playerPoints + " The House had " + housePoints);
                }
            }
            else if (playerPoints == housePoints){
                System.out.println("You Tied you had " + playerPoints + " The House had " + housePoints);
            }
            else{
                System.out.println("You lost you had " + playerPoints + " The House had " + housePoints);
            }
        }
    }

    // Getters for are important varibles
    public ArrayList<Card> getPlayerCards() {
        return playerCards;
    }

    public ArrayList<Card> getHouseCards() {
        return houseCards;
    }

    public boolean isGameOver() {
        return gameOver;
    }

    // PlayGame method lets the house play and then after the first card calls hit until the player chooses to not hit
    // Or they bust
    public void playGame(){
        printInstructions();
        housePoints = playHouse();
        playerPoints = 0;
        System.out.println("First Card");
        current = dc.deal();
        System.out.println(current.toString());
        playerPoints += current.getPoints();
        playerCards.add(current);
        // Calls hit until the player busts or exits also reprints the window everytime
        while (playerPoints < 22){
            window.repaint();
           if (hit() == 0){
               break;
            }
        }
        gameOver = true;
        window.repaint();
        printWinner();
    }
}
