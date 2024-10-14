package it.unibo.design.robot.api;

public interface Component {
    
    public boolean isOn();

    public void attach(ModularRobot robot);

    public void detach();

    public boolean isAttached();

    public void activate();

    public double getBatteryConsuption();

    public void turnOn();

    public void turnOff();
}
