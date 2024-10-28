package it.unibo.design.robot.impl;

public class BorderNavigator extends AbstractComponent {

    private static final double BATTERY_CONSUPTION = 0;

    public BorderNavigator() {
        super(BATTERY_CONSUPTION);
    }

    @Override
    public void activate() {
        if (isOperational()) {

            System.out.println("Ready to explore the boarders of the environment");

            System.out.println("Now moving to the up boarder");
            do {
                this.getRobot().moveUp();
            } while (!this.getRobot().moveUp());

            System.out.println("Now moving to the right boarder");
            do {
                this.getRobot().moveRight();
            } while (!this.getRobot().moveRight());

            System.out.println("Now moving to the down boarder");
            do {
                this.getRobot().moveDown();
            } while (!this.getRobot().moveDown());

            System.out.println("Now moving to the left boarder");
            do {
                this.getRobot().moveLeft();
            } while (!this.getRobot().moveLeft());

            System.out.println("Navigated trough all the boarders of the environment");
        }
    }
    
}
