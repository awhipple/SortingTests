/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.awhipple.sortingtests.sorts;

import net.awhipple.sortingtests.utils.ArrayUtils;

/**
 *
 * Algorithm: Hoare
 * Bounds Checking: False
 * Partition Select: First
 * Runs Insertion on short lists: False
 * 
 * @author Aaron
 */
public class QuickSortNoBounds {
    public static void sort(Comparable[] arr) {
        partitionCheckUpper(arr, 0, arr.length-1);
    }
    
    private static void partitionCheckUpper(Comparable[] arr, int s, int e) {
        if(e-s <= 0) return;
        Comparable p = arr[s];
        int i = s + 1;
        int j = e;
        while(i<j) {
            while(i < e && arr[i].compareTo(p) < 0) i++;
            while(arr[j].compareTo(p) > 0) j--;
            
            ArrayUtils.showAndMark(arr, "List", i, j, s, e);
            swap(arr, i, j);
        }
        ArrayUtils.showAndMark(arr, "List", i, j, s, e);
        swap(arr, i, j);
        ArrayUtils.showAndMark(arr, "List", s, i-1, s, e);
        swap(arr, s, i-1);
        partition(arr, s, i-2);
        partitionCheckUpper(arr, i, e);
    }
    
    private static void partition(Comparable[] arr, int s, int e) {
        if(e-s <= 0) return;
        Comparable p = arr[s];
        int i = s + 1;
        int j = e;
        while(i<j) {
            while(arr[i].compareTo(p) < 0) i++;
            while(arr[j].compareTo(p) > 0) j--;
            
            ArrayUtils.showAndMark(arr, "List", i, j, s, e);
            swap(arr, i, j);
        }
        ArrayUtils.showAndMark(arr, "List", i, j, s, e);
        swap(arr, i, j);
        ArrayUtils.showAndMark(arr, "List", s, i-1, s, e);
        swap(arr, s, i-1);
        partition(arr, s, i-2);
        partition(arr, i, e);
    }
    
    private static void swap(Comparable[] arr, int a, int b) {
        Comparable temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
