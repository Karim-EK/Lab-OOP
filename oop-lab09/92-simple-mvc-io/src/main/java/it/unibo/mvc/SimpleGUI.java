package it.unibo.mvc;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUI {

    private static final int PROPORTION = 5;
    private static final Object STRING = "Are you sure you want to save this text?";
    private static final String TITLE = "Saving";
    private final JFrame frame = new JFrame();
    private final Controller controller;

    public SimpleGUI() {
        this.controller = new Controller();
        final JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        final JTextArea textArea = new JTextArea();
        mainPanel.add(BorderLayout.CENTER, textArea);
        final JButton saveButton = new JButton("Save");
        mainPanel.add(BorderLayout.SOUTH, saveButton);
        frame.setContentPane(mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                final var result = JOptionPane.showConfirmDialog(frame, STRING, TITLE, JOptionPane.YES_NO_OPTION);
                if (result == JOptionPane.YES_OPTION) {
                    try (BufferedWriter fileWriter = new BufferedWriter(new FileWriter(controller.getFile()))) {
                        fileWriter.write(textArea.getText());
                    } catch (final Exception err) {
                        err.printStackTrace();
                    }
                }
            }
        });
    }

    private void display() {
        final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        final int sw = (int) screen.getWidth();
        final int sh = (int) screen.getHeight();
        frame.setSize(sw / PROPORTION, sh / PROPORTION);
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    public static void main(final String[] args) {
        new SimpleGUI().display();
    }
}
