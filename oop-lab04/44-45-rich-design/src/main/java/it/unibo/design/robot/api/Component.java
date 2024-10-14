package it.unibo.design.robot.api;

public interface Component {
    
    public boolean isOn();

    public void activate();

    public double getBatteryConsuption();

    public void turnOn();

    public void turnOff();
}
