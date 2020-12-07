/**
 * CIS 120 Game HW
 * (c) University of Pennsylvania
 * @version 2.1, Apr 2017
 */

import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;

import javax.swing.*;

/**
 * GameCourt
 * 
 * This class holds the primary game logic for how different objects interact with one another. Take
 * time to understand how the timer interacts with the different methods and how it repaints the GUI
 * on every tick().
 */
@SuppressWarnings("serial")
public class GameCourt extends JPanel {

    // the state of the game logic

    
    private Board board;
    private String turn = "red";
    private int cnt;
    private LinkedList<int[]> turnStack = new LinkedList<int[]>();

    private boolean playing = false; // whether the game is running 
    private JLabel status; // Current status text, i.e. "Running..."

    // Game constants
    public static final int COURT_WIDTH = 500;
    public static final int COURT_HEIGHT = 400;
    public static final int SQUARE_VELOCITY = 4;

    // Update interval for timer, in milliseconds
    public static final int INTERVAL = 35;

    public GameCourt(JLabel status) {
        // creates border around the court area, JComponent method
        setBorder(BorderFactory.createLineBorder(Color.BLACK));

        // The timer is an object which triggers an action periodically with the given INTERVAL. We
        // register an ActionListener with this timer, whose actionPerformed() method is called each
        // time the timer triggers. We define a helper method called tick() that actually does
        // everything that should be done in a single timestep.
        Timer timer = new Timer(INTERVAL, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                tick();
            }
        });
        timer.start(); // MAKE SURE TO START THE TIMER!

        // Enable keyboard focus on the court area.
        // When this component has the keyboard focus, key events are handled by its key listener.
        setFocusable(true);


        this.status = status;
    }

    /**
     * (Re-)set the game to its initial state.
     */
    public void reset() {

        board = new Board(COURT_WIDTH, COURT_HEIGHT);
        turn = "red";
        cnt = 0;
        turnStack = new LinkedList<int[]>();

        playing = true;
        status.setText("In Game... Red Turn");

        // Make sure that this component has the keyboard focus
        requestFocusInWindow();
    }
    
    /**
     * Undo
     */
    public void undo() {
        if (playing) {
            if (turnStack.size() < 1) {
                return;
            }
            System.out.println("im in undo");
            int[] ar = turnStack.pop();
            board.clear(ar[0], ar[1]);
            if (turn.equals("red")) {
                turn = "blue";
                status.setText("Blue Turn");
            } else {
                turn = "red";
                status.setText("Red Turn");
            
            }
            status.setText("Turn Undone. " + turn + " turn.");
        }
        
    }
    
    public void addTurn(int r, int c) {
        turnStack.push(new int[] {r,c});
    }
    
    public void save() {
        
        try {
            BufferedWriter bw = null;
            FileWriter fw = new FileWriter("files/saved_games");
            bw = new BufferedWriter(fw);
            for (int i = 0; i < 6; i++) {
                for (int j = 0; j < 7; j++) {
                    bw.write(board.get(i, j));
                }
                bw.newLine();
            }
            bw.write(turn);
            bw.close();
        } catch (IOException e) {
            //System.out.println("failed to write strings to file");
        }
        status.setText("Game Saved. " + turn + " turn.");
    }
    
    public void load() {
        String[] ar = new String[6];
        BufferedReader reader;
        String player = "red";
        try {
            reader = new BufferedReader(new FileReader("files/saved_games"));
            for (int i = 0; i < 6; i++) {
                ar[i] = reader.readLine();
            }
            player = reader.readLine();
        } catch (IOException e) { 
        }
        board.change(ar);
        turn = player;
        status.setText("Game Loaded. " + turn + " turn.");
    }
    
    public void intro() {
        //System.out.println("im in intro");
        JOptionPane.showMessageDialog(null,
                "Welcome to CONNECT4!!!!!! \n"
                + "There are two players, red and blue. \nRed goes first and alternates turns"
                + "with blue. \nThe first player to get 4 of their own color in a row wins!"
                + "4 in a row includes vertical, horizontal, and diagonals! \n"
                + "If you would like to undo your move, simply click undo. You can undo however"
                + " many moves as you like. \nHowever, if you loaded a saved game, you will not be "
                + "allowed to undo the loaded moves.\n"
                + "If you would like to save your progress, simply click the save button.\n"
                + "To reload a saved game, simply click load. Only one game board can be saved at"
                + " a time. \nUpon completing a game, click replay to play again.",
                "Game Instructions",
                JOptionPane.PLAIN_MESSAGE);
    }
    
    public void col(int n) {
        if (playing) {
            Color co;
            if (turn.equals("red")) {
                co = Color.red;
            } else {
                co = Color.blue;
            }
           
            boolean b = board.add(this, n, co);
            if (b) {
                if (turn.equals("red")) {
                    turn = "blue";
                    status.setText("Blue Turn");
                } else {
                    turn = "red";
                    status.setText("Red Turn");
                
                }
                cnt++;
            }
            if (cnt == 42) {
                status.setText("GAME OVER");
                JOptionPane.showMessageDialog(null,
                        "GAME OVER!!!! Nobody wins. Press Replay to play again",
                        "End Message",
                        JOptionPane.PLAIN_MESSAGE);
            }
        }
        
        
    }

    /**
     * This method is called every time the timer defined in the constructor triggers.
     */
    void tick() {
        if (playing) {
           

            // check for the game end conditions
            String winner;
            if (turn.equals("red")) {
                winner = "blue";
            } else {
                winner = "red";
            }
            if (board.hasWinner(winner)) {
                playing = false;
                status.setText(winner + " wins!");
                JOptionPane.showMessageDialog(null,
                        "GAME OVER!!!! " + winner + " wins. Press Replay to play again",
                        "End Message",
                        JOptionPane.PLAIN_MESSAGE);
                
            }
            

            // update the display
            repaint();
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
 
        board.draw(g);
        
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(COURT_WIDTH, COURT_HEIGHT);
    }
}