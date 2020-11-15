package pl.edu.agh.po.lab05;

import pl.edu.agh.po.lab01.MoveDirection;
import pl.edu.agh.po.lab02.Vector2d;
import pl.edu.agh.po.lab03.Animal;
import pl.edu.agh.po.lab04.IWorldMap;
import pl.edu.agh.po.lab04.MapVisualizer;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public abstract class AbstractWorldMap implements IWorldMap {
    protected final Map<Vector2d , Animal> animalsOnMap = new LinkedHashMap<Vector2d , Animal>();

    @Override
    public boolean place(Animal animal) {
        if (this.canMoveTo(animal.getPosition())) {
            this.animalsOnMap.put(animal.getPosition() , animal);
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
            Vector2d prevPosition = currAnimal.getPosition();
            currAnimal.move(directions.get(i));
            if (!prevPosition.equals(currAnimal.getPosition())) {
                animalsOnMap.remove(prevPosition);
                animalsOnMap.put(currAnimal.getPosition(),currAnimal);
            }
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
}
