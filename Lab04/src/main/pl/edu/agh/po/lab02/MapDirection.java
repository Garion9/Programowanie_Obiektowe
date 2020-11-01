package pl.edu.agh.po.lab02;

public enum MapDirection {
    NORTH,
    SOUTH,
    WEST,
    EAST;

    public String toString() {
        switch(this) {
            case NORTH: return "Polnoc";
            case SOUTH: return "Poludnie";
            case WEST: return "Zachod";
            case EAST: return "Wschod";
            default: return null;
        }
    }

    public MapDirection next() {
        return switch(this) {
            case NORTH -> EAST;
            case SOUTH -> WEST;
            case WEST -> NORTH;
            case EAST -> SOUTH;
        };
    }

    public MapDirection previous() {
        return switch(this) {
            case NORTH -> WEST;
            case SOUTH -> EAST;
            case WEST -> SOUTH;
            case EAST -> NORTH;
        };
    }

    public Vector2d toUnitVector() {
        return switch(this) {
            case NORTH -> new Vector2d(0,1);
            case SOUTH -> new Vector2d(0,-1);
            case WEST -> new Vector2d(-1,0);
            case EAST -> new Vector2d(1,0);
        };
    }
}
