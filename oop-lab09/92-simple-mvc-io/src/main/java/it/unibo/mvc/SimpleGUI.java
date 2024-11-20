package it.unibo.mvc;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import static it.unibo.mvc.GUIs.displayFrame;

/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUI {

    /**
     * This calss should not be instanciated.
     */
    private SimpleGUI() {

    }
    /**
     * Prepare the GUI.
     * @return the frame to be displayed
     */
    public static JFrame simpleGUI() {
        final JFrame frame = new JFrame();
        final Controller controller = new Controller();
        final JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        final JTextArea textArea = new JTextArea();
        mainPanel.add(BorderLayout.CENTER, textArea);
        final JButton saveButton = new JButton("Save");
        mainPanel.add(BorderLayout.SOUTH, saveButton);
        frame.setContentPane(mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        GUIs.addListener(saveButton, frame, controller, textArea);
        return frame;
    }

    /**
     * Main.
     * @param args unused
     */
    public static void main(final String[] args) {
        displayFrame(simpleGUI());
    }
}
