package it.unibo.design.robot.impl;

import it.unibo.design.robot.api.CommandableComponent;

public class ModularArms extends AbstractComponent implements CommandableComponent {

    private static final double BATTERY_CONSUPTION = 0.3;
    private final String[] availableCommands = {"pick", "drop"};

    private boolean isCarryingObjects;

    public ModularArms() {
        super(BATTERY_CONSUPTION);
        this.isCarryingObjects = false;
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
        System.out.println("Picking up object...");
        isCarryingObjects = true;
    }

    public void drop() {
        System.out.println("Dropping object...");
        this.isCarryingObjects = false;
    }

    @Override
    public String[] availableCommands() {
        return this.availableCommands;
    }

    @Override
    public void sendCommand(String command) {
        final String parsedCommand = command.toLowerCase();
        if (parsedCommand.equals("pick") ) {
            pick();
        } else if (parsedCommand.equals("drop")) {
            drop();
        } else {
            System.out.println("Command not found");
        }
    }
}
