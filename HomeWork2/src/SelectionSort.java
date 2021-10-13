public class SelectionSort {
    public static void sort(Notebook[] arr) {
        // внешний цикл для цены
        // внешний цикл
        for (int i = 0; i < arr.length - 1; i++) {
            // первый неотсортированный элемент
            int min = i;

            // внутренний цикл для цены
            // начинается со второго неотсортированного элемента
            for (int j = i + 1; j < arr.length; j++) {
                // если найден элемент меньше, чем первый неотсортированный
                if (arr[j].getPrice() < arr[min].getPrice()) {
                    // изменить значение
                    min = j;
                }
                // если не найден
                if (i == min) {
                    // выйти из внешнего цикла
                    continue;
                }

                Notebook temp = arr[i];
                arr[i] = arr[min];
                arr[min] = temp;
            }
        }

    }
}



