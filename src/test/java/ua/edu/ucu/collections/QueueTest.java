package ua.edu.ucu.collections;

import org.junit.Test;
import org.junit.Before;
import ua.edu.ucu.collections.immutable.ImmutableLinkedList;

import static org.junit.Assert.*;

public class QueueTest {
    private Queue queue;

    @Before
    public void init() {
        queue = new Queue();
        for (int i = 1; i <= 5; i++) {
            queue.enqueue(i);
        }
    }

    @Test
    public void testPeek() {
        assertEquals(5, queue.peek());
    }

    @Test
    public void testDequeue() {
        assertEquals(5, queue.dequeue());
        assertEquals(4, queue.dequeue());
        assertEquals(3, queue.dequeue());
        assertEquals(2, queue.dequeue());
        assertEquals(1, queue.dequeue());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testEmptyQueueDequeue() {
        queue.dequeue();
    }
}
