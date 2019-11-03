    package ua.edu.ucu.collections.immutable;


public class ImmutableLinkedList implements ImmutableList {
    private Node listHead;

    public ImmutableLinkedList() {
        listHead = null;
    }

    private void setHead(Node node) {
        listHead = node;
    }

    private Node getHead() {
        return listHead;
    }

    private Node copyNode(Node node) {
        return new Node(node.getValue());
    }

    private ImmutableLinkedList listCopy(int flag,
                                         int index,
                                         Object[] c,
                                         Object e) {
        ImmutableLinkedList newLinkedList = new ImmutableLinkedList();
        Node oldNode = getHead();
        newLinkedList.setHead(new Node(null));
        Node newNode = newLinkedList.getHead();

        // copying all elements before the index
        int cnt = 0;
        while (cnt < index) {
            newNode.setNext(copyNode(oldNode));
            newNode = newNode.getNext();
            oldNode = oldNode.getNext();
            cnt++;
        }

        // manipulation with elements on index according to the flag
        if (flag == -1) { // remove
            oldNode = oldNode.getNext();
        } else if (flag == 0) { // set
            newNode.setNext(new Node(e));
            newNode = newNode.getNext();
            oldNode = oldNode.getNext();
        } else if (flag == 1) { // add
            for ( int i = 0; i < c.length; i++ ) {
                newNode.setNext(new Node(c[i]));
                newNode = newNode.getNext();
            }
        }

        // copying all elements after the index
        while (oldNode != null) {
            newNode.setNext(copyNode(oldNode));
            newNode = newNode.getNext();
            oldNode = oldNode.getNext();
        }
        // removing null head
        newLinkedList.setHead(newLinkedList.getHead().getNext());
        return newLinkedList;
    }

    public ImmutableLinkedList(Object[] elements) {
        if (elements.length != 0) {
            setHead(new Node(elements[0]));
            Node node = getHead();
            for (int i = 1; i < elements.length; i++) {
                node.setNext(new Node(elements[i]));
                node = node.getNext();
            }
        }
    }

    @Override
    public ImmutableList add(Object e) {
        return add(size(), e);
    }

    @Override
    public ImmutableList add(int index, Object e) {
        return addAll(index, new Object[]{e});
    }

    @Override
    public ImmutableList addAll(Object[] c) {
        return addAll(size(), c);
    }

    @Override
    public ImmutableList addAll(int index, Object[] c) {
        checkIndexBounds(index);
        return listCopy(1, index, c, null);
    }

    @Override
    public ImmutableList remove(int index) {
        checkIndexBounds(index);
        if (isEmpty() || index == size()) {
            throw new IndexOutOfBoundsException();
        }
        return listCopy(-1, index, null, null);
    }

    @Override
    public ImmutableList set(int index, Object e) {
        checkIndexBounds(index);
        return listCopy(0, index, null, e);
    }

    @Override
    public Object get(int index) {
        checkIndexBounds(index);
        if (isEmpty() || index == size()) {
            throw new IndexOutOfBoundsException();
        }
        Node node = getNode(index);
        return node.getValue();
    }

    private Node getNode(int index) {
        Node node = getHead();
        int cnt = 0;
        while (cnt < index) {
            node = node.getNext();
            cnt++;
        }
        return node;
    }

    private void checkIndexBounds(int index) {
        if (index > size() || index < 0) {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public int indexOf(Object e) {
        Node node = getHead();
        int index = 0;
        while (node != null) {
            if (node.getValue() == e) {
                return index;
            } else {
                index++;
                node = node.getNext();
            }
        }
        return -1;
    }

    @Override
    public int size() {
        if (isEmpty()) {
            return 0;
        }
        int cnt = 0;
        Node node = getHead();
        while (node != null) {
            node = node.getNext();
            cnt++;
        }
        return cnt;
    }

    @Override
    public ImmutableList clear() {
        return new ImmutableLinkedList();
    }

    @Override
    public boolean isEmpty() {
        return listHead == null;
    }

    @Override
    public Object[] toArray() {
        Object[] newList = new Object[size()];
        Node node = listHead;
        int index = 0;
        while (node != null) {
            newList[index] = node.getValue();
            node = node.getNext();
            index++;
        }
        return newList;
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "";
        }
        StringBuffer buf = new StringBuffer();
        Node node = listHead;
        while (node.getNext() != null) {
            buf.append(node.getValue().toString() + ", ");
            node = node.getNext();
        }
        buf.append(node.getValue().toString());
        return buf.toString();
    }

    public ImmutableLinkedList addFirst(Object e) {
        return (ImmutableLinkedList) add(0, e);
    }

    public ImmutableLinkedList addLast(Object e) {
        return (ImmutableLinkedList) add(e);
    }

    public Object getFirst() {
        return get(0);
    }

    public Object getLast() {
        return get(size() - 1);
    }

    public ImmutableLinkedList removeFirst() {
        return (ImmutableLinkedList) remove(0);
    }

    public ImmutableLinkedList removeLast() {
        return (ImmutableLinkedList) remove(size() - 1);
    }
}
