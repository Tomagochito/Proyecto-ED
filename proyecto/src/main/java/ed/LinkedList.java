package ed;

import java.util.Iterator;
import java.util.NoSuchElementException;
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

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private NodeList<E> cursor = cabecera;
    
            @Override
            public boolean hasNext() {
                return cursor != null;
            }
    
            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                E elemento = cursor.getContent();
                cursor = cursor.getNext();
                return elemento;
            }
            @Override
            public void remove() {
                throw new UnsupportedOperationException("El método remove no está implementado en este iterador");
            }
        }; 
    }
}    