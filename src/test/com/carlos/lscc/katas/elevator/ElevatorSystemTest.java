package com.carlos.lscc.katas.elevator;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * User: Carlos Fernandez
 * Date: 23/03/2013
 */
public class ElevatorSystemTest {

    @Test
    public void shouldCreateElevatorSystem() {
        //Given
        int [][] expectedElevatorSystem = {{5,6}, {9,10}, {19,-12}, {19,-5}, {4,12}, {6,-3}};
        //When
        ElevatorSystem elevatorSystem = new ElevatorSystem(5,6,9,10,19,-12,19,-5,4,12,6,-3);
        //Then
        assertThat(elevatorSystem.showElevators(), is(expectedElevatorSystem));
    }

    @Test
    public void shouldChooseTheElevatorInTheSameFloorAndStationary() {
        //Given
        int floor = 5;
        int direction = 1;
        ElevatorSystem elevatorSystem = new ElevatorSystem(5,0,9,10,19,-12,19,-5,4,12,6,-3);
        //When
        String elevator = elevatorSystem.findElevator(floor, direction);
        //Then
        assertThat(elevator, is("Elevator 1"));
    }

    @Test
    public void shouldChooseTheElevatorInTheSameFloorAndMovingInTheSameDirection() {
        //Given
        int floor = 4;
        int direction = 1;
        ElevatorSystem elevatorSystem = new ElevatorSystem(5,-3,9,10,19,-12,19,-5,4,12,6,-3);
        //When
        String elevator = elevatorSystem.findElevator(floor, direction);
        //Then
        assertThat(elevator, is("Elevator 5"));
    }

    @Test
    public void shouldChooseTheElevatorAboveTheFloorWhereTheUserIsAndMovingInTheSameDirection() {
        //Given
        int floor = 11;
        int direction = 1;
        ElevatorSystem elevatorSystem = new ElevatorSystem(5,-3,9,10,19,-12,19,-5,4,12,6,-3);
        //When
        String elevator = elevatorSystem.findElevator(floor, direction);
        //Then
        assertThat(elevator, is("Elevator 2"));
    }

}