package Algo.Ex2.sort;

import Algo.Ex2.helper.Comparator;
import Algo.Ex2.lists.Listable;

public interface Sortable<T> {
    public void sort(Listable<T> list, Comparator<T> comparator);
}