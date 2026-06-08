package registry;

public interface Copyable<T> {

    /**
     * Copies a hero
     * @return T the copied object
     */
    T copy();
}
