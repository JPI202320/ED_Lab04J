package ed.lab;

public class Main {
    private static final ArrayGenerator<String> sortedArrayGenerator = size -> {
        String[] array = new String[size];
        for (int i = 0; i < size; i++) {
            // Formateamos con ceros a la izquierda (0001, 0002...)
            // para que el orden alfabético coincida con el numérico
            array[i] = String.format("%06d", i);
        }
        return array;
    };

    private static final ArrayGenerator<String> invertedArrayGenerator = size -> {
        String[] array = new String[size];
        for (int i = 0; i < size; i++) {
            array[i] = String.format("%06d", size - i);
        }
        return array;
    };

    private static final ArrayGenerator<String> randomArrayGenerator = size -> {
        String[] array = new String[size];
        java.util.Random rand = new java.util.Random();
        for (int i = 0; i < size; i++) {
            // Generamos una cadena aleatoria simple
            array[i] = "Str-" + rand.nextInt(size);
        }
        return array;
    };

    private static final QuickSort<String> highPivotQuickSort = SortingAlgorithms::highPivotQuickSort;

    private static final QuickSort<String> lowPivotQuickSort = SortingAlgorithms::lowPivotQuickSort;

    private static final QuickSort<String> randomPivotQuickSort = SortingAlgorithms::randomPivotQuickSort;

    public static QuickSort<String> getHighPivotQuickSort() {
        return highPivotQuickSort;
    }

    public static QuickSort<String> getLowPivotQuickSort() {
        return lowPivotQuickSort;
    }

    public static QuickSort<String> getRandomPivotQuickSort() {
        return randomPivotQuickSort;
    }

    public static ArrayGenerator<String> getSortedArrayGenerator() {
        return sortedArrayGenerator;
    }

    public static ArrayGenerator<String> getInvertedArrayGenerator() {
        return invertedArrayGenerator;
    }

    public static ArrayGenerator<String> getRandomArrayGenerator() {
        return randomArrayGenerator;
    }

    public static void main(String[] args) {
        final SortingTester<String> tester = new SortingTester<>();

        System.out.println("Ordenando un arreglo ordenado:");
        System.out.println("\tUtilizando el último elemento como pivote: ");
        tester.testSorting(sortedArrayGenerator, highPivotQuickSort);
        System.out.println("\tUtilizando el primer elemento como pivote: ");
        tester.testSorting(sortedArrayGenerator, lowPivotQuickSort);
        System.out.println("\tUtilizando un elemento aleatorio como pivote: ");
        tester.testSorting(sortedArrayGenerator, randomPivotQuickSort);
        System.out.println("================================");

        System.out.println("Ordenando un arreglo invertido:");
        System.out.println("\tUtilizando el último elemento como pivote: ");
        tester.testSorting(invertedArrayGenerator, highPivotQuickSort);
        System.out.println("\tUtilizando el primer elemento como pivote: ");
        tester.testSorting(invertedArrayGenerator, lowPivotQuickSort);
        System.out.println("\tUtilizando un elemento aleatorio como pivote: ");
        tester.testSorting(invertedArrayGenerator, randomPivotQuickSort);
        System.out.println("================================");

        System.out.println("Ordenando un arreglo aleatorio:");
        System.out.println("\tUtilizando el último elemento como pivote: ");
        tester.testSorting(randomArrayGenerator, highPivotQuickSort);
        System.out.println("\tUtilizando el primer elemento como pivote: ");
        tester.testSorting(randomArrayGenerator, lowPivotQuickSort);
        System.out.println("\tUtilizando un elemento aleatorio como pivote: ");
        tester.testSorting(randomArrayGenerator, randomPivotQuickSort);
        System.out.println("================================");
    }
}