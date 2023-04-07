import java.util.Arrays;

public class MyStack <E>{
    private E[] arr;
    private int size;

    public MyStack(int num){
        arr = (E[]) new Object[num];
        size = 0;
    }

    public void increaseSize(){
        //цей метод створює копію масиву, але розміром більше на 1
        int newLen = size + 1;
        arr = Arrays.copyOf(arr, newLen);
    }

    public void push(E element) {
        if (size == arr.length) {
            increaseSize();
        }
        arr[size++] = element;
    }

    public void remove(int index) {
        //перевіряємо, чи існує такий індекс
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        //зсуваємо масив на 1 елемент вліво
        for (int i = index; i < size - 1; i++) {
            arr[i] = arr[i + 1];
        }
        arr[--size] = null;
    }

    public void clear() {
        //кожен елемент масиву стає пустим
        for (int i = 0; i < size; i++) {
            arr[i] = null;
        }
        size = 0;
    }

    public E peek(){
        return arr[size - 1];
    }

    public E pop(){
        E element = arr[size - 1];
        arr[--size] = null;
        return element;
    }

    public int size() {
        return size;
    }
}
