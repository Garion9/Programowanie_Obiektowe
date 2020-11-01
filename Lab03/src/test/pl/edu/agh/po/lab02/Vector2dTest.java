package pl.edu.agh.po.lab02;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Vector2dTest {

    @Test
    void testEqualsSameInstance() {
        // given
        Vector2d vector2d = new Vector2d(1,2);
        // when
        boolean result = vector2d.equals(vector2d);
        //then
        assertTrue(result);
    }

    @Test
    void testEqualsDifferentClass() {
        // given
        Vector2d vector2d = new Vector2d(1,2);
        MapDirection mapdir = MapDirection.NORTH;
        // when
        boolean result = vector2d.equals(mapdir);
        //then
        assertFalse(result);
    }

    @Test
    void testEqualsDifferentValues() {
        // given
        Vector2d one = new Vector2d(1,2);
        Vector2d another = new Vector2d(2,3);
        // when
        boolean result = one.equals(another);
        //then
        assertFalse(result);
    }

    @Test
    void testEqualsSameValues() {
        // given
        Vector2d one = new Vector2d (1,2);
        Vector2d another = new Vector2d(1,2);
        // when
        boolean result = one.equals(another);
        //then
        assertTrue(result);
    }

    @Test
    void testToString() {
        // given
        Vector2d vector2d = new Vector2d(1,2);
        // when
        String result = vector2d.toString();
        // then
        assertEquals("(1,2)",result);
    }

    @Test
    void testPrecedesEqualVectors() {
        // given
        Vector2d one = new Vector2d(3,4);
        Vector2d another = new Vector2d(3,4);
        // when
        boolean result = one.precedes(another);
        // then
        assertTrue(result);
    }

    @Test
    void testPrecedesLeft() {
        // given
        Vector2d one = new Vector2d(3,4);
        Vector2d another = new Vector2d(2,4);
        // when
        boolean result = one.precedes(another);
        // then
        assertTrue(result);
    }

    @Test
    void testPrecedesBottom() {
        // given
        Vector2d one = new Vector2d(3,4);
        Vector2d another = new Vector2d(3,3);
        // when
        boolean result = one.precedes(another);
        // then
        assertTrue(result);
    }

    @Test
    void testPrecedesRight() {
        // given
        Vector2d one = new Vector2d(3,4);
        Vector2d another = new Vector2d(4,4);
        // when
        boolean result = one.precedes(another);
        // then
        assertFalse(result);
    }

    @Test
    void testPrecedesUp() {
        // given
        Vector2d one = new Vector2d(3,4);
        Vector2d another = new Vector2d(3,5);
        // when
        boolean result = one.precedes(another);
        // then
        assertFalse(result);
    }

    @Test
    void testFollowsEqualVectors() {
        // given
        Vector2d one = new Vector2d(3,4);
        Vector2d another = new Vector2d(3,4);
        // when
        boolean result = one.follows(another);
        // then
        assertTrue(result);
    }

    @Test
    void testFollowsLeft() {
        // given
        Vector2d one = new Vector2d(3,4);
        Vector2d another = new Vector2d(2,4);
        // when
        boolean result = one.follows(another);
        // then
        assertFalse(result);
    }

    @Test
    void testFollowsBottom() {
        // given
        Vector2d one = new Vector2d(3,4);
        Vector2d another = new Vector2d(3,3);
        // when
        boolean result = one.follows(another);
        // then
        assertFalse(result);
    }

    @Test
    void testFollowsRight() {
        // given
        Vector2d one = new Vector2d(3,4);
        Vector2d another = new Vector2d(4,4);
        // when
        boolean result = one.follows(another);
        // then
        assertTrue(result);
    }

    @Test
    void testFollowsUp() {
        // given
        Vector2d one = new Vector2d(3,4);
        Vector2d another = new Vector2d(3,5);
        // when
        boolean result = one.follows(another);
        // then
        assertTrue(result);
    }

    @Test
    void testUpperRightDifferentVectors() {
        // given
        Vector2d one = new Vector2d(2,13);
        Vector2d another = new Vector2d(7, 3);
        // when
        Vector2d result = one.upperRight(another);
        // then
        assertEquals(new Vector2d(7,13),result);
    }

    @Test
    void testUpperRightEqualVectors() {
        // given
        Vector2d one = new Vector2d(7,13);
        Vector2d another = new Vector2d(7, 13);
        // when
        Vector2d result = one.upperRight(another);
        // then
        assertEquals(new Vector2d(7,13),result);
    }

    @Test
    void testLowerLeftDifferentVectors() {
        // given
        Vector2d one = new Vector2d(2,13);
        Vector2d another = new Vector2d(7, 3);
        // when
        Vector2d result = one.lowerLeft(another);
        // then
        assertEquals(new Vector2d(2,3),result);
    }

    @Test
    void testLowerLeftEqualVectors() {
        // given
        Vector2d one = new Vector2d(2,3);
        Vector2d another = new Vector2d(2, 3);
        // when
        Vector2d result = one.lowerLeft(another);
        // then
        assertEquals(new Vector2d(2,3),result);
    }

    @Test
    void testAddNotEqualZero() {
        // given
        Vector2d one = new Vector2d(1,2);
        Vector2d another = new Vector2d(3,4);
        // when
        Vector2d result = one.add(another);
        // then
        assertEquals(new Vector2d(1+3,2+4), result);
    }

    @Test
    void testAddEqualZero() {
        // given
        Vector2d one = new Vector2d(7,13);
        Vector2d another = new Vector2d(-7,-13);
        // when
        Vector2d result = one.add(another);
        // then
        assertEquals(new Vector2d(0,0), result);
    }

    @Test
    void testSubtractNotEqualZero() {
        // given
        Vector2d one = new Vector2d(3,4);
        Vector2d another = new Vector2d(1,2);
        // when
        Vector2d result = one.subtract(another);
        // then
        assertEquals(new Vector2d(2,2), result);
    }

    @Test
    void testSubtractEqualZero() {
        // given
        Vector2d one = new Vector2d(7,13);
        Vector2d another = new Vector2d(7,13);
        // when
        Vector2d result = one.subtract(another);
        // then
        assertEquals(new Vector2d(0,0), result);
    }

    @Test
    void testOppositeNotZero() {
        // given
        Vector2d vector = new Vector2d(7,13);
        //when
        Vector2d result = vector.opposite();
        //then
        assertEquals(new Vector2d(-7,-13), result);
    }

    @Test
    void testOppositeZero() {
        // given
        Vector2d vector = new Vector2d(0,0);
        //when
        Vector2d result = vector.opposite();
        //then
        assertEquals(new Vector2d(0,0), result);
    }
}
