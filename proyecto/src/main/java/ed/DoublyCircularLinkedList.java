package ed;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Profesora: Adriana Collaguazo Jaramillo
 * Estudiante: Bolaños Tomás
 */
public class DoublyCircularLinkedList<E> implements List<E>, Iterable<E> {
    
    private DoublyCircularNodeList<E> last;
    
    public DoublyCircularNodeList<E> getLast() {
        return last;
    }
    
    public DoublyCircularNodeList<E> getHeader() {
        return last.getNext();
    }
    
    public void setLast(DoublyCircularNodeList<E> last) {
        this.last = last;
    }
    
    @Override
    public boolean addFirst(E e) {
        if (e == null) {
            return false;
        }

        DoublyCircularNodeList<E> newNode = new DoublyCircularNodeList<>(e);
        
        if (last == null) {
            last = newNode;
            last.setNext(newNode);
            last.setPrevious(newNode);
        } else {
            DoublyCircularNodeList<E> first = last.getNext();
            newNode.setNext(first);
            newNode.setPrevious(last);
            first.setPrevious(newNode);
            last.setNext(newNode);
        }
        
        return true;
    }

    @Override
    public boolean addLast(E e) {
        if (e == null) {
            return false;
        }

        DoublyCircularNodeList<E> newNode = new DoublyCircularNodeList<>(e);

        if (last == null) {
            last = newNode;
            last.setNext(newNode);
            last.setPrevious(newNode);
        } else {
            newNode.setNext(last.getNext());
            newNode.setPrevious(last);
            last.getNext().setPrevious(newNode);
            last.setNext(newNode);
            last = newNode;
        }

        return true;
    }

    @Override
    public E removeFirst() {
        if (last == null) {
            return null;
        }

        DoublyCircularNodeList<E> first = last.getNext();
        if (first == last) {
            last = null;
        } else {
            last.setNext(first.getNext());
            first.getNext().setPrevious(last);
        }

        return first.getContent();
    }

    @Override
    public E removeLast() {
        if (last == null) {
            return null;
        }

        DoublyCircularNodeList<E> previous = last.getPrevious();
        if (previous == last) {
            last = null;
        } else {
            previous.setNext(last.getNext());
            last.getNext().setPrevious(previous);
        }

        E removedElement = last.getContent();
        last = previous;
        return removedElement;
    }

    public int showSize() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean isEmpty() {
        return last == null;
    }

    @Override
    public void clear() {
        last = null;
    }

    @Override
    public boolean add(int index, E element) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public E remove(int index) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public E get(int index) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public E set(int index, E element) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        DoublyCircularNodeList<E> current = last;

        if (current != null) {
            current = current.getNext(); // Empezamos desde el primer elemento

            while (current != last) {
                sb.append(current.getContent()).append(", ");
                current = current.getNext();
            }

            // Añadimos el último elemento
            sb.append(last.getContent());
        }

        return sb.toString();
    }

    @Override
    public boolean isFull() {
        throw new UnsupportedOperationException("Unimplemented method 'isFull'");
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private DoublyCircularNodeList<E> current = (last != null) ? last.getNext() : null;
            private boolean isFirst = true;

            @Override
            public boolean hasNext() {
                return current != null && (isFirst || current != last.getNext());
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                E element = current.getContent();
                current = current.getNext();
                isFirst = false;
                return element;
            }
        };
    }
}
