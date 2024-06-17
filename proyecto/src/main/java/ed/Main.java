package ed;

import java.util.Comparator;
import java.util.Iterator;
/**
 * Profesora: Adriana Collaguazo Jaramillo
 * Estudiante: Bolaños Tomás
 */
public class Main {
    public static void main(String[] args) {

        // Crear instancias de cada tipo de lista
    LinkedList<Integer> linkedList = new LinkedList<>();
    // Agregar elementos a las listas


    linkedList.addLast(10);
    linkedList.addLast(20);
    linkedList.addLast(30);
    linkedList.addLast(40);
    linkedList.addLast(50);
    linkedList.addLast(20);
    linkedList.addLast(20);
    linkedList.addLast(20);


System.out.println("------------------------------------------------Lista a usar------------------------------------------------");
System.out.println(linkedList.toString());
System.out.println("------------------------------------------------------------------------------------------------------------");

    Comparator<Integer> comp = Comparator.naturalOrder();
    Integer findResult;

    System.out.println("------------------------------------------------Método find-------------------------------------------------");
    findResult = linkedList.find(comp, 20);
    System.out.println("Resultado de find(20) en LinkedList: " + findResult);
    findResult = linkedList.find(comp, 70);
    System.out.println("Resultado de find(70) en LinkedList: " + findResult);
    System.out.println("------------------------------------------------------------------------------------------------------------");

    System.out.println("------------------------------------------------Método findAll----------------------------------------------");
    LinkedList<Integer> findAllResultLinkedList = linkedList.findAll(comp, 20);
    System.out.println("Resultado de findAll(20) en LinkedList: " + findAllResultLinkedList.toString());
    LinkedList<Integer> findAllResultLinkedList2 = linkedList.findAll(comp, 80);
    System.out.println("Resultado de findAll(80) en LinkedList sin toString(): " + findAllResultLinkedList2);
    System.out.println("Resultado de findAll(80) en LinkedList con toString(): " );
    try{
     System.out.println(findAllResultLinkedList2.toString());
    }catch(NullPointerException npe){System.out.println("Se capturó un nullpointerexception, pues no se puede usa null.toString()");}


    System.out.println("----------------------------------------------Recorrido con Iterator----------------------------------------");
    Iterator<Integer> iterator = linkedList.iterator();
    while (iterator.hasNext()) {
         Integer element = iterator.next();
         System.out.println("Elemento: " + element);
    }
    System.out.println("------------------------------------------------------------------------------------------------------------");

    Comparator<Integer> comp2 = Comparator.naturalOrder();
    System.out.println("-----------------------------------Recorrido con Iterator y uso de compare----------------------------------");
    Iterator<Integer> iterator2 = linkedList.iterator();
    Integer compareInteger = 20;
    System.out.println("Cero si son los mismos \nNegativo si el primero es menor que el segundo\nPositivo si el segundo es menor que el primero");
    while (iterator2.hasNext()) {
         Integer element = iterator2.next();
         System.out.println("Elemento: " + element + ", compare(element, 20) = " + comp2.compare(element, compareInteger));
        }
    System.out.println("------------------------------------------------------------------------------------------------------------");




        /*LINEAS
         * ------------------------------------------------
         */
        /* 
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
            */
    }

    
}