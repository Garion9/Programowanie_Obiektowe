package pl.edu.agh.po.lab05;

import org.junit.jupiter.api.Test;
import pl.edu.agh.po.lab01.MoveDirection;
import pl.edu.agh.po.lab02.MapDirection;
import pl.edu.agh.po.lab02.Vector2d;
import pl.edu.agh.po.lab03.Animal;
import pl.edu.agh.po.lab03.OptionsParser;
import pl.edu.agh.po.lab04.IWorldMap;
import pl.edu.agh.po.lab04.RectangularMap;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RectangularMapTest {

    @Test
    void testCanMoveToRegular() {
        // given
        IWorldMap map = new RectangularMap(10,10);
        // when

        // then
        assertTrue(map.canMoveTo(new Vector2d(6,7)));
    }

    @Test
    void testCanMoveToOutOfBounds() {
        // given
        IWorldMap map = new RectangularMap(10,10);
        // when

        // then
        assertFalse(map.canMoveTo(new Vector2d(-8,17)));
    }

    @Test
    void testCanMoveToAlreadyOccupied() {
        // given
        IWorldMap map = new RectangularMap(10,10);
        // when
        map.place(new Animal(map, new Vector2d(5,5)));
        // then
        assertFalse(map.canMoveTo(new Vector2d(5,5)));
    }

    @Test
    void testPlaceRegular() {
        // given
        IWorldMap map = new RectangularMap(10,10);
        // when
        // then
        assertTrue(map.place(new Animal(map, new Vector2d(5,5))));
    }

    @Test
    void testPlaceOutOfBounds() {
        // given
        IWorldMap map = new RectangularMap(10,10);
        // when
        // then
        assertFalse(map.place(new Animal(map, new Vector2d(-8,17))));
    }

    @Test
    void testPlaceAlreadyOccupied() {
        // given
        IWorldMap map = new RectangularMap(10,10);
        // when
        map.place(new Animal(map, new Vector2d(7,8)));
        // then
        assertFalse(map.place(new Animal(map, new Vector2d(7,8))));
    }

    @Test
    void testRunSingleAnimal() {
        // given
        IWorldMap map = new RectangularMap(10,10);
        Animal animal = new Animal(map, new Vector2d(7,8), MapDirection.NORTH);
        map.place(animal);
        String[] directions = {"f","f","f","f","r","f","f","f","f","f","r","f","f","r","f","f"};
        List<MoveDirection> parsedDirections = OptionsParser.parse(directions);
        // when
        map.run(parsedDirections);
        // then
        assertEquals(animal.getPosition(), new Vector2d(7,7));
    }

    @Test
    void testRunTwoAnimals() {
        // given
        IWorldMap map = new RectangularMap(7,7);
        Animal animal1 = new Animal(map, new Vector2d(3,3), MapDirection.NORTH);
        Animal animal2 = new Animal(map, new Vector2d(4,4), MapDirection.SOUTH);
        map.place(animal1);
        map.place(animal2);
        String[] directions = {"r","f", "f","r", "l","f", "l","f", "f","f", "f","f", "l","f", "f","f"};
        List<MoveDirection> parsedDirections = OptionsParser.parse(directions);
        // when
        map.run(parsedDirections);
        // then
        assertEquals(animal1.getPosition(), new Vector2d(1,2));
        assertEquals(animal2.getPosition(), new Vector2d(1,3));
    }

    @Test
    void isOccupiedRegular() {
        // given
        IWorldMap map = new RectangularMap(7,7);
        // when
        map.place(new Animal(map, new Vector2d(3,3)));
        // then
        assertTrue(map.isOccupied(new Vector2d(3,3)));
    }

    @Test
    void isOccupiedOutOfBounds() {
        // given
        IWorldMap map = new RectangularMap(7,7);
        // when
        map.place(new Animal(map, new Vector2d(13,14)));
        // then
        assertFalse(map.isOccupied(new Vector2d(13,14)));
    }

    @Test
    void objectAtIsAnAnimal() {
        // given
        IWorldMap map = new RectangularMap(7,7);
        Animal animal = new Animal(map, new Vector2d(5,5), MapDirection.NORTH);
        // when
        map.place(animal);
        // then
        assertEquals(animal,map.objectAt(new Vector2d(5,5)).get());
    }

    @Test
    void objectAtIsNotAnAnimal() {
        // given
        IWorldMap map = new RectangularMap(7,7);
        Animal animal = new Animal(map, new Vector2d(5,5), MapDirection.NORTH);
        // when
        map.place(animal);
        // then
        assertFalse(map.objectAt(new Vector2d(4,6)).isPresent());
    }
}