package pl.edu.agh.po.lab02;

public class Animal {
    private MapDirection orientation;
    private Vector2d position;

    //default constructor
    public Animal() {
        this.orientation = MapDirection.NORTH;
        this.position = new Vector2d(2,2);
    }

    //custom constructor
    public Animal(MapDirection facing, Vector2d position) {
        this.orientation = facing;
        this.position = position;
    }

    public MapDirection getOrientation() {
        return this.orientation;
    }

    public Vector2d getPosition() {
        return this.position;
    }

    public String toString() {
        return "pozycja: " + this.position + " ; orientacja: " + this.orientation;
    }

    public void move(MoveDirection direction) {
        switch (direction) {
            case RIGHT -> this.orientation = this.orientation.next();
            case LEFT -> this.orientation = this.orientation.previous();
            case FORWARD -> {
                Vector2d step = this.orientation.toUnitVector();
                if ((this.position.add(step).precedes(new Vector2d(0,0))) && (this.position.add(step).follows(new Vector2d(4,4)))) {
                    this.position = this.position.add(step);
                }
            }
            case BACKWARD -> {
                Vector2d step = this.orientation.toUnitVector();
                if ((this.position.subtract(step).precedes(new Vector2d(0,0))) && (this.position.subtract(step).follows(new Vector2d(4,4)))) {
                    this.position = this.position.subtract(step);
                }
            }
        }
    }

    // zrobione do punktu 4 wlacznie
}
