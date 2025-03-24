import java.util.ArrayList;
import java.util.NoSuchElementException;

public class FIFO {

    private ArrayList<Object> queue;
    private int size;

    public FIFO() {
        queue = new ArrayList<>();
        size = 0;
    }
    public int size() {
        return size;
    }
    public boolean isEmpty() {
        return size == 0;
    }

    public Object first() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return this.queue.getFirst();
    }

    public boolean equals(Object f) {
        FIFO F = (FIFO) f;
        if (this.size != F.size()) {
            return false;
        }
        for (int i = 0; i < this.size; i++) {
            if (this.queue.get(i) == null && !(F.queue.get(i) == null)) {
                return false;
            }
            if (!this.queue.get(i).equals(F.queue.get(i))) {
                return false;
            }
        }
        return true;
    }

    public String toString() {
        String result = "Queue";
        for (Object element : queue) {
            result += "(" + String.valueOf(element) + ")";
        }
        return result;
    }

    public void add(Object item) {
        queue.add(item);
        size++;
    }

    public void removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        this.queue.removeFirst();
    }



}
