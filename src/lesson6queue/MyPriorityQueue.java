package lesson6queue;

import java.util.*;

/**
 * Created by: Mehrojbek
 * DateTime: 16/08/24 19:10
 **/
public class MyPriorityQueue<E extends Comparable> {

    //1. Priority bo'yicha tartiblash
    //2. Priority teng bo'lganda FIFO bo'yicha olish

    private List<E> elements;
    private int elementCount;
    private int capacity = 10;

    public MyPriorityQueue(int capacity) {
        this.elements = new ArrayList<>(capacity);
        this.capacity = capacity;
    }
    public MyPriorityQueue() {
        this.elements = new ArrayList<>();
    }

    public boolean enqueue(E e) {

        if (Objects.isNull(e))
            throw new NullPointerException("Element is null");

        if (isFull())
            throw new RuntimeException("Queue is full");

        elements.add(e);

        elementCount++;

        return true;
    }

    private boolean isFull() {
        return elementCount == capacity;
    }

    private boolean isEmpty() {
        return elementCount == 0;
    }

    public E dequeue() {

        Collections.sort(elements);

        elementCount--;

        E e = elements.get(0);
        elements.remove(e);
        return e;
    }

    @Override
    public String toString() {
        Collections.sort(elements);
        return elements.toString();
    }

    public static void main(String[] args) {

        MyPriorityQueue<Integer> integers = new MyPriorityQueue<>();
        integers.enqueue(19);
        integers.enqueue(7);
        integers.enqueue(3);
        integers.enqueue(1);
        integers.enqueue(9);
        integers.enqueue(4);

        System.out.println("integers.dequeue() = " + integers.dequeue());

        System.out.println("integers = " + integers);


    }

    public static class Student implements Comparable<Student> {
        private String name;

        @Override
        public int compareTo(Student o) {
            return Objects.compare(this.name, o.getName(), Comparator.naturalOrder());
        }

        public String getName() {
            return name;
        }
    }
}
