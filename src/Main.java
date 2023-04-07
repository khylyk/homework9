public class Main {
    public static void main(String[] args){
        MyArrayList arrayList = new MyArrayList<>(5);

        arrayList.add(5);
        arrayList.add("house");
        arrayList.add(true);

        System.out.println(arrayList.get(0));
        System.out.println(arrayList.size());

        MyLinkedList linkedList = new MyLinkedList();

        linkedList.add(5);
        linkedList.add("house");
        linkedList.add(true);

        System.out.println(linkedList.get(0));
        System.out.println(linkedList.size());

        MyQueue queue = new MyQueue<>(5);

        queue.add(5);
        queue.add("house");
        queue.add(true);

        System.out.println(queue.peek());

        MyStack stack = new MyStack<>(5);

        stack.push(5);
        stack.push("house");
        stack.push(true);

        System.out.println(stack.peek());

        MyHashMap hashMap = new MyHashMap<>(5);

        hashMap.put(1, 5);
        hashMap.put(2, "house");
        hashMap.put(3, true);

        System.out.println(hashMap.get(2));
    }
}
