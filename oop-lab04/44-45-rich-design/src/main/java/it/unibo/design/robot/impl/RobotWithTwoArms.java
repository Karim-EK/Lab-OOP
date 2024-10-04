package it.unibo.design.robot.impl;

import it.unibo.design.robot.api.RobotWithArms;

public class RobotWithTwoArms extends BaseRobot implements RobotWithArms {

    final static double ENERGY_CONSUMPTION_WHILE_HOLDING_1_OBJECT = 1.3;
    final static double ENERGY_CONSUMPTION_WHILE_HOLDING_2_OBJECTS = 1.4;

    final BasicArm leftArm;
    final BasicArm rightArm;
    int objectsHolding;

    public RobotWithTwoArms(final String robotName) {
        super(robotName);
        this.objectsHolding = 0;
        this.leftArm = new BasicArm("leftArm");
        this.rightArm = new BasicArm("rightArm");
    }

    @Override
    public boolean pickUp() {
        // // if is not holding anything, grab with left arm
        // if (this.objectsHolding == 0) {
        //     properlyGrab(leftArm);
        //     return true;
        // }
        // // if one arm is free it's the right
        // if (this.objectsHolding == 1) {
        //     properlyGrab(rightArm);
        //     return true;
        // }
        // // if both are busy
        // if (this.objectsHolding > 1) {
        //     return false;
        // }

        switch (this.objectsHolding) {
            case 0:
                properlyGrab(this.leftArm);
                return true;
            case 1:
                properlyGrab(this.rightArm);
                return true;
            case 2:
                return false;             
            default:
                return false;
        }
    }

    @Override
    public boolean dropDown() {
        switch (this.objectsHolding) {
            case 2:
                properlyDrop(this.rightArm);
                return true;
            case 1:
                properlyDrop(this.leftArm);
                return true;
            case 0:
                return false;
            default:
                return false;
        }
    }

    @Override
    public int getCarriedItemsCount() {
        return this.objectsHolding;
    }

    private void properlyGrab(final BasicArm arm) {
        arm.grab();
        this.increaseObjects();
        this.consumeBattery(BasicArm.getConsumption4Pickup());
    }

    private void properlyDrop(final BasicArm arm) {
        arm.dropDown();
        this.decreseObjects();
        this.consumeBattery(BasicArm.getConsumption4Dropdown());
    }

    private void increaseObjects() {
        this.objectsHolding++;
    }

    private void decreseObjects() {
        this.objectsHolding--;
    }
    
    @Override
    protected double getBatteryRequirementForMovement() {
        switch (objectsHolding) {
            case 0:
                return super.getBatteryRequirementForMovement();
            case 1:
                return ENERGY_CONSUMPTION_WHILE_HOLDING_1_OBJECT;
            case 2:
                return ENERGY_CONSUMPTION_WHILE_HOLDING_2_OBJECTS;
            default:
                return super.getBatteryRequirementForMovement();
        }
    }
}
