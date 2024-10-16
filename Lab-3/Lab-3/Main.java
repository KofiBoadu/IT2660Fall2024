public class Main {
  public static void main(String[] args) {
    String text = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    
    String bestCase = "ABC";

    // * Initialize startTime here
    long startTime = System.currentTimeMillis();
    int index = match(text, bestCase);
    // * Initialize endTime here
    long endTime = System.currentTimeMillis();
    // * Calculate elapsedTime here
    long elapsedTime = endTime - startTime;
    
    if (index >= 0)
      System.out.println("best-case input matched at index " + index);
    else
      System.out.println("best-case input unmatched");   

    String worstCase = "ZZZ";
    
    // * Initialize startTime here
    long startTimeW = System.currentTimeMillis();
    index = match(text, worstCase);
    // * Initialize endTime here
    long endTimeW = System.currentTimeMillis();
    // * Calculate elapsedTime here
    long elapsedTimeW = endTimeW - startTimeW;
    
    if (index >= 0)
      System.out.println("worst-case input matched at index " + index);
    else
      System.out.println("worst-case input unmatched");  
  }

  // Return the index of the first match. -1 otherwise.
  public static int match(String text, String pattern) {
    for (int i = 0; i < text.length() - pattern.length() + 1; i++) {
      if (isMatched(i, text, pattern))
        return i;
    }

    return -1;
  }
	
  // Test if pattern matches text starting at index i
  private static boolean isMatched(int i, String text, 
      String pattern) {
    for (int k = 0; k < pattern.length(); k++) {
      if (pattern.charAt(k) != text.charAt(i + k)) {
        return false;
      }
    }
    
    return true;
  }
}
