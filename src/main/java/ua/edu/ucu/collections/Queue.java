package ua.edu.ucu.collections;

import ua.edu.ucu.collections.immutable.ImmutableLinkedList;

public class Queue {
    private ImmutableLinkedList elements;

    public Queue() {
        elements = new ImmutableLinkedList();
    }

    public Object peek() {
        return elements.getFirst();
    }

    public Object dequeue() {
        Object top = elements.getFirst();
        elements = elements.removeFirst();
        return top;
    }

    public void enqueue(Object e) {
        elements = (ImmutableLinkedList) elements.add(e);
    }
}
