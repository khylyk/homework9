//цілий день гуглила як це зробити, сподіваюся результат буде зарахований)
public class MyLinkedList<E> {
    private Node head;
    private Node tail;
    private int size;

    private class Node {
        //створюю клас ноди з полями значення та посилання на наступний та попередній елемент
        private E value;
        private Node next;
        private Node prev;

        public Node(E value, Node next, Node prev) {
            //конструктор ноди
            this.value = value;
            this.next = next;
            this.prev = prev;
        }
    }

    public MyLinkedList() {
        //конструктор лінкед списку
        head = null;
        tail = null;
        size = 0;
    }

    public void add(E value) {
        //створюю ноду, яку будемо додавати в список
        Node newNode = new Node(value, null, tail);
        //якщо список порожній, ця нода стає "головою"
        if (tail == null) {
            head = newNode;
        } else {
            tail.next = newNode;
        }//інакше додаємо ноду в кінець
        //останній елемент стає "хвостом"
        tail = newNode;
        size++;
    }

    //найскладніша функція як на мене
    public void remove(int index) {
        //перевіряємо чи індекс дійсний
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        //починаємо спочатку списку, з голови
        Node nodeToRemove = head;
        //у цьому циклі ми шукаємо ноду, яку потрібно видалити. Ми просто проходимо весь список до необхідного індексу, аби його зберегти
        for (int i = 0; i < index; i++) {
            nodeToRemove = nodeToRemove.next;
        }
        //зберігаємо ноди, на яку ссилається та, що повинна бути видалена
        Node prevNode = nodeToRemove.prev;
        Node nextNode = nodeToRemove.next;
        //якщо це був перший елемент, другий стає першим
        if (prevNode == null) {
            head = nextNode;
        } else {
            prevNode.next = nextNode; //змінюємо посилання так, аби воно "обходило" елемент, що ми видаляємо
            nodeToRemove.prev = null;
        }

        //якщо це був останній елемент, передостанній стає хвостом
        if (nextNode == null) {
            tail = prevNode;
        } else {
            nextNode.prev = prevNode; //змінюємо посилання так, аби воно "обходило" елемент, що ми видаляємо
            nodeToRemove.next = null;
        }

        nodeToRemove.value = null; //стираємо значення
        size--;
    }

    public void clear() {
        //починаючи з голови, проходимо кожний елемент та очищаємо його посилання та значення
        Node node = head;
        while (node != null) {
            Node next = node.next;
            node.value = null;
            node.next = null;
            node.prev = null;
            node = next;
        }
        head = null;
        tail = null;
        size = 0;
    }

    public E get(int index) {
        //перевіряємо чи індекс дійсний
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node node = head;
        //у цьому циклі ми шукаємо ноду, яку потрібно видалити. Ми просто проходимо весь список до необхідного індексу, аби його зберегти
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node.value;
    }

    public int size() {
        return size;
    }
}