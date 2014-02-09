/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.awhipple.sortingtests;

/**
 *
 * @author Aaron
 */
public class BubbleSort {
    public static void sort(Comparable[] arr) {
        for(int i = arr.length-2; i >= 0; i--) {
            for(int a = 0; a <= i; a++) {
                if(arr[a].compareTo(arr[a+1]) > 0) {
                    Comparable temp = arr[a];
                    arr[a] = arr[a+1];
                    arr[a+1] = temp;
                }
            }
        }
    }
}
