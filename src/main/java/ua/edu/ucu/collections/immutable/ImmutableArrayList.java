package ua.edu.ucu.collections.immutable;

import java.util.Arrays;

public class ImmutableArrayList implements ImmutableList {
    private final int listSize;
    private final Object[] listElements;

    public ImmutableArrayList() {
        listSize = 0;
        listElements = new Object[1];
    }

    public ImmutableArrayList(Object[] elements) {
        listSize = elements.length;
        listElements = Arrays.copyOf(elements, listSize);
    }

    private void checkIndexBounds(int index) {
        if (index > listSize || index < 0) {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public ImmutableList add(Object e) {
        return add(listSize, e);
    }

    @Override
    public ImmutableList add(int index, Object e) {
        return addAll(index, new Object[]{e});
    }

    @Override
    public ImmutableList addAll(Object[] c) {
        return addAll(0, c);
    }

    @Override
    public ImmutableList addAll(int index, Object[] c) {
        checkIndexBounds(index);
        int cSize = c.length;
        Object[] newList = new Object[listSize + cSize];
        System.arraycopy(listElements, 0, newList, 0, index);
        System.out.println(c[0].toString());
        System.arraycopy(c, 0, newList, index, cSize);
        System.arraycopy(listElements, index, newList, index + cSize,
                listSize - index);
        return new ImmutableArrayList(newList);
    }

    @Override
    public Object get(int index) {
        checkIndexBounds(index);
        return listElements[index];
    }

    @Override
    public ImmutableList remove(int index) {
        checkIndexBounds(index);
        if (isEmpty()) {
            throw new IndexOutOfBoundsException();
        }
        Object[] newList = new Object[listSize - 1];
        System.arraycopy(listElements, 0, newList, 0, index);
        System.arraycopy(listElements, index + 1, newList, index,
                listSize - index - 1);
        return new ImmutableArrayList(newList);
    }

    @Override
    public ImmutableList set(int index, Object e) {
        checkIndexBounds(index);
        Object[] newList = toArray();
        newList[index] = e;
        return new ImmutableArrayList(newList);
    }

    @Override
    public int indexOf(Object e) {
        for (int i = 0; i < listSize; i++) {
            if (listElements[i] == e) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int size() {
        return listSize;
    }

    @Override
    public ImmutableList clear() {
        return new ImmutableArrayList();
    }

    @Override
    public boolean isEmpty() {
        return listSize == 0;
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(listElements, listSize);
    }

    @Override
    public String toString() {
        StringBuffer buf = new StringBuffer();
        for (int i = 0; i < listSize - 1; i++) {
            buf.append(listElements[i].toString() + ", ");
        }
        buf.append(listElements[listSize - 1].toString());
        return buf.toString();
    }
}
