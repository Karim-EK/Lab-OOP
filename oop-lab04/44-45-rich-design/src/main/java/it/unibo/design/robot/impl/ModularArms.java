package it.unibo.design.robot.impl;

public class ModularArms extends AbstractComponent {

    private static final double BATTERY_CONSUPTION = 0.3;

    public ModularArms() {
        super();
        setActualConsume(BATTERY_CONSUPTION);
    }

    @Override
    public void activate() {
       if (this.isOn()) {
            System.out.println("Arms attached and ready for use");
       }
    }
    
}
