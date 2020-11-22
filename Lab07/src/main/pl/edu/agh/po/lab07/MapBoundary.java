package pl.edu.agh.po.lab07;

import pl.edu.agh.po.lab02.Vector2d;
import pl.edu.agh.po.lab05.IMapElement;

import java.util.ArrayList;
import java.util.List;

public class MapBoundary implements IPositionChangeObserver {
    private final List<IMapElement> elementsByX;
    private final List<IMapElement> elementsByY;

    public MapBoundary() {
        elementsByX = new ArrayList<>();
        elementsByY = new ArrayList<>();
    }

    public void add(IMapElement element) {
        elementsByX.add(element);
        elementsByX.sort(new CompareMapElementsByCoordinateX());
        elementsByY.add(element);
        elementsByY.sort(new CompareMapElementsByCoordinateY());
    }

    @Override
    public void positionChanged(IMapElement movedElement, Vector2d oldPosition, Vector2d newPosition) {
        if (elementsByX.get(0).getPosition().x == oldPosition.x || elementsByX.get(elementsByX.size()-1).getPosition().x == oldPosition.x) {
            elementsByX.sort(new CompareMapElementsByCoordinateX());
        }
        if (elementsByY.get(0).getPosition().y == oldPosition.y || elementsByY.get(elementsByY.size()-1).getPosition().y == oldPosition.y) {
            elementsByY.sort(new CompareMapElementsByCoordinateY());
        }
    }

    public Vector2d bottomBoundary(){
        return new Vector2d(this.elementsByX.get(0).getPosition().x,this.elementsByY.get(0).getPosition().y);
    }

    public Vector2d topBoundary() {
        return new Vector2d(this.elementsByX.get(elementsByX.size()-1).getPosition().x,this.elementsByY.get(elementsByY.size()-1).getPosition().y);
    }
}
