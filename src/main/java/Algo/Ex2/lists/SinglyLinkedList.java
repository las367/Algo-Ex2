package Algo.Ex2.lists;

import Algo.Ex2.helper.Comparator;
import Algo.Ex2.sort.BubbleSort;
import Algo.Ex2.sort.SelectionSort;

public class SinglyLinkedList<T> implements Listable<T> {

    Node head = null;

    private class Node {

        T data;
        Node next;
    }

    //Ne Hilfsmethode zur Wiederbenutzung von search
    private Node getNodeByIndex(int index) {

        Node current = head;
        int counter = 0;

        while ( current != null ) {
            if ( counter == index ) {
                return current;
            }

            counter++;
            current = current.next;
        }

        return null;
    }

    @Override
    public Listable<T> searchBasedOnString( String query, Comparator<T> comparator ) {

        Listable<T> list = new SinglyLinkedList<T>();

        if ( head == null ) return null;

        Node current = head;
        while ( current != null ) {
            if ( comparator.checkIfEqualsString(current.data, query) ) {
                list.add(current.data);
            }

            current = current.next;
        }

        return list;
    }

    @Override
    public Listable<T> searchBasedOnInt( int query, Comparator<T> comparator ) {

        Listable<T> list = new SinglyLinkedList<T>();

        if ( head == null ) return null;

        Node current = head;
        while ( current != null ) {

            if ( comparator.checkIfEqualsInt(current.data, query) ) {

                list.add(current.data);
            }

            current = current.next;
        }

        return list;
    }

    @Override
    public void bubbleSort( Comparator<T> comparator ) {

        new BubbleSort<T>().sort(this, comparator);
    }

    @Override
    public void selectionSort( Comparator<T> comparator ) {

        new SelectionSort<T>().sort(this, comparator);
    }

    @Override
    public void add(T data) {

        //Also wenn kein Index verfügbar ist, dann wirkt die Methode genau wie addLast Methode
        addLast(data);
    }

    @Override
    public void add(int index, T data) {

        Node node = new Node();
        node.data = data;

        //if the index given is at least no bigger than the size (size is length + 1) means
        //when index == size => addLast
        //First get parent and child node where the new node would be inserted 
        Node parentNode = getNodeByIndex(index - 1);

        if ( parentNode == null ) return;
        
        Node childNode = parentNode.next;

        parentNode.next = node;
        node.next = childNode;
    }

    @Override
    public void addFirst(T data) {

        Node node = new Node();
        node.data = data;

        Node temp = head;

        //the exchange
        head = node;
        node.next = temp;
    }

    @Override
    public void addLast(T data) {

        Node node = new Node();
        node.data = data;
        node.next = null;

        if (head == null) {
            head = node;
        } else {

            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = node;
        }
    }

    @Override
    public T get(int index) {

        Node searchedElement = getNodeByIndex(index);

        if (searchedElement != null) {
            return searchedElement.data;
        }

        return null;
    }

    @Override
    public void set(int index, T data) {

        Node searchedNode = getNodeByIndex(index);

        if ( searchedNode != null ) {
            searchedNode.data = data;
        }
    }

    @Override
    public void remove(int index) {

        Node parentNode = getNodeByIndex( index - 1 );
        Node searchedNode = parentNode.next;

        if ( searchedNode != null ) {

            parentNode.next = searchedNode.next;
        }
    }

    @Override
    public void clear() {
        head = null;
    }

    @Override
    public int size() {

        int counter = 0;
        Node current = head;
        
        while (current != null) {
            counter++;
            current = current.next;
        }

        return counter;
    }

    @Override
    public void printAll() {

        Node current = head;
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }

    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public boolean equals(Object obj) {
        SinglyLinkedList<T> toCompare = (SinglyLinkedList<T>) obj;

        Node current = head;
        Node compareCurrent = toCompare.head;

        while ( current != null && compareCurrent != null ) {

            if ( !current.data.equals(compareCurrent.data) ) return false;

            current = current.next;
            compareCurrent = compareCurrent.next;
        }

        if ( current == null && compareCurrent == null ) return true;

        return false;
    }
}