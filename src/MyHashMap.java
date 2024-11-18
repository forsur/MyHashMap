public class MyHashMap<K,V> {

    private Node<K,V>[] bucket;
    private int capacity = 16;
    private int size;

    static final float LOAD_FACTOR = 0.75f;

    public MyHashMap(int capacity)
    {
        this.capacity = capacity;
        this.bucket = new Node[capacity];
        this.size = 0;
    }

    public MyHashMap()
    {
        this.bucket = new Node[16];
        this.size = 0;
    }

    public int hashFunction(K key)
    {
        int hashCode = key.hashCode();
        return Math.abs(hashCode % capacity);
    }

    public void resize()
    {
        int curSize = this.size;
        this.capacity *= 2;
        Node<K,V>[] newBucket = new Node[capacity];
        for(Node<K, V> node : bucket)
        {
            if (node != null) {
                Node<K, V> iter = node;
                while (iter != null) {
                    putInBucket(iter.key, iter.val, newBucket);
                    iter = iter.next;
                }
            }
        }
        this.size = curSize;
        this.bucket = newBucket;
    }

    public void putInBucket(K key, V val, Node<K,V>[] curBucket)
    {
        int idx = hashFunction(key);
        Node<K,V> bucketElement = curBucket[idx];
        if(bucketElement == null){
            curBucket[idx] = new Node<K,V>(key, val);
            size++;
        }else{
            Node<K,V> iter = bucketElement;
            while(iter != null && !iter.key.equals(key))
            {
                iter = iter.next;
            }
            if(iter == null){
                Node<K,V> newListNode = new Node<K,V>(key, val, bucketElement);
                curBucket[idx] = newListNode;
                size++; // 此时也需要增加 size
            }else{
                iter.val = val;
            }
        }
    }


    public void put(K key, V val)
    {
        if(size >= LOAD_FACTOR * capacity){
            resize();
        }

        putInBucket(key, val, this.bucket);
    }


    public V get(K key)
    {
        int idx = hashFunction(key);

        Node<K,V> bucketElement = bucket[idx];
        if(bucketElement == null){
            return null;
        }else{
            Node<K,V> iter = bucketElement;
            while(iter != null && !iter.key.equals(key))
            {
                iter = iter.next;
            }
            if(iter == null){
                return null;
            }else{
                return iter.val;
            }
        }
    }

    public int getSize()
    {
        return size;
    }

}