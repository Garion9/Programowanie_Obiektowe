package pl.edu.agh.po.lab02;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class WorldTest {
    @Test
    void testIntegration1() {
        // given
        Animal pet = new Animal();
        String[] directions = {"r", "x", "forward", "don't move", "forward", "left", "l", "left", "b", "move"};
        List<MoveDirection> parsedSteps = OptionsParser.parse(directions);
        for(MoveDirection step : parsedSteps) {
            pet.move(step);
        }
        // when
        MapDirection resultOrientation = MapDirection.SOUTH;
        Vector2d resultPosition = new Vector2d(4,3);
        boolean resultBounds = pet.getPosition().precedes(new Vector2d(0,0)) && pet.getPosition().follows(new Vector2d(4,4));
        List<MoveDirection> resultSteps = Arrays.asList(MoveDirection.RIGHT,MoveDirection.FORWARD,MoveDirection.FORWARD,MoveDirection.LEFT,MoveDirection.LEFT,MoveDirection.LEFT,MoveDirection.BACKWARD);
        // then
        assertEquals(resultOrientation, pet.getOrientation());
        assertEquals(resultPosition, pet.getPosition());
        assertTrue(resultBounds);
        assertEquals(resultSteps, parsedSteps);
    }

    @Test
    void testIntegration2() {
        // given
        Animal pet = new Animal();
        String[] directions = {"go", "run", "To infinity and beyond!", "just move already", "f", "left", "forward", "right", "f", "r", "forward", "f", "f", "l", "forward", "l", "f", "left"};
        List<MoveDirection> parsedSteps = OptionsParser.parse(directions);
        for(MoveDirection step : parsedSteps) {
            pet.move(step);
        }
        // when
        MapDirection resultOrientation = MapDirection.SOUTH;
        Vector2d resultPosition = new Vector2d(3,4);
        boolean resultBounds = pet.getPosition().precedes(new Vector2d(0,0)) && pet.getPosition().follows(new Vector2d(4,4));
        List<MoveDirection> resultSteps = Arrays.asList(MoveDirection.FORWARD,MoveDirection.LEFT,MoveDirection.FORWARD,MoveDirection.RIGHT,MoveDirection.FORWARD,MoveDirection.RIGHT, MoveDirection.FORWARD, MoveDirection.FORWARD, MoveDirection.FORWARD, MoveDirection.LEFT, MoveDirection.FORWARD, MoveDirection.LEFT, MoveDirection.FORWARD, MoveDirection.LEFT);
        // then
        assertEquals(resultOrientation, pet.getOrientation());
        assertEquals(resultPosition, pet.getPosition());
        assertTrue(resultBounds);
        assertEquals(resultSteps, parsedSteps);
    }

    @Test
    void testIntegration3() {
        // given
        Animal pet = new Animal();
        String[] directions = {"f", "ahead", "forward", "further", "f", "f", "turn around", "left twice", "left", "left", "go", "f", "not left", "right", "forward", "f", "f", "forward"};
        List<MoveDirection> parsedSteps = OptionsParser.parse(directions);
        for(MoveDirection step : parsedSteps) {
            pet.move(step);
        }
        // when
        MapDirection resultOrientation = MapDirection.WEST;
        Vector2d resultPosition = new Vector2d(0,3);
        boolean resultBounds = pet.getPosition().precedes(new Vector2d(0,0)) && pet.getPosition().follows(new Vector2d(4,4));
        List<MoveDirection> resultSteps = Arrays.asList(MoveDirection.FORWARD, MoveDirection.FORWARD, MoveDirection.FORWARD, MoveDirection.FORWARD, MoveDirection.LEFT, MoveDirection.LEFT, MoveDirection.FORWARD, MoveDirection.RIGHT, MoveDirection.FORWARD, MoveDirection.FORWARD, MoveDirection.FORWARD, MoveDirection.FORWARD);
        // then
        assertEquals(resultOrientation, pet.getOrientation());
        assertEquals(resultPosition, pet.getPosition());
        assertTrue(resultBounds);
        assertEquals(resultSteps, parsedSteps);
    }

    @Test
    void testIntegration4() {
        // given
        Animal pet = new Animal();
        String[] directions = {"ff", "fforward", "f f", "right left", "forwrd", "frwrd", "r f l b", "frowadr"};
        List<MoveDirection> parsedSteps = OptionsParser.parse(directions);
        for(MoveDirection step : parsedSteps) {
            pet.move(step);
        }
        // when
        MapDirection resultOrientation = MapDirection.NORTH;
        Vector2d resultPosition = new Vector2d(2,2);
        boolean resultBounds = pet.getPosition().precedes(new Vector2d(0,0)) && pet.getPosition().follows(new Vector2d(4,4));
        List<MoveDirection> resultSteps = Arrays.asList();
        // then
        assertEquals(resultOrientation, pet.getOrientation());
        assertEquals(resultPosition, pet.getPosition());
        assertTrue(resultBounds);
        assertEquals(resultSteps, parsedSteps);
    }

}