package Algo.Ex2.lists;

import Algo.Ex2.helper.Comparator;
import Algo.Ex2.sort.BubbleSort;
import Algo.Ex2.sort.SelectionSort;

public class DoublyLinkedList<T> implements Listable<T> {

    Node head = null;
    Node tail = null;

    private class Node {
    
        T data;
        Node prev;
        Node next;
    }

    //to check if the node from left and right overflows e.g left reached index 2 while right reached index 3/2
    public boolean nodeOverflows(Node left, Node right) {

        if ( left.next == right.prev ) return true;
        
        return left == right;
    }

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

    //implemented search algorithm here => moves from both head and tail to make the algo quicker.

    public Listable<T> searchBasedOnInt( int query, Comparator<T> comparator ) {

        Listable<T> list = new DoublyLinkedList<>();

        if ( head == null ) return null;
        if ( tail == null ) {
            if ( comparator.checkIfEqualsInt(head.data, query) ) {
                list.add(head.data);
                return list;
            }
        }

        Node currentLeft = head;
        Node currentRight = tail;

        while ( !nodeOverflows(currentLeft, currentRight) ) {

            if ( comparator.checkIfEqualsInt(currentLeft.data, query) ) {
                list.add(currentLeft.data);
            }

            if ( comparator.checkIfEqualsInt(currentRight.data, query) ) {
                list.add(currentRight.data);
            }

            currentLeft = currentLeft.next;
            currentRight = currentRight.prev;

        }

        return list;
    }

    public Listable<T> searchBasedOnString( String query, Comparator<T> comparator ) {

        Listable<T> list = new DoublyLinkedList<>();

        if ( head == null ) return null;
        if ( tail == null ) {
            if ( comparator.checkIfEqualsString(head.data, query) ) {
                list.add(head.data);
                return list;
            }
        }

        Node currentLeft = head;
        Node currentRight = tail;

        while ( !nodeOverflows(currentLeft, currentRight) ) {

            if ( comparator.checkIfEqualsString(currentLeft.data, query) ) {
                list.add(currentLeft.data);
            }

            if ( comparator.checkIfEqualsString(currentRight.data, query) ) {
                list.add(currentRight.data);
            }

            currentLeft = currentLeft.next;
            currentRight = currentRight.prev;

        }

        return list;
    }

    public void bubbleSort( Comparator<T> comparator ) {

        new BubbleSort<T>().sort(this, comparator);
    }

    public void selectionSort( Comparator<T> comparator ) {

        new SelectionSort<T>().sort(this, comparator);
    }

    @Override
    public void add(T data) {

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

        if ( parentNode != tail ) {

            Node childNode = parentNode.next;

            node.prev = parentNode;
            node.next = childNode;

            parentNode.next = node;
            childNode.prev = node;
        } else {

            addLast(data);
        }
    }

    @Override
    public void addFirst(T data) {

        Node node = new Node();
        node.data = data;

        Node temp = head;

        //the exchange
        if ( head == null ) {

            head = node;
        } else {

            head = node;
            node.next = temp;
            temp.prev = node;
        }
    }

    @Override
    public void addLast(T data) {

        Node node = new Node();
        node.data = data;
        node.next = null;

        if ( head == null ) {

            head = node;
        } else if ( head.next == null ) {
            
            tail = node;
            tail.prev = head;
            head.next = tail;
        } else {

            Node temp = tail;
            tail = node;
            tail.prev = temp;
            temp.next = tail;
        }
    }

    @Override
    public T get(int index) {
        
        int counter = 0;
        Node current = head;

        while (current != null) {
            if (counter == index) {
                return current.data;
            }
            
            counter++;
            current = current.next;
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
        DoublyLinkedList<T> toCompare = (DoublyLinkedList<T>) obj;

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