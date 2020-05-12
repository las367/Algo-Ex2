package Algo.Ex2.sort;

import Algo.Ex2.helper.Comparator;
import Algo.Ex2.lists.Listable;

public class BubbleSort<T> extends Swapper<T> implements Sortable<T> {

    @Override
    public void sort(Listable<T> list, Comparator<T> comparator) {
        
        //moves from left to right
        boolean swapped = true;
        for ( int i = 1; swapped && i < list.size(); i++ ) {

            //swapped => we don't have to go through the array when the array is already sorted.
            //swap flag => on best case => time complexity = O(n)
            swapped = false;
            //moves from left to right, everytime element e is bigger than e + 1 => swap the element
            for ( int j = 0; j < list.size() - i; j++ ) {
                
                if ( comparator.compare(list.get(j), list.get(j+1)) > 0 ) {
                    swap( list, j, j+1 );
                    //at the end of every step => the largest element would be at the far right
                    swapped = true;
                }
            }
        }
    }
    
}