package ed;


import java.util.Iterator;
/**
 * Profesora: Adriana Collaguazo Jaramillo
 * Estudiante: Bolaños Tomás
 */
public class DoublyLinkedList<E> implements List<E>,Iterable<E> {
    

    
    private DoublyNodeList<E> cabecera;
    private DoublyNodeList<E> último;
    
    public DoublyLinkedList(){
        this.cabecera = null;
        this.último = null;
    }

    public boolean isEmpty(){
        return cabecera == null && último == null;
    }
    
    public int showSize() {
        int tamaño = 0;
        DoublyNodeList<E> n = cabecera;
        while (n != null) {
            tamaño++;
            n = n.getNext();
        }
        return tamaño;
    }
    
    public DoublyNodeList<E> getHeader() {
        return cabecera;
    }

    public void setHeader(DoublyNodeList<E> cabecera) {
        this.cabecera = cabecera;
    }

    public DoublyNodeList<E> getLast() {
        return último;
    }

    public void setLast(DoublyNodeList<E> último) {
        this.último = último;
    }
    

    public boolean addFirst(E e)
    {
        if (e != null){
            DoublyNodeList<E> newNode = new DoublyNodeList<>(e);
            newNode.setNext(cabecera);
            cabecera.setPrevious(newNode);
            this.setHeader(newNode);
            return true;
        }
        return false;
    }
    
public boolean addLast(E e) {
    if (e != null) {
        DoublyNodeList<E> newNode = new DoublyNodeList<>(e);
        if (último != null) {
            último.setNext(newNode);
            newNode.setPrevious(último);
        }
        último = newNode;

        if (cabecera == null) {
            cabecera = newNode;
        }
        return true;
    } else {
        return false;
    }
}

    
    public boolean addAt(E e, int pos)
    {
        if (e != null && pos >= 0 && pos < this.showSize()) {
            DoublyNodeList<E> newNode = new DoublyNodeList<>(e);
            
            DoublyNodeList<E> p = cabecera;
            
            for(int i=0; i < pos ; i ++){
                p = p.getNext();
            }
            newNode.setNext(p.getNext());
            p.setNext(newNode);
            
            newNode.setPrevious(p);
            newNode.getNext().setPrevious(newNode);
           
        }
        return false;
    }
    
    /*public E removeElement (int pos){
        DoublyNodeList<E> p = header;
        
        for(int i=0; i < pos; i++){
            p = p.getNext();
        }
        
        p.getPrevious().setNext(p.getNext());
        p.getNext().setPrevious(p.getPrevious());
        
        p.setNext(null);
        p.setPrevious(null);
        
        return p.getContent();
        }
*/
    @Override
public E removeFirst() {
    if (isEmpty()) {
        return null;
    }
    E removedElement = cabecera.getContent();
    cabecera = cabecera.getNext();
    if (cabecera != null) {
        cabecera.setPrevious(null);
    } else {
        último = null;
    }
    return removedElement;
}

@Override
public E removeLast() {
    if (isEmpty()) {
        return null;
    }
    E removedElement = último.getContent();
    último = último.getPrevious(último);
    if (último != null) {
        último.setNext(null);
    } else {
        cabecera = null;
    }
    return removedElement;
}


@Override
public String toString() {
    StringBuilder s = new StringBuilder();
    DoublyNodeList<E> current = cabecera;
    while (current != null) {
        s.append(current.getContent());
        if (current.getNext() != null) {
            s.append(",");
        }
        current = current.getNext();
    }
    return s.toString();
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
    public boolean isFull(){
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody

    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private DoublyNodeList<E> current = cabecera;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public E next() {
                E content = current.getContent();
                current = current.getNext();
                return content;
            }
        };
    }
}
