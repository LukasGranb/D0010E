import java.util.ArrayList;
import java.util.NoSuchElementException;

public class FIFO implements Queue {

private ArrayList<Object> elements;
private int maxSize;

    public FIFO() {
        elements = new ArrayList<>();
        maxSize = 0;
    }
    @Override
    public int size() {
        return elements.size();
    }

    @Override
    public int maxSize() {
        return maxSize;
    }

    @Override
    public boolean isEmpty() {
        return elements.isEmpty();
    }

    @Override
    public Object first() {
        if (isEmpty()) {
            throw new NoSuchElementException("The queue is empty");
        }
        return elements.get(0);
    }

    @Override
    public boolean equals(Object f) {
        FIFO other = (FIFO) f;
        if (this.size() != other.size()) {
            return false;
        }
        for (int i = 0; i < this.size(); i++) {
            if (this.elements.get(i) == null && other.elements.get(i) != null) {
                return false;
            }
            if (this.elements.get(i) != null && !this.elements.get(i).equals(other.elements.get(i))) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        String result = "Queue: ";
        for (int i = 0; i < this.size(); i++) {
            result += "(" + String.valueOf(elements.get(i)) + ") ";
        }
        return result;
    }

    public void add(Object item) {
        elements.add(item);
    }

    public void removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("The queue is empty");
        }
        elements.remove(0);
    }
}