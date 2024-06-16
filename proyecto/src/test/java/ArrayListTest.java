

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import ed.ArrayList;

public class ArrayListTest {

    private ArrayList<String> list;

    @Before
    public void creacionArrayList() {
        list = new ArrayList<>();
        list.add(0, "diadeocio1");
        list.add(1, "Lunes");
        list.add(2, "Martes");
        list.add(3, "Miércoles");
        list.add(4, "diadeocio2");
        list.add(5, "Jueves");
        list.add(6, "Viernes");
        list.add(7, "Sábado");
        list.add(8, "Domingo");
        list.add(9, "diadeocio3");
    }

    @Test
    public void testRemove() {
        System.out.println("----------- TEST REMOVE(INDEX) -----------------");
        String removedElement = list.remove(4);
        assertEquals("diadeocio2", removedElement);        


                // lista que se espera despues del remove(index)
                ArrayList<String> expectedList = new ArrayList<>();
                expectedList.add(0, "diadeocio1");
                expectedList.add(1, "Lunes");
                expectedList.add(2, "Martes");
                expectedList.add(3, "Miércoles");
                expectedList.add(4, "Jueves");
                expectedList.add(5, "Viernes");
                expectedList.add(6, "Sábado");
                expectedList.add(7, "Domingo");
                expectedList.add(8, "diadeocio3");
        
                //Se comparan si son las mismas
                assertEquals(expectedList, list);
    }


    @Test
    public void testRemoveLast() {
        System.out.println("----------- TEST REMOVELAST() -----------------");
        String removedElement = list.removeLast();
        assertEquals("diadeocio3", removedElement);        


                // lista que se espera despues del remove(index)
                ArrayList<String> expectedList = new ArrayList<>();
                expectedList.add(0, "diadeocio1");
                expectedList.add(1, "Lunes");
                expectedList.add(2, "Martes");
                expectedList.add(3, "Miércoles");
                expectedList.add(4,"diadeocio2");
                expectedList.add(5, "Jueves");
                expectedList.add(6, "Viernes");
                expectedList.add(7, "Sábado");
                expectedList.add(8, "Domingo");
        
                //Se comparan si son las mismas
                assertEquals(expectedList, list);
    }


    @Test
    public void testRemoveFirst() {
        System.out.println("----------- TEST REMOVEFIRST() -----------------");
        String removedElement = list.removeFirst();
        assertEquals("diadeocio1", removedElement);        


                // lista que se espera despues del remove(index)
                ArrayList<String> expectedList = new ArrayList<>();
                expectedList.add(0, "Lunes");
                expectedList.add(1, "Martes");
                expectedList.add(2, "Miércoles");
                expectedList.add(3,"diadeocio2");
                expectedList.add(4, "Jueves");
                expectedList.add(5, "Viernes");
                expectedList.add(6, "Sábado");
                expectedList.add(7, "Domingo");
                expectedList.add(8,"diadeocio3");
        
                //Se comparan si son las mismas
                assertEquals(expectedList, list);
    }

    @Test
    public void testAddFirst() {
        System.out.println("----------- TEST ADD_FIRST() -----------------");
        list.addFirst("diadeocio0");
        assertEquals("diadeocio0", list.get(0));

        ArrayList<String> expectedList = new ArrayList<>();
        expectedList.add(0, "diadeocio0");
        expectedList.add(1, "diadeocio1");
        expectedList.add(2, "Lunes");
        expectedList.add(3, "Martes");
        expectedList.add(4, "Miércoles");
        expectedList.add(5, "diadeocio2");
        expectedList.add(6, "Jueves");
        expectedList.add(7, "Viernes");
        expectedList.add(8, "Sábado");
        expectedList.add(9, "Domingo");
        expectedList.add(10, "diadeocio3");

        assertEquals(expectedList, list);
    }

    @Test
    public void testAddLast() {
        System.out.println("----------- TEST ADD_LAST() -----------------");
        list.addLast("diadeocio4");
        assertEquals("diadeocio4", list.get(list.showUsedSize() - 1));

        ArrayList<String> expectedList = new ArrayList<>();
        expectedList.add(0, "diadeocio1");
        expectedList.add(1, "Lunes");
        expectedList.add(2, "Martes");
        expectedList.add(3, "Miércoles");
        expectedList.add(4, "diadeocio2");
        expectedList.add(5, "Jueves");
        expectedList.add(6, "Viernes");
        expectedList.add(7, "Sábado");
        expectedList.add(8, "Domingo");
        expectedList.add(9, "diadeocio3");
        expectedList.add(10, "diadeocio4");

        assertEquals(expectedList, list);
    }

    @Test
    public void testClear() {
        System.out.println("----------- TEST CLEAR() -----------------");
        list.clear();
        assertEquals(0, list.showUsedSize());

        ArrayList<String> expectedList = new ArrayList<>();
        assertEquals(expectedList, list);
    }

    @Test
    public void testSet() {
        System.out.println("----------- TEST SET() -----------------");
        String oldElement = list.set(4, "NuevoDiaDeOcio");
        assertEquals("diadeocio2", oldElement);
        assertEquals("NuevoDiaDeOcio", list.get(4));

        ArrayList<String> expectedList = new ArrayList<>();
        expectedList.add(0, "diadeocio1");
        expectedList.add(1, "Lunes");
        expectedList.add(2, "Martes");
        expectedList.add(3, "Miércoles");
        expectedList.add(4, "NuevoDiaDeOcio");
        expectedList.add(5, "Jueves");
        expectedList.add(6, "Viernes");
        expectedList.add(7, "Sábado");
        expectedList.add(8, "Domingo");
        expectedList.add(9, "diadeocio3");

        assertEquals(expectedList, list);
    }

    @Test
    public void testIsEmpty() {
        System.out.println("----------- TEST IS_EMPTY() -----------------");
        assertFalse(list.isEmpty());

        list.clear();
        assertTrue(list.isEmpty());
    }

    @Test
    public void testIsFull() {
        System.out.println("----------- TEST IS_FULL() -----------------");
        assertFalse(list.isFull());

        for (int i = list.showUsedSize(); i < list.showMaxSize(); i++) {
            list.addLast("Element " + i);
        }

        assertTrue(list.isFull());
    }

    @Test
    public void testShowMaxSize() {
        System.out.println("----------- TEST SHOW_MAX_SIZE() -----------------");
        assertEquals(100, list.showMaxSize());
    }

    @Test
    public void testShowUsedSize() {
        System.out.println("----------- TEST SHOW_USED_SIZE() -----------------");
        assertEquals(10, list.showUsedSize());

        list.addLast("NuevoElemento");
        assertEquals(11, list.showUsedSize());
    }



}
