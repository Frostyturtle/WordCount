import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class WordCount {
  
  public static void main (String args[]) throws Exception {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter a file name");
    String fileName = sc.nextLine();
    
    //Input file
    File file = new File(fileName);
    Scanner fileIn = new Scanner(file);
    sc.close();
    
    //Count words
    HashMap<String, Integer> counts = new HashMap<String, Integer>();
    while (fileIn.hasNext()) {
      String cur = fileIn.next();
      if (!counts.containsKey(cur))
        counts.put(cur, 1);
      else
        counts.put(cur, counts.get(cur)+1);
    }
    fileIn.close();
    
    for (Map.Entry<String, Integer> entry : counts.entrySet()) {
      String word = entry.getKey();
      Integer occurrences = entry.getValue();
      System.out.println(word + ", " + occurrences);
    }
  }
}
