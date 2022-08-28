//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: The file contains the interface for a Queue
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
public interface QueueADT<T> {
  
  // Adds one element to the back of the queue
  public void enqueue(T element);

  // Removes and returns the element at the front of the queue
  public T dequeue();

  // Returns without removing the element at the front of the queue
  public T peek();

  // Returns true if and only if the queue contains no elements
  public boolean isEmpty();

  // Returns the number of elements in the queue
  public int size();

  // Returns a string representation of the queue
  public String toString();
}   