//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: The file contains the class for a linkedQueue, containing all the methods and fields of a
// queue
//
// Author: Pranav Sharma
// Email: pnsharma@wisc.edu
// Lecturer: Mouna Kacem
//
///////////////////////// ALWAYS CREDIT OUTSIDE HELP //////////////////////////
//
// Persons: None used
// Online Sources: None used
//
///////////////////////////////////////////////////////////////////////////////
import java.util.NoSuchElementException;

/**
 * The file contains the class for a linkedQueue, containing all the methods and fields of a
 * queue
 * 
 * @author Pranav Sharma
 *
 * @param <T> The generic variable of a Node<T>
 */
public class LinkedQueue<T> implements QueueADT<T> {
  // fields of a queue
  protected Node<T> back;
  protected Node<T> front;
  private int n;

  @Override
  /**
   * Adds a new variable to the queue
   * 
   * @param T data the generic data variable being added to a queue
   */
  public void enqueue(T data) {
    // TODO Auto-generated method stub
    Node<T> newNode = new Node<T>(data);
    if (back == null || front == null) {
      back = front = newNode;
      n++;
      return;
    }
    back.setNext​(newNode);
    back = newNode;
    // increases size
    n++;
  }

  @Override
  /**
   * Removes the first element of the queue
   */
  public T dequeue() {
    if (isEmpty()) {
      throw new NoSuchElementException("Queue is emtpy");
    }
    T data = front.getData();
    front = front.getNext();
    // decreases size
    n--;
    return data;
  }

  @Override
  /**
   * Returns the first variable of the queue
   * 
   * @return T The variable at the front of the queue
   */
  public T peek() {
    if (isEmpty()) {
      throw new NoSuchElementException("Queue is emtpy");
    }
    return front.getData();
  }

  @Override
  /**
   * Checks if the queue is empty
   * 
   * @return true if queue is empty, false otherwise
   */
  public boolean isEmpty() {
    if (front == null || back == null || n == 0) {
      return true;
    }
    return false;
  }

  @Override
  /**
   * Returns the size of the queue
   * 
   * @return the size of the queue
   */
  public int size() {
    return n;
  }

  /**
   * Converts the queue into a string representation
   * 
   * @return the string representation of the queue
   */
  public String toString() {
    String output = "";
    Node<T> temp = front;
    while (temp != null) {
      output += temp.getData() + " ";
      temp = temp.getNext();
    }
    return output;
  }

}
