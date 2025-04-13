This project creates basic data storage tools from scratch in Java. These tools help store and organize data in different ways. The project doesn't use Java's built-in collections (like ArrayList or LinkedList).
Basic Storage Container:

1.MyArrayList:
Stores items in a row, like boxes on a shelf;
Good for quickly grabbing any item if you know its position;
Easy to add items at the end, harder to add in the middle.

2.MyLinkedList:
Stores items as separate pieces connected by links;
Like a chain where each link points to the next one;
Easy to add or remove items anywhere in the list.

Tools built using these containers:

1.MyStack:
Works like a stack of plates - you can only take from the top;
Last item in is the first item out (LIFO);
Uses MyArrayList because we only need fast access to the end.

2.MyQueue:
Works like a line of people - first come, first served;
First item in is the first item out (FIFO);
Uses MyLinkedList because we need good access to both ends.


3.MyMinHeap:
Always keeps the smallest item easily available;
Like a funnel that always drops the smallest item first;
Uses MyArrayList with special rules to maintain order.

INTERFACE:
All base data structures implement the MyList<T> interface, which extends Iterable<T> and provides the following methods:
javavoid add(T item);
void set(int index, T item);
void add(int index, T item);
void addFirst(T item);
void addLast(T item);
T get(int index);
T getFirst();
T getLast();
void remove(int index);
void removeFirst();
void removeLast();
void sort();
int indexOf(Object object);
int lastIndexOf(Object object);
boolean exists(Object object);
Object[] toArray();
void clear();
int size();

USAGE:
The Main class demonstrates how to use each data structure. 
