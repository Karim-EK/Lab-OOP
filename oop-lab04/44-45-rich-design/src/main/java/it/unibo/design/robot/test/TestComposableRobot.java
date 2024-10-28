package it.unibo.design.robot.test;

import it.unibo.design.robot.api.CommandableComponent;
import it.unibo.design.robot.api.ModularRobot;
import it.unibo.design.robot.impl.AbstractComponent;
import it.unibo.design.robot.impl.AtomicBattery;
import it.unibo.design.robot.impl.BaseRobot;
import it.unibo.design.robot.impl.BorderNavigator;
import it.unibo.design.robot.impl.ModularArms;

/**
 * Utility class for testing composable robots
 */
public final class TestComposableRobot {

    private static final int CYCLES = 200;

    private TestComposableRobot() { }

    public static void main(final String[] args) {
        final ModularRobot r0 = new BaseRobot("Evangelion Unit 01");
        final AbstractComponent navi = new BorderNavigator();
        final AbstractComponent battery = new AtomicBattery();
        final CommandableComponent arm1 = new ModularArms();
        final CommandableComponent arm2 = new ModularArms();
        
        
        r0.attachComponent(navi);
        r0.attachComponent(battery);
        r0.attachComponent(arm1);
        r0.attachComponent(arm2);
        
        
        navi.turnOn();
        arm1.turnOn();
        arm2.turnOn();
         
        for (int i = 0; i < CYCLES; i++) {
            if (r0.getBatteryLevel() < BaseRobot.BATTERY_FULL / 2) {
                battery.turnOn();
            } else {
                battery.turnOff();
            }
            arm1.sendCommand(arm1.availableCommands()[i % arm1.availableCommands().length]);
            arm2.sendCommand(arm2.availableCommands()[i % arm2.availableCommands().length]);
            r0.activateComponents();
        }
         
        r0.detachComponent(arm1);
        r0.detachComponent(arm2);
        
        r0.activateComponents();
        r0.activateComponents();
    }
}
