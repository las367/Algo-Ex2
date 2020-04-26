package Algo.Ex2.lists;

public class DoublyLinkedList<T> implements Listable<T> {

    Node head = null;
    Node tail = null;

    private class Node {
    
        T data;
        Node prev;
        Node next;
    }

    @Override
    public void add(T data) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void add(int index, T data) {
        // TODO Auto-generated method stub

    }

    @Override
    public void addFirst(T data) {
        // TODO Auto-generated method stub

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
        // TODO Auto-generated method stub

    }

    @Override
    public void remove(int index) {
        // TODO Auto-generated method stub

    }

    @Override
    public void clear() {
        // TODO Auto-generated method stub

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