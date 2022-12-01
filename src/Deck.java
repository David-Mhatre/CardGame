import java.util.ArrayList;


public class Deck {
    private int cardsLeft;
    private ArrayList<Card> cards;

    public Deck(String[] ranks, String[] suits, int[] points){
        for (int i; i < suits.length; i++){
            for (int j; j < ranks.length; j++){
                cards.add(ranks[j], suits[i], points[j]);
                cardsLeft++;
            }
        }
    }

    public boolean isEmpty(){
        if (cardsLeft > 0)
        {
            return false;
        }
        return true;
    }

    public int getCardsLeft() {
        return cardsLeft;
    }

    public Card deal(){
        if (isEmpty()){
            return null;
        }
        return cards.get(cardsLeft);
    }

    public void shuffle(){
        for (int i; i < cards.size(); i++){
            int swap = (int)(Math.random() * cards.size());
            Card holder = cards.get(swap);
            cards.set(swap, cards.get(i));
            cards.set(i, holder);
        }
        cardsLeft = cards.size();
    }
}
