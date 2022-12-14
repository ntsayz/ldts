package com.aor.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

public class ListAggregatorTest {
    private List<Integer> list;
    private List<Integer> list1;

    @BeforeEach
    public void setUp(){
        list = Arrays.asList(1,2,4,2,5);
        list1 = Arrays.asList(-1,-4,-5);

    }

    public List<Integer> getList(){
        return list;
    }

    @Test
    public void sum() {

        ListAggregator aggregator = new ListAggregator();
        int sum = aggregator.sum(getList()); //

        Assertions.assertEquals(14, sum);
    }

    @Test
    public void max() {

        ListAggregator aggregator = new ListAggregator();
        int max = aggregator.max(getList());

        Assertions.assertEquals(5, max);
    }
    //#7263
    @Test void max1(){

        ListAggregator aggregator = new ListAggregator();
        int max = aggregator.max(getList());; //

        Assertions.assertEquals(5, max);
    }

    @Test
    public void min() {
        ListAggregator aggregator = new ListAggregator();
        int min = aggregator.min(getList());

        Assertions.assertEquals(1, min);
    }

    @Test
    public void distinct() {

        ListAggregator aggregator = new ListAggregator();
        int distinct = aggregator.distinct(getList());

        Assertions.assertEquals(0, distinct);
    }
    //#8726
    /*@Test void distinct1(){
        list = Arrays.asList(1,2,4,2);
        GenericListDeduplicator deduplicator =
                Mockito.mock(GenericListDeduplicator.class);
        ListAggregator aggregator = new ListAggregator();
        //ListDeduplicator deduplicator = new ListDeduplicator();
        int distinct = aggregator.distinct(Arrays.asList(1, 2, 4, 2), deduplicator);


        Assertions.assertEquals(3, distinct);
    }*/
}
