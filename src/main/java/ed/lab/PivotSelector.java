package ed.lab;

@FunctionalInterface
public interface PivotSelector<T> {
    int selectPivot(T[] array, int low, int high);
}