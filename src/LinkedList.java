/**
 * Created by student on 10/17/17.
 */

import java.util.*;

@SuppressWarnings("serial")

public class LinkedList<T> implements Iterable<T> {
    private Node<T> root;

    /**
     * Constructs an empty list
     **/

    public LinkedList() {
        root = null;
    }

    /**
     * Returns true if the list is empty
     */

    public boolean isEmpty() {
        return root == null;
    }

    /**
     * Inserts a new node at the beginning of this list.
     * This root references itself
     */

    public void addFirst(T item) {
        root = new Node<>(item, root);
    }

    /**
     * Returns the first element in the list.
     */

    public T getFirst() {
        if (root == null) throw new NoSuchElementException();

        return root.data;
    }

    /**
     * Removes the first element in the list.
     */

    public T removeFirst() {
        T temp = getFirst();
        root = root.next;
        return temp;
    }

    /**
     * Inserts a new node to the end of this list.
     */

    public void addLast(T item) {
        if (root == null)
            addFirst(item);
        else {
            Node<T> temp = root;
            while (temp.next != null) temp = temp.next;

            temp.next = new Node <T> (item, null);
        }
    }

    /**
     * Returns the last element in the list.
     */

    public T getLast() {
        if (root == null) throw new NoSuchElementException();

        Node<T> temp = root;
        while (temp.next != null) temp = temp.next;

        return temp.data;
    }

    /**
     * Removes all nodes from the list.
     */

    public void clear() {
        root = null;
    }

    /**
     * Returns true if this list contains the specified element.
     */
    public boolean contains(T x) {
        for (T tmp : this)
            if (tmp.equals(x)) return true;

        return false;
    }

    /**
     * Returns the data at the specified position in the list.
     */

    public T get(int pos) {
        if (root == null) throw new IndexOutOfBoundsException();

        Node<T> tmp = root;
        for (int k = 0; k < pos; k++) tmp = tmp.next;

        if (tmp == null) throw new IndexOutOfBoundsException();

        return tmp.data;
    }

    /**
     * Returns a string representation
     */

    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Object x : this)
            result.append(x + " ");

        return result.toString();
    }

    /**
     * Inserts a new node after a node containing the key.
     */

    public void insertAfter(T key, T toInsert) {
        Node<T> tmp = root;

        while (tmp != null && !tmp.data.equals(key)) tmp = tmp.next;

        if (tmp != null)
            tmp.next = new Node<T>(toInsert, tmp.next);
    }

    /**
     * Inserts a new node before a node containing the key.
     */

    public void insertBefore(T key, T toInsert) {
        if (root == null) return;

        if (root.data.equals(key)) {
            addFirst(toInsert);
            return;
        }

        Node<T> previous = null;
        Node<T> current = root;

        while (current != null && !current.data.equals(key)) {
            previous = current;
            current = current.next;
        }
        //insert between cur and prev
        if (current != null)
            previous.next = new Node<T>(toInsert, current);
    }

    /**
     * Removes the first occurrence of the specified element in this list.
     */

    public void remove(T key) {
        if (root == null)
            throw new RuntimeException("ERROR -> Couldn't delete");

        if (root.data.equals(key)) {
            root = root.next;
            return;
        }

        Node<T> current = root;
        Node<T> previous = null;

        while (current != null && !current.data.equals(key)) {
            previous = current;
            current = current.next;
        }

        if (current == null)
            throw new RuntimeException("ERROR -> Couldn't delete");

        /** delete cur node */

        previous.next = current.next;
    }

    /**
     * Returns a copy of the list
     * Complexity: O(n^2)
     */


    public LinkedList<T> copy1() {
        LinkedList<T> twin = new LinkedList<T>();
        Node<T> temp = root;
        while (temp != null) {
            twin.addLast(temp.data);
            temp = temp.next;
        }

        return twin;
    }

    /**
     * Returns a copy of the list
     * Complexity: O(n)
     */

    public LinkedList<T> copy2() {
        LinkedList<T> twin = new LinkedList<T>();
        Node<T> temp = root;
        while (temp != null) {
            twin.addFirst(temp.data);
            temp = temp.next;
        }

        return twin.reverse();
    }

    /**
     * Reverses the list
     * Complexity: O(n)
     */

    public LinkedList<T> reverse() {
        LinkedList<T> list = new LinkedList<T>();
        Node<T> temp = root;
        while (temp != null) {
            list.addFirst(temp.data);
            temp = temp.next;
        }
        return list;
    }

    /**
     * Returns a copy of the immutable list
     * It uses a tail reference.
     * Complexity: O(n)
     */

    public LinkedList<T> copy3() {
        LinkedList<T> twin = new LinkedList<T>();
        Node<T> temp = root;
        if (root == null) return null;
        twin.root = new Node<T>(root.data, null);
        Node<T> tmpTwin = twin.root;
        while (temp.next != null) {
            temp = temp.next;
            tmpTwin.next = new Node<T>(temp.data, null);
            tmpTwin = tmpTwin.next;
        }

        return twin;
    }

    /*******************************************************
     *
     *  Iterator
     *
     ********************************************************/

    public Iterator<T> iterator() {
        return new LinkedListIterator();
    }

    private class LinkedListIterator implements Iterator<T> {
        private Node<T> nextNode;

        public LinkedListIterator() {
            nextNode = root;
        }

        public boolean hasNext() {
            return nextNode != null;
        }

        public T next() {
            if (!hasNext()) throw new NoSuchElementException();
            T res = nextNode.data;
            nextNode = nextNode.next;
            return res;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}