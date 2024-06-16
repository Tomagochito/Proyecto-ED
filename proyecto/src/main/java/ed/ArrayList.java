package ed;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayList<E> implements List<E>,Iterable<E> {

    private E listaElementosGenéricos[] = null; // lista de elementos genéricos
    private int capacidad_máxima = 100; // número que denota la máxima cantidad de elementos en una lista
    private int capacidad_utilizada; // número que denota la cantidad usada de elementos en una lista

    /**
     * Constructor crea una lista de genéricos con una capacidad usada de cero
     */
    @SuppressWarnings("unchecked")
    public ArrayList() {
        listaElementosGenéricos = (E[]) (new Object[capacidad_máxima]); // casting permitido con el arrayList
        capacidad_utilizada = 0;
    }

    /**
     * Añade a la lista de genéricos un elemento genérico al inicio de la lista
     * Retorna un booleano que denota si se completó con éxito
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

        for (int i = capacidad_utilizada - 1; i >= 0; i--) {
            listaElementosGenéricos[i + 1] = listaElementosGenéricos[i];
        }

        listaElementosGenéricos[0] = e;
        updateUsedCapacityPlus();
        return true;

    }

    /**
     * Añade a la lista de genéricos un elemento genérico al final de la lista
     * Retorna un booleano que denota si se completó con éxito
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
     * Retorna el elemento que se removió
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
        return removedElement;

    }

    /**
     * Elimina de la lista de genéricos el último elemento genérico de la lista
     * Retorna el elemento que se removió
     */
    public E removeLast() {
        if (isEmpty()) {
            return null;
        }
        E removedElement = listaElementosGenéricos[capacidad_utilizada - 1];
        listaElementosGenéricos[capacidad_utilizada - 1] = null;
        updateUsedCapacityMinus();
        return removedElement;
    }

    /**
     * Evalúa si la lista está vacía
     * Retorna un booleano
     */
    public boolean isEmpty() {
        return 0 == capacidad_utilizada;
    }

    /**
     * Vacía toda la lista
     * Retorna void
     */
    
    @SuppressWarnings("unchecked")
    public void clear() {
        listaElementosGenéricos = (E[]) (new Object[capacidad_máxima]);
        capacidad_utilizada=0;
    }

    /**
     * Añade en una posición de la lista un elemento
     * Retorna un booleano que denota si se realizó con éxito la operación
     */

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

    /**
     * Remueve un elemento de la lista dada una posición
     * Retorna dicho elemento
     */
    public E remove(int index) {
        try {
            if (isEmpty()) {
                return null;
            }
            E removedElement = listaElementosGenéricos[index];
            for (int i = index; i < capacidad_utilizada - 1; i++) {
                listaElementosGenéricos[i] = listaElementosGenéricos[i + 1];
            }
            listaElementosGenéricos[capacidad_utilizada - 1] = null;
            updateUsedCapacityMinus();
            return removedElement;
        } catch (IndexOutOfBoundsException ioobe) {
            System.out.println(
                    "El índice: " + index + " que se intentó remover de la lista sobrepasa su capacidad de "
                            + capacidad_utilizada);
            return null;
        }
    }

    /**
     * Obtiene un elemento de la lISta dada una posición
     * Retorna dicho elemento
     */
    public E get(int index) {
        try{
        return listaElementosGenéricos[index];
    } catch (IndexOutOfBoundsException ioobe) {
        System.out.println(
                "El índice: " + index + " que se intentó remover de la lista sobrepasa su capacidad de "
                        + capacidad_utilizada);
        return null;
    }
    }

    /**
     * Coloca un elemento en cierta posición de la lista
     * Retorna dicho elemento
     */
    public E set(int index, E element) {
        try{
        E elementoanterior = listaElementosGenéricos[index];
        listaElementosGenéricos[index] = element;
        return elementoanterior;
    } catch (IndexOutOfBoundsException ioobe) {
        System.out.println(
                "El índice: " + index + " que se intentó remover de la lista sobrepasa su capacidad de "
                        + capacidad_utilizada);
        return null;
    }
    }

    /**
     * Evalúa si la lista está llena
     * Retorna un booleano
     */
    public boolean isFull() {
        return capacidad_máxima == capacidad_utilizada;
    }

    /**
     * Añade más capacidad a la lista, al doble
     * Retorna void
     */
    @SuppressWarnings("unchecked")
    public void addCapacity() {
        E[] tmp = (E[]) new Object[capacidad_máxima * 2];
        System.out.println(capacidad_máxima * 2);
        for (int i = 0; i < capacidad_máxima; i++) {
            tmp[i] = listaElementosGenéricos[i];
        }
        listaElementosGenéricos = tmp;
        capacidad_máxima = capacidad_máxima * 2;

    }

    /**
     * Aumenta la capacidad utilizada de la lista en uno
     * Retorna void
     */
    public void updateUsedCapacityPlus() {
        capacidad_utilizada++;
    }

    /**
     * Reduce la capacidad utilizada de la lista en uno
     * Retorna void
     */
    public void updateUsedCapacityMinus() {
        capacidad_utilizada--;
    }

    /**
     * Imprime la capacidad máxima de la lista
     * Retorna void
     */
    public int showMaxSize() {
        return capacidad_máxima;
    }

    /**
     * Imprime la capacidad usada de la lista
     * Retorna void
     */
    public int showUsedSize() {
        return capacidad_utilizada;
    }

    /**
     * Método tostring que imprime los elementos de la lista
     * Retorna un string
     */
    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < capacidad_utilizada; i++) {
            s.append(listaElementosGenéricos[i]);
            if (i < capacidad_utilizada - 1) {
                s.append(", ");
            }
        }
        return s.toString();
    }

    /**
     * Método equals
     * Retorna un booleano
     */
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        ArrayList<?> arrayList = (ArrayList<?>) o;

        if (capacidad_utilizada != arrayList.capacidad_utilizada)
            return false;
        return Arrays.equals(listaElementosGenéricos, arrayList.listaElementosGenéricos);
    }


    /**
     * Retorna un iterador para recorrer los elementos de la lista.
     */
    @Override
    public Iterator<E> iterator() {
        return new ArrayListIterator();
    }

    /**
     * Clase interna que implementa el iterador para ArrayList.
     */
    private class ArrayListIterator implements Iterator<E> {
        private int currentIndex = 0; // Índice actual del iterador

        /**
         * Verifica si hay un siguiente elemento en la lista.
         */
        @Override
        public boolean hasNext() {
            return currentIndex < capacidad_utilizada;
        }

        /**
         * Retorna el siguiente elemento de la lista.
         */
        @Override
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException("No hay más elementos en la lista");
            }
            return listaElementosGenéricos[currentIndex++];
        }

        /**
         * Elimina el elemento actual de la lista (no se implementa en este ejemplo).
         */
        @Override
        public void remove() {
            throw new UnsupportedOperationException("El método remove no está implementado en este iterador");
        }
    }

}
