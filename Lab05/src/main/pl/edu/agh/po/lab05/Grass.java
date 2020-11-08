package pl.edu.agh.po.lab05;

import pl.edu.agh.po.lab02.Vector2d;

public class Grass extends AbstractWorldMapElement{

    public Grass(Vector2d position) { this.position = position; }

    @Override
    public String toString() {
        return "*";
    }

    @Override
    public boolean equals(Object other) {
        if (this == other)
            return true;
        if (!(other instanceof Grass))
            return false;
        Grass that = (Grass) other;
        return this.getPosition().equals(that.getPosition());
    }
}
