import javax.swing.*;
import java.awt.*;


public class CardView extends JFrame{
    // Sets the size of the window with constants
    private final int WINDOW_WIDTH = 750;
    private final int WINDOW_HEIGHT = 750;
    // Creates and instance of the game class
    private Game game;
    // The back of the card image that represents the deck
    private Image deck;

    public CardView(Game g){
        // Initializes the back of the card deck
        deck = new ImageIcon("resoucres/Cards/back.png").getImage();
        // Creates an instance of the game and then sets up the window
        game = g;
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Card Game");
        this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        this.setVisible(true);
    }

    @Override
    public void paint(Graphics g){
        // Sets the screen to green and repaints the back of the card
        g.setColor(Color.GREEN);
        g.fillRect(0,0,750,750);
        g.drawImage(deck, 100,50, 100, 100, this);
        // Prints the back of the card to show how many cards the House had
        for(int i = 0; i < game.getHouseCards().size(); i++){
            g.drawImage(deck, 100 + (100 * i), 200, 100, 100 ,this);
        }
        // Prints the players cards on the window
        for (int i = 0; i < game.getPlayerCards().size(); i++){
            Image img = game.getPlayerCards().get(i).getCardImage();
            g.drawImage(img, 100 + (100 * i), 500, 100, 100 ,this);
        }

        // If the game is over then show the houses cards
        if (game.isGameOver()) {
            for (int i = 0; i < game.getHouseCards().size(); i++) {
                Image img = game.getHouseCards().get(i).getCardImage();
                g.drawImage(img, 100 + (100 * i), 200, 100, 100, this);
            }
        }

        // Sets the font and prints the labels
        g.setColor(Color.BLACK);
        g.setFont(new Font("Arial", Font.PLAIN, 50));
        g.drawString("House Cards", 100, 200);
        g.drawString("Player Cards", 100, 650);
        // Decides what to print on the window based on who won
        if (game.checkWinner().equals("Player") && game.isGameOver()){
            g.drawString("You win", 100, 450);
        }
        if (game.checkWinner().equals("House") && game.isGameOver()){
            g.drawString("The House Wins", 100, 450);
        }
        if (game.checkWinner().equals("Tied") && game.isGameOver()){
            g.drawString("You Tied", 100, 450);
        }
    }

}
