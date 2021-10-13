
public class Main {
    public static void main(String[] args) {

        Notebook array[] = Notebook.generate(5000);

        System.out.println("Массив до сортировки");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i].getPrice() + " " + array[i].getRaw_memory() + " " + array[i].getManufacturer() + " ");
        }

        SelectionSort.sort(array);
//        InsertionSort.sort(array);
        System.out.println();

        System.out.println("Массив после сортировки");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i].getPrice() + " " + array[i].getRaw_memory() + " " + array[i].getManufacturer() + " ");
        }


    }
}
