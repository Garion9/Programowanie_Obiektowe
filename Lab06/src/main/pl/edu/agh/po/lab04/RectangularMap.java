package pl.edu.agh.po.lab04;

import pl.edu.agh.po.lab02.Vector2d;
import pl.edu.agh.po.lab05.AbstractWorldMap;

import java.util.Optional;

public class RectangularMap extends AbstractWorldMap {
    private final Vector2d bottomBoundary;
    private final Vector2d topBoundary;

    public RectangularMap(int width, int height) {
        bottomBoundary = new Vector2d(0,0);
        topBoundary = new Vector2d(width - 1,height - 1);
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return (position.follows(bottomBoundary) && position.precedes(topBoundary) && !this.isOccupied(position));
    }

    @Override
    public Optional<Object> objectAt(Vector2d position) {
        if (animalsOnMap.containsKey(position)) {
            return Optional.of(animalsOnMap.get(position));
        }
        return Optional.empty();
    }

    @Override
    protected Vector2d getLowerLimit() {
        return this.bottomBoundary;
    }

    @Override
    protected Vector2d getUpperLimit() {
        return this.topBoundary;
    }
}
