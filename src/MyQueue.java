import java.util.Arrays;

public class MyQueue <E>{
    private E[] arr;
    private int size;

    public MyQueue(int num){
        //базовий конструктор
        arr = (E[]) new Object[num];
        size = 0;
    }

    public void increaseSize(){
        //цей метод створює копію масиву, але розміром більше на 1
        int newLen = size + 1;
        arr = Arrays.copyOf(arr, newLen);
    }

    public void add(E element) {
        if (size == arr.length) {
            increaseSize();
        }
        arr[size++] = element;
    }

    public void clear() {
        //кожен елемент масиву стає пустим
        for (int i = 0; i < size; i++) {
            arr[i] = null;
        }
        size = 0;
    }

    public E peek(){
        return arr[0];
    }

    public E poll(){
        E element = arr[0];
        for (int i = 0; i < size - 1; i++) {
            arr[i] = arr[i + 1];
        }
        arr[--size] = null;
        return element;
    }


    public int size() {
        return size;
    }
}
