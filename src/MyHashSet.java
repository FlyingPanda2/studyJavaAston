import java.util.Arrays;

public class MyHashSet<T> {
    private static final int INITIAL_CAPACITY = 16;
    private Object[] buckets;
    private int size;

    public MyHashSet() {
        buckets = new Object[INITIAL_CAPACITY];
    }

    public boolean add(T element) {
        if (element == null) {
            if (buckets[0] == null) {
                buckets[0] = new Object();
                size++;
                return true;
            }
            return false;
        }

        int index = Math.abs(element.hashCode()) % buckets.length;
        Object bucket = buckets[index];

        if (bucket == null) {
            buckets[index] = element;
            size++;
            return true;
        } else if (bucket.equals(element)) {
            return false;
        } else {
            resize();
            return add(element);
        }
    }

    public boolean remove(T element) {
        if (element == null) {
            if (buckets[0] != null) {
                buckets[0] = null;
                size--;
                return true;
            }
            return false;
        }

        int index = Math.abs(element.hashCode()) % buckets.length;
        if (buckets[index] != null && buckets[index].equals(element)) {
            buckets[index] = null;
            size--;
            return true;
        }
        return false;
    }

    private void resize() {
        Object[] oldBuckets = buckets;
        buckets = new Object[oldBuckets.length * 2];
        size = 0;
        for (Object obj : oldBuckets) {
            if (obj != null) {
                add((T) obj);
            }
        }
    }

    @SuppressWarnings("unchecked")
    public java.util.stream.Stream<T> stream() {
        return Arrays.stream(buckets)
                .filter(obj -> obj != null)
                .map(obj -> (T) obj);
    }
}
