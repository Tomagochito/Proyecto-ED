package ed;

import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Profesora: Adriana Collaguazo Jaramillo
 * Estudiante: Bolaños Tomás
 */
public class DoublyCircularLinkedList<E> implements List<E>, Iterable<E> {
    
    private DoublyCircularNodeList<E> último;
    
    public DoublyCircularNodeList<E> getLast() {
        return último;
    }
    
    public DoublyCircularNodeList<E> getHeader() {
        return último.getNext();
    }
    
    public void setLast(DoublyCircularNodeList<E> último) {
        this.último = último;
    }
    
    @Override
    public boolean addFirst(E e) {
        if (e == null) {
            return false;
        }

        DoublyCircularNodeList<E> newNode = new DoublyCircularNodeList<>(e);
        
        if (último == null) {
            último = newNode;
            último.setNext(newNode);
            último.setPrevious(newNode);
        } else {
            DoublyCircularNodeList<E> first = último.getNext();
            newNode.setNext(first);
            newNode.setPrevious(último);
            first.setPrevious(newNode);
            último.setNext(newNode);
        }
        
        return true;
    }

    @Override
    public boolean addLast(E e) {
        if (e == null) {
            return false;
        }

        DoublyCircularNodeList<E> newNode = new DoublyCircularNodeList<>(e);

        if (último == null) {
            último = newNode;
            último.setNext(newNode);
            último.setPrevious(newNode);
        } else {
            newNode.setNext(último.getNext());
            newNode.setPrevious(último);
            último.getNext().setPrevious(newNode);
            último.setNext(newNode);
            último = newNode;
        }

        return true;
    }

    @Override
    public E removeFirst() {
        if (último == null) {
            return null;
        }

        DoublyCircularNodeList<E> first = último.getNext();
        if (first == último) {
            último = null;
        } else {
            último.setNext(first.getNext());
            first.getNext().setPrevious(último);
        }

        return first.getContent();
    }

    @Override
    public E removeLast() {
        if (último == null) {
            return null;
        }

        DoublyCircularNodeList<E> previous = último.getPrevious();
        if (previous == último) {
            último = null;
        } else {
            previous.setNext(último.getNext());
            último.getNext().setPrevious(previous);
        }

        E removedElement = último.getContent();
        último = previous;
        return removedElement;
    }

    public int showSize() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean isEmpty() {
        return último == null;
    }

    @Override
    public void clear() {
        último = null;
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
        if (isEmpty()) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder();
        DoublyCircularNodeList<E> current = último;

        if (current != null) {
            current = current.getNext(); // Empezamos desde el primer elemento

            while (current != último) {
                sb.append(current.getContent()).append(", ");
                current = current.getNext();
            }

            // Añadimos el último elemento
            sb.append(último.getContent());
        }

        return sb.toString();
    }

    @Override
    public boolean isFull() {
        throw new UnsupportedOperationException("Unimplemented method 'isFull'");
    }

    public int compare(E e1, E e2) {
        if (e1 instanceof String && e2 instanceof String) {
            String s1 = (String) e1;
            String s2 = (String) e2;
            return s1.compareTo(s2);
        } else if (e1 instanceof Integer && e2 instanceof Integer) {
            Integer i1 = (Integer) e1;
            Integer i2 = (Integer) e2;
            return i1.compareTo(i2);
        } else {
            return 0; // Si los tipos no son compatibles, se consideran iguales
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private DoublyCircularNodeList<E> current = (último != null) ? último.getNext() : null;
            private boolean isFirst = true;

            @Override
            public boolean hasNext() {
                return current != null && (isFirst || current != último.getNext());
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
    
    public E find(Comparator<E> comp, E elemento) {
    if (último == null) {
        return null;
    }

    Iterator<E> iterator = iterator(); // Obtener un iterador sobre la lista
    while (iterator.hasNext()) {
        E item = iterator.next();
        if (comp.compare(item, elemento) == 0) {
            return item;
        }
    }
    return null;
}

public DoublyCircularLinkedList<E> findAll(Comparator<E> comp, E elemento) {
    DoublyCircularLinkedList<E> result = new DoublyCircularLinkedList<>();

    if (último == null) {
        return result;
    }

    Iterator<E> iterator = iterator(); // Obtener un iterador sobre la lista
    while (iterator.hasNext()) {
        E item = iterator.next();
        if (comp.compare(item, elemento) == 0) {
            result.addLast(item);
        }
    }
    if(result.isEmpty()){
        return null;
    }else{
        return result;
    }}

}
