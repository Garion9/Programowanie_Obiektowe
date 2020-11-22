package pl.edu.agh.po.lab05;

import pl.edu.agh.po.lab02.Vector2d;


import java.util.*;

import static java.lang.Math.sqrt;

public class Grassfield extends AbstractWorldMap {
    private int quantity;
    protected final Map<Vector2d , Grass> grassOnMap = new LinkedHashMap<Vector2d , Grass>();


    public Grassfield(int quantity){
        this.quantity = quantity;
        Random generator = new Random();
        int i = 0;
        while (i<quantity) {
            Grass generatedGrass = new Grass(new Vector2d(generator.nextInt((int)sqrt(quantity*10)) , generator.nextInt((int)sqrt(quantity*10))));
            if (!grassOnMap.containsKey(generatedGrass.getPosition())) {
                grassOnMap.put(generatedGrass.getPosition(),generatedGrass);
                i++;
                this.boundaries.add(generatedGrass);
            }
        }
    }

    @Override
    public boolean canMoveTo(Vector2d position) { return !(isOccupied(position) && ((AbstractWorldMapElement)objectAt(position).get()).isBlocking()); }

    @Override
    public Optional<Object> objectAt(Vector2d position) {
        if (animalsOnMap.containsKey(position)) {
            return Optional.of(animalsOnMap.get(position));
        }
        if (grassOnMap.containsKey(position)) {
            return Optional.of(grassOnMap.get(position));
        }
        return Optional.empty();
    }

    @Override
    protected Vector2d getLowerLimit() {
        return this.boundaries.bottomBoundary();
    }

    @Override
    protected Vector2d getUpperLimit() {
        return this.boundaries.topBoundary();
    }
}
