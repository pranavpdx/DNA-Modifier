//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: The file contains a tester class that test methods to verify your implementation of the
// methods for P08.
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
import java.util.ArrayList;
import java.util.NoSuchElementException;
/**
 * Test methods to verify your implementation of the methods for P08.
 * 
 * @author Pranav Sharma
 */
public class DNATester {

  // TODO: verify your LinkedQueue implementation directly
  /**
   * Test the enqueue() and dequeue() methods in the LinkedQueue class
   * 
   * @return true if all tests pass, false otherwise
   */
  public static boolean testEnqueueDequeue() {
    // checks to see if any exceptions are thrown
    try {
      // enqueue() check
      LinkedQueue<Integer> queue = new LinkedQueue<Integer>();
      queue.enqueue(1);
      queue.enqueue(2);
      queue.enqueue(3);
      String expectedOutput = "1 2 3 ";
      if (!queue.toString().equals(expectedOutput)) {
        System.out.println("Error: enqueue() did not queue values correctly");
        return false;
      }
      // dequeue() check
      queue.dequeue();
      queue.dequeue();
      expectedOutput = "3 ";
      if (!queue.toString().equals(expectedOutput)) {
        System.out.println("Error: dequeue() did not dequeue values correctly");
        return false;
      }
      queue.dequeue();
      queue.dequeue();
      System.out.println("ERROR: dequeue() did not throw an exception when queue is emtpy");
      return false;
    } catch (NoSuchElementException e) {

    } catch (Exception e) {
      System.out.println("ERROR: dequeue() did not throw the right exception when queue is emtpy");
      return false;
    }
    return true;
  }

  /**
   * Tests the size() and isEmpty() methods in LinkedQueue
   * 
   * @return true if and only if the method works correctly
   */
  public static boolean testQueueSize() {
    try {
      LinkedQueue<Integer> queue = new LinkedQueue<Integer>();
      queue.enqueue(1);
      queue.enqueue(2);
      queue.enqueue(3);
      if (queue.size() != 3) {
        System.out.println("Error: size() did not return the correct value");
        return false;
      }
      queue.dequeue();
      if (queue.size() != 2) {
        System.out.println("Error: size() did not return the correct value");
        return false;
      }
      queue.dequeue();
      queue.dequeue();
      if (!queue.isEmpty()) {
        System.out.println("Error: isEmpty() did not return the correct value");
        return false;
      }
    } catch (Exception e) {
      System.out.println("ERROR: isEmpty() or size() methods throw an exception");
      return false;
    }
    return true;
  }

  /**
   * Tests the mRNATranslate() method in the DNA class
   * 
   * @return true if and only if the method works correctly
   */
  public static boolean testMRNATranslate() {
    DNA testDNA = new DNA("GGA");
    String expectedAA = "P ";
    if (!testDNA.mRNATranslate​(testDNA.transcribeDNA()).toString().equals(expectedAA)) {
      System.out.println(
          "ERROR: transcribeDNA() did not return the correct queue when given a 3 letter DNA "
              + "sequence");
      return false;
    }

    testDNA = new DNA("GATTACA");
    expectedAA = "L M ";
    if (!testDNA.mRNATranslate​(testDNA.transcribeDNA()).toString().equals(expectedAA)) {
      System.out.println(
          "ERROR: transcribeDNA() did not return the correct queue when given a 6 letter DNA"
              + " sequence");
      return false;
    }

    testDNA = new DNA("CCGGCCCTCCGGTGGATCCAA");
    expectedAA = "G R E A T ";
    if (!testDNA.mRNATranslate​(testDNA.transcribeDNA()).toString().equals(expectedAA)) {
      System.out.println(
          "ERROR: transcribeDNA() did not return the correct queue when a DNA sequence with a"
              + " stop codon");
      return false;
    }
    return true;
  }

  /**
   * Tests the transcribeDNA() method
   * 
   * @return true if and only if the method works correctly
   */
  public static boolean testTranscribeDNA() {
    DNA testDNA = new DNA("AAAATTTTCCCCGGGG");
    String expectedMRNA = "UUUUAAAAGGGGCCCC";
    if (!testDNA.transcribeDNA().toString().replaceAll(" ", "").equals(expectedMRNA)) {
      System.out.println("ERROR: translateMRNA() did not return the correct queue");
      return false;
    }
    return true;
  }

  /**
   * Tests the translateDNA() method
   * 
   * @return true if and only if the method works correctly
   */
  public static boolean testTranslateDNA() {
    DNA testDNA = new DNA("GGAGTCAGTTAAGCGACCGGGACATACTGTCTTGGTAATCTCCGAGCTAGAAAGTCTCTG");
    String expectedDNA = "GGAGTCAGTTAAGCGACCGGGACATACTGTCTTGGTAATCTCCGAGCTAGAAAGTCTCTG";
    String expectedAA = "PQSIRWPCMTEPLEARSFRD";
    if (!testDNA.translateDNA().toString().replaceAll(" ", "").equals(expectedAA)) {
      System.out.println("ERROR: translateDNA() did not return the correct queue");
      return false;
    }

    // checks if DNA is unchanged
    if (!testDNA.DNA.toString().replaceAll(" ", "").equals(expectedDNA)) {
      System.out.println("ERROR: translateDNA() changed the value of DNA");
      return false;
    }
    return true;
  }

  /**
   * Runs all tests and returns true if all tests pass
   * 
   * @return
   */
  public static boolean testAll() {
    if (testTranscribeDNA() && testTranslateDNA() && testEnqueueDequeue() && testQueueSize()
        && testMRNATranslate()) {
      return true;
    }
    return false;
  }

  /**
   * Main method - use this to run your test methods and output the results (ungraded)
   * 
   * @param args unused
   */
  public static void main(String[] args) {
    ArrayList<Double> grades = new ArrayList<Double>();   
    grades.add(97.3);   
    grades.add(85.7);
    grades.add(75.4);
    grades.add(91.98);   
    grades.add(63.5);
    for (Double grade: grades) { // for-each loop
      grade = 100.0;
    }
    System.out.println(grades.toString());
  }

}
