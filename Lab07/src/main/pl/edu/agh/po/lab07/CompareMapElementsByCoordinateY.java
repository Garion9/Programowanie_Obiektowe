package pl.edu.agh.po.lab07;

import pl.edu.agh.po.lab05.IMapElement;

import java.util.Comparator;

public class CompareMapElementsByCoordinateY implements Comparator<IMapElement> {
    public int compare (IMapElement first, IMapElement second) {
        if (first.getPosition().equals(second.getPosition())) {
            if (!first.isBlocking() && second.isBlocking()) return 1;
            else if (first.isBlocking() && !second.isBlocking()) return -1;
            else return 0;
        }
        if(first.getPosition().y == second.getPosition().y) {
            return first.getPosition().x - second.getPosition().x;
        }
        return first.getPosition().y - second.getPosition().y;
    }
}
