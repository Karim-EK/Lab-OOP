package it.unibo.design.robot.impl;

import it.unibo.design.robot.api.Component;
import it.unibo.design.robot.api.ModularRobot;

public abstract class AbstractComponent implements Component {

    private double batteryConsuption;
    private boolean isOn;
    private boolean isAttached;
    private ModularRobot robot;

    public AbstractComponent() {
        this.isOn = false;
        this.isAttached = false;
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
    
    protected void setActualConsume(double batteryConsuption) {
        this.batteryConsuption = batteryConsuption;
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
