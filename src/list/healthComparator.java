package list;
import java.util.Comparator;
public class healthComparator implements Comparator<T> {
    @Override
    public int compare(T o1, T o2) {
        health1 = o1.getMaxHealth();
        health2 = o2.getMaxHealth();

        if (health1 < health2) {
            return -1;
        } else if (health1 == health2) {
            return 0;
        } else {
            return 1;
        }
    }
}