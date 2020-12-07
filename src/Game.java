/**
 * CIS 120 Game HW
 * (c) University of Pennsylvania
 * @version 2.1, Apr 2017
 */

// imports necessary libraries for Java swing
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Game Main class that specifies the frame and widgets of the GUI
 */
public class Game implements Runnable {
    public void run() {
        // NOTE : recall that the 'final' keyword notes immutability even for local variables.

        // Top-level frame in which game components live
        // Be sure to change "TOP LEVEL FRAME" to the name of your game
        final JFrame frame = new JFrame("ConnectFour");
        frame.setLocation(300, 300);

        // Status panel
        final JPanel status_panel = new JPanel();
        frame.add(status_panel, BorderLayout.SOUTH);
        final JLabel status = new JLabel("In Game...");
        status_panel.add(status);

        // Main playing area
        final GameCourt court = new GameCourt(status);
        frame.add(court, BorderLayout.CENTER);

        // Reset button
        final JPanel control_panel = new JPanel();
        frame.add(control_panel, BorderLayout.NORTH);
        

        // Note here that when we add an action listener to the reset button, we define it as an
        // anonymous inner class that is an instance of ActionListener with its actionPerformed()
        // method overridden. When the button is pressed, actionPerformed() will be called.
        final JButton reset = new JButton("Replay");
        reset.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                court.reset();
            }
        });
        control_panel.add(reset);
        
        final JButton undo = new JButton("Undo");
        undo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                court.undo();
            }
        });
        control_panel.add(undo);
        
        final JButton save = new JButton("Save");
        save.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                court.save();
            }
        });
        control_panel.add(save);
        
        final JButton load = new JButton("Load");
        load.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                court.load();
            }
        });
        control_panel.add(load);
        
        final JButton intro = new JButton("Instructions");
        intro.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                court.intro();
            }
        });
        control_panel.add(intro);
        
        
        //Button Panel
        court.setLayout(new GridLayout(1,7));
        
        //Colums
        JButton col0 = new JButton("");
        col0.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                court.col(0);
            }
        });
        col0.setOpaque(false);
        col0.setContentAreaFilled(false);
        col0.setBorderPainted(false);

        court.add(col0);
        
        
        JButton col1 = new JButton("");
        col1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                court.col(1);
            }
        });
        col1.setOpaque(false);
        col1.setContentAreaFilled(false);
        col1.setBorderPainted(false);

        court.add(col1);
        
        JButton col2 = new JButton("");
        col2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                court.col(2);
            }
        });
        col2.setOpaque(false);
        col2.setContentAreaFilled(false);
        col2.setBorderPainted(false);
        court.add(col2);
        
        JButton col3 = new JButton("");
        col3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                court.col(3);
            }
        });
        col3.setOpaque(false);
        col3.setContentAreaFilled(false);
        col3.setBorderPainted(false);
        court.add(col3);
        
        JButton col4 = new JButton("");
        col4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                court.col(4);
            }
        });
        col4.setOpaque(false);
        col4.setContentAreaFilled(false);
        col4.setBorderPainted(false);
        court.add(col4);
        
        JButton col5 = new JButton("");
        col5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                court.col(5);
            }
        });
        col5.setOpaque(false);
        col5.setContentAreaFilled(false);
        col5.setBorderPainted(false);
        court.add(col5);
        
        JButton col6 = new JButton("");
        col6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                court.col(6);
            }
        });
        col6.setOpaque(false);
        col6.setContentAreaFilled(false);
        col6.setBorderPainted(false);
        court.add(col6);
        


        // Put the frame on the screen
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        // Start game
        court.reset();
    }

    /**
     * Main method run to start and run the game. Initializes the GUI elements specified in Game and
     * runs it. IMPORTANT: Do NOT delete! You MUST include this in your final submission.
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Game());
    }
}