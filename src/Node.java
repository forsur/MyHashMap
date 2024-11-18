public class Node<K,V> {
    public K key;
    public V val;
    public Node<K,V> next;

    public Node(K key, V val, Node<K,V> next)
    {
        this.key = key;
        this.val = val;
        this.next = next;
    }

    public Node(K key, V val) {
        this.key = key;
        this.val = val;
    }
}