package it.unibo.design.robot.impl;

import it.unibo.design.robot.api.Component;
import it.unibo.design.robot.api.ModularRobot;

public abstract class AbstractComponent implements Component {

    private final double batteryConsuption;
    private boolean isOn;
    private boolean isAttached;
    private ModularRobot robot;

    public AbstractComponent(final double batteryConsuption) {
        this.isOn = false;
        this.isAttached = false;
        this.batteryConsuption = batteryConsuption;
    }

    protected boolean isOperational() {
        return this.isAttached && this.isOn;
    }

    @Override
    public boolean isOn() {
        return this.isOn;
    }

    @Override
    public boolean isAttached() {
        return this.isAttached;
    }

    @Override
    public abstract void activate();

    @Override
    public double getBatteryConsuption() {
        return batteryConsuption;
    }

    @Override
    public void turnOn() {
        this.isOn = true;
    }

    @Override
    public void turnOff() {
        this.isOn = false;
    }

    @Override
    public void attach(ModularRobot robot) {
        this.robot = robot;
    }

    @Override
    public void detach() {
        this.robot = null;
    }

    public ModularRobot getRobot() {
        return this.robot;
    }
}
