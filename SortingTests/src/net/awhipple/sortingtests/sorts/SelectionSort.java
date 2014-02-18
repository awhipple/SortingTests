/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.awhipple.sortingtests.sorts;

/**
 *
 * @author Aaron
 */
public class SelectionSort implements Sort{
    @Override
    public void sort(Comparable[] arr) {
        for(int i = 0; i < arr.length-1; i++) {
            int smallestIndex = i;
            Comparable smallestValue = arr[i];
            for(int j = i+1; j < arr.length; j++) {
                if(arr[j].compareTo(smallestValue) < 0) {
                    smallestIndex = j;
                    smallestValue = arr[j];
                }
            }
            Comparable temp = arr[i];
            arr[i] = arr[smallestIndex];
            arr[smallestIndex] = temp;
        }
    }
}
