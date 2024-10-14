package it.unibo.design.robot.impl;

public class AtomicBattery extends AbstractComponent {

    private static final double BATTERY_CONSUPTION = 0.00001;

    public AtomicBattery() {
        this.setActualConsume(BATTERY_CONSUPTION);
    }

    @Override
    public void activate() {
        if (isOperational()) {
            if (this.getRobot().getBatteryLevel() >= 50) {
                System.out.println("Attivo batteria atomica..");
                this.getRobot().recharge();
            }
        }
    }
}
