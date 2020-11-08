package pl.edu.agh.po.lab05;

import pl.edu.agh.po.lab01.MoveDirection;
import pl.edu.agh.po.lab02.Vector2d;
import pl.edu.agh.po.lab03.Animal;
import pl.edu.agh.po.lab04.IWorldMap;
import pl.edu.agh.po.lab04.MapVisualizer;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractWorldMap implements IWorldMap {
    protected List<AbstractWorldMapElement> elementsOnMap = new ArrayList<AbstractWorldMapElement>();

    @Override
    public boolean place(Animal animal) {
        if (this.canMoveTo(animal.getPosition())) {
            this.elementsOnMap.add(animal);
            return true;
        }
        else return false;
    }

    @Override
    public void run(List<MoveDirection> directions) {
        List<Animal> animals = new ArrayList<Animal>();
        for (AbstractWorldMapElement element : elementsOnMap) {
            if(element instanceof Animal) {
                animals.add((Animal)element);
            }
        }
        int animalsLength = animals.toArray().length;
        int directionsLength = directions.toArray().length;
        for (int i = 0; i < directionsLength; i++) {
            animals.get(i % animalsLength).move(directions.get(i));
        }
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        return objectAt(position).isPresent();
    }

    protected Vector2d getLowerLimit() {
        Vector2d bottomBoundary = elementsOnMap.get(0).getPosition();
        for (AbstractWorldMapElement element : elementsOnMap) {
            bottomBoundary = bottomBoundary.lowerLeft(element.getPosition());
        }
        return bottomBoundary;
    }

    protected Vector2d getUpperLimit() {
        Vector2d topBoundary = elementsOnMap.get(0).getPosition();
        for (AbstractWorldMapElement element : elementsOnMap) {
            topBoundary = topBoundary.upperRight(element.getPosition());
        }
        return topBoundary;
    }

    @Override
    public String toString() {
        MapVisualizer visualizer = new MapVisualizer(this);
        return visualizer.draw(this.getLowerLimit(), this.getUpperLimit());
    }
}
