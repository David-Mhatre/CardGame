import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;


public class Deck {
    // Instance variables for how many cards left and our deck named cards
    private int cardsLeft;
    private ArrayList<Card> cards;
    private Image[] cardImages;

    // Contractor adds cards to the deck based on the arrays we pass in
    public Deck(String[] ranks, String[] suits, int[] points, CardView window){
        cards = new ArrayList<Card>();
        cardImages = new Image[52];
        for (int i = 0; i < ranks.length; i++){
            for (int j = 0; j < suits.length; j++){
                Card p = new Card(ranks[i], suits[j], points[j], window);
                cardImages[i] = new ImageIcon("resoucres/" + i + ".png").getImage();
                cards.add(p);
                cardsLeft++;
            }
        }
    }

    // Checks if the deck is empty using the CardsLeft variable
    public boolean isEmpty(){
        if (cardsLeft > 0)
        {
            return false;
        }
        return true;
    }

    // Getter method for CardsLeft
    public int getCardsLeft() {
        return cardsLeft;
    }

    // Deal return the last card in the deck and removes it
    public Card deal(){
        if (isEmpty()){
            return null;
        }
        cardsLeft -= 1;
        return cards.remove(cardsLeft);
    }

    // Using the Algorithm we go through the deck and swap each index with a random one
    public void shuffle(){
        for (int i = 0; i < cards.size(); i++){
            int swap = (int)(Math.random() * cards.size());
            Card holder = cards.get(swap);
            cards.set(swap, cards.get(i));
            cards.set(i, holder);
        }
        cardsLeft = cards.size() - 1;
    }

    public void draw(Graphics g){

    }
}
