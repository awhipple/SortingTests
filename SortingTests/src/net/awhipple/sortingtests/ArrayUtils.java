/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.awhipple.sortingtests;

/**
 *
 * @author Aaron
 */
public class ArrayUtils {

    //Outputs the contents of arr with no header
    public static void show(Comparable[] arr) {
        show(arr, "");
    }   
    
    //Outputs the contents of arr with header arrName
    public static void show(Comparable[] arr, String arrName) {
        if(!arrName.isEmpty()) System.out.print(arrName + ": ");
        for(int a = 0; a < arr.length; a++) {
            String sep = a < arr.length - 1 ? ", " : "";
            System.out.print(arr[a] + sep);
        }
        System.out.println();
    }
    
    //Returns a deep copy of arr
    public static Comparable[] copy(Comparable[] arr) {
        if(arr == null) return null;
        if(arr.length == 0) return new Comparable[0];
        Comparable[] newArr = new Comparable[arr.length];
        System.arraycopy(arr, 0, newArr, 0, arr.length);
        return newArr;
    }
    
    //Returns true if the arrays contain the same elements, ignoring order
    public static boolean sameElements(Comparable[] arr1, Comparable[] arr2) {
        if(arr1.length != arr2.length) return false;
        Comparable[] testArray = copy(arr2);
        for(int i = 0; i < arr1.length; i++) {
            boolean foundCopy = false;
            for(int j = 0; j < testArray.length; j++) {
                if(arr1[i].equals(testArray[j])) {
                    testArray[j] = null;
                    foundCopy = true;
                    break;
                }
            }
            if(!foundCopy) return false;
        }
        return true;
    }
    
    //Returns true if the array is sorted
    public static boolean isSorted(Comparable[] arr) {
        for(int i = 0; i < arr.length-1; i++) {
            if(arr[i].compareTo(arr[i+1]) > 0) return false;
        }
        return true;
    }
    
    //Returns an array of ints randing from min to max with size size
    public static Comparable[] randomInts(int size, int min, int max) {
        Comparable[] arr = new Comparable[size];
        for(int i = 0; i < size; i++) {
            arr[i] = (int)Math.floor(Math.random()*(max-min+1)+min);
        }
        return arr;
    }
}
