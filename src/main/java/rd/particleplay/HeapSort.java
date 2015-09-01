package rd.particleplay;

/**
 * Created by Ryan on 8/9/2015.
 */
public abstract class HeapSort{

    //Do not use position 0 out of convenience

    public static <T> Comparable<T>[] sort(Comparable<T>[] array)
    {
        int N = array.length - 1;

        //start from the smallest node that has children (heapSize/2) and work your way up sinking nodes to create the heap.
        for(int k = N/2; k >= 1; k--)
        {
            sink(array, N, k);
        }

        //exchange the largest element with the smallest spot, decrease the heap size by 1 and repair the heap.
        while(N > 1)
        {
            exchangeValues(array, N--, 1);
            sink(array, N, 1);
        }

        return array;
    }

    public static void sink(Comparable[] array, int heapSize, int k)
    {
        //while we are not at the end of a heap arm
        while (leftChildIndex(k) <= heapSize)
        {
            //if 2 children exist and the right is larger.
            if(leftChildIndex(k) < heapSize && valueIsLessThan(array, leftChildIndex(k), rightChildIndex(k))){

                if(valueIsLessThan(array, k, rightChildIndex(k))){
                    exchangeValues(array, k, rightChildIndex(k));
                    k = rightChildIndex(k);
                }

                continue;
            }

            if(valueIsLessThan(array, k, leftChildIndex(k))){
                exchangeValues(array, k, leftChildIndex(k));
                k = leftChildIndex(k);

                continue;
            }

            break;
        }
    }

    public static void swim(Comparable[] array, int k)
    {
        while (k > 1 && valueIsLessThan(array, parentIndexOf(k), k))
        {
            exchangeValues(array, k, parentIndexOf(k));
            k = parentIndexOf(k);
        }
    }

    public static boolean valueIsLessThan(Comparable[] array, int indexI, int indexJ)
    {
        return array[indexI].compareTo(array[indexJ]) < 0;
    }

    public static void exchangeValues(Comparable[] array, int i, int j)
    {
        Comparable temp = array[i];

        array[i] = array[j];
        array[j] = temp;
    }

    public static int parentIndexOf(int k){ return k/2; }
    public static int leftChildIndex(int k){ return 2*k; }
    public static int rightChildIndex(int k){ return 2*k + 1; }
}
