package it.unibo.design.robot.impl;

public class ModularArms extends AbstractComponent {

    private static final double BATTERY_CONSUPTION = 0.3;

    private boolean isCarryingObjects;

    public ModularArms() {
        super();
        this.isCarryingObjects = false;
        setActualConsume(BATTERY_CONSUPTION);
    }

    @Override
    public void activate() {
       if (isOperational()) {
            System.out.println("Arms attached and powered on.");
            if (isCarryingObjects) {
                System.out.println("Currently holding objects");   
            } else {
                System.out.println("Currently not holding anything");
            }
       }
    }
    
    public void pick() {
        if (!isCarryingObjects) {
           isCarryingObjects = true;
        }
    }

    public void drop() {
        if (isCarryingObjects) {
            this.isCarryingObjects = false;
        }
    }
}
