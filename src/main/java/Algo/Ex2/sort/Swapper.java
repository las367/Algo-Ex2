package Algo.Ex2.sort;

import Algo.Ex2.lists.Listable;

public class Swapper<T> {
    
    protected void swap(Listable<T> list, int i, int j) {

        T memorizedObj = list.get(i);
        list.set(i, list.get(j));
        list.set(j, memorizedObj);
    }
}