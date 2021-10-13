public class InsertionSort {
    public static void sort(Notebook[] arr) {
        // внешний цикл цен
        for (int i = 1; i < arr.length; i++) {
            // элемент, с которым все будет сравниваться
            int value = i;
            // j-первый неотсортированный элемент
            // i - 1 - второй неотсортированный элемент
            int j = i - 1;
            // внутренний цикл цен
            // условие для продолжения цикла
            while (j >= 0 && arr[j].price > value) {
                arr[j + 1].price = arr[j].price;
                j--;
            }
            // следующий элемент
            arr[j + 1].price = value;
        }

    }
}

