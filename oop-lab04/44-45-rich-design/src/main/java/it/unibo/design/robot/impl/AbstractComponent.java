package it.unibo.design.robot.impl;

import it.unibo.design.robot.api.Component;

public abstract class AbstractComponent implements Component {

    private double batteryConsuption;
    private boolean isOn;

    public AbstractComponent() {
        this.isOn = false;
    }

    @Override
    public boolean isOn() {
        return this.isOn;
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
}
