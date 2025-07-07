package org.example;

import java.util.ArrayList;

public class App {


    // linear search 
    public static int linearSearch(ArrayList<Fuzzy> list) {
        for (int i = 0; i < list.size(); i++) {
            if ("gold".equals(list.get(i).color)) {
                return i;                          // index of the golden fuzzy
            }
        }
        return -1;                                 // not found
    }

    // binary search
    public static int binarySearch(ArrayList<Fuzzy> list) {
      int low = 0;
      int high = list.size() - 1;
      while (low <= high) {
          int mid = (low + high) / 2;            // simple midpoint
          int cmp = list.get(mid).color.compareTo("gold");
          if (cmp == 0) {
              return mid;                        // found gold
          } else if (cmp < 0) {
              low = mid + 1;                     // gold is after mid
          } else {
              high = mid - 1;                    // gold is before mid
          }
      }
      return -1;                                 // not found
  }
  


    public static void main(String[] args) {

        FuzzyListGenerator generator = new FuzzyListGenerator();

        ArrayList<Fuzzy> sorted  = generator.sortedRainbowFuzzies();
        ArrayList<Fuzzy> random  = generator.randomizedRainbowFuzzies();

        System.out.println("Linear  (sorted): "  + linearSearch(sorted));
        System.out.println("Binary  (sorted): "  + binarySearch(sorted));
        System.out.println("Linear  (random): "  + linearSearch(random));
        System.out.println("Binary  (random): "  + binarySearch(random));
    }
}
