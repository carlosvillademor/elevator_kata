package com.carlos.lscc.katas.elevator;

import java.util.ArrayList;
import java.util.List;

/**
 * User: Carlos Fernandez
 * Date: 23/03/2013
 */
public class ElevatorSystem {
    private List<Elevator> elevators = new ArrayList<Elevator>();

    public ElevatorSystem(int floorElevator1, int directionElevator1, int floorElevator2, int directionElevator2,
                          int floorElevator3, int directionElevator3, int floorElevator4, int directionElevator4,
                          int floorElevator5, int directionElevator5, int floorElevator6, int directionElevator6) {
        elevators.add(createElevator(floorElevator1, directionElevator1));
        elevators.add(createElevator(floorElevator2, directionElevator2));
        elevators.add(createElevator(floorElevator3, directionElevator3));
        elevators.add(createElevator(floorElevator4, directionElevator4));
        elevators.add(createElevator(floorElevator5, directionElevator5));
        elevators.add(createElevator(floorElevator6, directionElevator6));
    }

    public String findElevator(int floor, int direction) {
        for (Elevator elevator : elevators) {
            if(elevator.isOnFloor(floor) && (elevator.isStationary() || elevator.isMovingInSameDirection(direction))) {
                return "Elevator " + (elevators.indexOf(elevator)+1);
            } else if(direction == 1 ? elevator.isBelowFloor(floor) && elevator.isGoingAtLeastToFloor(floor) :
                    elevator.isAboveFloor(floor) && (elevator.isGoingAtLeastToFloor(floor)) ){
                return "Elevator " + (elevators.indexOf(elevator)+1);
            }
        }
        int nearestStationaryElevator = findNearestStationaryElevator(elevators, floor);
        if(nearestStationaryElevator>-1){ return "Elevator " + (nearestStationaryElevator + 1); }
        return "No elevator";
    }

    private int findNearestStationaryElevator(List<Elevator> elevators, int floor) {
        int nearest = -1;
        int minimumDistance = 21;
        for (int i=0; i < elevators.size(); i++) {
            int distanceInFloors = elevators.get(i).distanceToFloor(floor);
            if(elevators.get(i).isStationary() && distanceInFloors < minimumDistance) {
                nearest = i;
                minimumDistance = distanceInFloors;
            }
        }
        return nearest;
    }

    private Elevator createElevator(int floor, int direction) {
        if(floor > 20) {throw new HighestFloorException();}
        if(floor < 1) {throw new LowestFloorException();}
        return new Elevator(floor, direction);
    }

    public Integer numberOfElevators() {
        return elevators.size();
    }
}