/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.awhipple.sortingtests;

import net.awhipple.sortingtests.sorts.quicksorts.QuickSortHoare;
import net.awhipple.sortingtests.utils.ArrayUtils;
import net.awhipple.sortingtests.sorts.*;
import java.util.Date;
import net.awhipple.sortingtests.sorts.quicksorts.QuickSortLomuto;
import net.awhipple.sortingtests.sorts.quicksorts.QuickSortMedianOfThree;
import net.awhipple.sortingtests.sorts.quicksorts.QuickSortRandomPart;
import net.awhipple.sortingtests.sorts.quicksorts.QuickSortSmallInsertion;

/**
 *
 * @author Aaron
 */
public class SortingTests {
    
    //0 is not condensed, 1 is condensed, 2 is spreadsheet mode
    public static final int CONDENSE_LEVEL = 2;
    public static final boolean RUN_TESTS = true;
    public static final int NUM_ELEMENTS = 500000;
    public static final int ELEMENT_LOW = 1, ELEMENT_HIGH = 1000;
    public static final int NUM_TESTS = 20;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Comparable[] random = ArrayUtils.randomInts(NUM_ELEMENTS, ELEMENT_LOW, ELEMENT_HIGH);
        Comparable[] sorted = ArrayUtils.copy(random);
        (new WhippleSort()).sort(sorted);
        Comparable[] reversed = ArrayUtils.copy(sorted);
        ArrayUtils.reverseArray(reversed);

        runThreeSorts(new QuickSortLomuto(), "Lomuto Quick Sort", random, sorted, reversed, NUM_TESTS);
        //runThreeSorts(new QuickSortHoare(), "Hoare Quick Sort", random, sorted, reversed, NUM_TESTS);

        //runThreeSorts(new QuickSortRandomPart(), "Random Partition Quick Sort", random, sorted, reversed, NUM_TESTS);
        
        //runThreeSorts(new QuickSortSmallInsertion(), "Small Insertion Quick Sort", random, sorted, reversed, NUM_TESTS);
        
        //runThreeSorts(new QuickSortMedianOfThree(), "Median of Three Quick Sort", random, sorted, reversed, NUM_TESTS);
    }
    
    public static void runThreeSorts(Sort sort, String algName, Comparable[] random, Comparable[] sorted, Comparable[] reversed, int numTests) {
        runSorts(random, sort, algName + " on random array", numTests);
        runSorts(sorted, sort, algName + " on sorted array", numTests);
        runSorts(reversed, sort, algName + " on reversed array", numTests);
    }
    
    public static void runSorts(Comparable[] arr, Sort sort, String algName, int trials) {
        long startTime, endTime;
        if(CONDENSE_LEVEL == 2) System.out.println("Running " + algName + ", results in ms");
        for(int i = 0; i < trials; i++) {
            Comparable[] arrS = ArrayUtils.copy(arr);
            if(CONDENSE_LEVEL == 0) System.out.println("Running " + algName + " on arrS");
            startTime = (new Date()).getTime();
            try {
                sort.sort(arrS);
                endTime = (new Date()).getTime();
                showSortTime(algName, startTime, endTime);
                
                if(RUN_TESTS) {
                    isArraySorted(arrS, "arrS");
                    areArraysSame(arr, "arr", arrS, "arrS");
                }
            } catch(StackOverflowError ex) {
                System.out.println("StackOverFlow Error on " + algName);
                System.out.println();
                return;
            }
            
        }
        System.out.println();
    }
    
    public static void isArraySorted(Comparable[] arr, String name) {
        if(CONDENSE_LEVEL != 0) {
            if(!ArrayUtils.isSorted(arr)) System.out.println("WARNING! ARRAY NOT SORTED");
        } else {
            ArrayUtils.show(arr, name);
            System.out.print("Is " + name + " sorted? ");
            System.out.println(boolToYesNo(ArrayUtils.isSorted(arr)));
            System.out.println();
        }
    }
    
    public static void areArraysSame(Comparable[] arr1, String name1, Comparable[] arr2, String name2) {
        if(CONDENSE_LEVEL != 0) {
            if(!ArrayUtils.sameElements(arr1, arr2)) System.out.println("WARNING! ARRAYS CONTAIN DIFFERENT ELEMENTS");
        } else {
            System.out.print("Do " + name1 + " and " + name2 + " contain the same elements? ");
            System.out.println(boolToYesNo(ArrayUtils.sameElements(arr1, arr2)));
            System.out.println();
        }
    }
    
    public static void showSortTime(String algName, long startTime, long endTime) {
        if(CONDENSE_LEVEL < 2) System.out.print(algName + " running time: ");
        System.out.print(endTime - startTime);
        if(CONDENSE_LEVEL < 2) System.out.println(" ms");
        else System.out.println();
        if(CONDENSE_LEVEL == 0) {
            System.out.println();
        }
    }
    
    public static String boolToYesNo(boolean bool) {
        return bool ? "Yes" : "No";
    }
}

