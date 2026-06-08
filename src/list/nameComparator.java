package list;

import java.util.Comparator;

public class nameComparator implements Comparator<T> {

    @Override
    public int compare(T o1, T o2) {
        name1 = T.getName();
        name2 = T.getName();

        return name1.compareTo(name2);
    }
}