package ed;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Profesora: Adriana Collaguazo Jaramillo
 * Estudiante: Bolaños Tomás
 */
public class CircularLinkedList<E> implements List<E>,Iterable<E> {
    
    private CircularNodeList<E> último;
    public CircularNodeList<E> getLast(){
        return último;
    }
    
     public CircularNodeList<E> getHeader(){
        return último.getNext();
    }
    
    public void setLast(CircularNodeList<E> last){
        this.último = last;
    }
    
    @Override
    public boolean addFirst(E e) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

@Override
public boolean addLast(E e) {
    if (e == null) {
        return false;
    }
    
    CircularNodeList<E> newNode = new CircularNodeList<>(e);
    
    if (último == null) {
        último = newNode;
        último.setNext(newNode);
    } else {
        newNode.setNext(último.getNext());
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
        CircularNodeList<E> removedNode = último.getNext();
        if (removedNode == último) {
            último = null;
        } else {
            último.setNext(removedNode.getNext());
        }
        return removedNode.getContent();
}


    @Override
    public E removeLast() {
        if (último == null) {
            return null;
        }
        CircularNodeList<E> current = último.getNext();
        while (current.getNext() != último) {
            current = current.getNext();
        }
        E removedElement = último.getContent();
        current.setNext(último.getNext());
        último = current;
        return removedElement;
    }

    public int showSize() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean isEmpty() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean add(int index, E element) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public E remove(int index) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public E get(int index) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public E set(int index, E element) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
   
    @Override
public String toString() {
    StringBuilder sb = new StringBuilder();
    CircularNodeList<E> current = último;
    
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

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private CircularNodeList<E> current = último.getNext();

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
