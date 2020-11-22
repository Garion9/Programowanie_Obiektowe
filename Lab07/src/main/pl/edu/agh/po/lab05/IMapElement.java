package pl.edu.agh.po.lab05;

import pl.edu.agh.po.lab02.Vector2d;

public interface IMapElement {
    /**
     * Get the map position of a given map element.
     *
     * @return Position of the element on the map.
     */
    Vector2d getPosition();

    boolean isBlocking();


}