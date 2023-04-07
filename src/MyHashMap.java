import java.util.Arrays;

//linkedlist у порівнянні з цим ще дуже простий...
//взяла багато з інтернету, але сподіваюся це не проблема
public class MyHashMap<K, V> {

    private Node<K, V>[] table;
    private int size;

    private static class Node<K, V> {
        //цей клас ноди відрізняється від того що в LinkedList, бо тут тільки одностороння прив'язка
        private final K key;
        private V value;
        private Node<K, V> next;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }

        public Node<K, V> getNext() {
            return next;
        }

        public void setNext(Node<K, V> next) {
            this.next = next;
        }
    }

    public MyHashMap(int num) {
        table = (Node<K, V>[]) new Node[num];
        size = 0;
    }

    public void put(K key, V value) {
        int index = getIndex(key); //рахуємо хещ-код ключа
        Node<K, V> node = table[index];
        //шукаємо нод з цим хеш-кодом
        while (node != null) {
            if (node.getKey().equals(key)) {
                node.setValue(value); //якщо є нод з таким ключем, змінюємо його значення
                return;
            }
            node = node.getNext();
        }
        //якщо такого ключа немає, створюємо новий
        Node<K, V> newNode = new Node<>(key, value);
        newNode.setNext(table[index]);
        table[index] = newNode;
        size++;
    }

    public V get(K key) {
        int index = getIndex(key); //рахуємо хещ-код ключа
        Node<K, V> node = table[index];
        //шукаємо нод з цим хеш-кодом
        while (node != null) {
            if (node.getKey().equals(key)) {
                return node.getValue(); //якщо є нод з таким ключем, повертаємо його значення
            }
            node = node.getNext();
        }

        return null; //інакше повертаємо null
    }

    public void remove(K key) {
        int index = getIndex(key); //рахуємо хещ-код ключа
        Node<K, V> node = table[index];
        Node<K, V> prev = null;
        //шукаємо нод з цим хеш-кодом
        while (node != null) {
            if (node.getKey().equals(key)) {
                if (prev == null) {
                    table[index] = node.getNext(); //якщо нода була першою, встановлюємо наступну першою
                } else {
                    prev.setNext(node.getNext()); //інакше змінюємо посилання на попередню
                }
                size--;
                return;
            }
            prev = node;
            node = node.getNext();
        }
    }

    public void clear() {
        Arrays.fill(table, null);
        size = 0;
    }

    public int size() {
        return size;
    }

    private int getIndex(K key) {
        //тут ми вираховуємо індекс ключа за допомогою його хеш коду
        return Math.abs(key.hashCode() % table.length);
    }


}

