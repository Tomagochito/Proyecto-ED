package ed;

import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        /*LINEAS
         * ------------------------------------------------
         */
        ArrayList<String> test_arraylist = new ArrayList<>();
        test_arraylist.add(0, "diadeocio");
        test_arraylist.add(1, "Lunes");
        test_arraylist.add(2, "Martes");
        test_arraylist.add(3, "Miércoles");
        test_arraylist.add(4, "diadeocio");
        test_arraylist.add(5, "Jueves");
        test_arraylist.add(6, "Viernes");
        test_arraylist.add(7, "Sábado");
        test_arraylist.add(8, "Domingo");
        test_arraylist.add(9, "diadeocio");
        System.out.println("------------------------------------------------LISTA QUE SE USARÁ------------------------------------------------\n");
        
        System.out.println(test_arraylist.toString()+"\n");
        System.out.println("------------------------------------------------------------------------------------------------------------------");

        /*Pruebas para remove(index) */
        System.out.println("------------------------------------------------TEST Iterator------------------------------------------------");
        // Obtener un iterador de la lista
        Iterator<String> iterator = test_arraylist.iterator();

        // Usar el iterador para recorrer e imprimir la lista
        System.out.println("Recorriendo la lista con Iterator:");
        while (iterator.hasNext()) {
            String elemento = iterator.next();
            System.out.println(elemento);
        }
        System.out.println("La lista será puesta en reversa");
        test_arraylist.reverse();
        iterator = test_arraylist.iterator();
        System.out.println("Recorriendo la lista reverse con Iterator:");
        while (iterator.hasNext()) {
            String elemento = iterator.next();
            System.out.println(elemento);
        }


        LinkedList<String> testLinkedList = new LinkedList<>();
        testLinkedList.addLast("diadeocio");
        testLinkedList.addLast("Lunes");
        testLinkedList.addLast("Martes");
        testLinkedList.addLast("Miércoles");
        testLinkedList.addLast("diadeocio");
        testLinkedList.addLast("Jueves");
        testLinkedList.addLast("Viernes");
        testLinkedList.addLast("Sábado");
        testLinkedList.addLast("Domingo");
        testLinkedList.addLast("diadeocio");

        System.out.println("------------------------------------------------LISTA QUE SE USARÁ------------------------------------------------\n");
        System.out.println(testLinkedList.toString() + "\n");
        System.out.println("------------------------------------------------------------------------------------------------------------------");

        System.out.println("------------------------------------------------TEST Iterator------------------------------------------------");
        Iterator<String> iteratorl = testLinkedList.iterator();

        System.out.println("Recorriendo la LinkedList lista con Iterator:");
        while (iteratorl.hasNext()) {
            String elemento = iteratorl.next();
            System.out.println(elemento);
        }

        System.out.println("La lista será puesta en reversa");
        testLinkedList.reverse();
        iteratorl = testLinkedList.iterator();
        System.out.println("Recorriendo la lista reverse con Iterator:");
        while (iteratorl.hasNext()) {
            String elemento = iteratorl.next();
            System.out.println(elemento);
        }
    }

    
}