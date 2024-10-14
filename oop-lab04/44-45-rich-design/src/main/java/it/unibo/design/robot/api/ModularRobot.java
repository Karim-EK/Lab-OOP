package it.unibo.design.robot.api;

public interface ModularRobot extends Robot {
    
    public void attachComponent(Component component);

    public void detachComponent(Component component);

    public void activateComponents();

    //public Component getComponents();
}
