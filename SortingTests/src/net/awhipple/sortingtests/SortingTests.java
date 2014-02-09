/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.awhipple.sortingtests;

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
        
        long startTime, endTime;
        
        Comparable[] arr = ArrayUtils.randomInts(50000, 1, 100);
        Comparable[] arrBubb = ArrayUtils.copy(arr);
        
        isArraySorted(arr, "arr");
        
        startTime = (new Date()).getTime();
        BubbleSort.sort(arrBubb);
        endTime = (new Date()).getTime();
        sortTime("Bubble sort", startTime, endTime);
                
        isArraySorted(arrBubb, "arrBubb");
        
        areArraysSame(arr, "arr", arrBubb, "arrBubb");
    }
    
    public static void isArraySorted(Comparable[] arr, String name) {
        ArrayUtils.show(arr, name);
        System.out.print("Is " + name + " sorted? ");
        System.out.println(boolToYesNo(ArrayUtils.isSorted(arr)));
        System.out.println();
    }
    
    public static void areArraysSame(Comparable[] arr1, String name1, Comparable[] arr2, String name2) {
        ArrayUtils.show(arr1, name1);
        ArrayUtils.show(arr2, name2);
        System.out.print("Do " + name1 + " and " + name2 + " contain the same elements? ");
        System.out.println(boolToYesNo(ArrayUtils.sameElements(arr1, arr2)));
    }
    
    public static void sortTime(String algName, long startTime, long endTime) {
        System.out.print(algName + " running time: ");
        System.out.print(endTime - startTime);
        System.out.println(" ms");
        System.out.println();
    }
    
    public static String boolToYesNo(boolean bool) {
        return bool ? "Yes" : "No";
    }
}
