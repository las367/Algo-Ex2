package Algo.Ex2.sort;

import Algo.Ex2.helper.Comparator;
import Algo.Ex2.lists.Listable;

public class SelectionSort<T> extends Swapper<T> implements Sortable<T> {

    @Override
    public void sort(Listable<T> list, Comparator<T> comparator) {

        int minimum = 0;
        for (int i = 0; i < list.size(); i++) {

            //move from left to right
            //set number i as minimum => beginning of the algo: set 0 as minimum
            minimum = i;
            for (int e = i + 1; e < list.size(); e++) {

                //for every step, search the minimum num between i and length of the list 
                if (comparator.compare(list.get(e), list.get(minimum)) < 0) {
                    minimum = e;
                }
                //at the end of every step the min number would be placed to where i is.
            }

            swap(list, i, minimum);
        }
    }
    
}