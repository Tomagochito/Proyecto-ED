package ed;

import java.util.Comparator;
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
        return último == null;   }

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
    if (isEmpty()) {
        return "[]";
    }
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
            private CircularNodeList<E> current = (último != null) ? último.getNext() : null;
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
    
    public CircularLinkedList<E> findAll(Comparator<E> comp, E elemento) {
        CircularLinkedList<E> result = new CircularLinkedList<>();
    
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
        }    }
    
    

    
}
