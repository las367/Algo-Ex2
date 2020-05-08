package Algo.Ex2.lists;

import Algo.Ex2.helper.Comparator;

public interface Listable<T> {

    void add(T data);

    void add(int index, T data);

    void addFirst(T data);

    void addLast(T data);

    T get(int index);

    void set(int index, T data);

    void remove(int index);

    void clear();

    int size();

    void printAll();

    boolean isEmpty();

    Listable<T> searchBasedOnString(String query, Comparator<T> Comparator);
    
    Listable<T> searchBasedOnInt(int query, Comparator<T> comparator);

    void bubbleSort( Comparator<T> comparator );

    void selectionSort( Comparator<T> comparator );
}