//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: The file defines the DNA class that translates and transcribes a DNA sequence
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
 * Defines the DNA class that translates and transcribes a DNA sequence
 * 
 * @author Pranav Sharma
 *
 */
public class DNA {
  // protected fields in the class
  protected LinkedQueue<Character> DNA;
  protected static String[][] mRNAtoProteinMap =
      {{"UUU", "F"}, {"UUC", "F"}, {"UUA", "L"}, {"UUG", "L"}, {"UCU", "S"}, {"UCC", "S"},
          {"UCA", "S"}, {"UCG", "S"}, {"UAU", "Y"}, {"UAC", "Y"}, {"UAA", "STOP"}, {"UAG", "STOP"},
          {"UGU", "C"}, {"UGC", "C"}, {"UGA", "STOP"}, {"UGG", "W"}, {"CUU", "L"}, {"CUC", "L"},
          {"CUA", "L"}, {"CUG", "L"}, {"CCU", "P"}, {"CCC", "P"}, {"CCA", "P"}, {"CCG", "P"},
          {"CAU", "H"}, {"CAC", "H"}, {"CAA", "Q"}, {"CAG", "Q"}, {"CGU", "R"}, {"CGC", "R"},
          {"CGA", "R"}, {"CGG", "R"}, {"AUU", "I"}, {"AUC", "I"}, {"AUA", "I"}, {"AUG", "M"},
          {"ACU", "T"}, {"ACC", "T"}, {"ACA", "T"}, {"ACG", "T"}, {"AAU", "N"}, {"AAC", "N"},
          {"AAA", "K"}, {"AAG", "K"}, {"AGU", "S"}, {"AGC", "S"}, {"AGA", "R"}, {"AGG", "R"},
          {"GUU", "V"}, {"GUC", "V"}, {"GUA", "V"}, {"GUG", "V"}, {"GCU", "A"}, {"GCC", "A"},
          {"GCA", "A"}, {"GCG", "A"}, {"GAU", "D"}, {"GAC", "D"}, {"GAA", "E"}, {"GAG", "E"},
          {"GGU", "G"}, {"GGC", "G"}, {"GGA", "G"}, {"GGG", "G"}};

  /**
   * Constructor that creates the DNA queue
   * 
   * @param sequence the DNA sequence to be added to the DNA queue
   */
  public DNA(String sequence) {
    DNA = new LinkedQueue<Character>();
    for (int i = 0; i < sequence.length(); i++) {
      DNA.enqueue(sequence.charAt(i));
    }
  }

  /**
   * Converts the DNA sequence into an mRNA sequence
   * 
   * @return an mRNA sequence transcribes from the DNA sequence
   */
  public LinkedQueue<Character> transcribeDNA() {
    LinkedQueue<Character> mRNA = new LinkedQueue<Character>();
    for (int i = 0; i < DNA.size(); i++) {
      Character temp = DNA.dequeue();
      if (temp == 'A') {
        mRNA.enqueue('U');
      } else if (temp == 'T') {
        mRNA.enqueue('A');
      } else if (temp == 'C') {
        mRNA.enqueue('G');
      } else if (temp == 'G') {
        mRNA.enqueue('C');
      }
      DNA.enqueue(temp);
    }
    return mRNA;
  }

  /**
   * Translates an mRNA sequence into an Amino Acid sequence
   * 
   * @param mRNA an mRNA sequence that will be translated into AA
   * @return a sequence of Amino Acids stored in a queue
   */
  public LinkedQueue<String> mRNATranslate​(LinkedQueue<Character> mRNA) {
    LinkedQueue<String> AA = new LinkedQueue<String>();
    int size = mRNA.size();
    int index = 0;
    for (int i = 2; i < size + 1; i = i + 3) {
      char c1 = mRNA.dequeue();
      char c2 = mRNA.dequeue();
      char c3 = mRNA.dequeue();
      String sequence = "" + c1 + c2 + c3;
      for (int j = 0; j < mRNAtoProteinMap.length; j++) {
        if (mRNAtoProteinMap[j][0].equals(sequence)) {
          if (!mRNAtoProteinMap[j][1].equals("STOP")) {
            AA.enqueue(mRNAtoProteinMap[j][1]);
          }else {
            return AA;
          }
        }
      }
      mRNA.enqueue(c1);
      mRNA.enqueue(c2);
      mRNA.enqueue(c3);
      index = i;
    }
    if (index != size - 1) {
      for (int i = 0; i < (size - 1 - index); i++) {
        mRNA.enqueue(mRNA.dequeue());
      }
    }
    return AA;
  }

  /**
   * Translates a DNA sequence into an Amino Acid sequence
   * 
   * @return an Amino Acid sequence
   */
  public LinkedQueue<String> translateDNA() {
    return mRNATranslate​(transcribeDNA());
  }
}
