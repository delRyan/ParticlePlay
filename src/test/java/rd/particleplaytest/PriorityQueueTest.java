package rd.particleplaytest;

import org.junit.Assert;
import org.junit.Test;
import rd.particleplay.PriorityQueue;

/**
 * Created by Ryan on 8/30/2015.
 */
public class PriorityQueueTest {

    @Test
    public void priorityQueue_correctlySortsByMinimum(){
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        pq.insert(3);
        pq.insert(1);
        pq.insert(2);
        pq.insert(6);
        pq.insert(5);
        pq.insert(8);
        pq.insert(10);
        pq.insert(9);
        pq.insert(4);
        pq.insert(7);

        Assert.assertEquals(1, (int) pq.removeMinimum());
        Assert.assertEquals(2, (int) pq.removeMinimum());
        Assert.assertEquals(3, (int) pq.removeMinimum());
        Assert.assertEquals(4, (int) pq.removeMinimum());
        Assert.assertEquals(5, (int) pq.removeMinimum());
        Assert.assertEquals(6, (int) pq.removeMinimum());
        Assert.assertEquals(7, (int) pq.removeMinimum());
        Assert.assertEquals(8, (int) pq.removeMinimum());
        Assert.assertEquals(9, (int) pq.removeMinimum());
        Assert.assertEquals(10,(int) pq.removeMinimum());
    }

    @Test
    public void insert_doesNotCauseIndexOutOfBoundsException(){
        PriorityQueue<Integer> pq = new PriorityQueue<>(2);

        pq.insert(1);
        pq.insert(1);
        pq.insert(1);
        pq.insert(1);
    }

    @Test(expected=IllegalArgumentException.class)
    public void insert_throwsIllegalArgumentExceptionOnNullArgument(){
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        pq.insert(null);
    }

    @Test
    public void removeMinimum_actuallyRemovesTheItem(){
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        pq.insert(9);
        pq.removeMinimum();

        Assert.assertEquals(true, pq.isEmpty());
    }


    @Test
    public void removeMinimum_returnsSmallestValueWhenInsertedLast(){
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.insert(9);
        pq.insert(1);

        Assert.assertEquals(1, (int)pq.removeMinimum());
    }

    @Test
    public void removeMinimum_returnsSmallestValueWhenInsertedFirst(){
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.insert(1);
        pq.insert(9);

        Assert.assertEquals(1, (int)pq.removeMinimum());
    }

    @Test(expected=IndexOutOfBoundsException.class)
    public void removeMinimum_throwsOutOfBoundsWhenEmpty(){
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int min = pq.removeMinimum();
    }

    @Test(expected=IndexOutOfBoundsException.class)
    public void minimum_throwsOutOfBoundsWhenEmpty(){
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int min = pq.minimum();
    }

    @Test
    public void minimum_returnsSmallestValueWhenInsertedLast(){
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.insert(9);
        pq.insert(1);

        Assert.assertEquals(1, (int)pq.minimum());
    }

    @Test
    public void minimum_returnsSmallestValueWhenInsertedFirst(){
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.insert(1);
        pq.insert(9);

        Assert.assertEquals(1, (int)pq.minimum());
    }

    @Test
    public void isEmpty_returnsTrue(){
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        Assert.assertTrue(pq.isEmpty());
    }

    @Test
    public void isEmpty_returnsFalse(){
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        pq.insert(1);

        Assert.assertFalse(pq.isEmpty());
    }
}
