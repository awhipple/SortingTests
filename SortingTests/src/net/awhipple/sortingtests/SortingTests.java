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

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Comparable[] arr = ArrayUtils.randomInts(40000, 1, 100);
        isArraySorted(arr, "arr");
        
        //runBubbleSorts(arr, 1);
        runInsertionSorts(arr, 5);
    }
    
    public static void runBubbleSorts(Comparable[] arr, int amount) {
        String algName = "Bubble sort";
        long startTime, endTime;
        for(int i = 0; i < amount; i++) {
            Comparable[] arrS = ArrayUtils.copy(arr);
            System.out.println("Running " + algName + " on arrS");
            startTime = (new Date()).getTime();
            BubbleSort.sort(arrS);
            endTime = (new Date()).getTime();
            showSortTime(algName, startTime, endTime);
                
            isArraySorted(arrS, "arrS");
        
            areArraysSame(arr, "arr", arrS, "arrS");
        }
    }
    
    public static void runInsertionSorts(Comparable[] arr, int amount) {
        String algName = "Insertion sort";
        long startTime, endTime;
        for(int i = 0; i < amount; i++) {
            Comparable[] arrS = ArrayUtils.copy(arr);
            System.out.println("Running " + algName + " on arrS");
            startTime = (new Date()).getTime();
            InsertionSort.sort(arrS);
            endTime = (new Date()).getTime();
            showSortTime(algName, startTime, endTime);
                
            isArraySorted(arrS, "arrS");
        
            areArraysSame(arr, "arr", arrS, "arrS");
        }
    }
    
    public static void isArraySorted(Comparable[] arr, String name) {
        ArrayUtils.show(arr, name);
        System.out.print("Is " + name + " sorted? ");
        System.out.println(boolToYesNo(ArrayUtils.isSorted(arr)));
        System.out.println();
    }
    
    public static void areArraysSame(Comparable[] arr1, String name1, Comparable[] arr2, String name2) {
        System.out.print("Do " + name1 + " and " + name2 + " contain the same elements? ");
        System.out.println(boolToYesNo(ArrayUtils.sameElements(arr1, arr2)));
        System.out.println();
    }
    
    public static void showSortTime(String algName, long startTime, long endTime) {
        System.out.print(algName + " running time: ");
        System.out.print(endTime - startTime);
        System.out.println(" ms");
        System.out.println();
    }
    
    public static String boolToYesNo(boolean bool) {
        return bool ? "Yes" : "No";
    }
}
