/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.awhipple.sortingtests.sorts.quicksorts;

import net.awhipple.sortingtests.sorts.Sort;

/**
 *
 * Algorithm: Lomuto
 * 
 * @author Tim Huynh
 */
public class QuickSortLomuto implements Sort{
    @Override
    public void sort(Comparable[] arr) {
        partition(arr, 0, arr.length-1);
    }
    
    private void partition(Comparable[] arr, int s, int e) {
        if(e-s < 1) return;
        Comparable p = arr[s]; // p <- A[l]
        int split = s;
        for(int j = s+1; j <= e; j++) { // for i <- l + 1 to r do
        	if(arr[j].compareTo(p) < 0) { // if A[j] <= x
        		split++;
        		swap(arr, split, j);
        	}
        }
    	swap(arr, s, split);
    	partition(arr, s, split-1);
    	partition(arr, split+1, e); // How to recursive? 
    }
    
    private void swap(Comparable[] arr, int a, int b) {
        Comparable temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
