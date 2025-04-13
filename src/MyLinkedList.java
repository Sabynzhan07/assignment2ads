import java.util.Iterator;
public class MyLinkedList<T> implements MyList<T> {
    private class MyNode {
        T element;
        MyNode next;
        MyNode prev;

        MyNode(T element) {
            this.element = element;
            this.next = null;
            this.prev = null;
        }
    }
    private MyNode head;
    private MyNode tail;
    private int size;
    public MyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public void add(T item) {
        addLast(item);
    }
    @Override
    public void set(int index, T item) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }

        MyNode current = getNodeAt(index);
        current.element = item;
    }

    @Override
    public void add(int index, T item) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }

        if (index == 0) {
            addFirst(item);
        } else if (index == size) {
            addLast(item);
        } else {
            MyNode newNode = new MyNode(item);
            MyNode current = getNodeAt(index);

            newNode.next = current;
            newNode.prev = current.prev;
            current.prev.next = newNode;
            current.prev = newNode;

            size++;
        }
    }

    @Override
    public void addFirst(T item) {
        MyNode newNode = new MyNode(item);

        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }

        size++;
    }

    @Override
    public void addLast(T item) {
        MyNode newNode = new MyNode(item);

        if (tail == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }

        size++;
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }

        return getNodeAt(index).element;
    }

    private MyNode getNodeAt(int index) {
        MyNode current;

        if (index < size / 2) {
            current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
        } else {
            current = tail;
            for (int i = size - 1; i > index; i--) {
                current = current.prev;
            }
        }

        return current;
    }

    @Override
    public T getFirst() {
        if (head == null) {
            throw new IndexOutOfBoundsException("List is empty");
        }
        return head.element;
    }

    @Override
    public T getLast() {
        if (tail == null) {
            throw new IndexOutOfBoundsException("List is empty");
        }
        return tail.element;
    }

    @Override
    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }

        if (index == 0) {
            removeFirst();
        } else if (index == size - 1) {
            removeLast();
        } else {
            MyNode nodeToRemove = getNodeAt(index);

            nodeToRemove.prev.next = nodeToRemove.next;
            nodeToRemove.next.prev = nodeToRemove.prev;
            nodeToRemove.prev = null;
            nodeToRemove.next = null;
            nodeToRemove.element = null;

            size--;
        }
    }
    @Override
    public void removeFirst() {
        if (head == null) {
            throw new IndexOutOfBoundsException("List is empty");
        }

        MyNode oldHead = head;

        if (head == tail) {
            head = null;
            tail = null;
        } else {
            head = head.next;
            head.prev = null;
        }

        oldHead.next = null;
        oldHead.element = null;

        size--;
    }

    @Override
    public void removeLast() {
        if (tail == null) {
            throw new IndexOutOfBoundsException("List is empty");
        }

        MyNode oldTail = tail;

        if (head == tail) {
            head = null;
            tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }

        oldTail.prev = null;
        oldTail.element = null;

        size--;
    }

    @Override
    @SuppressWarnings("unchecked")
    public void sort() {
        if (size <= 1) {
            return;
        }

        Object[] array = toArray();

        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - i - 1; j++) {
                if (((Comparable<T>) array[j]).compareTo((T) array[j + 1]) > 0) {
                    Object temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }

        clear();
        for (Object obj : array) {
            add((T) obj);
        }
    }

    @Override
    public int indexOf(Object object) {
        int index = 0;
        for (MyNode current = head; current != null; current = current.next) {
            if (object == null ? current.element == null : object.equals(current.element)) {
                return index;
            }
            index++;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object object) {
        int index = size - 1;
        for (MyNode current = tail; current != null; current = current.prev) {
            if (object == null ? current.element == null : object.equals(current.element)) {
                return index;
            }
            index--;
        }
        return -1;
    }

    @Override
    public boolean exists(Object object) {
        return indexOf(object) >= 0;
    }

    @Override
    public Object[] toArray() {
        Object[] result = new Object[size];
        int i = 0;
        for (MyNode current = head; current != null; current = current.next) {
            result[i++] = current.element;
        }
        return result;
    }

    @Override
    public void clear() {
        for (MyNode current = head; current != null; ) {
            MyNode next = current.next;
            current.prev = null;
            current.next = null;
            current.element = null;
            current = next;
        }

        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private MyNode current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new IndexOutOfBoundsException("No more elements");
                }
                T element = current.element;
                current = current.next;
                return element;
            }
        };
    }
}