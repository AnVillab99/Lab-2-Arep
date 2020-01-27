package edu.escuelaing.arem.ASE.app;

import java.util.Iterator;

/**
 * 
 * LinkedList class Is a genereic list that consist of multiple Nodes connected.
 */
public class LinkedList<T> implements Iterable<T> {

    private Node<T> head;
    private Node<T> tail;
    private int size;

    // private ArrayList<Node> lista=new ArrayList<Node>();
    /**
     * Empty contructor
     */
    public LinkedList() {
        size = 0;
    }

    /**
     * Constructor that recieves 1 data set and converts it to a node
     * 
     * @param data the value of the first node
     */
    public LinkedList(T data) {
        Node<T> n = new Node<T>(data, null, null);
        head = n;
        tail = n;
        size = 1;
    }

    /**
     * Constructor that receives a T data array
     * 
     * @param dat array of data T
     */
    public LinkedList(T[] dat) {
        Node<T> pre = null;
        Node<T> nex = null;
        int s = 0;
        for (T x : dat) {
            Node<T> n = new Node<T>(x, nex, pre);

            if (s == 0) {
                head = n;
            }
            if (!(s == 0)) {
                pre.setNext(n);
            }
            s++;

            pre = n;
            if (s == dat.length) {
                tail = n;
            }

        }

        size = s;
    }

    /**
     * Method add a single T data element
     * 
     * @param data T elemtn to add
     * @return boolean indicating if it was added
 
     */
    public boolean add(T data)  {

        Node<T> n = new Node<T>(data, null, tail);

        if (size == 0) {

            head = n;
        } else {
            tail.setNext(n);
            n.setPrev(tail);

        }
        tail = n;
        size++;

        return true;
    }

    /**
     * Method adds an element T in poscision index
     * 
     * @param index poscision where to add the data
     * @param data  T to be added
     * @throws Exception if the index is out of range
     */
    public void add(int index, T data) throws Exception {
        if (!(index < 0 || index >= size)) {

            Node<T> Iprev = getNode(index - 1);
            Node<T> Inext = getNode(index);
            Node<T> n = new Node<T>(data, Inext, Iprev);
            Iprev.setNext(n);
            Inext.setPrev(n);
            size++;
        } else
            throw new Exception("Index is out of range");
    }

    /**
     * Method adds to the linkedlist elements of an T data array
     * 
     * @param dat T data array
     * @return boolean indicating if the array was added
     * 
     */
    public boolean addAll(T[] dat) {

        Node<T> pre = tail;
        Node<T> nex = null;
        int s = size;
        for (T x : dat) {
            Node<T> n = new Node<T>(x, nex, pre);
            if (s == 0) {
                head = n;
            }
            if (!(s == 0)) {
                pre.setNext(n);
            }
            pre = n;
            if (s == dat.length) {
                tail = n;
            }
            s++;
        }

        size = s;
        return true;

    }

    /**
     * Method clears the linked list
     */
    public void clear() {
        head = null;
        tail = null;
        size = 0;
        System.gc();

    }

    /**
     * Methos that search for an specific value on the linkedlist
     * 
     * @param data Value to search on the linkedlist
     * @return boolean indicating if the value is present on the linkedlist
     */
    public boolean contains(T data) {

        Node<T> sHead = head;
        while (sHead.getNext() != null) {
            if (sHead.getNext().getValue().equals(data)) {
                return true;
            } else
                sHead = sHead.getNext();

        }
        return false;
    }

    /**
     * method returns an specific value based on an index
     * 
     * @param index int that indicates which value to return
     * @return T or null if the index is wrong
     * @throws Exception If the index is out of range
     */
    public T get(int index) throws Exception {
        if (index >= size || index < 0) {
            throw new Exception("Index is out of range");
        } else {
            Node<T> retornar = getNode(index);
            return retornar.getValue();
        }
    }

    /**
     * Method return the node in an specific location
     * 
     * @param index position of the node to extract
     * @return the node on the location or null if the location is invalid
     * @throws Exception If the index is out of range
     */
    private Node<T> getNode(int index) throws Exception {
        if (index >= size || index < 0) {
            throw new Exception("Index is out of range");
        } else {
            int m = size / 2;
            int it;
            Node<T> F = null;

            if (index <= m) {
                F = head;
                it = 0;
                while (it < index) {
                    F = F.getNext();
                    it++;
                }

            } else {
                it = size - 1;
                F = tail;
                while (it > index) {
                    F = F.getPrev();
                    it--;
                }

            }
            return F;
        }

    }

    /**
     * Method returns the index of an specific value
     * 
     * @param data the value to be searched
     * @return the index of the node where the value is stored, or -1 if it isn't
     *         found
     */
    public int indexOf(T data) {

        Node<T> sHead = head;
        int index = 0;

        while (index < size) {
            if (sHead.getValue().equals(data)) {
                return index;
            } else
                sHead = sHead.getNext();
            index++;

        }
        return -1;

    }

    /**
     * Method return a boolean indicating if the list is empty
     * 
     * @return boolean
     */
    public boolean isEmpty() {
        if (size != 0) {
            return false;
        } else
            return true;
    }

    /**
     * Method remove a node based on an specific value
     * 
     * @param data data that the node to be deleted contains
     * @return boolean indicating if the node was deleted
     * @throws Exception If the list is empty
     */
    public boolean remove(T data) throws Exception {
        if (!(size == 0)) {

            int exist = indexOf(data);

            if (exist != (-1)) {

                Node<T> Iprev = getNode(exist).getPrev();
                Node<T> Inext = getNode(exist).getNext();
                Node<T> n = getNode(exist);

                if (exist == size - 1) {
                    tail = Iprev;
                    Iprev.setNext(Inext);

                } else if (exist == 0) {
                    head = Inext;
                    Inext.setPrev(Iprev);

                } else {
                    Iprev.setNext(Inext);
                    Inext.setPrev(Iprev);
                }
                n.delete();
                n = null;
                return true;

            }
            return false;
        }

        else
            throw new Exception(" No element found");

    }

    /**
     * Method removes a node based on its position
     * 
     * @param index position of the node to be removed
     * @return boolean indicating if the node was removed
     * @throws Exception If the index is out of range
     * @throws Exception If the list is empty
     */
    public T remove(int index) throws Exception {

        if (index >= size || index < 0) {
            throw new Exception("Index is out of range");
        } else if (size == 0) {
            throw new Exception(" No element found");
        }

        if (index < size && index > -1) {
            Node<T> Iprev = getNode(index).getPrev();
            Node<T> Inext = getNode(index).getNext();
            Node<T> n = getNode(index);
            if (index == size - 1) {
                tail = Iprev;
                Iprev.setNext(Inext);

            } else if (index == 0) {
                head = Inext;
                Inext.setPrev(Iprev);

            } else {
                Iprev.setNext(Inext);
                Inext.setPrev(Iprev);
            }
            Node<T> deleted = n;
            n = null;

            return deleted.getValue();

        }
        return null;
    }

    /**
     * Method returns the size of the linkedlist
     * 
     * @return int the size of the linkedlist
     */
    public int size() {
        return size;
    }

    /**
     * Method remove the head of the linkedlist
     * 
     * @throws Exception If the ist is empty
     */
    public void removeHead() throws Exception {
        if (size == 0) {
            throw new Exception(" No element found");
        }

        Node<T> nHead = head.getNext();
        nHead.setPrev(null);
        head.delete();
        head = null;
        head = nHead;

    }

    /**
     * Method removes the tail of the linkedlist
     * 
     * @throws Exception If the ist is empty
     */
    public void removeTail() throws Exception {
        if (size == 0) {
            throw new Exception(" No element found");
        }
        Node<T> nTail = tail.getPrev();
        if (!(nTail == null)) {
            nTail.setNext(null);
            tail.delete();
            tail = null;
            tail = nTail;
        } else {
            head = null;
            tail = null;
        }

    }

    /**
     * Method returns the head of the linkedlist
     * 
     * @return Node the head of the linked list
     */
    public Node<T> head() {
        return head;
    }

    /**
     * Method returns the tail of the linkedlist
     * 
     * @return Node the tail of the linked list
     */
    public Node<T> tail() {
        return tail;
    }

    public Iterator<T> iterator() {
        return new IteratorLl<T>(this);
    }

}
