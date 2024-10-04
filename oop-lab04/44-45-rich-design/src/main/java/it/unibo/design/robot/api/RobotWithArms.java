package it.unibo.design.robot.api;

public interface RobotWithArms extends Robot {
    boolean pickUp();

    boolean dropDown();

    /*returns the number of objects this robot is currently transporting*/
    int getCarriedItemsCount();
}
