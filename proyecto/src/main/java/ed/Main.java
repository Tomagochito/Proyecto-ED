package ed;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> test_arraylist = new ArrayList<>();
        test_arraylist.addFirst("test_arraylist_exitoso");
        System.out.println(test_arraylist.get(0));
        System.out.println(test_arraylist.isEmpty());
        System.out.println(test_arraylist.size());
        System.out.println(test_arraylist.isFull());
        test_arraylist.showMaxSize();
        test_arraylist.showUsedSize();
        for(int i=0;i<=110;i++){
            test_arraylist.addLast(String.valueOf(i));
        }
        System.out.println("\nSe aumentará la capacidad máxima del arraylist: ");
       
        test_arraylist.showMaxSize();
        
    }
}