package ed.lab;

import java.util.Random;

public class SortingAlgorithms {

    //highPivotQuickSort
    public static <T extends Comparable<T>> void highPivotQuickSort(T[] array) {
        quickSort(array, 0, array.length - 1, (arr, low, high) -> high);
    }

    // lowPivotQuickSort
    public static <T extends Comparable<T>> void lowPivotQuickSort(T[] array) {
        quickSort(array, 0, array.length - 1, (arr, low, high) -> low);
    }

    //randomPivotQuickSort
    public static <T extends Comparable<T>> void randomPivotQuickSort(T[] array) {
        quickSort(array, 0, array.length - 1, (arr, low, high) -> {
            Random rand = new Random();
            return rand.nextInt(high - low + 1) + low;
        });
    }

    // quicksort
    private static <T extends Comparable<T>> void quickSort(T[] array, int low, int high, PivotSelector<T> selector) {
        if (low < high) {
            int pi = partition(array, low, high, selector);
            quickSort(array, low, pi - 1, selector);
            quickSort(array, pi + 1, high, selector);
        }
    }

    private static <T extends Comparable<T>> int partition(T[] array, int low, int high, PivotSelector<T> selector) {
        int pivotIndex = selector.selectPivot(array, low, high);
        T pivot = array[pivotIndex];

        swap(array, pivotIndex, high);

        int i = (low - 1);
        for (int j = low; j < high; j++) {
            // compareTo ya que T hereda de Comparable
            if (array[j].compareTo(pivot) <= 0) {
                i++;
                swap(array, i, j);
            }
        }
        swap(array, i + 1, high);
        return i + 1;
    }

    // Metodo que intercambia elementos
    private static <T> void swap(T[] array, int i, int j) {
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}