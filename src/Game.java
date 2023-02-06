import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    // Instance variables for how players, deck, points, and card also adds scanner and our arrays for the deck constructor
    private ArrayList<Player> players;
    private Deck dc;
    private int bjPoints;
    private Card current;
    Scanner s = new Scanner(System.in);
    private CardView window;
    String[] ranks = {"Ace", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};
    String[] suits = {"Hearts", "Clubs", "Spades", "Diamonds"};
    int[] points = {1, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10, 10};

    // Game Constructor gets name of player and initializes all of our variables
    public Game(){
        window = new CardView(this);
        players = new ArrayList<Player>();
        dc = new Deck(ranks, suits, points, window);
        System.out.println("What is your name? ");
        String name = s.nextLine();
        Player p = new Player(name);
        players.add(p);
        dc.shuffle();
    }

    // Prints the instructions to the console so the user knows how to play
    public void printInstructions(){

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
            bjPoints += current.getPoints();
            System.out.println(current.toString());
            return 1;
        }
    }

    // House acts as the dealer or the casino when you play always stands on 17
    public int House(){
        int h = 0;
        // House will always stand on 17
        while (h < 18){
            current = dc.deal();
            h += current.getPoints();
        }
        // If house busts it will be zero so the user always wins unless they bust
        if (h > 21){
            h = 0;
        }
        return h;
    }

    public void Winner(int hPoints){
        // Determines what line to print based on the outcome
        if (bjPoints > 21){
            System.out.println("You Busted better luck next time.");
        }
        else{
            if (bjPoints > hPoints){
                if (hPoints == 0){
                    System.out.println("You Won you had " + bjPoints + " The House Busted");
                }
                else{
                    System.out.println("You Won you had " + bjPoints + " The House had " + hPoints);
                }
            }
            else if (bjPoints == hPoints){
                System.out.println("You Tied you had " + bjPoints + " The House had " + hPoints);
            }
            else{
                System.out.println("You lost you had " + bjPoints + " The House had " + hPoints);
            }
        }
    }
    // PlayGame method lets the house play and then after the first card calls hit until the player chooses to not hit
    // Or they bust
    public void playGame(){
        window.repaint();
        int h = House();
        bjPoints = 0;
        printInstructions();
        System.out.println("First Card");
        current = dc.deal();
        System.out.println(current.toString());
        bjPoints += current.getPoints();
        // Calls hit until the player busts or exits
        while (bjPoints < 22){
            window.repaint();
           if (hit() == 0){
               break;
            }
        }
        Winner(h);
    }
}
