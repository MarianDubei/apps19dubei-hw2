package ua.edu.ucu.collections;

import ua.edu.ucu.collections.immutable.ImmutableLinkedList;

public class Stack {
    private ImmutableLinkedList elements;

    public Stack() {
        elements = new ImmutableLinkedList();
    }

    public Object peek() {
        return elements.getLast();
    }

    public Object pop() {
        Object top = elements.getLast();
        elements = elements.removeLast();
        return top;
    }

    public void push(Object e) {
        elements = (ImmutableLinkedList) elements.add(e);
    }
}
