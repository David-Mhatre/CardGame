import javax.swing.*;
import java.awt.*;


public class CardView extends JFrame{
    private final int WINDOW_WIDTH = 750;
    private final int WINDOW_HEIGHT = 750;
    private final int DECK = 50;
    private Game game;

    public CardView(Game g){
        for (int i = 0; i > 53; i++){

        }
        game = g;
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Card Game");
        this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        this.setVisible(true);
    }

    @Override
    public void paint(Graphics g){
        Image deck = new ImageIcon("resoucres/back.png").getImage();
        g.drawImage(deck, 50,50, this);
        for(int i = 0; i < game.getHouseCards().size(); i++){
            g.drawImage(game.getHouseCards().get(i).getCardImage(), 100 + 100 + game.getHouseCards().get(i).getCardImage().getWidth(this), 100, this);
        }
        for (int i = 0; i < game.getPlayerCards().size(); i++){
            g.drawImage(game.getPlayerCards().get(i).getCardImage(), 100 + 100 + game.getPlayerCards().get(i).getCardImage().getWidth(this), 600, this);
        }
    }

}
