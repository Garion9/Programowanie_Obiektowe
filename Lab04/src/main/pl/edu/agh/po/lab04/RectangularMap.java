package pl.edu.agh.po.lab04;

import pl.edu.agh.po.lab01.MoveDirection;
import pl.edu.agh.po.lab02.Vector2d;
import pl.edu.agh.po.lab03.Animal;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class RectangularMap implements IWorldMap {
    private List<Animal> animals;
    private final Vector2d bottomBoundary;
    private final Vector2d topBoundary;

    public RectangularMap(int width, int height) {
        this.animals = new ArrayList<Animal>();
        bottomBoundary = new Vector2d(0,0);
        topBoundary = new Vector2d(width - 1,height - 1);
    }

    public boolean canMoveTo(Vector2d position) {
        return (position.follows(bottomBoundary) && position.precedes(topBoundary) && !this.isOccupied(position));
    }

    public boolean place(Animal animal) {
        if (this.canMoveTo(animal.getPosition())) {
            this.animals.add(animal);
            return true;
        }
        else return false;
    }

    public void run(List<MoveDirection> directions) {
        int animalsLength = animals.toArray().length;
        int directionsLength = directions.toArray().length;
        for (int i = 0; i < directionsLength; i++) {
            animals.get(i % animalsLength).move(directions.get(i));
        }
    }

    public boolean isOccupied(Vector2d position) {
        return objectAt(position).isPresent();
    }

    public Optional<Object> objectAt(Vector2d position) {
        for (Animal animal : animals) {
            if (animal.getPosition().equals(position)) {
                return Optional.of(animal);
            }
        }
        // possibly additional loops for different objects present on the map
        return Optional.empty();
    }

    public String toString() {
        MapVisualizer visualizer = new MapVisualizer(this);
        return visualizer.draw(this.bottomBoundary, this.topBoundary);
    }
}
