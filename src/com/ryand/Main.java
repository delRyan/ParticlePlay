package com.ryand;

import java.io.Console;

public class Main {

    public static void main(String[] args) {

        Comparable<Object>[] array = new Comparable[]{0, 4, 3, 3, 10};

        array = HeapSort.sort(array);


        System.out.println(array);
    }
}
