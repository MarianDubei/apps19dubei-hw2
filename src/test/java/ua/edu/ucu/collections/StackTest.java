package ua.edu.ucu.collections;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class StackTest {
    private Stack stack;

    @Before
    public void init() {
        stack = new Stack();
        for (int i = 1; i <= 5; i++) {
            stack.push(i);
        }
    }

    @Test
    public void testPeek() {
        assertEquals(5, stack.peek());
    }

    @Test
    public void testPop() {
        assertEquals(5, stack.pop());
        assertEquals(4, stack.pop());
        assertEquals(3, stack.pop());
        assertEquals(2, stack.pop());
        assertEquals(1, stack.pop());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testEmptyStackPop() {
        stack.pop();
    }
}
