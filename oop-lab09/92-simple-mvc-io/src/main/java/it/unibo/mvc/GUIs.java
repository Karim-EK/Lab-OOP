package it.unibo.mvc;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

/**
 * Utility class to avoid CPD.
 */
public final class GUIs {
    private static final Object STRING = "Are you sure you want to save this text?";
    private static final String TITLE = "Saving";
    private static final int PROPORTION = 5;

    /**
     * This class should not be instantiated.
     */
    private GUIs() {

    }
    /**
     * Add a specific ActionListener for a JButton.
     * @param button where the listener should be add
     * @param frame that contains the button
     * @param controller which controll the GUI
     * @param textArea which contains the strings
     */
    public static void addListener(
        final JButton button,
        final JFrame frame, 
        final Controller controller,
        final JTextArea textArea
    ) {
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                final var result = JOptionPane.showConfirmDialog(frame, STRING, TITLE, JOptionPane.YES_NO_OPTION);
                if (result == JOptionPane.YES_OPTION) {
                    try (
                        BufferedWriter fileWriter =
                            new BufferedWriter(new FileWriter(controller.getFile(), StandardCharsets.UTF_8))
                    ) {
                        fileWriter.write(textArea.getText());
                    } catch (final IOException err) {
                        err.printStackTrace(); // NOPMD suppressed as it is a false positive
                    }
                }
            }
        });
    }
    /**
     * Make a frame visible.
     * @param frame wich should be displayed
     */
    public static void displayFrame(final JFrame frame) {
        final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        final int sw = (int) screen.getWidth();
        final int sh = (int) screen.getHeight();
        frame.setSize(sw / PROPORTION, sh / PROPORTION);
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }
}
