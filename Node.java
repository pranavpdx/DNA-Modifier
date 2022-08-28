//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: The file contains the class for Node, which defines a linked node for T data type
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
/**
 * The class for Node, which defines a linked node for T data type
 * 
 * @author Pranav Sharma
 *
 * @param <T> The variable of the node
 */
public class Node<T> {
  // private fields of a linked node
  private T data;
  private Node<T> next;
  
  /**
   * Constructor that assigns the data variable
   * 
   * @param data the data of the node
   */
  public Node(T data) {
    this.data = data;
  }
  
  /**
   * overloaded constructor that assigns the data field and the next variable
   * 
   * @param data the data of the node
   * @param next the node this node is linked to
   */
  public Node(T data, Node<T> next) {
    this.data = data;
    this.next = next;
  }
  
  /**
   * returns the data of the node
   * 
   * @return the data of the node
   */
  public T getData() {
    return data;
  }
  
  /**
   * Returns the next linked node in the linked list
   * 
   * @return the next node
   */
  public Node<T> getNext(){
    return next;
  }
  
  /**
   * Sets the next node
   * 
   * @param next the node that is next
   */
  public void setNext​(Node<T> next) {
    this.next = next;
  }
}
