/**
 * Created by student on 10/17/17.
 */

public class Node<T>
{
    public T data;
    public Node<T> next;
    public Node<T> prev;
    public boolean isLast;

    public Node(T data, Node<T> next)
    {
        this.data = data;
        this.next = next;
    }

    public Node getNext() {
        if (next != null){
            return next;
        }
        else {
            return getHead();
        }
    }

    public Node getHead(){
        if(prev.getPrev() == null) {
            return prev;
        } else {
            return this.getPrev().getHead();
        }
    }

    public Node getPrev(){
        return prev;
    }
}
