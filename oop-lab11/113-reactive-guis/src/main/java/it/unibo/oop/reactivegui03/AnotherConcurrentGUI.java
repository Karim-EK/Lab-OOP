package it.unibo.oop.reactivegui03;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.lang.reflect.InvocationTargetException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 * Third experiment with reactive gui.
 */
@SuppressWarnings("PMD.AvoidPrintStackTrace")
public final class AnotherConcurrentGUI extends JFrame {
    private static int counter;
    private static final double WIDTH_PERC = 0.2;
    private static final double HEIGHT_PERC = 0.1;
    private final JLabel display = new JLabel();
    private final JButton up = new JButton("up");
    private final JButton down = new JButton("down");
    private final JButton stop = new JButton("stop");

    /**
     * 
     */
    public AnotherConcurrentGUI() {
        super();
        counter = 0;
        final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setSize((int) (screenSize.getWidth() * WIDTH_PERC), (int) (screenSize.getHeight() * HEIGHT_PERC));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        final JPanel panel = new JPanel();
        panel.add(display);
        panel.add(up);
        panel.add(down);
        panel.add(stop);
        this.getContentPane().add(panel);
        this.setVisible(true);

        final var agent = new StopwatchAgent();
        final var stopAgent = new TimerAgent();
        new Thread(agent).start();
        new Thread(stopAgent).start();
        up.addActionListener((e) -> agent.goUp());
        down.addActionListener((e) -> agent.goDown());
        stop.addActionListener((e) -> {
            agent.stop();
            up.setEnabled(false);
            down.setEnabled(false);
            stop.setEnabled(false);
        });
        
    }

    private class TimerAgent implements Runnable {

        @Override
        public void run() {
            try {
                Thread.sleep(10_000);
                AnotherConcurrentGUI.this.stop.doClick();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private class StopwatchAgent implements Runnable {

        private volatile boolean stop;
        private volatile boolean increasing = true;

        @Override
        public void run() {
            while (!this.stop) {
                try {
                    SwingUtilities.invokeAndWait(() -> AnotherConcurrentGUI.this.display.setText(Integer.toString(counter)));
                    checkDirection(increasing);
                    Thread.sleep(100);
                } catch (InvocationTargetException | InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        private void checkDirection(boolean flag) {
            if (flag) {
                counter ++;
            } else{
                counter --;
            }
        }

        public void stop() {
            this.stop = true;
        }
        
        public void goDown() {
            this.increasing = false;
        }

        public void goUp() {
            this.increasing = true;
        }
    }
}
