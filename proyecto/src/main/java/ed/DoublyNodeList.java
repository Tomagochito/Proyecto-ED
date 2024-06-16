package ed;
/**
 * Profesora: Adriana Collaguazo Jaramillo
 * Estudiante: Bolaños Tomás
 */
public class DoublyNodeList<E> {
    private E content;
    private DoublyNodeList<E> next;
    private DoublyNodeList<E> previous;
    
    public DoublyNodeList(E content){
        this.content = content;
        this.next = null;
        this.previous=null;
    }
    
    public E getContent() {
        return content;
    }

    public void setContent(E content) {
        this.content = content;
    }

    public DoublyNodeList<E> getNext() {
        return next;
    }

    public void setNext(DoublyNodeList<E> next) {
        this.next = next;
    }

    public DoublyNodeList<E> getPrevious(DoublyNodeList<E> node){
        return previous;
    }

    public void setPrevious(DoublyNodeList<E> previous) {
        this.previous = previous;
    }
    
}

