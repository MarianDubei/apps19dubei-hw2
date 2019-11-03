package ua.edu.ucu.collections.immutable;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class ImmutableArrayListTest {
    private ImmutableArrayList list1;
    private ImmutableArrayList list2;

    @Before
    public void setUp() {
        list1 = new ImmutableArrayList();
        list2 = new ImmutableArrayList(new Object[]{1, 3, 5, 7});
    }

    @Test
    public void testAdd() {
        assertArrayEquals(new Object[]{1}, list1.add(1).toArray());
    }

    @Test
    public void testAddWithIndex() {
        assertArrayEquals(new Object[]{1, 2, 3, 5, 7}, list2.add(1, 2).toArray());
    }

    @Test
    public void testAddAll() {
        assertArrayEquals(new Object[]{3, 6}, list1.addAll(new Object[]{3, 6}).toArray());
    }

    @Test
    public void testAddAllWithIndex() {
        assertArrayEquals(new Object[]{1, 3, 5, 4, 5, 7}, list2.addAll(3, new Object[]{4, 5}).toArray());
    }

    @Test
    public void testGet() {
        assertEquals(5, list2.get(2));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetOutOfBounds() {
        list2.get(5);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveFromEmpty() {
        list1.remove(0);
    }

    @Test
    public void testRemove() {
        assertArrayEquals(new Object[]{1, 3, 7}, list2.remove(2).toArray());
    }

    @Test
    public void testSet() {
        assertArrayEquals(new Object[]{1, 3, 3, 7}, list2.set(2, 3).toArray());
    }

    @Test
    public void testSize() {
        assertEquals(4, list2.size());
    }

    @Test
    public void testClear() {
        assertArrayEquals(new Object[]{}, list2.clear().toArray());
    }

    @Test
    public void testIndexOf() {
        assertEquals(1, list2.indexOf(3));
    }

    @Test
    public void testIndexOfNotFound() {
        assertEquals(-1, list2.indexOf(10));
    }

    @Test
    public void testIsEmpty() {
        assertEquals(true, list1.isEmpty());
    }

    @Test
    public void testToArray() {
        assertArrayEquals(new Object[]{1, 3, 5, 7}, list2.toArray());
    }

    @Test
    public void testToString() {
        assertEquals("1, 3, 5, 7", list2.toString());
    }
}