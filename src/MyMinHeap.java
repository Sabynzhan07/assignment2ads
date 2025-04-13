public class MyMinHeap<T extends Comparable<T>> {
    private MyArrayList<T> list;
    public MyMinHeap() {
        list = new MyArrayList<>();
    }
    private int parent(int index) {
        return (index - 1) / 2;
    }

    private int leftChild(int index) {
        return 2 * index + 1;
    }

    private int rightChild(int index) {
        return 2 * index + 2;
    }

    private void swap(int i, int j) {
        T temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }

    private void siftUp(int index) {
        int parent = parent(index);
        if (index > 0 && list.get(index).compareTo(list.get(parent)) < 0) {
            swap(index, parent);
            siftUp(parent);
        }
    }

    private void siftDown(int index) {
        int smallest = index;
        int left = leftChild(index);
        int right = rightChild(index);
        int size = list.size();

        if (left < size && list.get(left).compareTo(list.get(smallest)) < 0) {
            smallest = left;
        }

        if (right < size && list.get(right).compareTo(list.get(smallest)) < 0) {
            smallest = right;
        }

        if (smallest != index) {
            swap(index, smallest);
            siftDown(smallest);
        }
    }

    public void insert(T item) {
        list.add(item);
        siftUp(list.size() - 1);
    }

    public T extractMin() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("Heap is empty");
        }

        T min = list.get(0);
        T last = list.get(list.size() - 1);
        list.set(0, last);
        list.remove(list.size() - 1);

        if (list.size() > 0) {
            siftDown(0);
        }

        return min;
    }

    public T peek() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("Heap is empty");
        }
        return list.get(0);
    }

    public boolean isEmpty() {
        return list.size() == 0;
    }

    public int size() {
        return list.size();
    }

    public void clear() {
        list.clear();
    }
}