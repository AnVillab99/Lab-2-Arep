package edu.escuelaing.arem.ASE.app;

import java.util.Iterator;

/**
 * Creates an Itereator for the given linkedlist
 * @param <T> type of value of the list
 */
public class IteratorLl<T> implements Iterator<T> {

    Node<T> now;

    /**
     * Creates an Itereator for the given linkedlist
     * @param l linkedlist to get the iterator from
     */
    public IteratorLl(LinkedList<T> l) {
        now = l.head();
    }
    
    /**
     * Method checks if the itereator has a next node.
     * @return boolean indicating if the current node has a next node.
     */
    public boolean hasNext() {
        boolean t=true;
        if(now.next==null){ t=false;}

        return t;
    }

    /**
     * method replace the current iterator node with the next one and returns the value of the current one 
     * @return T returns the value of the prior iterator node
     */
    public T next() {
        T data = now.getValue();
        now = now.next();
        return data;
    }
}