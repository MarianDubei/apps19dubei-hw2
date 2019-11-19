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

    private void checkIndexBoundsAuxiliary(int index) {
        if (isEmpty() || index == size()) {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public ImmutableArrayList add(Object e) {
        return add(listSize, e);
    }

    @Override
    public ImmutableArrayList add(int index, Object e) {
        return addAll(index, new Object[]{e});
    }

    @Override
    public ImmutableArrayList addAll(Object[] c) {
        return addAll(0, c);
    }

    @Override
    public ImmutableArrayList addAll(int index, Object[] c) {
        if (c != null) {
            checkIndexBounds(index);
            int cSize = c.length;
            Object[] newList = new Object[listSize + cSize];
            System.arraycopy(listElements, 0, newList, 0, index);
            System.arraycopy(c, 0, newList, index, cSize);
            System.arraycopy(listElements, index, newList, index + cSize,
                    listSize - index);
            return new ImmutableArrayList(newList);
        } else { return new ImmutableArrayList(listElements); }
    }

    @Override
    public Object get(int index) {
        checkIndexBounds(index);
        return listElements[index];
    }

    @Override
    public ImmutableArrayList remove(int index) {
        checkIndexBounds(index);
        checkIndexBoundsAuxiliary(index);
        if (isEmpty()) { throw new IndexOutOfBoundsException(); }
        Object[] newList = new Object[listSize - 1];
        System.arraycopy(listElements, 0, newList, 0, index);
        System.arraycopy(listElements, index + 1, newList, index,
                listSize - index - 1);
        return new ImmutableArrayList(newList);
    }

    @Override
    public ImmutableArrayList set(int index, Object e) {
        checkIndexBounds(index);
        Object[] newList = toArray();
        newList[index] = e;
        return new ImmutableArrayList(newList);
    }

    @Override
    public int indexOf(Object e) {
        for (int i = 0; i < listSize; i++) {
            if (listElements[i].equals(e)) {
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
    public ImmutableArrayList clear() {
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
        StringBuilder buf = new StringBuilder();
        for (int i = 0; i < listSize - 1; i++) {
            buf.append(listElements[i].toString()).append(", ");
        }
        buf.append(listElements[listSize - 1].toString());
        return buf.toString();
    }
}
