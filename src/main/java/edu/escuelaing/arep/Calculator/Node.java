package edu.escuelaing.arem.ASE.app;

/**
 * Node Node class. An object which holds it's next and previous Nodes and holds
 * a value
 */
public class Node<T> {
    public T value;
    public Node<T> next, prev;

    /**
     * Empty constructor
     */
    public Node() {

    }

    /**
     * Node constructor
     * 
     * @param v    main value of the node
     * @param next next Node
     * @param prev previous node
     */
    public Node(T v, Node<T> next, Node<T> prev) {
        value = v;
        this.next = next;
        this.prev = prev;

    }

    /**
     * Node constructor, set next and previous nodes as null
     * 
     * @param v main node value
     */
    public Node(T v) {
        value = v;
        this.next = null;
        this.prev = null;

    }

    /**
     * Returns the main value of the node
     * 
     * @return value of the node
     */
    public T getValue() {
        return value;
    }

    /**
     * Sets the main value of the node
     * 
     * @param value the new value of the node
     */
    public void setValue(T value) {
        this.value = value;
    }

    /**
     * Returns the next nodes
     * 
     * @return The next node
     */
    public Node<T> getNext() {
        return next;
    }

    /**
     * Sets the next node
     * 
     * @param next the new next node
     */
    public void setNext(Node<T> next) {
        this.next = next;
    }

    /**
     * Returns the prior node
     * 
     * @return the prior node
     */
    public Node<T> getPrev() {
        return prev;
    }

    /**
     * Sets the prior node
     * 
     * @param prior the new prior node
     */
    public void setPrev(Node<T> prior) {
        this.prev = prior;
    }

    /**
     * Returns the next nodes
     * 
     * @return The next node
     */
    public Node<T> next() {
        return next;
    }

    /**
     * Returns the prior node
     * 
     * @return the prior node
     */
    public Node<T> prev() {
        return prev;
    }

    /**
     * voids the node and its content
     */
    public void delete() {
        next = null;
        value = null;
        prev = null;
    }

    /**
     * Compares the values of two nodes
     * 
     * @param comp the other node to compare
     * @return boolean that says if the values are equal
     */
    public boolean equals(Node<T> comp) {
        if (this.value.equals(comp.getValue())) {
            return true;
        }
        return false;

    }

}
