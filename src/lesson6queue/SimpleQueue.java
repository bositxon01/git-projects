package lesson6queue;

import java.util.Arrays;

/**
 * Created by: Mehrojbek
 * DateTime: 14/08/24 20:41
 **/
public class SimpleQueue<E> {

    private Object[] elements;
    private int elementCount = 0;

    public SimpleQueue(int capacity) {
        this.elements = new Object[capacity];
    }

    //element qo'shildi navbat oxiriga
    public boolean enqueue(E e) {

        if (isFull())
            throw new RuntimeException("Queue is full");

        elements[elementCount] = e;
        elementCount++;
        //[null, null, null, null] -> [e, null,...]
        //[e1, null, null, null] -> [e1, e,...]
        return true;
    }

    private boolean isFull() {
        return elementCount == elements.length;
    }

    @SuppressWarnings("unchecked")
    public E dequeue() {

        if (isEmpty())
            throw new RuntimeException("Queue is empty");

        E element = (E) elements[0];

        for (int i = 0; i < elements.length - 1; i++) {
            elements[i] = elements[i + 1];
        }

        elementCount--;

        return element;
    }

    private boolean isEmpty() {
        return elementCount == 0;
    }

    @Override
    public String toString() {
        return "SimpleQueue{" +
                "elements=" + Arrays.toString(Arrays.copyOf(elements, elementCount)) +
                '}';
    }

    public static void main(String[] args) {
        SimpleQueue<Integer> integerSimpleQueue = new SimpleQueue<>(10);

        integerSimpleQueue.enqueue(1);
        integerSimpleQueue.enqueue(2);
        integerSimpleQueue.enqueue(3);
        integerSimpleQueue.enqueue(9);


        System.out.println(integerSimpleQueue);

        Integer dequeue = integerSimpleQueue.dequeue();
        System.out.println("dequeue = " + dequeue);
        System.out.println(integerSimpleQueue);
    }
}
