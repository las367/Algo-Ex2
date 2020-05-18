package Algo.Ex2.lists;

import Algo.Ex2.helper.Comparator;
import Algo.Ex2.sort.BubbleSort;
import Algo.Ex2.sort.SelectionSort;

public class DoublyLinkedList<T> implements Listable<T> {

    //TODO OPTIMIZE => set static variable size => faster getNodeByIndex.

    Node head;
    Node tail;
    int size;

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
        //TODO optimize => get the size then when index > middle => start from tail.

        if ( index > size ) return null;

        Node current;
        int counter;
        if ( index > size / 2 ) {

            counter = size - 1;
            current = tail;
            while ( current != null ) {

                if ( counter == index ) {
                    return current;
                }

                counter--;
                current = current.prev;
            }
        } else {

            counter = 0;
            current = head;
            while ( current != null ) {

                if ( counter == index ) {
                    return current;
                }

                counter++;
                current = current.next;
            }
        }

        return null;
    }

    //implemented search algorithm here => moves from both head and tail to make the algo quicker.

    @Override
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

    @Override
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

    //implements swapper for each lists => swapper for singly != swapper for doubly!
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
            if ( childNode != null ) childNode.prev = node;
            size++;
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

        size++;
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
            if ( temp != null ) temp.next = tail;
        }

        size++;
    }

    @Override
    public T get(int index) {

        Node node = getNodeByIndex(index);

        if ( node == null ) return null;

        return node.data;
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

        boolean indexIsZero = index == 0;

        if ( indexIsZero ) {

            head = head.next;
            head.prev = null;
            size--;

        } else {

            Node parentNode = getNodeByIndex( index - 1 );
            Node searchedNode = null;

            if  ( parentNode != null ) searchedNode = parentNode.next;
    
            if ( searchedNode != null ) {
    
                parentNode.next = searchedNode.next;
                if ( searchedNode.next != null ) searchedNode.next.prev = parentNode;
                size--;
            }
        }
    }

    @Override
    public void clear() {

        head = null;
        size = 0;
    }

    @Override
    public int size() {
        return size;
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