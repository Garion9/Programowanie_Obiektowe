package pl.edu.agh.po.lab05;

import pl.edu.agh.po.lab01.MoveDirection;
import pl.edu.agh.po.lab02.Vector2d;
import pl.edu.agh.po.lab03.Animal;
import pl.edu.agh.po.lab04.IWorldMap;
import pl.edu.agh.po.lab04.MapVisualizer;
import pl.edu.agh.po.lab07.IPositionChangeObserver;
import pl.edu.agh.po.lab07.MapBoundary;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public abstract class AbstractWorldMap implements IWorldMap, IPositionChangeObserver {
    protected final Map<Vector2d , Animal> animalsOnMap = new LinkedHashMap<Vector2d , Animal>();
    protected final MapBoundary boundaries = new MapBoundary();

    @Override
    public boolean place(Animal animal) {
        if (this.canMoveTo(animal.getPosition())) {
            this.animalsOnMap.put(animal.getPosition() , animal);
            animal.addObserver(this);
            animal.addObserver(this.boundaries);
            this.boundaries.add(animal);
            return true;
        }
        else throw new IllegalArgumentException("Placing an animal on position: " + animal.getPosition() + " is not possible.");
    }

    @Override
    public void run(List<MoveDirection> directions) {
        List<Animal> movables = new ArrayList<Animal>(animalsOnMap.values());

        int animalsLength = movables.toArray().length;
        int directionsLength = directions.toArray().length;
        for (int i = 0; i < directionsLength; i++) {
            Animal currAnimal = movables.get(i % animalsLength);
            currAnimal.move(directions.get(i));
        }
    }

    @Override
    public boolean isOccupied(Vector2d position) { return objectAt(position).isPresent(); }

    abstract protected Vector2d getLowerLimit();

    abstract protected Vector2d getUpperLimit();

    @Override
    public String toString() {
        MapVisualizer visualizer = new MapVisualizer(this);
        return visualizer.draw(this.getLowerLimit(), this.getUpperLimit());
    }

    @Override
    public void positionChanged(IMapElement movedElement, Vector2d oldPosition, Vector2d newPosition) {
        animalsOnMap.remove(oldPosition);
        animalsOnMap.put(newPosition, (Animal) movedElement);
    }
}
