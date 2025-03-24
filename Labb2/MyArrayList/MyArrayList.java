import java.io.Serializable;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

@SuppressWarnings("serial")
public class MyArrayList<E> implements Serializable, Cloneable, Iterable<E>,
        Collection<E>, List<E>, RandomAccess {


    private int size;
    private E[] elements;

    // ---------------------------------------------------------------

    public static void main(String[] args) {
        MyArrayList<String> strlist = new MyArrayList<String>();

    }

    // ---------------------------------------------------------------

    public MyArrayList(int initialCapacity) {
        if (initialCapacity < 0) {
            throw new IllegalArgumentException();
        }
        Object[] array = new Object[initialCapacity];
        this.size = 0;
        this.elements = (E[]) array;
    }

    public MyArrayList() {
        this(10);
    }

    // -- 1 --

    @Override
    public int size() {
        /* ska implementeras */
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        /* ska implementeras */
        return (size() == 0);
    }

    @Override
    public void clear() {
        /* ska implementeras */
        if (isEmpty()) {
            return;
        }
        for (int i = 0; i < this.elements.length; i++) {
            if (elements[i] != null) {
                elements[i] = null;
            }
        }
        this.size = 0;
    }

    // -- 2 --

    public void ensureCapacity(int minCapacity) {
        if (minCapacity > this.elements.length) {
            Object[] temp = new Object[this.elements.length * 2];

            for (int i = 0; i < this.elements.length; i++) {
                temp[i] = elements[i];
            }
            this.elements = (E[]) temp;
        }
    }

    public void trimToSize() {
        /* ska implementeras */
        if (this.size < this.elements.length) {
            Object[] temp = new Object[this.size];
            for (int i = 0; i < this.size; i++) {
                temp[i] = elements[i];
            }
            this.elements = (E[]) temp;
        }
    }

    // -- 3 --
    private void checkForIndexOutOfBounds(int index)
    {
        if (index < 0 || index > this.size) {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public void add(int index, E element) {
        /* ska implementeras */
        this.ensureCapacity(this.size + 1);

        checkForIndexOutOfBounds(index);
        if (this.elements[index] == null) {
            this.elements[index] = element;
        }else {
            for (int i = 0; i > index; i--) {
                this.elements[i] = this.elements[i - 1];
            }
        }
        this.elements[index] = element;
        this.size++;

    }

    @Override
    public boolean add(E e) {
        /* ska implementeras */
        add(this.size, e);
        return true; /* bara med för att Eclipse inte ska klaga */
    }

    // -- 4 --

    @Override
    public E get(int index) {
        /* ska implementeras */
        checkForIndexOutOfBounds(index);
        return this.elements[index]; /* bara med för att Eclipse inte ska klaga */
    }

    @Override
    public E set(int index, E element) {
        /* ska implementeras */
        checkForIndexOutOfBounds(index);

        E oldElement = this.elements[index];
        this.elements[index] = element;
        return oldElement; /* bara med för att Eclipse inte ska klaga */
    }

    // -- 5 --

    @Override
    public E remove(int index) {
        /* ska implementeras */
        checkForIndexOutOfBounds(index);
        E oldElement = this.elements[index];
        this.elements[index] = null;
        return oldElement; /* bara med för att Eclipse inte ska klaga */
    }

    protected void removeRange(int fromIndex, int toIndex) {
        /* ska implementeras */
        checkForIndexOutOfBounds(fromIndex);
        checkForIndexOutOfBounds(toIndex);
        for (int i = fromIndex; i < toIndex; i++) {
            this.elements[i] = null;
        }
        this.size = this.size - (toIndex - fromIndex);
    }

    // -- 6 --

    @Override
    public int indexOf(Object o) {
        /* ska implementeras */
        for (int i = 0; i < this.size; i++) {
            if (this.elements[i] == o) {
                return i;
            }
        }
        return -1; /* bara med för att Eclipse inte ska klaga */
    }

    @Override
    public boolean remove(Object o) {
        /* ska implementeras */
        for (int i = 0; i < this.size; i++) {
            if (this.elements[i] == o) {
                this.elements[i] = null;
                return true;
            }
        }
        return false; /* bara med för att Eclipse inte ska klaga */
    }

    @Override
    public boolean contains(Object o) {
        /* ska implementeras */
        for (int i = 0; i < this.size; i++) {
            if (this.elements[i] == o) {
                return true;
            }
        }
        return false; /* bara med för att Eclipse inte ska klaga */
    }

    // -- 7 --

    @Override
    public Object clone() {
        /* ska implementeras */
        MyArrayList<E> cloned = new MyArrayList<>(this.size);
        for (int i = 0; i < this.size; i++) {
            cloned.elements[i] = this.elements[i];
        }
        cloned.size = this.size;
        return cloned; /* bara med för att Eclipse inte ska klaga */
    }

    @Override
    public Object[] toArray() {
        /* ska implementeras */
        Object[] toArray = new Object[this.size];
        for (int i = 0; i < this.size; i++) {
            toArray[i] = this.elements[i];
        }
        return toArray; /* bara med för att Eclipse inte ska klaga */
    }

    // --- Rör ej nedanstående kod -----------------------------------

    public MyArrayList(Collection<? extends E> c) {
        throw new UnsupportedOperationException();
    }

    private class InternalIterator implements Iterator {
        int current = 0;

        @Override
        public boolean hasNext() {
            return current < size();
        }

        @Override
        public Object next() {
            return get(current++);

        }

    }

    @Override
    public Iterator<E> iterator() {
        return new InternalIterator();
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int lastIndexOf(Object o) {
        throw new UnsupportedOperationException();
    }

    @Override
    public <T> T[] toArray(T[] a) {
        throw new UnsupportedOperationException();
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public ListIterator<E> listIterator() {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void forEach(Consumer<? super E> action) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Spliterator<E> spliterator() {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean removeIf(Predicate<? super E> filter) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void replaceAll(UnaryOperator<E> operator) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void sort(Comparator<? super E> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

}