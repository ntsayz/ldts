package com.aor.numbers;

import java.util.ArrayList;
import java.util.List;

public interface GenericListDeduplicator {

    default List<Integer> deduplicate(List<Integer> list){
        return new ArrayList<>();
    }
}
