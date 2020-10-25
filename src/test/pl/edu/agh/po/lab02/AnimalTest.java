package pl.edu.agh.po.lab02;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AnimalTest {

    @Test
    void testMoveRight() {
        // given
        Animal animal = new Animal();
        // when
        animal.move(MoveDirection.RIGHT);
        // then
        assertTrue(animal.getOrientation() == MapDirection.EAST);
    }

    @Test
    void testMoveLeft() {
        // given
        Animal animal = new Animal();
        // when
        animal.move(MoveDirection.LEFT);
        // then
        assertTrue(animal.getOrientation() == MapDirection.WEST);
    }

    @Test
    void testMoveForward() {
        // given
        Animal animal = new Animal();
        // when
        animal.move(MoveDirection.FORWARD);
        // then
        assertTrue(animal.getPosition().equals(new Vector2d(2,3)));
    }

    @Test
    void testMoveForwardBoundary() {
        // given
        Animal animal = new Animal();
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
        Animal animal = new Animal();
        // when
        animal.move(MoveDirection.BACKWARD);
        // then
        assertTrue(animal.getPosition().equals(new Vector2d(2,1)));
    }

    @Test
    void testMoveBackwardBoundary() {
        // given
        Animal animal = new Animal();
        // when
        for (int i=0;i<10;i++) {animal.move(MoveDirection.BACKWARD);}
        animal.move(MoveDirection.RIGHT);
        for (int i=0;i<10;i++) {animal.move(MoveDirection.BACKWARD);}
        // then
        assertTrue(animal.getPosition().equals(new Vector2d(0,0)));
    }
}