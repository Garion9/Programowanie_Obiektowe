package pl.edu.agh.po.lab03;

import pl.edu.agh.po.lab01.MoveDirection;
import pl.edu.agh.po.lab02.MapDirection;
import pl.edu.agh.po.lab02.Vector2d;
import pl.edu.agh.po.lab04.IWorldMap;

public class Animal {
    private MapDirection orientation;
    private Vector2d position;
    private IWorldMap map;

    //default constructor (old version)
    public Animal() {
        this.orientation = MapDirection.NORTH;
        this.position = new Vector2d(2,2);
    }

    //default constructor
    public Animal(IWorldMap map) {
        this.orientation = MapDirection.NORTH;
        this.position = new Vector2d(2,2);
        this.map = map;
    }

    //custom constructor
    public Animal(IWorldMap map, Vector2d position) {
        this.orientation = MapDirection.NORTH;
        this.position = position;
        this.map = map;
    }

    //custom-er constructor
    public Animal(IWorldMap map, Vector2d position, MapDirection orientation) {
        this.orientation = orientation;
        this.position = position;
        this.map = map;
    }

    public MapDirection getOrientation() { return this.orientation; }

    public Vector2d getPosition() { return this.position; }

    //public String toString() { return "pozycja: " + this.position + " ; orientacja: " + this.orientation; }

    public String toString() {
        return switch (this.orientation) {
            case NORTH -> "^";
            case SOUTH -> "v";
            case EAST -> ">";
            case WEST -> "<";
        };
    }

    private void moveIfPossible(Vector2d step) {
        if (this.map.canMoveTo(this.position.add(step))) {
            this.position = this.position.add(step);
        }
    }

    public void move(MoveDirection direction) {
        switch (direction) {
            case RIGHT -> this.orientation = this.orientation.next();
            case LEFT -> this.orientation = this.orientation.previous();
            case FORWARD -> this.moveIfPossible(this.orientation.toUnitVector());
            case BACKWARD -> this.moveIfPossible(this.orientation.toUnitVector().opposite());
        }
    }
}
