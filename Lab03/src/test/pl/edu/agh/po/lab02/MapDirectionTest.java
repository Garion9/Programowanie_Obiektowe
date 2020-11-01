package pl.edu.agh.po.lab02;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MapDirectionTest {

    @Test
    void nextFromNorth() {
        // given
        MapDirection mapdirection = MapDirection.NORTH;
        // when
        MapDirection result = mapdirection.next();
        // then
        assertEquals(MapDirection.EAST, result);
    }

    @Test
    void nextFromEast() {
        // given
        MapDirection mapdirection = MapDirection.EAST;
        // when
        MapDirection result = mapdirection.next();
        // then
        assertEquals(MapDirection.SOUTH, result);
    }

    @Test
    void nextFromSouth() {
        // given
        MapDirection mapdirection = MapDirection.SOUTH;
        // when
        MapDirection result = mapdirection.next();
        // then
        assertEquals(MapDirection.WEST, result);
    }

    @Test
    void nextFromWest() {
        // given
        MapDirection mapdirection = MapDirection.WEST;
        // when
        MapDirection result = mapdirection.next();
        // then
        assertEquals(MapDirection.NORTH, result);
    }

    @Test
    void previousFromNorth() {
        // given
        MapDirection mapdirection = MapDirection.NORTH;
        // when
        MapDirection result = mapdirection.previous();
        //then
        assertEquals(MapDirection.WEST, result);
    }

    @Test
    void previousFromWest() {
        // given
        MapDirection mapdirection = MapDirection.WEST;
        // when
        MapDirection result = mapdirection.previous();
        //then
        assertEquals(MapDirection.SOUTH, result);
    }

    @Test
    void previousFromSouth() {
        // given
        MapDirection mapdirection = MapDirection.SOUTH;
        // when
        MapDirection result = mapdirection.previous();
        //then
        assertEquals(MapDirection.EAST, result);
    }

    @Test
    void previousFromEast() {
        // given
        MapDirection mapdirection = MapDirection.EAST;
        // when
        MapDirection result = mapdirection.previous();
        //then
        assertEquals(MapDirection.NORTH, result);
    }
}
