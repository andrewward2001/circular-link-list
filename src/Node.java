/**
 * Created by student on 10/17/17.
 */

import java.util.*;
import java.util.function.Consumer;

public class Node<T> implements Iterable<T> {
    private Node<T> root;
    public Node(){
        root = null;
    }

    public boolean isEmpty()
    {
        return root == null;
    }

    public void addFirst(T item)
    {
        root = new Node<T>(item, root);
    }

    public Iterator<T> iterator() {
        return null;
    }

    public void forEach(Consumer<? super T> action) {

    }

    public Spliterator<T> spliterator() {
        return null;
    }
}
