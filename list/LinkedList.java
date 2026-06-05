package list;

/**
 * For creating LinkedLists using comparable and list
 */
public class LinkedList<T extends Comparable<T>> implements List<T> {

 /**
  * For creating blank nodes for creating or affecting linkedlists
  */
 private static class Node<T> {
  public T data;
  public Node<T> next;

  /**
  * For creating data nodes to store data for creating or affecting linkedlists
  */
  public Node(T data, Node<T> next) {
   this.data = data;
   this.next = next;
  }
  public Node() {
   this(null, null);
  }
  public Node(T data) {
   this(data, null);
  }

  /**
  * Overrides toString to give give null if the linkedlist is blank
  * @return the toString "null"
  */
  @Override
  public String toString() {
   if (data == null) {
    return "null";
   } else {
    return data.toString();
   }
  }
 }

 /**
  * Overrides toString to give useful information for testing list commands
  * @return the list data, size, head, and tail.
  */
 @Override
 public String toString() {
  String s = "[";
  Node<T> cur = head.next;

  while (cur != null) {
   s += cur.data.toString();
   if (cur.next != null) {
    s += ", ";
   }
   cur = cur.next;
  }

  s += "]";
  s += ", size = " + size;
  s += ", head: " + head.toString();
  s += ", tail: " + tail.toString();
  return s;
 }

 private int size;
 private Node<T> head;
 private Node<T> tail;

 /**
  * For creating a new blank LinkedList
  */
 public LinkedList() {
  this.size = 0;
  head = new Node<T>();
  tail = head;
 }

 /**
  * To check if the LinkedList is empty
  * @return true if empty, false if not
  */
 @Override
 public boolean isEmpty() {
  return (size() == 0);
 }

 /**
  * To return the size of the LinkedList
  * @return the size
  */
 @Override
 public int size() {
  return this.size;
 }

 /**
  * To add an element to the end of the LinkedList
  * @param element to add
  */
 @Override
 public void add(T element) {

  Node<T> newNode = new Node<>(element);
  tail.next = newNode;
  tail = newNode;
  size++;
 }

 /**
  * To remove an specific element from the LinkedList
  * @param element to be removed
  */
 @Override
 public void remove(T element) {
  Node<T> cur = head.next;
  boolean found = false;
  if (cur.data.equals(element)) {
   cur.next = cur.next.next;
   size--;
   found = true;
   if(cur.next == null) {
    tail = cur;
   }
  }
  while (cur != null && !found) {
   if(cur.next.data.equals(element)) {
    cur.next = cur.next.next;
    size--;
    if(cur.next == null) {
     tail = cur;
    }
   }
   cur = cur.next;
  }
 }

 /**
  * To get the data of a specific index in the LinkedList
  * @param index to look at
  * @return the data of said index
  */
 @Override
 public T get(int index) {
  if (index >= size) {
   throw new IndexOutOfBoundsException("Index out of bounds");
  }
  if (index < 0){
   return null;
  }

  Node<T> cur = head.next;
  for (int i = 0; i <= index; i++) {
   if (cur.next != null) {
    cur = cur.next;
   }
  }
  return cur.data;
 }

 /**
  * To remove a specific index from the LinkedList
  * @param index to remove
  * @return the data of the removed index
  */
 @Override
 public T remove(int index) {
  if (index >= size) {
   throw new IndexOutOfBoundsException("Index out of bounds");
  }
  if (index < 0){
   return null;
  }

  Node<T> cur = head.next;
  Node<T> removed;
  if (index == 0) {
   removed = cur;
   head.next = cur.next;
   size--;
  } else {
   for (int i = 0; i < index -1; i++) {
    cur = cur.next;
   }
   removed = cur.next;
   cur.next = cur.next.next;
   size--;
  }
  if (index == size()) {
   tail = cur;
  }
  return removed.data;
 }

 /**
  * To see if the LinkedList contains a specific element
  * @param element to search for
  * @return true if included, false if not
  */
 @Override
 public boolean contains (T element) {
  Node<T> cur = head.next;
  while (cur != null) {
   if (cur.data.equals(element)) {
    return true;
   }
   cur = cur.next;
  }
  return false;
 }

 /**
  * To see the first index of a specific element
  * @param element to search for
  * @return the index of the element. Is 0 if not on the LinkedList
  */
 @Override
 public int indexOf (T element) {

  Node<T> cur = head.next;
  int index = 0;
  while (cur.next != null) {
   if(cur.data.equals(element)) {
    index ++;
    return index;
   }
   cur = cur.next;
  }
  return index;
 }

 /**
  * To set an index to a specific element
  * @param index to set
  * @param element to be set to
  */
 @Override
 public void set(int index, T element) {
  if(index < 0 || index > size) {
   throw new IndexOutOfBoundsException("Index out of bounds");
  } else {
   if(index == 0) {
    Node<T> newNode = new Node<>(element);
    newNode.next = head.next;
    head.next = newNode;
    size++;
   } else if (index == size) {
    add(element);
   } else {
    Node<T> newNode = new Node<>(element);
    Node<T> cur = head.next;
    for(int i = 0; i < index - 1; i++) {
     cur = cur.next;
    }
    Node<T> temp = cur.next.next;

    cur.next = newNode;

    newNode.next = temp;
   }
  }
 }

 /**
  * To remove all data from the LinkedList
  */
 @Override
 public void clear() {
  Node<T> cur = head.next;
  while(cur != null) {
   Node<T> next = cur.next;
   cur.data = null;
   cur = next;
  }
  head.next = null;
  tail = head;
  size = 0;
 }

}