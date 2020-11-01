package pl.edu.agh.po.lab03;

import org.junit.jupiter.api.Test;
import pl.edu.agh.po.lab01.MoveDirection;
import pl.edu.agh.po.lab02.MapDirection;
import pl.edu.agh.po.lab02.Vector2d;
import pl.edu.agh.po.lab04.IWorldMap;
import pl.edu.agh.po.lab04.RectangularMap;

import static org.junit.jupiter.api.Assertions.*;

class AnimalTest {

    @Test
    void testMoveRight() {
        // given
        IWorldMap map = new RectangularMap(5,5);
        Animal animal = new Animal(map);
        // when
        animal.move(MoveDirection.RIGHT);
        // then
        assertTrue(animal.getOrientation() == MapDirection.EAST);
    }

    @Test
    void testMoveLeft() {
        // given
        IWorldMap map = new RectangularMap(5,5);
        Animal animal = new Animal(map);
        // when
        animal.move(MoveDirection.LEFT);
        // then
        assertTrue(animal.getOrientation() == MapDirection.WEST);
    }

    @Test
    void testMoveForward() {
        // given
        IWorldMap map = new RectangularMap(5,5);
        Animal animal = new Animal(map);
        // when
        animal.move(MoveDirection.FORWARD);
        // then
        assertTrue(animal.getPosition().equals(new Vector2d(2,3)));
    }

    @Test
    void testMoveForwardBoundary() {
        // given
        IWorldMap map = new RectangularMap(5,5);
        Animal animal = new Animal(map);
        // when
        for (int i=0;i<10;i++) {animal.move(MoveDirection.FORWARD);}
        animal.move(MoveDirection.RIGHT);
        for (int i=0;i<10;i++) {animal.move(MoveDirection.FORWARD);}
        // then
        assertTrue(animal.getPosition().equals(new Vector2d(4,4)));
    }

    @Test
    void testMoveBackward() {
        // given
        IWorldMap map = new RectangularMap(5,5);
        Animal animal = new Animal(map);
        // when
        animal.move(MoveDirection.BACKWARD);
        // then
        assertTrue(animal.getPosition().equals(new Vector2d(2,1)));
    }

    @Test
    void testMoveBackwardBoundary() {
        // given
        IWorldMap map = new RectangularMap(5,5);
        Animal animal = new Animal(map);
        // when
        for (int i=0;i<10;i++) {animal.move(MoveDirection.BACKWARD);}
        animal.move(MoveDirection.RIGHT);
        for (int i=0;i<10;i++) {animal.move(MoveDirection.BACKWARD);}
        // then
        assertTrue(animal.getPosition().equals(new Vector2d(0,0)));
    }
}