package pl.edu.agh.po.lab04;

import pl.edu.agh.po.lab02.Vector2d;
import pl.edu.agh.po.lab03.Animal;
import pl.edu.agh.po.lab05.AbstractWorldMap;
import pl.edu.agh.po.lab05.AbstractWorldMapElement;

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
        for (AbstractWorldMapElement element : elementsOnMap) {
            if (element.getPosition().equals(position)) {
                return Optional.of(element);
            }
        }
        // possibly additional loops for different objects present on the map
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
