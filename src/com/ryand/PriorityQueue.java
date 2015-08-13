package com.ryand;

import java.util.Arrays;

/**
 * Created by Ryan on 8/9/2015.
 */
public class PriorityQueue<T extends Comparable<T>> {

    private int N = 0;
    private T[] array;

    //Creates a new PQ with the given size.
    public PriorityQueue(int size){
        array = (T[]) new Comparable[size];
    }

    //Inserts a new item into the queue.
    public void insert(T item)
    {
        N++;

        growArray();

        array[N] = item;
        HeapSort.swim(array, N);
    }

    //Removes and returns the minimum item in the queue.
    public T deleteMinimum()
    {
        T min = array[N];
        array[N] = null;
        N--;

        shrinkArray();

        return min;
    }

    //Returns the minimum item in the queue.
    public T minimum(){ return array[N]; }

    private void growArray()
    {
        if(N >= array.length){
            array = Arrays.copyOf(array, array.length*2);
        }
    }
    private void shrinkArray()
    {
        if(N < array.length/4){
            array = Arrays.copyOf(array, array.length/2);
        }
    }

    public boolean isEmpty(){ return N == 0; }
    public int size(){ return N; }
}
