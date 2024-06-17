package ed;

import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

import org.w3c.dom.Node;
/**
 * Profesora: Adriana Collaguazo Jaramillo
 * Estudiante: Bolaños Tomás
 */
public class LinkedList<E> implements List<E>,Iterable<E> {
    private NodeList<E> cabecera;
    private NodeList<E> último;

    public LinkedList() {
        this.cabecera = null;
        this.último = null;
    }

    @Override
    public boolean addFirst(E e) {
        if (e != null) {
            NodeList<E> nuevoNodo = new NodeList<>(e);
            nuevoNodo.setNext(cabecera);
            cabecera = nuevoNodo;
            if (último == null) {
                último = nuevoNodo;
            }
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean addLast(E e) {
        if (e != null) {
            NodeList<E> nuevoNodo = new NodeList<>(e);
            if (último != null) {
                último.setNext(nuevoNodo);
            }
            último = nuevoNodo;
            if (cabecera == null) {
                cabecera = nuevoNodo;
            }
            return true;
        } else {
            return false;
        }
    }

    @Override
    public E removeFirst() {
        if (isEmpty()) {
            return null;
        }
        E elementoEliminado = cabecera.getContent();
        cabecera = cabecera.getNext();
        if (cabecera == null) {
            último = null; 
        }
        return elementoEliminado;
    }



    @Override
    public E removeLast() {
        if (isEmpty()) {
            return null;
        }
        if (cabecera == último) {
            E elementoEliminado = último.getContent();
            cabecera = null;
            último = null;
            return elementoEliminado;
        }

        NodeList<E> actual = cabecera;
        NodeList<E> anterior = null;
        while (actual.getNext() != null) {
            anterior = actual;
            actual = actual.getNext();
        }
        último = anterior;
        último.setNext(null);

        return  actual.getContent();
    }

    public int showSize() {
        int tamaño = 0;
        NodeList<E> n = cabecera;
        while (n != null) {
            tamaño++;
            n = n.getNext();
        }
        return tamaño;
    }

    @Override
    public boolean isEmpty() {
        return cabecera == null;
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        NodeList<E> actual = cabecera;
        while (actual != null) {
            sb.append(actual.getContent());
            actual = actual.getNext();
            if (actual != null) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }


    @Override
    public void clear() {
        cabecera=null;
        último=null;
    }

    @Override
    public boolean add(int index, E element) throws IndexOutOfBoundsException {
        throw new UnsupportedOperationException("Unimplemented method 'add'");
    }

    @Override
    public E remove(int index) throws IndexOutOfBoundsException {
        throw new UnsupportedOperationException("Unimplemented method 'remove'");
    }

    @Override
    public E get(int index) throws IndexOutOfBoundsException {
        throw new UnsupportedOperationException("Unimplemented method 'get'");
    }

    @Override
    public E set(int index, E element) throws IndexOutOfBoundsException {
        throw new UnsupportedOperationException("Unimplemented method 'set'");
    }

    @Override
    public boolean isFull() {
        throw new UnsupportedOperationException("Unimplemented method 'isFull'");
    }

    public void reverse() {
        if(!isEmpty()){
            NodeList<E> previous = null;
            NodeList<E> current = cabecera;
            while (current != null) { 
                NodeList<E> next = current.getNext(); 
                current.setNext(previous); 
    
                previous = current; 
                current = next; 
            }
            cabecera = previous;
        }

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

public E find(Comparator<E> comp, E elemento) {
    Iterator<E> iterator = iterator(); // Obtener un iterador sobre la lista
    while (iterator.hasNext()) {
        E item = iterator.next();
        if (comp.compare(item, elemento) == 0) {
            return item;
        }
    }
    return null;
}

public LinkedList<E> findAll(Comparator<E> comp, E elemento) {
    LinkedList<E> result = new LinkedList<>();
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
    }

}


@Override
public Iterator<E> iterator() {
    return new Iterator<E>() {
        private NodeList<E> current = cabecera;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            E element = current.getContent();
            current = current.getNext();
            return element;
        }
    };
}

}    