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
    public void clear() {
        listaElementosGenéricos = (E[]) (new Object[capacidad_máxima]);
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
        if (isEmpty()) {
            return null;
        }
        E removedElement = listaElementosGenéricos[index];
        System.out.println("El elemento que se removerà es: "+removedElement);
        /*
         * list = ["lunes","martes","miercoles","diadeocio","jueves","viernes","sabado","domingo"]
         * remove(3)
         * i=3; 3<7
         * lista[3] = "diadeocio" = lista[4]="jueves"
         * i=4; 4<7
         * lista[4]="jueves" = lista[5]="viernes"
         * i=5; 5<7
         * lista[5]="viernes" = lista[6]="sabado"
         * i=6; 6<7
         * lista[6]="sabado" = lista[7]="domingo"
         * 
         */

        for (int i = index; i < capacidad_utilizada-1; i++) {

            System.out.println("iterador: "+i+";   "+i+" < "+capacidad_utilizada);
            System.out.println("El elemento que estaba en lista["+ i +"] es: "+listaElementosGenéricos[i]+" ;   ahora será el que está en lista["+i+"+1] que es:"+listaElementosGenéricos[i+1
            ]);
            listaElementosGenéricos[i] = listaElementosGenéricos[i+1];
            System.out.println("La lista es:  "+toString());

        }
        System.out.println("El for ha finalizado, pero la lista aun contiene "+ capacidad_utilizada + " elementos" );
        toString();
        listaElementosGenéricos[capacidad_utilizada - 1] = null;
        System.out.println("El elemento que estaba al final de la lista ya no existe: "+listaElementosGenéricos[capacidad_utilizada-1]);
        updateUsedCapacityMinus();
        System.out.println("la capacidad ultilizada de la lista ahora es");
        showUsedSize();
        return removedElement;
    } 


    /**
     * Obtiene un elemento de la lISta dada una posición
     * Retorna dicho elemento
     */
    public E get(int index) {
        return listaElementosGenéricos[index];
    } 

    /**
     * Coloca un elemento en cierta posición de la lista
     * Retorna dicho elemento
     */
    public E set(int index, E element) {
        E elementoanterior = listaElementosGenéricos[index];
        listaElementosGenéricos[index] = element;
        return elementoanterior;
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
    public void addCapacity() {
        E[] tmp = (E[]) new Object[capacidad_máxima * 2];
        System.out.println(capacidad_máxima*2);
        for (int i = 0; i < capacidad_máxima; i++){
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
    public void showMaxSize() {
        System.out.println(capacidad_máxima);
    }

    /**
     * Imprime la capacidad usada de la lista
     * Retorna void
     */
    public void showUsedSize() {
        System.out.println(capacidad_utilizada);
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
    
}
