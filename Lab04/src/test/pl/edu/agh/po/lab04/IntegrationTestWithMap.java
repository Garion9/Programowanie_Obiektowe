package pl.edu.agh.po.lab04;

import org.junit.jupiter.api.Test;
import pl.edu.agh.po.lab01.MoveDirection;
import pl.edu.agh.po.lab02.MapDirection;
import pl.edu.agh.po.lab02.Vector2d;
import pl.edu.agh.po.lab03.Animal;
import pl.edu.agh.po.lab03.OptionsParser;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class IntegrationTestWithMap {
    @Test
    void testIntegration1() {
        // given
        IWorldMap map = new RectangularMap(10,5);
        Animal animal1 = new Animal(map);
        Animal animal2 = new Animal(map, new Vector2d(3,4));
        map.place(animal1);
        map.place(animal2);
        String[] directions = {"f","b","r","l","f","f","r","r","f","f","f","f","f","f","f","f"};
        // when
        List<MoveDirection> parsedSteps = OptionsParser.parse(directions);
        map.run(parsedSteps);
        // then
        assertEquals(animal1.getPosition(), new Vector2d(2,0));
        assertEquals(animal1.getOrientation(),MapDirection.SOUTH);
        assertEquals(animal2.getPosition(), new Vector2d(3,4));
        assertEquals(animal2.getOrientation(),MapDirection.NORTH);
    }

    @Test
    void testIntegration2() {
        // given
        IWorldMap map = new RectangularMap(10,10);
        Animal animal1 = new Animal(map, new Vector2d(1,1));
        Animal animal2 = new Animal(map, new Vector2d(2,2));
        Animal animal3 = new Animal(map, new Vector2d(3,3));
        String[] directions1 = {"f","f","r","f","f","r","f","f","r","f","f","r","b","b","r","b","b","r","b","r","b","r"};
        String[] directions2 = {"f","r", "r","l", "f","b", "f","f", "l","f", "f","b", "b","f", "f","f"};
        String[] directions3 = {"f","b","r", "l","f","f", "r","r","f", "f","r","f", "f","f","f", "f","f","f", "f","f","f", "f","f","f", "f","f","f"};
        // when
        List<MoveDirection> parsedSteps1 = OptionsParser.parse(directions1);
        List<MoveDirection> parsedSteps2 = OptionsParser.parse(directions2);
        List<MoveDirection> parsedSteps3 = OptionsParser.parse(directions3);
        map.place(animal1);
        map.run(parsedSteps1);
        map.place(animal2);
        map.run(parsedSteps2);
        map.place(animal3);
        map.run(parsedSteps3);
        // then
        assertEquals(new Vector2d(2,9), animal1.getPosition());
        assertEquals(MapDirection.NORTH, animal1.getOrientation());
        assertEquals(new Vector2d(2,0), animal2.getPosition());
        assertEquals(MapDirection.SOUTH, animal2.getOrientation());
        assertEquals(new Vector2d(9,3), animal3.getPosition());
        assertEquals(MapDirection.EAST, animal3.getOrientation());
    }
}