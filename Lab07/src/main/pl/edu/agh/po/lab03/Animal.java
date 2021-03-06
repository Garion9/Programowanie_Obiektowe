package pl.edu.agh.po.lab03;

import pl.edu.agh.po.lab01.MoveDirection;
import pl.edu.agh.po.lab02.MapDirection;
import pl.edu.agh.po.lab02.Vector2d;
import pl.edu.agh.po.lab04.IWorldMap;
import pl.edu.agh.po.lab05.AbstractWorldMapElement;
import pl.edu.agh.po.lab07.IPositionChangeObserver;
import pl.edu.agh.po.lab07.IPositionChangedPublisher;

import java.util.ArrayList;
import java.util.List;

public class Animal extends AbstractWorldMapElement implements IPositionChangedPublisher {
    private MapDirection orientation;
    private IWorldMap map;
    private List<IPositionChangeObserver> observers = new ArrayList<IPositionChangeObserver>();

    //default constructor
    public Animal(IWorldMap map) { this(map, new Vector2d(2,2), MapDirection.NORTH); }

    //custom constructor
    public Animal(IWorldMap map, Vector2d position) { this(map, position, MapDirection.NORTH); }

    //custom-er constructor
    public Animal(IWorldMap map, Vector2d position, MapDirection orientation) {
        this.orientation = orientation;
        this.position = position;
        this.map = map;
    }

    public Vector2d getPosition() { return this.position; }

    public MapDirection getOrientation() { return this.orientation; }

    @Override
    public String toString() {
        return switch (this.orientation) {
            case NORTH -> "^";
            case SOUTH -> "v";
            case EAST -> ">";
            case WEST -> "<";
        };
    }

    @Override
    public boolean isBlocking() { return true; }

    private void moveIfPossible(Vector2d step) {
        if (this.map.canMoveTo(this.position.add(step))) {
            Vector2d oldPosition = this.position;
            this.position = this.position.add(step);
            Vector2d newPosition = this.position;
            this.positionChanged(oldPosition, newPosition);
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

    @Override
    public void addObserver(IPositionChangeObserver observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(IPositionChangeObserver observer) {
        observers.remove(observer);
    }

    private void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        for (IPositionChangeObserver observer : observers) {
            observer.positionChanged(this, oldPosition, newPosition);
        }
    }
}
