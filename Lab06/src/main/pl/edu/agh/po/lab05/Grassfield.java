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
        else if (grassOnMap.containsKey(position)) {
            return Optional.of(grassOnMap.get(position));
        }
        else return Optional.empty();
    }

    @Override
    protected Vector2d getLowerLimit() {
        Set<Vector2d> positions = new HashSet<Vector2d>(grassOnMap.keySet());
        positions.addAll(animalsOnMap.keySet());
        List<Vector2d> positionsList = new ArrayList<Vector2d>(positions);
        Vector2d bottomBoundary = positionsList.get(0);
        for (Vector2d position : positionsList) {
            bottomBoundary = bottomBoundary.lowerLeft(position);
        }
        return bottomBoundary;
    }

    @Override
    protected Vector2d getUpperLimit() {
        Set<Vector2d> positions = new HashSet<Vector2d>(grassOnMap.keySet());
        positions.addAll(animalsOnMap.keySet());
        List<Vector2d> positionsList = new ArrayList<Vector2d>(positions);
        Vector2d topBoundary = positionsList.get(0);
        for (Vector2d position : positionsList) {
            topBoundary = topBoundary.upperRight(position);
        }
        return topBoundary;
    }
}
