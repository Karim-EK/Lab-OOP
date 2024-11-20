package it.unibo.mvc;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import static it.unibo.mvc.GUIs.displayFrame;


/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUIWithFileChooser {

    /**
     * This calss should not be instanciated.
     */
    private SimpleGUIWithFileChooser() {

    }
    /**
     * Prepare the GUI.
     * @return the frame to be displayed
     */
    public static JFrame simpleGUIWithFileChooser() {
        final JFrame frame = new JFrame();
        final Controller controller = new Controller();
        final JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        final JTextArea textArea = new JTextArea();
        mainPanel.add(BorderLayout.CENTER, textArea);
        final JButton saveButton = new JButton("Save");
        mainPanel.add(BorderLayout.SOUTH, saveButton);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        final JPanel northPanel = new JPanel();
        northPanel.setLayout(new BorderLayout());
        final JTextField textField = new JTextField();
        final JButton browse = new JButton("Browse...");
        mainPanel.add(BorderLayout.NORTH, northPanel);
        northPanel.add(BorderLayout.CENTER, textField);
        northPanel.add(BorderLayout.LINE_END, browse);
        textField.setEditable(false);
        frame.setContentPane(mainPanel);
        textField.setText(controller.getFilePath());
        browse.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(final ActionEvent e) {
                final JFileChooser fileChooser = new JFileChooser();
                fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
                final var result = fileChooser.showSaveDialog(frame);
                if (result == JFileChooser.APPROVE_OPTION) {
                    final var file = fileChooser.getSelectedFile();
                    controller.setFile(file);
                    textField.setText(file.getPath());
                } else if (result == JFileChooser.ERROR_OPTION) {
                    JOptionPane.showMessageDialog(frame, JOptionPane.ERROR_MESSAGE, "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        GUIs.addListener(saveButton, frame, controller, textArea);
        return frame;
    }

    /**
     * Main.
     * @param args unused
     */
    public static void main(final String[] args) {
        displayFrame(simpleGUIWithFileChooser());
    }

}
