package rd.particleplay;

import java.util.Arrays;

/**
 * Created by Ryan on 8/9/2015.
 */
public class PriorityQueue<T extends Comparable<T>> {

    private int N = 0;
    private T[] array;

    //Creates a new PQ with the given size.
    public PriorityQueue(){ array = (T[]) new Comparable[10]; }
    public PriorityQueue(int size){ array = (T[]) new Comparable[size]; }

    /**Inserts an item into the queue. Throws IllegalArgumentException
     * if the item is null.
     */
    public void insert(T item){
        if(item == null){ throw new IllegalArgumentException("Item cannot be null."); }

        N++;

        growArray();

        array[N] = item;
        HeapSort.swim(array, N);
    }

    /**Removes and returns the minimum item in the queue. Throws IndexOutOfBoundsException
     * if the queue is empty.
     */
    public T removeMinimum(){
        if(N <= 0){ throw new IndexOutOfBoundsException("The Queue is empty.");}

        HeapSort.exchangeValues(array, 1, N);

        T min = array[N];
        array[N] = null;
        N--;

        HeapSort.sink(array, N, 1);
        shrinkArray();

        return min;
    }

    /**Returns the minimum item in the queue. Throws IndexOutOfBoundsException
     * if the queue is empty.
     */
    public T minimum(){
        if(N == 0){ throw new IndexOutOfBoundsException("The Queue is empty.");}

        return array[1];
    }

    private void growArray(){
        if(N >= array.length){
            array = Arrays.copyOf(array, array.length*2);
        }
    }
    private void shrinkArray(){
        if(N < array.length/4){
            array = Arrays.copyOf(array, array.length/2);
        }
    }

    public boolean isEmpty(){ return N == 0; }
}
