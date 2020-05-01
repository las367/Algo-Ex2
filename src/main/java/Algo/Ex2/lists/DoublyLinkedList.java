package Algo.Ex2.lists;

public class DoublyLinkedList<T> implements Listable<T> {

    Node head = null;
    Node tail = null;

    private class Node {
    
        T data;
        Node prev;
        Node next;
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
        if ( index <= size() ) {

            //First get parent and child node where the new node would be inserted 
            Node parentNode = getNodeByIndex(index - 1);
        
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
    }

    @Override
    public void addFirst(T data) {

        Node node = new Node();
        node.data = data;

        Node temp = head;

        //the exchange
        if ( head == null ) {

            head = node;
            tail = node;
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
            tail = node;
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

        printAll();
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
    
}