/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.awhipple.sortingtests.utils;

import java.util.HashMap;

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
        HashMap<Comparable, Integer> map = new HashMap<>();
        for(int i = 0; i < arr1.length; i++) {
            if(map.containsKey(arr1[i])) {
                map.put(arr1[i], map.remove(arr1[i])+1);
            } else {
                map.put(arr1[i], 1);
            }
        }
        for(int i = 0; i < arr2.length; i++) {
            if(!map.containsKey(arr2[i])) return false;
            Integer remaining = map.remove(arr2[i])-1;
            if(remaining > 0) map.put(arr2[i], remaining);
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
    
    //Returns an array of ints ranging from min to max with size s
    public static Comparable[] randomInts(int s, int min, int max) {
        Comparable[] arr = new Comparable[s];
        for(int i = 0; i < s; i++) {
            arr[i] = (int)Math.floor(Math.random()*(max-min+1)+min);
        }
        return arr;
    }

    public static void showAndMark(Comparable[] arr, String arrName, int i, int j, int s, int e) {
        if(!arrName.isEmpty()) System.out.print(arrName + ": ");
        for(int a = 0; a < arr.length; a++) {
            String sep = a < arr.length - 1 ? ", " : "";
            if(a==s) System.out.print("<<");
            if(a==i) System.out.print("(*");
            if(a==j) System.out.print("(*");
            System.out.print(arr[a]);
            if(a==i) System.out.print("*)");
            if(a==j) System.out.print("*)");
            if(a==e) System.out.print(">>");
            System.out.print(sep);
        }
        System.out.println();
    }
}
