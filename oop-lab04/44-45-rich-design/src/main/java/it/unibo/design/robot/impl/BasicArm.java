package it.unibo.design.robot.impl;

public class BasicArm {
    
    private static final double CONSUMPTION_4_PICKUP = 0.5;
    private static final double CONSUMPTION_4_DROPDOWN = 0.2;

    private boolean isGrabbing;
    final private String armName;

    public BasicArm(final String name) {
        this.armName = name;
        this.isGrabbing = false;
    }

    public boolean isGrabbing() {
        return this.isGrabbing;
    }

    protected void grab() {
        this.isGrabbing = true;
    }

    public void pickUp() {
        if (!isGrabbing) {
            isGrabbing = true;
        }
    }

    public void dropDown() {
        if (isGrabbing) {
            isGrabbing = false;
        }
    }

    public static double getConsumption4Pickup() {
        return CONSUMPTION_4_PICKUP;
    }

    public static double getConsumption4Dropdown() {
        return CONSUMPTION_4_DROPDOWN;
    }
}
