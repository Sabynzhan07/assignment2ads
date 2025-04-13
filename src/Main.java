public class Main {
    public static void main(String[] args) {
        System.out.println("Testing MyArrayList...");
        testArrayList();

        System.out.println("\nTesting MyLinkedList...");
        testLinkedList();

        System.out.println("\nTesting MyStack...");
        testStack();

        System.out.println("\nTesting MyQueue...");
        testQueue();

        System.out.println("\nTesting MyMinHeap...");
        testMinHeap();
    }

    private static void testArrayList() {
        MyArrayList<Integer> arrayList = new MyArrayList<>();
        arrayList.add(5);
        arrayList.add(10);
        arrayList.add(7);

        System.out.print("Elements: ");
        for (Integer item : arrayList) {
            System.out.print(item + " ");
        }
        System.out.println();

        arrayList.set(1, 15);
        System.out.println("After setting element at index 1 to 15: " + arrayList.get(1));

        arrayList.add(1, 20);
        System.out.print("After adding 20 at index 1: ");
        for (Integer item : arrayList) {
            System.out.print(item + " ");
        }
        System.out.println();

        arrayList.remove(2);
        System.out.print("After removing element at index 2: ");
        for (Integer item : arrayList) {
            System.out.print(item + " ");
        }
        System.out.println();

        arrayList.sort();
        System.out.print("After sorting: ");
        for (Integer item : arrayList) {
            System.out.print(item + " ");
        }
        System.out.println();

        arrayList.add(5);
        System.out.println("Index of 5: " + arrayList.indexOf(5));
        System.out.println("Last index of 5: " + arrayList.lastIndexOf(5));
        System.out.println("Does 15 exist? " + arrayList.exists(15));
        System.out.println("Does 100 exist? " + arrayList.exists(100));
        System.out.println("Size: " + arrayList.size());
        arrayList.clear();
        System.out.println("Size after clear: " + arrayList.size());
    }

    private static void testLinkedList() {
        MyLinkedList<String> linkedList = new MyLinkedList<>();

        linkedList.add("Apple");
        linkedList.add("Banana");
        linkedList.add("Cherry");

        System.out.print("Elements: ");
        for (String item : linkedList) {
            System.out.print(item + " ");
        }
        System.out.println();

        linkedList.addFirst("Orange");
        linkedList.addLast("Grape");
        System.out.print("After adding Orange at first and Grape at last: ");
        for (String item : linkedList) {
            System.out.print(item + " ");
        }
        System.out.println();
        System.out.println("First element: " + linkedList.getFirst());
        System.out.println("Last element: " + linkedList.getLast());

        linkedList.removeFirst();
        linkedList.removeLast();
        System.out.print("After removing first and last elements: ");
        for (String item : linkedList) {
            System.out.print(item + " ");
        }
        System.out.println();

        linkedList.sort();
        System.out.print("After sorting: ");
        for (String item : linkedList) {
            System.out.print(item + " ");
        }
        System.out.println();
        System.out.println("Size: " + linkedList.size());
    }

    private static void testStack() {
        MyStack<Character> stack = new MyStack<>();
        stack.push('A');
        stack.push('B');
        stack.push('C');

        System.out.println("Top element: " + stack.peek());
        System.out.print("Popping elements: ");
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
        System.out.println();
        System.out.println("Is stack empty? " + stack.isEmpty());
    }

    private static void testQueue() {
        MyQueue<Integer> queue = new MyQueue<>();
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        System.out.println("Front element: " + queue.peek());
        System.out.print("Dequeuing elements: ");
        while (!queue.isEmpty()) {
            System.out.print(queue.dequeue() + " ");
        }
        System.out.println();
        System.out.println("Is queue empty? " + queue.isEmpty());
    }

    private static void testMinHeap() {
        MyMinHeap<Integer> minHeap = new MyMinHeap<>();

        minHeap.insert(5);
        minHeap.insert(3);
        minHeap.insert(8);
        minHeap.insert(1);
        minHeap.insert(10);

        System.out.println("Minimum element: " + minHeap.peek());
        System.out.print("Extracting elements in order: ");
        while (!minHeap.isEmpty()) {
            System.out.print(minHeap.extractMin() + " ");
        }
        System.out.println();
        System.out.println("Is heap empty? " + minHeap.isEmpty());
    }
}