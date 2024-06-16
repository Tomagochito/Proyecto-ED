import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Before;
import org.junit.Test;

import ed.LinkedList;

public class LinkedListTest {

    private LinkedList<String> lista;

    @Before
    public void creacionLinkedList(){
        lista = new LinkedList<>();
        lista.addLast("Lunes");
        lista.addLast("Martes");
        lista.addLast("Miércoles");
        lista.addLast("Jueves");
        lista.addLast("Viernes");
        lista.addLast("Sábado");
        lista.addLast("Domingo");
    }

    @Test
    public void testAddFirst() {
        lista.addFirst("diadeocio");
        assertEquals("[diadeocio, Lunes, Martes, Miércoles, Jueves, Viernes, Sábado, Domingo]", lista.toString());
    }

    @Test
    public void testAddLast() {
        lista.addLast("diadeocio");
        assertEquals("[Lunes, Martes, Miércoles, Jueves, Viernes, Sábado, Domingo, diadeocio]", lista.toString());
    }

    @Test
    public void testRemoveFirst() {
        String elementoEliminado = lista.removeFirst();
        assertEquals("[Martes, Miércoles, Jueves, Viernes, Sábado, Domingo]", lista.toString());
        assertEquals("Lunes", elementoEliminado);
    }

    @Test
    public void testRemoveLast() {
        String elementoEliminado = lista.removeLast();
        assertEquals("[Lunes, Martes, Miércoles, Jueves, Viernes, Sábado]", lista.toString());
        assertEquals("Domingo", elementoEliminado);
    }

    @Test
    public void testReverse() {
        lista.reverse();
        assertEquals("[Domingo, Sábado, Viernes, Jueves, Miércoles, Martes, Lunes]", lista.toString());
    }

    @Test
    public void testClear() {
        lista.clear();
        assertEquals("[]", lista.toString());
    }

    @Test
    public void testIterator() {
        Iterator<String> iterator = lista.iterator();

        assertTrue(iterator.hasNext());
        assertEquals("Lunes", iterator.next());

        assertTrue(iterator.hasNext());
        assertEquals("Martes", iterator.next());

        assertTrue(iterator.hasNext());
        assertEquals("Miércoles", iterator.next());


        assertTrue(iterator.hasNext());
        assertEquals("Jueves", iterator.next());

        assertTrue(iterator.hasNext());
        assertEquals("Viernes", iterator.next());

        assertTrue(iterator.hasNext());
        assertEquals("Sábado", iterator.next());

        assertTrue(iterator.hasNext());
        assertEquals("Domingo", iterator.next());


        assertFalse(iterator.hasNext());
    }
}
