package ed;

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
        System.out.println(test_arraylist.toString());

        System.out.println("------------------------------------------------------------------------------------------------------------------");

        /*Pruebas para remove(index) */
        System.out.println("------------------------------------------------TEST REMOVE(INDEX)------------------------------------------------");
        test_arraylist.remove(4);
    }
}