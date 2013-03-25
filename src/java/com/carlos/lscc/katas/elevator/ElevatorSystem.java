package com.carlos.lscc.katas.elevator;

import java.util.ArrayList;
import java.util.List;

/**
 * User: Carlos Fernandez
 * Date: 23/03/2013
 */
public class ElevatorSystem {
    private int[][] elevators = new int[6][2];

    public ElevatorSystem(int floorElevator1, int directionElevator1, int floorElevator2, int directionElevator2, int floorElevator3, int directionElevator3, int floorElevator4, int directionElevator4, int floorElevator5, int directionElevator5, int floorElevator6, int directionElevator6) {
        elevators[0] = new int[]{floorElevator1, directionElevator1};
        elevators[1] = new int[]{floorElevator2, directionElevator2};
        elevators[2] = new int[]{floorElevator3, directionElevator3};
        elevators[3] = new int[]{floorElevator4, directionElevator4};
        elevators[4] = new int[]{floorElevator5, directionElevator5};
        elevators[5] = new int[]{floorElevator6, directionElevator6};
    }

    public int[][] showElevators() {
        return elevators;
    }

    public String findElevator(int floor, int direction) {
        for (int i=0; i<elevators.length; i++) {
            List stationaryElevators = new ArrayList();
            if(elevators[i][0]==floor && (elevators[i][1]==0 || (direction == 1? elevators[i][1] > 0 : elevators[i][1] < 0))) {
                return "Elevator " + (i+1);
            } else if(direction == 1 ? elevators[i][0] < floor && (elevators[i][0] + elevators[i][1] >= floor) : elevators[i][0] > floor && (elevators[i][0] + elevators[i][1] <= floor) ){
                return "Elevator " + (i+1);
            } else if(elevators[i][1] == 0) {
                int nearest = findNearestStationaryElevator(elevators, floor);
            }
        }
        return "Elevator 6";
    }

    private int findNearestStationaryElevator(int[][] elevators, int floor) {
        int nearest = -1;
//        for (int i=0; i < stationaryElevators.size(); i++) {
//            if(abs(stationaryElevators[i][0]-floor))
//        }
        return nearest;
    }

}