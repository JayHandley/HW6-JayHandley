package list;

import universe.Universe;

/**
 * For creating different commands to edit lists with.
 */
public interface List<T extends Comparable<T>> {

     /**
    * To add an element to the end of the LinkedList
    * @param element to add
    */
    void add(T element);

    /**
    * To remove an specific element from the LinkedList
    * @param element to be removed
    */
    void remove(T element);

    /**
    * To remove a specific index from the LinkedList
    * @param index to remove
    * @return the data of the removed index
    */
    T remove(int index);

    /**
    * To return the size of the LinkedList
    * @return the size
    */
    int size();

    /**
    * To see if the LinkedList contains a specific element
    * @param element to search for
    * @return true if included, false if not
    */
    boolean contains(T element);

    /**
    * To remove all data from the LinkedList
    */
    void clear();

    /**
    * To check if the LinkedList is empty
    * @return true if empty, false if not
    */
    boolean isEmpty();

    /**
    * To get the data of a specific index in the LinkedList
    * @param index to look at
    * @return the data of said index
    */
    T get(int index);

    /**
    * To set an index to a specific element
    * @param index to set
    * @param element to be set to
    */
    void set(int index, T element);

    /**
    * To see the first index of a specific element
    * @param element to search for
    * @return the index of the element. Is 0 if not on the LinkedList
    */
    int indexOf(T element);
}
