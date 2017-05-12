import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class WordCount {
  
  //Store counts of words in HashMap
  public static Map<String, Integer> countWords(Scanner fileIn) {
    HashMap<String, Integer> counts = new HashMap<String, Integer>();
    while (fileIn.hasNext()) {
      String cur = fileIn.next();
      if (!counts.containsKey(cur))
        counts.put(cur, 1);
      else
        counts.put(cur, counts.get(cur)+1);
    }
    return counts;
  }
  
  // Iterate through map and print counts
  public static void printResults(Map<String, Integer> counts) {
    for (Map.Entry<String, Integer> entry : counts.entrySet()) {
      String word = entry.getKey();
      Integer occurrences = entry.getValue();
      System.out.println(word + ", " + occurrences);
    }
  }
  
  public static void main (String args[]) throws Exception {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter a file name");
    String fileName = sc.nextLine();
    
    //Input file
    File file = new File(fileName);
    sc.close();
    //Make sure file is valid
    if (file.exists() && !file.isDirectory()) {
      Scanner fileIn = new Scanner(file);
      
      //Count words
      Map<String, Integer> counts = countWords(fileIn);
      fileIn.close();
      
      //Print out counts
      printResults(counts);
    }
    else {
      System.out.println(fileName + " is not a valid file. Exiting.");
    }
  }
}
