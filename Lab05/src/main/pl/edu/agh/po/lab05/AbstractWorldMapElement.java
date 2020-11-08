package pl.edu.agh.po.lab05;

import pl.edu.agh.po.lab02.Vector2d;

public abstract class AbstractWorldMapElement implements IMapElement {
    protected Vector2d position;

    @Override
    public Vector2d getPosition() { return this.position; }
}
