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
    }
}
