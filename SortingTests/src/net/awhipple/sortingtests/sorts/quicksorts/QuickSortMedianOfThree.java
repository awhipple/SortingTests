/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.awhipple.sortingtests.sorts.quicksorts;

import net.awhipple.sortingtests.sorts.Sort;

/**
 *
 * Algorithm: Hoare
 * Partition Select: Median of Three
 * Runs Insertion on short lists: True
 * 
 * @author Aaron
 */
public class QuickSortMedianOfThree implements Sort{
    @Override
    public void sort(Comparable[] arr) {
        partition(arr, 0, arr.length-1);
    }
    
    private void partition(Comparable[] arr, int s, int e) {
        if(e-s <= 150) {
            if(e-s <= 0) return;
            for(int i = s+1; i <= e; i++) {
                for(int j = i; j > s; j--) {
                    if(arr[j].compareTo(arr[j-1]) < 0) {
                        Comparable temp = arr[j];
                        arr[j] = arr[j-1];
                        arr[j-1] = temp;
                    } else {
                        break;
                    }
                }
            }
            return;
        }
        int m = (int)((s+e)/2);
        int med, other;
        if(arr[s].compareTo(arr[m])<0) {
            med = s;
            other = m;
        } else {
            med = m;
            other = s;
        }
        if(arr[med].compareTo(arr[e])<0) {
            if(arr[e].compareTo(arr[other])<0) {
                med = e;
            } else {
                med = other;
            }
        }
        Comparable p = arr[med];
        int i = s - 1;
        int j = e + 1;
        while(true) {
            do{j--;} while(arr[j].compareTo(p) > 0);
            do{i++;} while(arr[i].compareTo(p) < 0);
            
            if(i < j) { swap(arr, i, j);}
            else      { break; }
        }
        partition(arr, s, j);
        partition(arr, j+1, e);
    }
    
    private void swap(Comparable[] arr, int a, int b) {
        Comparable temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
