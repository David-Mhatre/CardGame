import java.util.ArrayList;

public class Player {
    // Instance variables for how many cards left and our deck named cards
    private String name;
    private ArrayList<Card> hand;
    private int points;

    // Overloaded constructors one just gives player the name and one starts the player with a hand
    public Player(String name){
        this.name = name;
        points = 0;
    }

    public Player(String name, ArrayList<Card> p){
        this.name = name;
        points = 0;
        for(int i = 0; i < p.size(); i++){
            hand.add(p.get(i));
        }
    }

    // Getter and Setter methods for name, hand, and points
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Card> getHand() {

        return hand;
    }

    public void setHand(ArrayList<Card> hand) {

        this.hand = hand;
    }

    public int getPoints() {

        return points;
    }

    public void setPoints(int points) {

        this.points = points;
    }

    public void addPoints(int add) {

        points += add;
    }

    public void addCard(Card c) {

        hand.add(c);
    }

    // Overrides toString method to show player's entire hand
    @Override
    public String toString() {
        String cards = "";
        for(int i = 0; i < hand.size(); i++){
            cards  = cards + hand.get(i).toString();
        }
        return name + " has " + points + " points " + name + "'s cards" + cards;
    }
}

