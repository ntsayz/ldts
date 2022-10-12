package com.aor.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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

    @Test void max1(){
        List<Integer> list = getList();

        ListAggregator aggregator = new ListAggregator();
        int max = aggregator.max(list); //

        Assertions.assertEquals(5, max);
    }

    @Test
    public void sum() {
        List<Integer> list = getList();

        ListAggregator aggregator = new ListAggregator();
        int sum = aggregator.sum(list); //

        Assertions.assertEquals(14, sum);
    }

    @Test
    public void max() {
        List<Integer> list = getList();

        ListAggregator aggregator = new ListAggregator();
        int max = aggregator.max(list);

        Assertions.assertEquals(5, max);
    }

    @Test
    public void min() {
        List<Integer> list = getList();

        ListAggregator aggregator = new ListAggregator();
        int min = aggregator.min(list);

        Assertions.assertEquals(1, min);
    }

    @Test
    public void distinct() {
        List<Integer> list = getList();

        ListAggregator aggregator = new ListAggregator();
        int distinct = aggregator.distinct(list);

        Assertions.assertEquals(4, distinct);
    }
}
