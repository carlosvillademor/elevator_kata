package com.carlos.lscc.katas.elevator;

import static java.lang.Math.abs;

/**
 * User: Carlos Fernandez
 * Date: 25/03/2013
 */
public class Elevator {

    private final int direction;
    private final int floor;

    public Elevator(int floor, int direction) {
        this.floor = floor;
        this.direction = direction;
    }

    public boolean isStationary() {
        return this.direction == 0;
    }

    public int distanceToFloor(int floor) {
        return abs(floor - this.floor);
    }

    public boolean isOnFloor(int floor) {
        return this.floor == floor;
    }

    public boolean isMovingUp() {
        return this.direction > 0;
    }

    public boolean isMovingDown() {
        return this.direction < 0;
    }

    public boolean isMovingInSameDirection(int direction) {
        return (direction == 1 ? isMovingUp() : isMovingDown());
    }

    public int getFloor() {
        return floor;
    }

    public int getDirection() {
        return direction;
    }
}