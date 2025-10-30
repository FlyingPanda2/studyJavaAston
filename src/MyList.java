import java.util.Arrays;
import java.util.Objects;

public class MyList<T> {
    private Object[] elements;
    private int size;
    private static final int DEFAULT_CAPACITY = 10;

    public MyList() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    public void add(T item) {
        ensureCapacity();
        elements[size++] = item;
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        return (T) elements[index];
    }

    public boolean remove(T item) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(item, elements[i])) {
                System.arraycopy(elements, i + 1, elements, i, size - i - 1);
                elements[--size] = null;
                return true;
            }
        }
        return false;
    }

    public void addAll(MyList<T> other) {
        for (int i = 0; i < other.size; i++) {
            add(other.get(i));
        }
    }

    private void ensureCapacity() {
        if (size == elements.length) {
            elements = Arrays.copyOf(elements, size * 2);
        }
    }

    public int size() {
        return size;
    }

    public java.util.stream.Stream<T> stream() {
        return Arrays.stream(elements, 0, size).map(obj -> (T) obj);
    }
}
