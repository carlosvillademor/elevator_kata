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

    public int getFloor() {
        return this.floor;
    }

    public int getDirection() {
        return this.direction;
    }

    public boolean isStationary() {
        return this.direction == 0;
    }

    public int distanceToFloor(int floor) {
        return abs(floor - this.floor);
    }
}