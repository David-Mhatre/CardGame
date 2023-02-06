import java.awt.*;

public class Card {
    // Instance variables for rank suit and point value of the cards
    private String rank;
    private String suit;
    private int points;
    CardView view;

    // Constructor for all variables
    public Card(String rank, String suit, int points, CardView view){
        this.points = points;
        this.rank = rank;
        this.suit = suit;
        this.view = view;
    }

    // Getter and setter methods for all of or instance variables
    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getSuit() {
        return suit;
    }

    public void setSuit(String suit) {
        this.suit = suit;
    }

    // ToString Method to format our cards
    @Override
    public String toString() {
        return rank + " of " + suit;
    }

    public void draw(Graphics g){

    }
}
