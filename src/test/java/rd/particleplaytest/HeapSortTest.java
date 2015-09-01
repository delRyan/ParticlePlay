package rd.particleplaytest;

import org.junit.Assert;
import org.junit.Test;
import rd.particleplay.HeapSort;

/**
 * Created by Ryan on 8/30/2015.
 */
public class HeapSortTest {

    @Test
    public void sink_smallestValueMovesToBottom(){
        //Position 0 is unused.
        Integer[] array = new Integer[]{0, 1, 2 ,3};

        HeapSort.sink(array, array.length - 1, 1);

        Assert.assertEquals((int)array[3], 1);
    }

    @Test
    public void sink_leftChildStaysAtTop(){
        //Position 0 is unused.
        Integer[] array = new Integer[]{0, 5, 4, 3, 2, 1};

        HeapSort.sink(array, array.length - 1, 2);

        Assert.assertEquals((int)array[2], 4);
    }

    @Test
    public void sink_rightChildStaysAtTop(){
        //Position 0 is unused.
        Integer[] array = new Integer[]{0, 5, 4, 3, 2, 1};

        HeapSort.sink(array, array.length - 1, 3);

        Assert.assertEquals((int)array[3], 3);
    }

    @Test
    public void sink_parentTakesLeftLargerChild(){
        //Position 0 is unused.
        Integer[] array = new Integer[]{0, 5, 6, 4, 1};

        HeapSort.sink(array, array.length - 1, 1);

        Assert.assertEquals((int)array[2], 5);
    }

    @Test
    public void sink_parentTakesRightLargerChild(){
        //Position 0 is unused.
        Integer[] array = new Integer[]{0, 5, 4, 6, 1};

        HeapSort.sink(array, array.length - 1, 1);

        Assert.assertEquals((int)array[3], 5);
    }

    @Test
    public void swim_largestValueMovesToTop(){
        //Position 0 is unused.
        Integer[] array = new Integer[]{0, 1, 2 ,3};

        HeapSort.swim(array, 3);

        Assert.assertEquals((int)array[1], 3);
    }

    @Test
    public void swim_leftChildStaysAtBottom() {
        //Position 0 is unused.
        Integer[] array = new Integer[]{0, 3, 2 ,1};

        HeapSort.swim(array, 3);

        Assert.assertEquals((int)array[3], 1);
    }

    @Test
    public void swim_rightChildStaysAtBottom() {
        //Position 0 is unused.
        Integer[] array = new Integer[]{0, 3, 1 ,2};

        HeapSort.swim(array, 3);

        Assert.assertEquals((int) array[3], 2);
    }

    @Test
    public void swim_childTakesParentButNotTop() {
        //Position 0 is unused.
        Integer[] array = new Integer[]{0, 6, 3, 3, 4};

        HeapSort.swim(array, 4);

        Assert.assertEquals((int) array[2], 4);
    }


    @Test
    public void valueIsLessThan_trueForLesserFirstArgument(){
        Integer[] array = new Integer[]{1, 2};

        Boolean result = HeapSort.valueIsLessThan(array, 0, 1);

        Assert.assertTrue(result);
    }

    @Test
    public void valueIsLessThan_falseForGreaterFirstArgument(){
        Integer[] array = new Integer[]{2, 1};

        Boolean result = HeapSort.valueIsLessThan(array, 0, 1);

        Assert.assertFalse(result);
    }

    @Test
    public void valueIsLessThan_falseForEqualArguments(){
        Integer[] array = new Integer[]{1, 2};

        Boolean result = HeapSort.valueIsLessThan(array, 1, 1);

        Assert.assertFalse(result);
    }

    @Test
    public void exchangeValues_exchangesValues(){
        int firstValue = 23, secondValue = 66;
        int firstIndex = 0, secondIndex = 1;
        Integer[] array = new Integer[]{firstValue, secondValue};

        HeapSort.exchangeValues(array, firstIndex, secondIndex);

        Assert.assertEquals((int)array[firstIndex], secondValue);
        Assert.assertEquals((int)array[secondIndex], firstValue);
    }
}
