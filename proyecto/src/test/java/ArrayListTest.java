

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import ed.ArrayList;

public class ArrayListTest {

    private ArrayList<String> list;

    @Before
    public void creacionArrayList() {
        list = new ArrayList<>();
        list.add(0, "diadeocio");
        list.add(1, "Lunes");
        list.add(2, "Martes");
        list.add(3, "Miércoles");
        list.add(4, "diadeocio");
        list.add(5, "Jueves");
        list.add(6, "Viernes");
        list.add(7, "Sábado");
        list.add(8, "Domingo");
        list.add(9, "diadeocio");
    }

    @Test
    public void testRemove() {
        System.out.println("----------- TEST REMOVE(INDEX) -----------------");
        
        // Remove element at index 4
        String removedElement = list.remove(4);
        assertEquals("diadeocio", removedElement);

        // Verify list after removal
        
        assertEquals("Jueves", list.get(4));
        assertEquals("Domingo", list.get(7));

        // Print updated list
        System.out.println("La lista después de remover: " + list.toString());
    }
}
