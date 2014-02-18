/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.awhipple.sortingtests.sorts;

/**
 *
 * Algorithm: Hoare
 * Bounds Checking: True
 * Partition Select: First
 * Runs Insertion on short lists: False
 * 
 * @author Aaron
 */
public class QuickSortHoare implements Sort{
    @Override
    public void sort(Comparable[] arr) {
        partition(arr, 0, arr.length-1);
    }
    
    private void partition(Comparable[] arr, int s, int e) {
        if(e-s <= 0) return;
        swap(arr, s+1, smallestElement(arr, s, e));
        swap(arr, e, largestElement(arr, s, e));
        Comparable p = arr[s];
        int i = s + 1;
        int j = e;
        while(i<j) {
            while(i < e && arr[i].compareTo(p) <= 0) i++;
            while(j > s && arr[j].compareTo(p) >= 0) j--;
            
            swap(arr, i, j);
        }
        swap(arr, i, j);
        swap(arr, s, i-1);
        partition(arr, s, i-2);
        partition(arr, i, e);
    }
    
    private void swap(Comparable[] arr, int a, int b) {
        Comparable temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
    
    private int largestElement(Comparable[] arr, int s, int e) {
        int p = s;
        Comparable largest = arr[p];
        for(int i = s+1; i <= e; i++) {
            if(arr[i].compareTo(largest) > 0) {
                p = i;
                largest = arr[p];
            }
        }
        return p;
    }
    
    private int smallestElement(Comparable[] arr, int s, int e) {
        int p = s;
        Comparable smallest = arr[p];
        for(int i = s+1; i <= e; i++) {
            if(arr[i].compareTo(smallest) < 0) {
                p = i;
                smallest = arr[p];
            }
        }
        return p;
    }
}
