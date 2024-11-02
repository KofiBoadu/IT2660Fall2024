import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;



public class Main {
    public static void main(String[] args) {
        System.out.println("Unsorted Array ---------------------------------------------------");
        ArrayList<Integer> integerList = Lab4.getList();
        Lab4.outputList(integerList);

        System.out.println("\n\nBubble sort results ----------------------------------------------");
        ArrayList<Integer> bubbleSortedList = Lab4.bubbleSort(new ArrayList<>(integerList)); // Create a copy to maintain the original list
        Lab4.outputList(bubbleSortedList);

        System.out.println("\n\nInsertion sort results -------------------------------------------");
        ArrayList<Integer> insertionSortedList = Lab4.insertionSort(new ArrayList<>(integerList)); // Create a copy to maintain the original list
        Lab4.outputList(insertionSortedList);

        // Measure time for insertion sort
        ArrayList<Integer> insertionList = new ArrayList<>(integerList);
        long startInsertion = System.nanoTime();
        Lab4.insertionSort(insertionList);
        long endInsertion = System.nanoTime();
        System.out.println("\nInsertion Sort took: " + (endInsertion - startInsertion) / 1_000_000.0 + " ms");

        // Measure time for bubble sort
        ArrayList<Integer> bubbleList = new ArrayList<>(integerList);
        long startBubble = System.nanoTime();
        Lab4.bubbleSort(bubbleList);
        long endBubble = System.nanoTime();
        System.out.println("Bubble Sort took: " + (endBubble - startBubble) / 1_000_000.0 + " ms");
    }
}

class Lab4 {
    public static ArrayList<Integer> insertionSort(ArrayList<Integer> integerList) {
        for (int i = 1; i < integerList.size(); i++) {
            int key = integerList.get(i);
            int j = i - 1;

            while (j >= 0 && integerList.get(j) > key) {
                integerList.set(j + 1, integerList.get(j));
                j = j - 1;
            }
            integerList.set(j + 1, key);
        }
        return integerList;
    }

    public static ArrayList<Integer> bubbleSort(ArrayList<Integer> integerList) {
        for (int i = 0; i < integerList.size() - 1; i++) {
            for (int j = 1; j < integerList.size() - i; j++) {
                if (integerList.get(j) < integerList.get(j - 1)) {
                    int temp = integerList.get(j - 1);
                    integerList.set(j - 1, integerList.get(j));
                    integerList.set(j, temp);
                }
            }
        }
        return integerList;
    }

    public static ArrayList<Integer> getList() {
        ArrayList<Integer> integerList = new ArrayList<>();
        String line;
        try (BufferedReader br = new BufferedReader(new FileReader("integers.txt"))) {
            while ((line = br.readLine()) != null) {
                integerList.add(Integer.parseInt(line));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return integerList;
    }

    public static void outputList(ArrayList<Integer> integerList) {
        for (int i = 0; i < integerList.size(); i++) {
            System.out.print(integerList.get(i) + " ");
        }
    }
}

 // 1. If you were implementing a sort algorithm for a new language, which sort would you use?
    // Answer: If I were to implement a sort algorithm for a new language, I would use the Merge Sort or Quick Sort. 
    // These algorithms are more efficient for larger data sets with an average and worst-case time complexity of O(n log n). 
    // While Quick Sort is typically faster in practice, Merge Sort provides stable sorting, which is advantageous for certain applications.



  
 // 2. Was there a difference in the time it took for bubble and insertion sort to run? 
        // Does this make sense given the time complexities for these sorting algorithms?
        // Answer: Yes, there is typically a difference in the time it takes for bubble sort and insertion sort to run.
        // Insertion sort is usually faster than bubble sort for smaller or partially sorted data sets because it moves through the list 
        // only once to place each element in its correct position. Bubble sort, on the other hand, makes multiple passes to swap adjacent elements.
        // This aligns with their time complexities: O(n^2) for both in the worst case, but insertion sort can run in O(n) in the best case, 
        // while bubble sort always runs in O(n^2).

      

// 3. Which sort algorithm has an easier implementation (in terms of understanding) to you?
        // Answer: Insertion sort has an easier implementation and is more straightforward to understand. 
        // Its logic of comparing and inserting elements into a sorted subarray is intuitive, especially for someone learning sorting algorithms. 
        // Bubble sort, while conceptually simple, involves more passes and comparisons, making it less efficient and practical.
    


