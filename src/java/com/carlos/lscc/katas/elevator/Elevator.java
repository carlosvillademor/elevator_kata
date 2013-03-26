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

    public boolean isBelowFloor(int floor) {
        return this.floor < floor;
    }

    public boolean isGoingAtLeastToFloor(int floor) {
        return this.floor < floor ? this.floor + this.direction >= floor : this.floor + this.direction <= floor;
    }

    public boolean isAboveFloor(int floor) {
        return this.floor > floor;
    }

    private boolean isGoingSameDirection(int direction) {
        return this.direction == direction;
    }

    @Override
    public boolean equals(Object other) {
        if(!(other instanceof Elevator)) {return false;}
        if(this == other) {return true; }
        return ((Elevator) other).distanceToFloor(this.floor) == 0 && ((Elevator) other).isGoingSameDirection(this.direction);
    }

}