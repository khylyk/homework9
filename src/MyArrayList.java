import java.util.Arrays;

public class MyArrayList <E> {
    private E[] arr;
    private int len;

    public MyArrayList(int num) {
        //базовий конструктор
        arr = (E[]) new Object[num];
        len = 0;
    }

    public void increaseSize(){
        //цей метод створює копію масиву, але розміром більше на 1
        int newLen = len + 1;
        arr = Arrays.copyOf(arr, newLen);
    }

    public void add(E element) {
        if (len == arr.length) {
            increaseSize();
        }
        arr[len++] = element;
    }

    public void remove(int index) {
        //перевіряємо, чи існує такий індекс
        if (index < 0 || index >= len) {
            throw new IndexOutOfBoundsException();
        }
        //зсуваємо масив на 1 елемент вліво
        for (int i = index; i < len - 1; i++) {
            arr[i] = arr[i + 1];
        }
        arr[len--] = null;

    }

    public E get(int index) {
        //перевіряємо, чи існує такий індекс
        if (index < 0 || index >= len) {
            throw new IndexOutOfBoundsException();
        }
        return arr[index];
    }

    public void clear() {
        //кожен елемент масиву стає пустим
        for (int i = 0; i < len; i++) {
            arr[i] = null;
        }
        len = 0;
    }

    public int size() {
        return len;
    }

}