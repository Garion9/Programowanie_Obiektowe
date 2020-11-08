package pl.edu.agh.po.lab05;

import pl.edu.agh.po.lab02.Vector2d;
import pl.edu.agh.po.lab03.Animal;

import java.util.*;

import static java.lang.Math.sqrt;

public class Grassfield extends AbstractWorldMap {
    private int quantity;


    public Grassfield(int quantity){
        this.quantity = quantity;
        Random generator = new Random();
        int i = 0;
        while (i<quantity) {
            Grass generatedGrass = new Grass(new Vector2d(generator.nextInt((int)sqrt(quantity*10)) , generator.nextInt((int)sqrt(quantity*10))));
            if (!elementsOnMap.contains(generatedGrass)) {
                elementsOnMap.add(generatedGrass);
                i++;
            }
            
        }
    }

    @Override
    public boolean canMoveTo(Vector2d position) { return !(isOccupied(position) && objectAt(position).get() instanceof Animal); }

    @Override
    public Optional<Object> objectAt(Vector2d position) {
        Animal animalAtPosition = null;
        boolean animalFound = false;
        Grass grassAtPosition = null;
        boolean grassFound = false;
        for (AbstractWorldMapElement element : elementsOnMap) {
            if (element.getPosition().equals(position)) {
                if (element instanceof Animal) {
                    animalAtPosition = (Animal) element;
                    animalFound = true;
                }
                else if (element instanceof Grass) {
                    grassAtPosition = (Grass) element;
                    grassFound = true;
                }
            }
        }
        if (animalFound) return Optional.of(animalAtPosition);
        else if (grassFound) return Optional.of(grassAtPosition);
        else return Optional.empty();
    }

    @Override
    protected Vector2d getLowerLimit() {
        Vector2d bottomBoundary = elementsOnMap.get(0).getPosition();
        for (AbstractWorldMapElement element : elementsOnMap) {
            bottomBoundary = bottomBoundary.lowerLeft(element.getPosition());
        }
        return bottomBoundary;
    }

    @Override
    protected Vector2d getUpperLimit() {
        Vector2d topBoundary = elementsOnMap.get(0).getPosition();
        for (AbstractWorldMapElement element : elementsOnMap) {
            topBoundary = topBoundary.upperRight(element.getPosition());
        }
        return topBoundary;
    }
}
