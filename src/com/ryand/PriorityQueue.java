package com.ryand;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * Created by Ryan on 8/9/2015.
 */
public class PriorityQueue<T extends Comparable<T>> {

    //Creates a new PQ with the given size.
    public PriorityQueue(int size){

    }

    //Inserts a new item into the queue.
    public void insert(T item){

    }

    //Returns the minimum item in the queue.
    T minimum(){
        throw new NotImplementedException();
    }

    //Removes and returns the minimum item in the queue.
    T deleteMinimum(){
        throw new NotImplementedException();
    }

    //Returns true if no items are in the queue.
    boolean isEmpty(){
        throw new NotImplementedException();
    }

    //Returns the number of items in the queue.
    int size(){
        throw new NotImplementedException();
    }
}
