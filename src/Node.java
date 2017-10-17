/**
 * Created by student on 10/17/17.
 */
public class Node<T extends Comparable<T>> {

    private Node<T> root;
    private T data;

    public Node(T data, Node<T> root){
        this.data = data;
        this.root = root;
    }
}
