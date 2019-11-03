package ua.edu.ucu.collections;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class StackTest {
    private Stack stack1;
    private Stack stack2;

    @Before
    public void init() {
        stack1 = new Stack();
        for (int i = 1; i <= 5; i++) {
            stack1.push(i);
        }
        stack2 = new Stack();
    }

    @Test
    public void testPeek() {
        assertEquals(5, stack1.peek());
    }

    @Test
    public void testPop() {
        assertEquals(5, stack1.pop());
        assertEquals(4, stack1.pop());
        assertEquals(3, stack1.pop());
        assertEquals(2, stack1.pop());
        assertEquals(1, stack1.pop());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testEmptyStackPop() {
        stack2.pop();
    }
}
