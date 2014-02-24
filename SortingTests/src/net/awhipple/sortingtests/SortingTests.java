/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.awhipple.sortingtests;

import net.awhipple.sortingtests.sorts.quicksorts.QuickSortHoare;
import net.awhipple.sortingtests.utils.ArrayUtils;
import net.awhipple.sortingtests.sorts.*;
import java.util.Date;
import net.awhipple.sortingtests.sorts.quicksorts.QuickSortMedianOfThree;
import net.awhipple.sortingtests.sorts.quicksorts.QuickSortRandomPart;
import net.awhipple.sortingtests.sorts.quicksorts.QuickSortSmallInsertion;

/**
 *
 * @author Aaron
 */
public class SortingTests {
    
    public static final boolean CONDENSE_RESULTS = true;
    public static final boolean RUN_TESTS = true;
    public static final int NUM_ELEMENTS = 1000000;
    public static final int ELEMENT_LOW = 1, ELEMENT_HIGH = 100;
    public static final int NUM_TESTS = 5;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Comparable[] random = ArrayUtils.randomInts(NUM_ELEMENTS, ELEMENT_LOW, ELEMENT_HIGH);
        Comparable[] sorted = ArrayUtils.copy(random);
        (new WhippleSort()).sort(sorted);
        Comparable[] reversed = ArrayUtils.copy(sorted);
        ArrayUtils.reverseArray(reversed);

        try {
            runThreeSorts(new QuickSortHoare(), "Hoare Quick Sort", random, sorted, reversed, NUM_TESTS);
        } catch (StackOverflowError ex) {
            System.out.println("Stack Overflow");
            System.out.println();
        }

        runThreeSorts(new QuickSortRandomPart(), "Random Partition Quick Sort", random, sorted, reversed, NUM_TESTS);
        
        runThreeSorts(new QuickSortSmallInsertion(), "Small Insertion Quick Sort", random, sorted, reversed, NUM_TESTS);
        
        runThreeSorts(new QuickSortMedianOfThree(), "Median of Three Quick Sort", random, sorted, reversed, NUM_TESTS);
    }
    
    public static void runThreeSorts(Sort sort, String algName, Comparable[] random, Comparable[] sorted, Comparable[] reversed, int numTests) {
        runSorts(random, sort, algName + " on random array", numTests);
        runSorts(sorted, sort, algName + " on sorted array", numTests);
        runSorts(reversed, sort, algName + " on reversed array", numTests);
    }
    
    public static void runSorts(Comparable[] arr, Sort sort, String algName, int trials) {
        long startTime, endTime;
        for(int i = 0; i < trials; i++) {
            Comparable[] arrS = ArrayUtils.copy(arr);
            if(!CONDENSE_RESULTS) System.out.println("Running " + algName + " on arrS");
            startTime = (new Date()).getTime();
            sort.sort(arrS);
            endTime = (new Date()).getTime();
            showSortTime(algName, startTime, endTime);
                
            if(RUN_TESTS) {
                isArraySorted(arrS, "arrS");
                areArraysSame(arr, "arr", arrS, "arrS");
            }
        }
        System.out.println();
    }
    
    public static void isArraySorted(Comparable[] arr, String name) {
        if(CONDENSE_RESULTS) {
            if(!ArrayUtils.isSorted(arr)) System.out.println("WARNING! ARRAY NOT SORTED");
        } else {
            ArrayUtils.show(arr, name);
            System.out.print("Is " + name + " sorted? ");
            System.out.println(boolToYesNo(ArrayUtils.isSorted(arr)));
            System.out.println();
        }
    }
    
    public static void areArraysSame(Comparable[] arr1, String name1, Comparable[] arr2, String name2) {
        if(CONDENSE_RESULTS) {
            if(!ArrayUtils.sameElements(arr1, arr2)) System.out.println("WARNING! ARRAYS CONTAIN DIFFERENT ELEMENTS");
        } else {
            System.out.print("Do " + name1 + " and " + name2 + " contain the same elements? ");
            System.out.println(boolToYesNo(ArrayUtils.sameElements(arr1, arr2)));
            System.out.println();
        }
    }
    
    public static void showSortTime(String algName, long startTime, long endTime) {
        System.out.print(algName + " running time: ");
        System.out.print(endTime - startTime);
        System.out.println(" ms");
        if(!CONDENSE_RESULTS) {
            System.out.println();
        }
    }
    
    public static String boolToYesNo(boolean bool) {
        return bool ? "Yes" : "No";
    }
}

//Insight... My Array verification step was taking forever when I went to 1 mil elements. New method works far better.