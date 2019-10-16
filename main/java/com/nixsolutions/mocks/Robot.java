package com.nixsolutions.mocks;

public class Robot {
    private double xCoordinate = 0.0;

    private boolean turnLeft = false;
    private boolean turnRight = false;

    public void setxCoordinate(double xCoordinate) {
        this.xCoordinate = xCoordinate;
    }

    public boolean isTurnLeft() {
        return turnLeft;
    }

    public void setTurnLeft(boolean turnLeft) {
        this.turnLeft = turnLeft;
    }

    public boolean isTurnRight() {
        return turnRight;
    }

    public void setTurnRight(boolean turnRight) {
        this.turnRight = turnRight;
    }

    public void stepForward() {
        if (turnLeft) {
            xCoordinate -= 0.1;
        }
        if (turnRight) {
            xCoordinate += 0.1;
        }
    }

    public double getxCoordinate() {
        return xCoordinate;
    }
}
