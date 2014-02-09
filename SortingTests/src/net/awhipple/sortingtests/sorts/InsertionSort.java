/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.awhipple.sortingtests.sorts;

/**
 *
 * @author Aaron
 */
public class InsertionSort {
    public static void sort(Comparable[] arr) {
        for(int i = 1; i < arr.length; i++) {
            for(int j = i; j > 0; j--) {
                if(arr[j].compareTo(arr[j-1]) < 0) {
                    Comparable temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                } else {
                    break;
                }
            }
        }
    }
}
