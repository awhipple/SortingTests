/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.awhipple.sortingtests;

import net.awhipple.sortingtests.utils.ArrayUtils;
import net.awhipple.sortingtests.sorts.*;
import java.util.Date;

/**
 *
 * @author Aaron
 */
public class SortingTests {
    
    public static final boolean CONDENSE_RESULTS = true;
    public static final boolean RUN_TESTS = true;
    public static final int NUM_RUNS = 1;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Comparable[] arr = ArrayUtils.randomInts(20, 1, 100);
        
        /*
        runBubbleSorts(arr, 5);
        System.out.println();
        runInsertionSorts(arr, 5);
        System.out.println();
        runSelectionSorts(arr, 5);
        System.out.println();
        runMergeSorts(arr, 5);
        System.out.println();
        */
        
        runHoareQuickSorts(arr, NUM_RUNS);
        runNoBoundsQuickSorts(arr, NUM_RUNS);
    }
    
    public static void runBubbleSorts(Comparable[] arr, int amount) {
        String algName = "Bubble sort";
        long startTime, endTime;
        for(int i = 0; i < amount; i++) {
            Comparable[] arrS = ArrayUtils.copy(arr);
            if(!CONDENSE_RESULTS) System.out.println("Running " + algName + " on arrS");
            startTime = (new Date()).getTime();
            BubbleSort.sort(arrS);
            endTime = (new Date()).getTime();
            if(!CONDENSE_RESULTS) ArrayUtils.show(arrS);
            showSortTime(algName, startTime, endTime);
                
            if(RUN_TESTS) {
                isArraySorted(arrS, "arrS");
                areArraysSame(arr, "arr", arrS, "arrS");
            }
        }
    }
    
    public static void runInsertionSorts(Comparable[] arr, int amount) {
        String algName = "Insertion sort";
        long startTime, endTime;
        for(int i = 0; i < amount; i++) {
            Comparable[] arrS = ArrayUtils.copy(arr);
            if(!CONDENSE_RESULTS) System.out.println("Running " + algName + " on arrS");
            startTime = (new Date()).getTime();
            InsertionSort.sort(arrS);
            endTime = (new Date()).getTime();
            if(!CONDENSE_RESULTS) ArrayUtils.show(arrS);
            showSortTime(algName, startTime, endTime);
                
            if(RUN_TESTS) {
                isArraySorted(arrS, "arrS");
                areArraysSame(arr, "arr", arrS, "arrS");
            }
        }
    }
    
    public static void runSelectionSorts(Comparable[] arr, int amount) {
        String algName = "Selection sort";
        long startTime, endTime;
        for(int i = 0; i < amount; i++) {
            Comparable[] arrS = ArrayUtils.copy(arr);
            if(!CONDENSE_RESULTS) System.out.println("Running " + algName + " on arrS");
            startTime = (new Date()).getTime();
            SelectionSort.sort(arrS);
            endTime = (new Date()).getTime();
            if(!CONDENSE_RESULTS) ArrayUtils.show(arrS);
            showSortTime(algName, startTime, endTime);
                
            if(RUN_TESTS) {
                isArraySorted(arrS, "arrS");
                areArraysSame(arr, "arr", arrS, "arrS");
            }
        }
    }
    
    public static void runMergeSorts(Comparable[] arr, int amount) {
        String algName = "Merge sort";
        long startTime, endTime;
        for(int i = 0; i < amount; i++) {
            Comparable[] arrS = ArrayUtils.copy(arr);
            if(!CONDENSE_RESULTS) System.out.println("Running " + algName + " on arrS");
            startTime = (new Date()).getTime();
            MergeSort.sort(arrS);
            endTime = (new Date()).getTime();
            if(!CONDENSE_RESULTS) ArrayUtils.show(arrS);
            showSortTime(algName, startTime, endTime);
                
            if(RUN_TESTS) {
                isArraySorted(arrS, "arrS");
                areArraysSame(arr, "arr", arrS, "arrS");
            }
        }
    }
    
    public static void runHoareQuickSorts(Comparable[] arr, int amount) {
        String algName = "Hoare Quick sort";
        long startTime, endTime;
        for(int i = 0; i < amount; i++) {
            Comparable[] arrS = ArrayUtils.copy(arr);
            if(!CONDENSE_RESULTS) ArrayUtils.show(arrS);
            if(!CONDENSE_RESULTS) System.out.println("Running " + algName + " on arrS");
            
            startTime = (new Date()).getTime();
            QuickSortHoare.sort(arrS);
            endTime = (new Date()).getTime();
            if(!CONDENSE_RESULTS) ArrayUtils.show(arrS);
            showSortTime(algName, startTime, endTime);
                
            if(RUN_TESTS) {
                isArraySorted(arrS, "arrS");
                areArraysSame(arr, "arr", arrS, "arrS");
            }
        }
    }
    
    public static void runNoBoundsQuickSorts(Comparable[] arr, int amount) {
        String algName = "No bounds check quick sort";
        long startTime, endTime;
        for(int i = 0; i < amount; i++) {
            Comparable[] arrS = ArrayUtils.copy(arr);
            if(!CONDENSE_RESULTS) ArrayUtils.show(arrS);
            if(!CONDENSE_RESULTS) System.out.println("Running " + algName + " on arrS");
            
            startTime = (new Date()).getTime();
            QuickSortNoBounds.sort(arrS);
            endTime = (new Date()).getTime();
            if(!CONDENSE_RESULTS) ArrayUtils.show(arrS);
            showSortTime(algName, startTime, endTime);
                
            if(RUN_TESTS) {
                isArraySorted(arrS, "arrS");
                areArraysSame(arr, "arr", arrS, "arrS");
            }
        }
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