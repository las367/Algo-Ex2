package Algo.Ex2.helper;

import Algo.Ex2.lists.DoublyLinkedList;

public interface Comparator<T> {
    int compare(T o1, T o2);
    boolean checkIfEqualsString(T o1, String query);
    boolean checkIfEqualsInt(T o1, int query);
}