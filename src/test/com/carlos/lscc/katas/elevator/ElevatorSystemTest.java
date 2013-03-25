package com.carlos.lscc.katas.elevator;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

/**
 * User: Carlos Fernandez
 * Date: 23/03/2013
 */
public class ElevatorSystemTest {

    @Test
    public void shouldCreateElevatorSystemWithCorrectNumberOfElevators() {
        //Given/When
        ElevatorSystem elevatorSystem = new ElevatorSystem(5,6,9,10,19,-12,19,-5,4,12,6,-3);
        //Then
        assertThat(elevatorSystem.numberOfElevators(), is(6));
    }

    @Test
    (expected = HighestFloorException.class)
    public void shouldValidateThatHighestFloorIs20() {
        //Given/When
        new ElevatorSystem(5,6,9,10,19,-12,19,-5,4,12,21,-3);
        //Then
        fail("It should have thrown an Exception because highest floor possible is 20");
    }

    @Test
    (expected = LowestFloorException.class)
    public void shouldValidateThatLowestFloorIs1() {
        //Given/When
        new ElevatorSystem(5,6,9,10,19,-12,0,-5,4,12,20,-3);
        //Then
        fail("It should have thrown an Exception because lowest floor possible is 1");
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

    @Test
    public void shouldChooseTheElevatorStationaryNearerToTheFloorWhereTheUserIs() {
        //Given
        int floor = 15;
        int direction = 0;
        ElevatorSystem elevatorSystem = new ElevatorSystem(5,0,9,10,14,-12,13,-5,17,0,6,-3);
        //When
        String elevator = elevatorSystem.findElevator(floor, direction);
        //Then
        assertThat(elevator, is("Elevator 5"));
    }

}