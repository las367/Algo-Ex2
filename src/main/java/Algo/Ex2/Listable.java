package Algo.Ex2;

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
}