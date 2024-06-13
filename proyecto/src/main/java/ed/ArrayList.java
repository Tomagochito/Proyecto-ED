package ed;

public class ArrayList<E> implements List<E> {

    private E listaElementosGenéricos[] = null; // lista de elementos genéricos
    private int capacidad_máxima = 100; // número que denota la máxima cantidad de elementos en una lista
    private int capacidad_utilizada; // número que denota la cantidad usada de elementos en una lista

    /**
     * Constructor crea una lista de genéricos con una capacidad usada de cero
     */
    public ArrayList() {
        listaElementosGenéricos = (E[]) (new Object[capacidad_máxima]); // casting permitido con el arrayList
        capacidad_utilizada = 0;
    }

    /**
     * Añade a la lista de genéricos un elemento genérico al inicio de la lista
     */
    public boolean addFirst(E e) {
        if (e == null) {
            return false;
        } else if (isEmpty()) {
            listaElementosGenéricos[0] = e;
            updateUsedCapacityPlus();
            return true;
        } else if (isFull()) {
            addCapacity();
        }

        for (int i = capacidad_máxima - 1; i >= 0; i--) {
            listaElementosGenéricos[i + 1] = listaElementosGenéricos[i];
        }

        listaElementosGenéricos[0] = e;
        updateUsedCapacityPlus();
        ;
        return true;

    }

    /**
     * Añade a la lista de genéricos un elemento genérico al final de la lista
     */
    public boolean addLast(E e) {
        if (e == null) {
            return false;
        }
        if (isFull()) {
            addCapacity();
        }
        listaElementosGenéricos[capacidad_utilizada] = e;
        updateUsedCapacityPlus();
        return true;

    }

    /**
     * Elimina de la lista de genéricos el primer elemento genérico de la lista
     */
    public E removeFirst() {

        if (isEmpty()) {
            return null;
        }
        E removedElement = listaElementosGenéricos[0];
        for (int i = 1; i < capacidad_utilizada; i++) {
            listaElementosGenéricos[i - 1] = listaElementosGenéricos[i];
        }
        listaElementosGenéricos[capacidad_utilizada - 1] = null;
        updateUsedCapacityMinus();
        ;
        return removedElement;

    }

    /**
     * Elimina de la lista de genéricos el primer elemento genérico de la lista
     */
    public E removeLast() {
        if (isEmpty()) {
            return null;
        }
        E removedElement = listaElementosGenéricos[capacidad_utilizada - 1];
        listaElementosGenéricos[capacidad_utilizada - 1] = null;
        updateUsedCapacityMinus();
        ;
        return removedElement;
    }

    public int size() {
        return capacidad_utilizada;
    }

    public boolean isEmpty() {
        return 0 == capacidad_utilizada;
    }

    public void clear() {
        
    }

    public boolean add(int index, E element) {
        try {
            if (isFull()) {
                addCapacity();
            }
            for (int i = capacidad_utilizada; i > index; i--) {
                listaElementosGenéricos[i] = listaElementosGenéricos[i - 1];
            }
            listaElementosGenéricos[index] = element;
            updateUsedCapacityPlus();
            return true;
        } catch (IndexOutOfBoundsException ioobe) {
            System.out.println(
                    "El índice: " + index + "que se intentó colocar en la lista sobrepasa su capacidad de "
                            + capacidad_utilizada);
            return false;
        }
    }

    public E remove(int index) {
        return null;
    } // remueve y retorna el elemento en la posicion index

    public E get(int index) {
        return listaElementosGenéricos[index];
    } // retorna el elemento ubicado en la posicion index

    public E set(int index, E element) {
        return null;
    } // setea elemento en la posicion index

    public boolean isFull() {
        return capacidad_máxima == capacidad_utilizada;
    }

    public void addCapacity() {
        /*System.out.println("antes de aumentar");
        capacidad_máxima++;
        System.out.println("despues de aumentar");
        Esto no funciona porque cuando la lista se crea tiene una capacidad maxima fija, no se actualiza porque ya esta creada
        */
        E[] tmp = (E[]) new Object[capacidad_máxima * 2];
        System.out.println(capacidad_máxima*2);
        for (int i = 0; i < capacidad_máxima; i++){
            tmp[i] = listaElementosGenéricos[i];
        }
        listaElementosGenéricos = tmp;
        capacidad_máxima = capacidad_máxima * 2;

    }

    public void updateUsedCapacityPlus() {
        capacidad_utilizada++;
    }

    public void updateUsedCapacityMinus() {
        capacidad_utilizada--;
    }

    public void showMaxSize() {
        System.out.println(capacidad_máxima);
    }

    public void showUsedSize() {
        System.out.println(capacidad_utilizada);
    }
}
