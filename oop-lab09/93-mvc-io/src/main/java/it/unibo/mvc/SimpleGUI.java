package it.unibo.mvc;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUI {

    private static final int PROPORTION = 5;
        private final JFrame frame = new JFrame("Printing Application");
        private final ControllerImpl controller;
    
        public SimpleGUI() {
            this.controller = new ControllerImpl();
            final JPanel mainPanel = new JPanel();
            mainPanel.setLayout(new BorderLayout());
            final var textField = new JTextField("Text to print here");
            mainPanel.add(BorderLayout.NORTH, textField);
            final var textArea = new JTextArea("Logs will be printed here");
            mainPanel.add(BorderLayout.CENTER, textArea);
            final var print = new JButton("print");
            final var history = new JButton("show history");
            final var southPanel = new JPanel();
            southPanel.setLayout(new BoxLayout(southPanel, BoxLayout.X_AXIS));
            mainPanel.add(BorderLayout.SOUTH, southPanel);
            southPanel.add(print);
            southPanel.add(history);
            print.addActionListener(new ActionListener() {
    
                @Override
                public void actionPerformed(final ActionEvent e) {
                    controller.setToPrint(textField.getText());
                    controller.print();
                }
                
            });
            history.addActionListener(new ActionListener() {
    
                @Override
                public void actionPerformed(final ActionEvent e) {
                    textArea.setText("");
                    for (final var string : controller.getPrintLog()) {
                        textArea.append(string + "\n");
                    }
                }
                
            });
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setContentPane(mainPanel);
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
