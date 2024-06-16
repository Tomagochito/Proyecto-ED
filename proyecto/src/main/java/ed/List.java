package ed;
/**
 * Profesora: Adriana Collaguazo Jaramillo
 * Estudiante: Bolaños Tomás
 */
public interface List<E> {

    public boolean addFirst(E e); //Inserta el elemento e al inicio
            
    public boolean addLast(E e); //Inserta el elemento e al final
            
    public E removeFirst(); //remueve el elemento al inicio de la lista
    
    public E removeLast(); // remueve el elemento al final de la lista
    
    public boolean isEmpty();
    
    public void clear();
            
    public boolean add(int index, E element) throws IndexOutOfBoundsException; //Inserta el elemento en la posicion index
            
    public E remove(int index) throws IndexOutOfBoundsException;  // remueve y retorna el elemento en la posicion index
    
    public E get(int index) throws IndexOutOfBoundsException; //retorna el elemento ubicado en la posicion index
    
    public E set(int index, E element) throws IndexOutOfBoundsException; //setea elemento en la posicion index

    public boolean isFull();
}

